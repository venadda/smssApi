package com.smss.api.system.daos;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.smss.api.app.database.EmssDB;
import com.smss.api.smssApi.apiclazz.BranchParam;
import com.smss.api.smssApi.apiclazz.OrganizationParam;
import com.smss.api.system.mapper.*;
import com.smss.api.system.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Transactional
@Repository
public class OrganizationDAO {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private EmssDB queries;

    public List<Organization> getActiveOrganization() throws SQLException {

        return (List<Organization>) jdbcTemplate.query(queries.getGetActiveOrganization(), new MapSqlParameterSource(), new MOrganization());

    }


    public List<Organization> addOrganization(Organization org) throws SQLException {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        MapSqlParameterSource source = new MapSqlParameterSource();

        System.out.println(queries.getInsertOrganization());
        jdbcTemplate.update(queries.getInsertOrganization(), source, holder);
        long primaryKey = holder.getKey().longValue();
        return getAllOrganization();
    }


    public List<Organization> removeOrganization(Organization org) throws SQLException {

        SqlParameterSource source = new MapSqlParameterSource("o_id", org.getO_id());
        jdbcTemplate.update(queries.getDeleteOrganization(), source);
        return getActiveOrganization();

    }


    public List<Organization> getAllOrganization() throws SQLException {
        System.out.println(queries.getGetAllOrganization());
        return jdbcTemplate.query(queries.getGetAllOrganization(), new MapSqlParameterSource(), new MOrganization());

    }


    public List<Organization> updateOrganization(Organization org) throws SQLException {

        MapSqlParameterSource source = new MapSqlParameterSource();
        mapOrganization( source,org);

        jdbcTemplate.update(queries.getUpdateOrganization(), source);
        return getAllOrganization();
    }


    public List<Organization> getOrganizationById(OrganizationParam org) throws SQLException {

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("o_id", org.getOrgId());
        List<Organization> orgs = (List<Organization>) jdbcTemplate.query(queries.getGetOrganizationById(), source, new MOrganization());

        return orgs;
    }


   /* public List<Organization> insertBulkOrganization(List<Organization> orgs) throws SQLException {

        List<Map<String, Object>> batchValues = new ArrayList<>(orgs.size());
        for (Organization org : orgs) {
            batchValues.add(
                    new MapSqlParameterSource("o_title", org.getO_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertOrganization(), batchValues.toArray(new Map[orgs.size()]));
        return getAllOrganization();
    }*/
/*
        function : insert or update bulk organizations
        status : green
 */

    public List<Organization> insertBulkOrganization(List<Organization> orgs) throws SQLException {
        List<Map<String, Object>> batchUpdateValues = new ArrayList<>(orgs.size());
        List<Map<String, Object>> batchInsertValues = new ArrayList<>(orgs.size());
        int batchUpdateInt = 0;
        int batchInsertInt = 0;
        MapSqlParameterSource source;

        for (Organization org : orgs) {
            source = new MapSqlParameterSource();
            mapOrganization(source,org);
            if(Optional.ofNullable(org.getO_id()).orElse(0) != 0) {
                batchUpdateValues.add(source.getValues());
                batchUpdateInt++;
            }else{
                batchInsertValues.add(source.getValues());
                batchInsertInt++;
            }
        }
        if(batchInsertValues.size()>0) {
            jdbcTemplate.batchUpdate(queries.getInsertOrganization(), batchInsertValues.toArray(new Map[batchInsertInt]));
        }
        else {
            jdbcTemplate.batchUpdate(queries.getUpdateOrganization(), batchUpdateValues.toArray(new Map[batchUpdateInt]));
        }
        return getAllOrganization();
    }
    /*
            function : Delete Bulk Organization
            status:yellow
         */
    public List<Organization> deleteBulkOrganization(List<Organization> orgs) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(orgs.size());
        for (Organization org : orgs) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            mapOrganization(source,org );
            batchValues.add(source.getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteOrganization(), batchValues.toArray(new Map[orgs.size()]));
        return getAllOrganization();
    }

    public List<Audit> getAuditDetailsByOrg(int orgid){
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("orgid",orgid);
        return (List<Audit>) jdbcTemplate.query(queries.getAuditDetailsByOrg(),source,new MAudit());
    }

    public List<Audit> getAuditDetailsByUser(int orgid,int userid){
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("orgid",orgid);
        source.addValue("action_by",userid);
        return (List<Audit>) jdbcTemplate.query(queries.getAuditDetailsByUser(),source,new MAudit());
    }



    private void mapOrganization(MapSqlParameterSource source,Organization org){
        source.addValue("o_id" ,org.getO_id());
        source.addValue("o_title" ,org.getO_title());
        source.addValue("o_active_ind" ,org.getO_active_ind().equals("Y")?true:false);
        source.addValue("o_address" ,org.getO_address());
        source.addValue("o_location" ,org.getO_location());
        source.addValue("o_street" ,org.getO_street());
        source.addValue("o_city" ,org.getO_city());
        source.addValue("o_state" ,org.getO_state());
        source.addValue("o_country" ,org.getO_country());
        source.addValue("o_zipcode" ,org.getO_zipcode());
        source.addValue("o_district" ,org.getO_district());
        source.addValue("o_mandal" ,org.getO_mandal());
        source.addValue("o_village" ,org.getO_village());
        source.addValue("o_pcontactno" ,org.getO_pcontactno());
        source.addValue("o_scontactno" ,org.getO_scontactno());
        source.addValue("o_pfaxno" ,org.getO_pfaxno());
        source.addValue("o_sfaxno" ,org.getO_sfaxno());
        source.addValue("o_pemail" ,org.getO_pemail());
        source.addValue("o_semail" ,org.getO_semail());
        source.addValue("o_pcontactperson" ,org.getO_pcontactno());
        source.addValue("o_scontactperson" ,org.getO_scontactno());
        source.addValue("o_pwebsite" ,org.getO_pwebsite());
        source.addValue("o_swebsite" ,org.getO_swebsite());
        source.addValue("o_smsurl" ,org.getO_smsurl());
        source.addValue("o_type" ,org.getO_type());

    }

//==============================================================================================


    public List<Branch> branchInsert(Branch branch) throws SQLException {
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        branchMapping(parameterSource, branch);
        int result = jdbcTemplate.update(queries.getBranchInsert(), parameterSource,holder);
        long generatedValue = holder.getKey().longValue();
        BranchParam param = new BranchParam();
        param.setOrgId(branch.getB_oid().intValue());
        return getAllBranch(param);

    }


    public List<Branch> branchDelete(BranchParam param) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_id", param.getBranchId());
        source.addValue("b_oid", param.getOrgId());
        jdbcTemplate.update(queries.getBranchDelete(), source);
        return getAllBranch(param);

    }


    public List<Branch> branchUpdate(Branch branch) throws SQLException {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        branchMapping(parameterSource,branch);
        jdbcTemplate.update(queries.getBranchUpdate(), parameterSource);
        BranchParam param = new BranchParam();
        param.setOrgId(branch.getB_oid().intValue());
        return getAllBranch(param);

    }


    public List<Branch> getActiveBranch(BranchParam branch) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", branch.getOrgId());
        source.addValue("b_id", branch.getBranchId());
        return (List<Branch>) jdbcTemplate.query(queries.getGetActiveBranch(), source, new MBranch());

    }


    public List<Branch> getAllBranch(BranchParam param) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", param.getOrgId());
        return  jdbcTemplate.query(queries.getGetAllBranch(),
                source, new MBranch());

    }


    public List<Branch> getBranchById(BranchParam param) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_id", param.getBranchId());
        source.addValue("b_oid", param.getOrgId());
        return  jdbcTemplate.query(queries.getGetBranchById(), source, new MBranch());
    }


    public List<Branch> insertBulkBranch(List<Branch> branchs) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(branchs.size());
        for (Branch branch : branchs) {
            System.out.println(branch.toString());
            MapSqlParameterSource source = new MapSqlParameterSource();
            branchMapping(source, branch);
            batchValues.add(source.getValues());
        }
        jdbcTemplate.batchUpdate(queries.getBranchInsert(), batchValues.toArray(new Map[branchs.size()]));

        BranchParam param = new BranchParam();
        param.setOrgId(branchs.get(0).getB_oid().intValue());
        return getAllBranch(param);
    }


    public List<Branch> updateBulkBranch(List<Branch> branchs) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(branchs.size());
        for (Branch branch : branchs) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            branchMapping(source, branch);
        }

        jdbcTemplate.batchUpdate(queries.getBranchUpdate(), batchValues.toArray(new Map[branchs.size()]));
        BranchParam param = new BranchParam();
        param.setOrgId(branchs.get(0).getB_oid().intValue());
        return getAllBranch(param);
    }





    public List<Branch> deleteBulkBranch(List<Branch> branchs) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(branchs.size());
        for (Branch branch : branchs) {
            MapSqlParameterSource source = new MapSqlParameterSource();
            branchMapping(source, branch);

            batchValues.add(source.getValues());
        }

        jdbcTemplate.batchUpdate(queries.getBranchDelete(), batchValues.toArray(new Map[branchs.size()]));
        BranchParam param = new BranchParam();
        param.setOrgId(branchs.get(0).getB_oid().intValue());
        return getAllBranch(param);
    }

    private void branchMapping(MapSqlParameterSource source,Branch branch){
        source.addValue("b_id", branch.getB_id());
        source.addValue("b_title", branch.getB_title());
        source.addValue("b_refId", branch.getB_refId());
        source.addValue("b_address", branch.getB_address());
        source.addValue("b_location", branch.getB_location());
        source.addValue("b_street", branch.getB_street());
        source.addValue("b_city", branch.getB_city());
        source.addValue("b_state", branch.getB_state());
        source.addValue("b_mandal", branch.getB_mandal());
        source.addValue("b_district", branch.getB_district());
        source.addValue("b_zipcode", branch.getB_zipcode());
        source.addValue("b_pphonenumber", branch.getB_pphoneNumber());
        source.addValue("b_sphonenumber", branch.getB_sphoneNumber());
        source.addValue("b_pfaxnumber", branch.getB_pfaxNumber());
        source.addValue("b_active_ind", branch.getB_active_ind().equals("Y")?true:false);
        source.addValue("b_oid", branch.getB_oid());
        source.addValue("b_village", branch.getB_village());
        source.addValue("b_zone", branch.getB_zone());

    }

    public List<OrgDepartment> getActiveDepartment(OrgDepartment dept) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());
        return (List<OrgDepartment>) jdbcTemplate.query(queries.getActiveDepartment(), source, new MOrgDepartment());
    }


    public List<OrgDepartment> getNonActiveDepartment(OrgDepartment dept) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());
        return (List<OrgDepartment>) jdbcTemplate.query(queries.getNonActiveDepartment(), source, new MOrgDepartment());
    }


    public List<OrgDepartment> getAllOrgDepartment(OrgDepartment dept) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());
        return (List<OrgDepartment>) jdbcTemplate.query(queries.getAllOrgDepartment(), source, new MOrgDepartment());
    }


    public List<OrgDepartment> insertOrgDepartment(OrgDepartment dept) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());
        source.addValue("d_title", dept.getD_title());
        source.addValue("d_active_ind", dept.isD_active_ind());
        jdbcTemplate.update(queries.getInsertOrgDepartment(), source);
        return (List<OrgDepartment>) jdbcTemplate.query(queries.getAllOrgDepartment(), new MapSqlParameterSource("d_oid", dept.getD_oid()), new MOrgDepartment());
    }


    public List<OrgDepartment> updateOrgDepartment(OrgDepartment dept) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());
        source.addValue("d_title", dept.getD_title());
        source.addValue("d_active_ind", dept.isD_active_ind());
        source.addValue("d_id", dept.getD_id());
        jdbcTemplate.update(queries.getUpdateOrgDepartment(), source);
        return (List<OrgDepartment>) jdbcTemplate.query(queries.getAllOrgDepartment(), new MapSqlParameterSource("d_oid", dept.getD_oid()), new MOrgDepartment());
    }


    public List<OrgDepartment> deleteOrgDepartment(OrgDepartment dept) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());
        source.addValue("d_id", dept.getD_id());
        jdbcTemplate.update(queries.getDeleteOrgDepartment(), source);
        source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());

        return (List<OrgDepartment>) jdbcTemplate.query(queries.getAllOrgDepartment(), source, new MOrgDepartment());
    }


    public List<OrgDepartment> getDepartmentGetById(OrgDepartment dept) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());
        source.addValue("d_id", dept.getD_id());
        return (List<OrgDepartment>) jdbcTemplate.query(queries.getDepartmentGetById(), source, new MOrgDepartment());

    }


    public List<OrgDepartment> getDepartmentGetByName(OrgDepartment dept) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", dept.getD_oid());
        source.addValue("d_title", dept.getD_title());
        return (List<OrgDepartment>) jdbcTemplate.query(queries.getDepartmentGetByName(), source, new MOrgDepartment());

    }


    public List<OrgDepartment> insertBulkDepartment(List<OrgDepartment> dept) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(dept.size());
        for (OrgDepartment dpt : dept) {
            batchValues.add(
                    new MapSqlParameterSource("d_oid", dpt.getD_oid())
                            .addValue("d_title", dpt.getD_title())
                            .addValue("d_active_ind", dpt.isD_active_ind())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertOrgDepartment(), batchValues.toArray(new Map[dept.size()]));
        return getAllOrgDepartment(dept.get(0));
    }


    public List<OrgDepartment> updateBulkDepartment(List<OrgDepartment> dept) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(dept.size());
        for (OrgDepartment dpt : dept) {
            batchValues.add(
                    new MapSqlParameterSource("d_oid", dpt.getD_oid())
                            .addValue("d_title", dpt.getD_title())
                            .addValue("d_active_ind", dpt.isD_active_ind())
                            .getValues());
        }
        jdbcTemplate.batchUpdate(queries.getUpdateOrgDepartment(), batchValues.toArray(new Map[dept.size()]));
        return getAllOrgDepartment(dept.get(0));
    }


    public List<OrgDepartment> deleteBulkDepartment(List<OrgDepartment> dept) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(dept.size());
        for (OrgDepartment dpt : dept) {
            batchValues.add(
                    new MapSqlParameterSource("d_oid", dpt.getD_oid())
                            .addValue("d_title", dpt.getD_title())
                            .addValue("d_active_ind", dpt.isD_active_ind())
                            .getValues());
        }
        jdbcTemplate.batchUpdate(queries.getDeleteOrgDepartment(), batchValues.toArray(new Map[dept.size()]));
        return getAllOrgDepartment(dept.get(0));
    }


    public List<OrgDesignation> getActiveDesignation(OrgDesignation design) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", design.getD_oid());
        return (List<OrgDesignation>) jdbcTemplate.query(queries.getActiveDesignation(), source, new MOrgDesignation());

    }


    public List<OrgDesignation> getNonActiveDesignation(OrgDesignation design) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", design.getD_oid());
        return (List<OrgDesignation>) jdbcTemplate.query(queries.getNonActiveDesignation(), source, new MOrgDesignation());
    }


    public List<OrgDesignation> getAllOrgDesignation(OrgDesignation design) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", design.getD_oid());
        return (List<OrgDesignation>) jdbcTemplate.query(queries.getAllOrgDesignation(), source, new MOrgDesignation());
    }


    public List<OrgDesignation> insertOrgDesignation(OrgDesignation design) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_id", design.getD_id());
        source.addValue("d_oid", design.getD_oid());
        source.addValue("d_title", design.getD_title());
        source.addValue("d_active_ind", design.isD_active_ind());
        source.addValue("d_dcat", design.getD_dcat());
        jdbcTemplate.update(queries.getInsertOrgDesignation(), source);
        source = new MapSqlParameterSource();
        source.addValue("d_oid", design.getD_oid());
        return (List<OrgDesignation>) jdbcTemplate.query(queries.getActiveDesignation(), source, new MOrgDesignation());
    }


    public List<OrgDesignation> updateOrgDesignation(OrgDesignation desg) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", desg.getD_oid());
        source.addValue("d_title", desg.getD_title());
        source.addValue("d_id", desg.getD_id());
        source.addValue("d_active_ind", desg.isD_active_ind());
        source.addValue("d_dcat", desg.getD_dcat());
        jdbcTemplate.update(queries.getUpdateOrgDesignation(), source);
        source = new MapSqlParameterSource();
        source.addValue("d_oid", desg.getD_oid());
        return (List<OrgDesignation>) jdbcTemplate.query(queries.getActiveDesignation(), source, new MOrgDesignation());
    }


    public List<OrgDesignation> deleteOrgDesignation(OrgDesignation design) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", design.getD_oid());
        source.addValue("d_id", design.getD_id());
        source.addValue("d_title",design.getD_title());
        source.addValue("d_active_ind", design.isD_active_ind());
        source.addValue("d_dcat", design.getD_dcat());


        jdbcTemplate.update(queries.getUpdateOrgDesignation(), source);
        source = new MapSqlParameterSource();
        source.addValue("d_oid", design.getD_oid());
        return (List<OrgDesignation>) jdbcTemplate.query(queries.getActiveDesignation(), source, new MOrgDesignation());

    }


    public List<OrgDesignation> getDesignationGetById(OrgDesignation design) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", design.getD_oid());
        source.addValue("d_id", design.getD_id());

        return (List<OrgDesignation>) jdbcTemplate.query(queries.getDesignationGetById(), source, new MOrgDesignation());
    }


    public List<OrgDesignation> getDesignationGetByName(OrgDesignation design) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_oid", design.getD_oid());
        source.addValue("d_title", design.getD_title());

        return (List<OrgDesignation>) jdbcTemplate.query(queries.getDesignationGetByName(), source, new MOrgDesignation());
    }


    public List<OrgDesignation> insertBulkDesignation(List<OrgDesignation> designs) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(designs.size());
        for (OrgDesignation design : designs) {
            batchValues.add(
                    new MapSqlParameterSource("d_oid", design.getD_oid())
                            .addValue("d_title", design.getD_title())
                            .addValue("d_active_ind", design.isD_active_ind())
                            .addValue("d_dcat", design.getD_dcat())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertOrgDesignation(), batchValues.toArray(new Map[designs.size()]));
        return getAllOrgDesignation(designs.get(0));
    }


    public List<OrgDesignation> updateBulkDesignation(List<OrgDesignation> designs) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(designs.size());
        for (OrgDesignation design : designs) {
            batchValues.add(
                    new MapSqlParameterSource("d_oid", design.getD_oid())
                            .addValue("d_title", design.getD_title())
                            .addValue("d_id", design.getD_id())
                            .addValue("d_active_ind", design.isD_active_ind())
                            .addValue("d_dcat", design.getD_dcat())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getBranchDelete(), batchValues.toArray(new Map[designs.size()]));
        return getAllOrgDesignation(designs.get(0));
    }


    public List<OrgDesignation> deleteBulkDesignation(List<OrgDesignation> designs) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(designs.size());
        for (OrgDesignation design : designs) {
            batchValues.add(
                    new MapSqlParameterSource("d_oid", design.getD_oid())
                            .addValue("d_id", design.getD_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteOrgDesignation(), batchValues.toArray(new Map[designs.size()]));
        return getAllOrgDesignation(designs.get(0));
    }

/*-----------------------------------batchs-------------------------------------------- */

    public List<BatchesLookup> insertBatch(BatchesLookup batch) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        source.addValue("b_batchtitle", batch.getB_batchtitle());
        source.addValue("b_desc", batch.getB_desc());
        source.addValue("b_active_ind", batch.isB_active_ind());
        source.addValue("b_ayid",batch.getB_ayid());
        jdbcTemplate.update(queries.getInsertBatch(), source);
        source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        return (List<BatchesLookup>) jdbcTemplate.query(queries.getBatchByOrgId(), source, new MBatchesLookup());
    }


    public List<BatchesLookup> updateBatch(BatchesLookup batch) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        source.addValue("b_batchtitle", batch.getB_batchtitle());
        source.addValue("b_desc", batch.getB_desc());
        source.addValue("b_id", batch.getB_id());
        source.addValue("b_active_ind", batch.isB_active_ind());
        source.addValue("b_ayid",batch.getB_ayid());
        jdbcTemplate.update(queries.getUpdateBatch(), source);
        source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        return (List<BatchesLookup>) jdbcTemplate.query(queries.getBatchByOrgId(), source, new MBatchesLookup());
    }


    public List<BatchesLookup> deleteBatch(BatchesLookup batch) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        source.addValue("b_batchtitle", batch.getB_batchtitle());
        source.addValue("b_id", batch.getB_id());
        source.addValue("b_ayid",batch.getB_ayid());
        jdbcTemplate.update(queries.getDeleteBatch(), source);
        source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        return (List<BatchesLookup>) jdbcTemplate.query(queries.getBatchByOrgId(), source, new MBatchesLookup());
    }


    public List<BatchesLookup> batchByName(BatchesLookup batch) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        source.addValue("b_year",batch.getB_year());
        source.addValue("b_ayid",batch.getB_ayid());
        source.addValue("b_batchtitle",batch.getB_batchtitle());
        return (List<BatchesLookup>) jdbcTemplate.query(queries.getBatchByName(), source, new MBatchesLookup());
    }


    public List<BatchesLookup> batchById(BatchesLookup batch) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        source.addValue("b_year",batch.getB_year());
        source.addValue("b_ayid",batch.getB_ayid());
        source.addValue("b_id",batch.getB_id());
        source.addValue("b_batchtitle",batch.getB_batchtitle());return (List<BatchesLookup>) jdbcTemplate.query(queries.getBatchById(), source, new MBatchesLookup());
    }


    public List<BatchesLookup> batchByOrgId(BatchesLookup batch) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        source.addValue("b_year",batch.getB_year());
        source.addValue("b_ayid",batch.getB_ayid());
        source.addValue("b_batchtitle",batch.getB_batchtitle());

        return (List<BatchesLookup>) jdbcTemplate.query(queries.getBatchByOrgId(), source, new MBatchesLookup());
    }

    public List<BatchesLookup> batchByYear(BatchesLookup batch) throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        source.addValue("b_year",batch.getB_year());
        source.addValue("b_ayid",batch.getB_ayid());
        source.addValue("b_batchtitle",batch.getB_batchtitle());
        return (List<BatchesLookup>) jdbcTemplate.query(queries.getBatchByYear(), source, new MBatchesLookup());
    }

    public List<BatchesLookup> activeBatches(BatchesLookup batch) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("b_oid", batch.getB_oid());
        source.addValue("b_year",batch.getB_year());
        source.addValue("b_ayid",batch.getB_ayid());
        source.addValue("b_batchtitle",batch.getB_batchtitle());

        return (List<BatchesLookup>) jdbcTemplate.query(queries.getActiveBatches(), source, new MBatchesLookup());
    }


    public List<BatchesLookup> insertBulkBatches(List<BatchesLookup> batches) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(batches.size());
        for (BatchesLookup batch : batches) {
            batchValues.add(
                    new MapSqlParameterSource("b_oid", batch.getB_oid())
                            .addValue("b_batchtitle", batch.getB_batchtitle())
                            .addValue("b_desc", batch.getB_desc())
                            .addValue("b_active_ind", batch.isB_active_ind())
                            .addValue("b_id", batch.getB_id())
                            .addValue("b_ayid",batch.getB_ayid())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertBatch(), batchValues.toArray(new Map[batches.size()]));
        return batchByOrgId(batches.get(0));
    }


    public List<BatchesLookup> updateBulkBatches(List<BatchesLookup> batches) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(batches.size());
        for (BatchesLookup batch : batches) {
            batchValues.add(
                    new MapSqlParameterSource("b_oid", batch.getB_oid())
                            .addValue("b_batchtitle", batch.getB_batchtitle())
                            .addValue("b_desc", batch.getB_desc())
                            .addValue("b_active_ind", batch.isB_active_ind())
                            .addValue("b_id", batch.getB_id())
                            .addValue("b_ayid",batch.getB_ayid())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateBatch(), batchValues.toArray(new Map[batches.size()]));
        return batchByOrgId(batches.get(0));
    }


    public List<BatchesLookup> deleteBulkBatches(List<BatchesLookup> batches) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(batches.size());
        for (BatchesLookup batch : batches) {
            batchValues.add(
                    new MapSqlParameterSource("b_oid", batch.getB_oid())
                            .addValue("b_id", batch.getB_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteBatch(), batchValues.toArray(new Map[batches.size()]));
        return batchByOrgId(batches.get(0));
    }

/*-----------------------------------------courseLevel ------------------------------------------*/
    public List<CourseLevelLookup> insertCourseLevel(CourseLevelLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("c_title", course.getC_title());
        source.addValue("c_desc", course.getC_desc());
        source.addValue("c_country", course.getC_country());
        source.addValue("c_group",course.getC_group());
        jdbcTemplate.update(queries.getInsertCourseLevel(), source);
        source = new MapSqlParameterSource();
        source.addValue("c_country", course.getC_country());
        return (List<CourseLevelLookup>) jdbcTemplate.query(queries.getCourseLevelByCounrty(), source, new MCourseLevelLookup());
    }


    public List<CourseLevelLookup> updateCourseLevel(CourseLevelLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("c_title", course.getC_title());
        source.addValue("c_desc", course.getC_desc());
        source.addValue("c_country", course.getC_country());
        jdbcTemplate.update(queries.getUpdateCourseLevel(), source);
        source = new MapSqlParameterSource();
        source.addValue("c_country", course.getC_country());
        return (List<CourseLevelLookup>) jdbcTemplate.query(queries.getCourseLevelByCounrty(), source, new MCourseLevelLookup());
    }


   /* public List<CourseLevelLookup> deleteCourseLevel(CourseLevelLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("c_title", course.getC_title());
        source.addValue("c_desc", course.getC_desc());
        source.addValue("c_country", course.getC_country());
        jdbcTemplate.update(queries.getDeleteCourseLevel(), source);
        source = new MapSqlParameterSource();
        source.addValue("c_country", course.getC_country());
        return (List<CourseLevelLookup>) jdbcTemplate.query(queries.getCourseLevelByCounrty(), source, new MCourseLevelLookup());
    }
*/

    public List<CourseLevelLookup> courseLevelByTitle(CourseLevelLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("c_title", course.getC_title());
        source.addValue("c_country", course.getC_country());
        return (List<CourseLevelLookup>) jdbcTemplate.query(queries.getCourseLevelByTitle(), source, new MCourseLevelLookup());
    }
    public List<CourseLevelLookup> courseLevelByGroup(CourseLevelLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("c_group", course.getC_group());
        source.addValue("c_country", course.getC_country());
        return (List<CourseLevelLookup>) jdbcTemplate.query(queries.getCourseLevelByGroup(), source, new MCourseLevelLookup());
    }

    public List<CourseLevelLookup> courseLevelByCounrty(CourseLevelLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("c_country", course.getC_country());
        return (List<CourseLevelLookup>) jdbcTemplate.query(queries.getCourseLevelByCounrty(), source, new MCourseLevelLookup());
    }


    public List<CourseLevelLookup> inserrtBulkcourseLevel(List<CourseLevelLookup> courses) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(courses.size());
        for (CourseLevelLookup course : courses) {
            batchValues.add(
                    new MapSqlParameterSource("c_title", course.getC_title())
                            .addValue("c_desc", course.getC_desc())
                            .addValue("c_country", course.getC_country())
                            .addValue("c_group", course.getC_group())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertCourseLevel(), batchValues.toArray(new Map[courses.size()]));
        return courseLevelByCounrty(courses.get(0));
    }


    public List<CourseLevelLookup> updateBulkcourseLevel(List<CourseLevelLookup> courses) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(courses.size());
        for (CourseLevelLookup course : courses) {
            batchValues.add(
                    new MapSqlParameterSource("c_title", course.getC_title())
                            .addValue("c_desc", course.getC_desc())
                            .addValue("c_country", course.getC_country())
                            .addValue("c_group",course.getC_group())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateCourseLevel(), batchValues.toArray(new Map[courses.size()]));
        return courseLevelByCounrty(courses.get(0));
    }


/*
    public List<CourseLevelLookup> deleteBulkcourseLevel(List<CourseLevelLookup> courses) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(courses.size());
        for (CourseLevelLookup course : courses) {
            batchValues.add(
                    new MapSqlParameterSource("c_title", course.getC_title())
                            .addValue("c_desc", course.getC_desc())
                            .addValue("c_country", course.getC_country())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteCourseLevel(), batchValues.toArray(new Map[courses.size()]));
        return courseLevelByCounrty(courses.get(0));
    }
*/

/*-------------------------------- course category ---------------------------------------------*/

    public List<CourseCategory> insertCourseCategory(CourseCategory course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("cc_code", course.getCc_code());
        source.addValue("cc_desc", course.getCc_desc());
        source.addValue("cc_country", course.getCc_country());
        jdbcTemplate.update(queries.getInsertCategory(), source);
        source = new MapSqlParameterSource();
        source.addValue("c_country", course.getCc_country());
        return (List<CourseCategory>) jdbcTemplate.query(queries.getCourseCategories(), source, new MCourseCategory());
    }


    public List<CourseCategory> updateCourseCategory(CourseCategory course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("cc_code", course.getCc_code());
        source.addValue("cc_desc", course.getCc_desc());
        source.addValue("cc_country", course.getCc_country());
        jdbcTemplate.update(queries.getUpdateCourseCategory(), source);
        source = new MapSqlParameterSource();
        source.addValue("cc_country", course.getCc_country());
        source.addValue("cc_code",course.getCc_code());
        return (List<CourseCategory>) jdbcTemplate.query(queries.getCourseCategories(), source, new MCourseCategory());
    }


    public List<CourseCategory> courseCategories(CourseCategory course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("cc_code", course.getCc_code());
        source.addValue("cc_country", course.getCc_country());
        source.addValue("cc_desc",course.getCc_desc());
        return (List<CourseCategory>) jdbcTemplate.query(queries.getCourseCategories(), source, new MCourseCategory());
    }

/*---------------------------------course classes ------------------------------------*/
    public List<CourseClasses> insertCourseClass(CourseClasses classes) throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("cc_code", classes.getCc_code());
        source.addValue("cc_cs_code",classes.getCc_cs_code());
        source.addValue("cc_desc",classes.getCc_desc());
        source.addValue("cc_title",classes.getCc_title());
        source.addValue("cc_cc_code",classes.getCc_cc_code());
        jdbcTemplate.update(queries.getInsertCourseClass(), source);

        return (List<CourseClasses>) jdbcTemplate.query(queries.getCourseClassId(), source, new MCourseClasses());
    }
    public List<CourseClasses> updateCourseClass(CourseClasses classes) throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("cc_code", classes.getCc_code());
        source.addValue("cc_cs_code",classes.getCc_cs_code());
        source.addValue("cc_desc",classes.getCc_desc());
        source.addValue("cc_title",classes.getCc_title());
        jdbcTemplate.update(queries.getUpdateCourseClass(), source);

        return (List<CourseClasses>) jdbcTemplate.query(queries.getCourseClassId(), source, new MCourseClasses());
    }

    public List<CourseClasses> getCourseClassByCode(CourseClasses classes){
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("cc_code", classes.getCc_code());
        source.addValue("cc_cs_code",classes.getCc_cs_code());
        source.addValue("cc_desc",classes.getCc_desc());
        source.addValue("cc_title",classes.getCc_title());
        source.addValue("cc_cc_code",classes.getCc_cc_code());
        System.out.println(queries.getCourseClassId()+" "+classes.toString());
         return (List<CourseClasses>) jdbcTemplate.query(queries.getCourseClassId(), source, new MCourseClasses());
    }
    public List<CourseClasses> getCourseClassByStudyCode(CourseClasses classes){
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("cc_code", classes.getCc_code());
        source.addValue("cc_cs_code",classes.getCc_cs_code());
        source.addValue("cc_desc",classes.getCc_desc());
        source.addValue("cc_title",classes.getCc_title());
        System.out.println(classes.toString());
        return (List<CourseClasses>) jdbcTemplate.query(queries.getCourseClassByStudyCode(), source, new MCourseClasses());
    }

    public List<OrgClasses> getBranchCourseClassById(ObjectNode classes) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode lclasses = mapper.valueToTree(classes);
        System.out.println(lclasses.toString());
         MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("cc_code", lclasses.get("cc_code").toString());
        source.addValue("cc_cs_code",lclasses.get("cc_cs_code").toString());
        source.addValue("cc_desc",lclasses.get("cc_desc").toString());
        source.addValue("cc_title",lclasses.get("cc_title").toString());
        source.addValue("cc_cc_code",lclasses.get("cc_cc_code").textValue());
        source.addValue("bc_oid",lclasses.get("bc_oid").intValue());
        source.addValue("bc_bid",lclasses.get("bc_bid").intValue());
        System.out.println(source.getValues());
        return (List<OrgClasses>) jdbcTemplate.query(queries.getBranchCourseClassById(),source,new MOrgClasses());
    }
    public List<TermFees> getTermFeeByTermList(TermFees termFees) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tf_active_ind",termFees.isTf_active_ind());
        source.addValue("tf_amount",termFees.getTf_amount());
        source.addValue("tf_bid",termFees.getTf_bid());
        source.addValue("tf_fee_id",termFees.getTf_fee_id());
        source.addValue("tf_id",termFees.getTf_id());
        source.addValue("tf_oid",termFees.getTf_oid());
        source.addValue("tf_other_amount",termFees.getTf_other_amount());
        source.addValue("tf_term_id",termFees.getTf_term_id());
        source.addValue("tf_cls_id",termFees.getTf_cls_id());
        source.addValue("tf_cls_code",termFees.getTf_cls_code());
        source.addValue("tf_course_id",termFees.getTf_course_id());
        source.addValue("tf_ay_id",termFees.getTf_ay_id());
        return jdbcTemplate.query(queries.getTermFeeByTermList(),source, new MTermFees());
    }
    public List<TermMapTermFee> getTermMapTermFee(ObjectNode object) throws Exception {
        List<TermMapTermFee> termMapTermFee = new ArrayList<TermMapTermFee>();
        MapSqlParameterSource obj = new MapSqlParameterSource();
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode newNode = objectMapper.valueToTree(object);

        obj.addValue("bc_oid",newNode.get("bc_oid").intValue());
        obj.addValue("bc_bid",newNode.get("bc_bid").intValue());
        obj.addValue("cc_cc_code",newNode.get("cc_cc_code").textValue());
        obj.addValue("bc_cls_code",newNode.get("bc_cls_code").textValue());
        System.out.println(obj.getValues());
        List<OrgClasses> orgClasses = jdbcTemplate.query(queries.getBranchCourseClassById(),obj,new MOrgClasses());
        for(OrgClasses cls:orgClasses){
            Terms term = new Terms();
            term.setT_active_ind(true);
            term.setT_ay(new BigDecimal(cls.getBc_ayid()));
            term.setT_course_category(newNode.get("cc_cc_code").toString());
            term.setT_course(newNode.get("bc_cls_code").toString());
            term.setT_bid(newNode.get("bc_bid").intValue());
            term.setT_oid(newNode.get("bc_oid").intValue());
            obj = new MapSqlParameterSource();

            obj.addValue("t_course_category",newNode.get("cc_cc_code").textValue());
            obj.addValue("t_bid",newNode.get("bc_bid").intValue());
            obj.addValue("t_oid",cls.getBc_oid());//newNode.get("cc_cc_code").toString());
            obj.addValue("t_course",cls.getBc_cls_code());
            obj.addValue("t_ay",cls.getBc_ayid());
            TermMapTermFee mapTerms = new TermMapTermFee();
            mapTerms.setBc_ayid(cls.getBc_ayid());
            mapTerms.setBc_bid(cls.getBc_bid());
            mapTerms.setBc_cls_code(cls.getBc_cls_code());
            mapTerms.setBc_cls_id(cls.getBc_cls_id());
            mapTerms.setBc_dsply_title(cls.getBc_dsply_title());
            mapTerms.setBc_oid(cls.getBc_oid());
            mapTerms.setBc_short_title(cls.getBc_short_title());
            List<Terms> terms = jdbcTemplate.query(queries.getTermsAyCourseCategory(),obj,new MTerms());
            List<TermAndTermFees> fterms = new ArrayList<TermAndTermFees>();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            for(Terms t:terms) {
                System.out.println(t.toString());
                TermAndTermFees ttf = new TermAndTermFees();
                ttf.setT_active_ind(t.isT_active_ind());
                ttf.setT_ay(t.getT_ay());
                ttf.setT_bid(t.getT_bid());
                ttf.setT_cls_id(t.getT_cls_id());
                ttf.setT_course(t.getT_course());
                ttf.setT_course_category(t.getT_course_category());
                ttf.setT_fromdate(df.parse(t.getT_fromdate()));
                ttf.setT_id(t.getT_id());
                ttf.setT_oid(t.getT_oid());
                ttf.setT_title(t.getT_title());
                ttf.setT_todate(df.parse(t.getT_todate()));
                MapSqlParameterSource lsource = new MapSqlParameterSource();
                    lsource.addValue("tf_term_id", ttf.getT_id().intValue());
                    lsource.addValue("tf_other_amount", 0);
                    lsource.addValue("tf_oid", ttf.getT_oid());
                    lsource.addValue("tf_id", null);
                    lsource.addValue("tf_bid", ttf.getT_bid());
                    lsource.addValue("tf_active_ind", true);

                      List<TermFees> ltermFees = jdbcTemplate.query(queries.getTermFeeByTermList(), lsource, new MTermFees());
                      ttf.setTermFees(ltermFees);
                fterms.add(ttf);

                for (TermFees tf : ltermFees) {
                    System.out.println(tf.toString());
                }
               mapTerms.setTerms(fterms);
            }
                termMapTermFee.add(mapTerms);

        }
        return termMapTermFee;
    }
    /*--------------------------------------- class subject ---------------------------------*/

    public List<ClassSubject> insertClassSubject(ClassSubject subject)throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("s_clid", subject.getS_clid());
        source.addValue("s_code",subject.getS_code());
        source.addValue("s_desc",subject.getS_desc());
        source.addValue("s_title",subject.getS_title());
        jdbcTemplate.update(queries.getInsertClassSubject(),source);
        return (List<ClassSubject>) jdbcTemplate.query(queries.getCourseSubjectClsId(),source,new MClassSubject());
    }

    public List<ClassSubject> updateClassSubject(ClassSubject subject)throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("s_clid", subject.getS_clid());
        source.addValue("s_code",subject.getS_code());
        source.addValue("s_desc",subject.getS_desc());
        source.addValue("s_title",subject.getS_title());
        jdbcTemplate.update(queries.getUpdateClassSubject(),source);
        return (List<ClassSubject>) jdbcTemplate.query(queries.getCourseSubjectClsId(),source,new MClassSubject());
    }

    public List<ClassSubject> getClassSubjectById(ClassSubject subject)throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("s_clid", subject.getS_clid());
        source.addValue("s_code",subject.getS_code());
        source.addValue("s_desc",subject.getS_desc());
        source.addValue("s_title",subject.getS_title());

        return (List<ClassSubject>) jdbcTemplate.query(queries.getCourseSubjectId(),source,new MClassSubject());
    }

    public List<ClassSubject> getClassSubjectByClsId(ClassSubject subject)throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("s_clid", subject.getS_clid());
        source.addValue("s_code",subject.getS_code());
        source.addValue("s_desc",subject.getS_desc());
        source.addValue("s_title",subject.getS_title());

        return (List<ClassSubject>) jdbcTemplate.query(queries.getCourseSubjectClsId(),source,new MClassSubject());
    }
    public List<ClassSubject> getClassSubject()throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();


        return (List<ClassSubject>) jdbcTemplate.query(queries.getCourseClassSubjects(),source,new MClassSubject());
    }
    /*------------------------------- organization classes ------------------------------*/
    public List<OrgClasses> insertOrgClasses(OrgClasses classes)throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("bc_cls_code", classes.getBc_cls_code());
        source.addValue("bc_cls_id",classes.getBc_cls_id());
        source.addValue("bc_dsply_title",classes.getBc_dsply_title());
        source.addValue("bc_short_title",classes.getBc_short_title());
        source.addValue("bc_bid",classes.getBc_bid());
        source.addValue("bc_ayid",classes.getBc_ayid());

        jdbcTemplate.update(queries.getInsertOrgClasses(),source);
        return (List<OrgClasses>) jdbcTemplate.query(queries.getOrgClasses(),source,new MOrgClasses());
    }

    public List<OrgClasses> updateOrgClass(OrgClasses classes)throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("bc_cls_code", classes.getBc_cls_code());
        source.addValue("bc_cls_id",classes.getBc_cls_id());
        source.addValue("bc_dsply_title",classes.getBc_dsply_title());
        source.addValue("bc_short_title",classes.getBc_short_title());
        source.addValue("bc_bid",classes.getBc_bid());
        source.addValue("bc_ayid",classes.getBc_ayid());

        jdbcTemplate.update(queries.getUpdateOrgClasses(),source);
        return (List<OrgClasses>) jdbcTemplate.query(queries.getOrgClasses(),source,new MOrgClasses());
    }

    public List<OrgClasses> getOrgClassByOrgID(OrgClasses classes)throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();

        System.out.println(classes.toString());
        source.addValue("bc_cls_code", classes.getBc_cls_code());
        source.addValue("bc_cls_id",classes.getBc_cls_id());
        source.addValue("bc_dsply_title",classes.getBc_dsply_title());
        source.addValue("bc_short_title",classes.getBc_short_title());
        source.addValue("bc_bid",classes.getBc_bid());
        source.addValue("bc_ayid",classes.getBc_ayid());

        return (List<OrgClasses>) jdbcTemplate.query(queries.getOrgClasses(),source,new MOrgClasses());
    }

    public List<OrgClasses> getOrgClassesByClsId(OrgClasses classes)throws SQLException{
        MapSqlParameterSource source = new MapSqlParameterSource();


        source.addValue("bc_cls_code", classes.getBc_cls_code());
        source.addValue("bc_cls_id",classes.getBc_cls_id());
        source.addValue("bc_dsply_title",classes.getBc_dsply_title());
        source.addValue("bc_short_title",classes.getBc_short_title());
        source.addValue("bc_bid",classes.getBc_bid());
        source.addValue("bc_ayid",classes.getBc_ayid());
        return (List<OrgClasses>) jdbcTemplate.query(queries.getOrgClassesByCls(),source,new MOrgClasses());
    }

    /*-------------------------------------study branch ---------------------------------------*/
    public List<StudyBranchLookup> insertStudyBranch(StudyBranchLookup study) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("sb_title", study.getSb_title());
        jdbcTemplate.update(queries.getInsertStudyBranch(), source);
        source = new MapSqlParameterSource();
        return (List<StudyBranchLookup>) jdbcTemplate.query(queries.getStudyBranchList(), source, new MStudyBranchLookup());
    }


    public List<StudyBranchLookup> deleteStudyBranch(StudyBranchLookup study) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("sb_title", study.getSb_title());
        jdbcTemplate.update(queries.getDeleteStudyBranch(), source);
        source = new MapSqlParameterSource();

        return (List<StudyBranchLookup>) jdbcTemplate.query(queries.getStudyBranchList(), source, new MStudyBranchLookup());
    }


    public List<StudyBranchLookup> studyBranchList(StudyBranchLookup study) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        return (List<StudyBranchLookup>) jdbcTemplate.query(queries.getStudyBranchList(), source, new MStudyBranchLookup());
    }


    public List<StudyBranchLookup> insertBulkstudyBranch(List<StudyBranchLookup> studys) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(studys.size());
        for (StudyBranchLookup study : studys) {
            batchValues.add(
                    new MapSqlParameterSource("sb_title", study.getSb_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertStudyBranch(), batchValues.toArray(new Map[studys.size()]));
        return studyBranchList(studys.get(0));
    }


    public List<StudyBranchLookup> updateBulkstudyBranch(List<StudyBranchLookup> studys) throws SQLException {
        return null;
    }


    public List<StudyBranchLookup> deleteBulkstudyBranch(List<StudyBranchLookup> studys) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(studys.size());
        for (StudyBranchLookup study : studys) {
            batchValues.add(
                    new MapSqlParameterSource("sb_title", study.getSb_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteStudyBranch(), batchValues.toArray(new Map[studys.size()]));
        return studyBranchList(studys.get(0));
    }


    public List<DistrictLookup> insertDistrict(DistrictLookup district) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        source.addValue("d_title", district.getD_title());
        jdbcTemplate.update(queries.getInsertDistrict(), source);
        source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        return (List<DistrictLookup>) jdbcTemplate.query(queries.getDistrictByState(), source, new MDistrictLookup());
    }


    public List<DistrictLookup> updateDistrict(DistrictLookup district) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        source.addValue("d_title", district.getD_title());
        source.addValue("d_id", district.getD_id());
        jdbcTemplate.update(queries.getUpdateDistrict(), source);
        source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        return (List<DistrictLookup>) jdbcTemplate.query(queries.getDistrictByState(), source, new MDistrictLookup());
    }


    public List<DistrictLookup> deleteDistrict(DistrictLookup district) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        source.addValue("d_id", district.getD_id());
        jdbcTemplate.update(queries.getDeleteDistrict(), source);
        source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        return (List<DistrictLookup>) jdbcTemplate.query(queries.getDistrictByState(), source, new MDistrictLookup());
    }


    public List<DistrictLookup> districtById(DistrictLookup district) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        source.addValue("d_id", district.getD_id());
        return (List<DistrictLookup>) jdbcTemplate.query(queries.getDistrictById(), source, new MDistrictLookup());
    }


    public List<DistrictLookup> districtByName(DistrictLookup district) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        source.addValue("d_title", district.getD_title());
        return (List<DistrictLookup>) jdbcTemplate.query(queries.getDistrictByName(), source, new MDistrictLookup());
    }


    public List<DistrictLookup> districtByState(DistrictLookup district) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("d_country", district.getD_country());
        source.addValue("d_state", district.getD_state());
        return (List<DistrictLookup>) jdbcTemplate.query(queries.getDistrictByState(), source, new MDistrictLookup());
    }


    public List<DistrictLookup> insertBulkDistrict(List<DistrictLookup> districts) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(districts.size());
        for (DistrictLookup district : districts) {
            batchValues.add(
                    new MapSqlParameterSource("d_country", district.getD_country())
                            .addValue("d_state", district.getD_state())
                            .addValue("d_title", district.getD_title())
                            .addValue("d_id", district.getD_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertDistrict(), batchValues.toArray(new Map[districts.size()]));
        return districtByState(districts.get(0));
    }


    public List<DistrictLookup> updateBulkDistrict(List<DistrictLookup> districts) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(districts.size());
        for (DistrictLookup district : districts) {
            batchValues.add(
                    new MapSqlParameterSource("d_country", district.getD_country())
                            .addValue("d_state", district.getD_state())
                            .addValue("d_title", district.getD_title())
                            .addValue("d_id", district.getD_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateDistrict(), batchValues.toArray(new Map[districts.size()]));
        return districtByState(districts.get(0));
    }


    public List<DistrictLookup> deleteBulkDistrict(List<DistrictLookup> districts) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(districts.size());
        for (DistrictLookup district : districts) {
            batchValues.add(
                    new MapSqlParameterSource("d_country", district.getD_country())
                            .addValue("d_state", district.getD_state())
                            .addValue("d_id", district.getD_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteDistrict(), batchValues.toArray(new Map[districts.size()]));
        return districtByState(districts.get(0));
    }


    public List<MandalLookup> insertMandal(MandalLookup mandal) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("m_district", mandal.getM_district());
        source.addValue("m_id", mandal.getM_id());
        source.addValue("m_title", mandal.getM_title());
        jdbcTemplate.update(queries.getInsertMandal(), source);
        source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("d_state", mandal.getM_district());
        return (List<MandalLookup>) jdbcTemplate.query(queries.getMandalByDistrict(), source, new MMandalLookup());
    }


    public List<MandalLookup> updateMandal(MandalLookup mandal) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("m_district", mandal.getM_district());
        source.addValue("m_id", mandal.getM_id());
        source.addValue("m_title", mandal.getM_title());
        jdbcTemplate.update(queries.getUpdateMandal(), source);
        source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("d_state", mandal.getM_district());
        return (List<MandalLookup>) jdbcTemplate.query(queries.getMandalByDistrict(), source, new MMandalLookup());
    }


    public List<MandalLookup> deleteMandal(MandalLookup mandal) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("m_district", mandal.getM_district());
        source.addValue("m_id", mandal.getM_id());
        jdbcTemplate.update(queries.getDeleteMandal(), source);
        source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("d_state", mandal.getM_district());
        return (List<MandalLookup>) jdbcTemplate.query(queries.getMandalByDistrict(), source, new MMandalLookup());
    }


    public List<MandalLookup> mandalById(MandalLookup mandal) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("m_district", mandal.getM_district());
        source.addValue("m_id", mandal.getM_id());
        return (List<MandalLookup>) jdbcTemplate.query(queries.getMandalById(), source, new MMandalLookup());
    }


    public List<MandalLookup> mandalByName(MandalLookup mandal) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("m_district", mandal.getM_district());
        source.addValue("m_title", mandal.getM_title());
        return (List<MandalLookup>) jdbcTemplate.query(queries.getMandalByName(), source, new MMandalLookup());
    }


    public List<MandalLookup> mandalByDistrict(MandalLookup mandal) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("m_country", mandal.getM_country());
        source.addValue("m_state", mandal.getM_state());
        source.addValue("m_district", mandal.getM_district());

        return (List<MandalLookup>) jdbcTemplate.query(queries.getMandalByDistrict(), source, new MMandalLookup());
    }


    public List<MandalLookup> insertBulkMandal(List<MandalLookup> mandals) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(mandals.size());
        for (MandalLookup mandal : mandals) {
            batchValues.add(
                    new MapSqlParameterSource("m_country", mandal.getM_country())
                            .addValue("m_state", mandal.getM_state())
                            .addValue("m_district", mandal.getM_district())
                            .addValue("m_id", mandal.getM_id())
                            .addValue("m_title", mandal.getM_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertMandal(), batchValues.toArray(new Map[mandals.size()]));
        return mandalByDistrict(mandals.get(0));
    }


    public List<MandalLookup> updateBulkMandal(List<MandalLookup> mandals) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(mandals.size());
        for (MandalLookup mandal : mandals) {
            batchValues.add(
                    new MapSqlParameterSource("m_country", mandal.getM_country())
                            .addValue("m_state", mandal.getM_state())
                            .addValue("m_district", mandal.getM_district())
                            .addValue("m_id", mandal.getM_id())
                            .addValue("m_title", mandal.getM_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateMandal(), batchValues.toArray(new Map[mandals.size()]));
        return mandalByDistrict(mandals.get(0));
    }


    public List<MandalLookup> deleteBulkMandal(List<MandalLookup> mandals) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(mandals.size());
        for (MandalLookup mandal : mandals) {
            batchValues.add(
                    new MapSqlParameterSource("m_country", mandal.getM_country())
                            .addValue("m_state", mandal.getM_state())
                            .addValue("m_district", mandal.getM_district())
                            .addValue("m_id", mandal.getM_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteMandal(), batchValues.toArray(new Map[mandals.size()]));
        return mandalByDistrict(mandals.get(0));
    }


    public List<ZoneLookup> insertZone(ZoneLookup zone) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());
        source.addValue("z_active_ind", zone.isZ_active_ind());
        source.addValue("z_title", zone.getZ_title());
        jdbcTemplate.update(queries.getInsertZone(), source);
        source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());
        return (List<ZoneLookup>) jdbcTemplate.query(queries.getZoneByState(), source, new MZoneLookup());
    }


    public List<ZoneLookup> updateZone(ZoneLookup zone) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());
        source.addValue("z_active_ind", zone.isZ_active_ind());
        source.addValue("z_title", zone.getZ_title());
        source.addValue("z_id", zone.getZ_id());
        jdbcTemplate.update(queries.getUpdateZone(), source);
        source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());
        return (List<ZoneLookup>) jdbcTemplate.query(queries.getZoneByState(), source, new MZoneLookup());
    }


    public List<ZoneLookup> deleteZone(ZoneLookup zone) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());
        source.addValue("z_id", zone.getZ_id());

        jdbcTemplate.update(queries.getDeleteZone(), source);
        source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());
        return (List<ZoneLookup>) jdbcTemplate.query(queries.getZoneByState(), source, new MZoneLookup());
    }


    public List<ZoneLookup> zoneById(ZoneLookup zone) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());
        source.addValue("z_id", zone.getZ_id());

        return (List<ZoneLookup>) jdbcTemplate.query(queries.getZoneById(), source, new MZoneLookup());
    }


    public List<ZoneLookup> zoneByName(ZoneLookup zone) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());
        source.addValue("z_title", zone.getZ_title());

        return (List<ZoneLookup>) jdbcTemplate.query(queries.getZoneByName(), source, new MZoneLookup());
    }


    public List<ZoneLookup> zoneByState(ZoneLookup zone) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("z_country", zone.getZ_country());
        source.addValue("z_state", zone.getZ_state());


        return (List<ZoneLookup>) jdbcTemplate.query(queries.getZoneByState(), source, new MZoneLookup());
    }


    public List<ZoneLookup> insertBulkZone(List<ZoneLookup> zones) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(zones.size());
        for (ZoneLookup zone : zones) {
            batchValues.add(
                    new MapSqlParameterSource("z_country", zone.getZ_country())
                            .addValue("z_state", zone.getZ_state())
                            .addValue("z_active_ind", zone.isZ_active_ind())
                            .addValue("z_title", zone.getZ_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertZone(), batchValues.toArray(new Map[zones.size()]));
        return deleteZone(zones.get(0));
    }


    public List<ZoneLookup> updateBulkZone(List<ZoneLookup> zones) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(zones.size());
        for (ZoneLookup zone : zones) {
            batchValues.add(
                    new MapSqlParameterSource("z_country", zone.getZ_country())
                            .addValue("z_state", zone.getZ_state())
                            .addValue("z_active_ind", zone.isZ_active_ind())
                            .addValue("z_title", zone.getZ_title())
                            .addValue("z_id", zone.getZ_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateZone(), batchValues.toArray(new Map[zones.size()]));
        return zoneByState(zones.get(0));
    }


    public List<ZoneLookup> deleteBulkZone(List<ZoneLookup> zones) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(zones.size());
        for (ZoneLookup zone : zones) {
            batchValues.add(
                    new MapSqlParameterSource("z_country", zone.getZ_country())
                            .addValue("z_state", zone.getZ_state())
                            .addValue("z_id", zone.getZ_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateZone(), batchValues.toArray(new Map[zones.size()]));
        return zoneByState(zones.get(0));


    }


    public List<CategoryLookup> insertCategory(CategoryLookup category) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("c_country", category.getC_country());
        source.addValue("c_title", category.getC_title());
        jdbcTemplate.update(queries.getInsertCategory(), source);
        source = new MapSqlParameterSource();
        source.addValue("c_country", category.getC_country());

        return (List<CategoryLookup>) jdbcTemplate.query(queries.getCategories(), source, new MCategoryLookup());

    }


    public List<CategoryLookup> updateCategory(CategoryLookup category) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("c_country", category.getC_country());
        source.addValue("c_title", category.getC_title());
        jdbcTemplate.update(queries.getUpdateCategory(), source);
        source = new MapSqlParameterSource();
        source.addValue("c_country", category.getC_country());

        return (List<CategoryLookup>) jdbcTemplate.query(queries.getCategories(), source, new MCategoryLookup());
    }


    public List<CategoryLookup> deleteCategory(CategoryLookup category) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("c_country", category.getC_country());
        source.addValue("c_title", category.getC_title());
        jdbcTemplate.update(queries.getDeleteCategory(), source);
        source = new MapSqlParameterSource();
        source.addValue("c_country", category.getC_country());

        return (List<CategoryLookup>) jdbcTemplate.query(queries.getCategories(), source, new MCategoryLookup());
    }


    public List<CategoryLookup> categoryByName(CategoryLookup category) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("c_country", category.getC_country());
        source.addValue("c_title", category.getC_title());
        return (List<CategoryLookup>) jdbcTemplate.query(queries.getCategoryByName(), source, new MCategoryLookup());
    }


    public List<CategoryLookup> categories(CategoryLookup category) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("c_country", category.getC_country());

        return (List<CategoryLookup>) jdbcTemplate.query(queries.getCategories(), source, new MCategoryLookup());
    }


    public List<CategoryLookup> insertBulkcategory(List<CategoryLookup> categories) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(categories.size());
        for (CategoryLookup category : categories) {
            batchValues.add(
                    new MapSqlParameterSource("c_country", category.getC_country())
                            .addValue("c_title", category.getC_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertCategory(), batchValues.toArray(new Map[categories.size()]));
        return categories(categories.get(0));
    }


    public List<CategoryLookup> updateBulkcategory(List<CategoryLookup> categories) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(categories.size());
        for (CategoryLookup category : categories) {
            batchValues.add(
                    new MapSqlParameterSource("c_country", category.getC_country())
                            .addValue("c_title", category.getC_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateCategory(), batchValues.toArray(new Map[categories.size()]));
        return categories(categories.get(0));
    }


    public List<CategoryLookup> deleteBulkcategory(List<CategoryLookup> categories) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(categories.size());
        for (CategoryLookup category : categories) {
            batchValues.add(
                    new MapSqlParameterSource("c_country", category.getC_country())
                            .addValue("c_title", category.getC_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteCategory(), batchValues.toArray(new Map[categories.size()]));
        return categories(categories.get(0));
    }


    public List<AcademicYear> insertAcademicYear(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_batch", academic.getAy_batch());
        source.addValue("ay_clevel", academic.getAy_clevel());
        source.addValue("ay_fromdate", academic.getAy_fromdate());
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_todate", academic.getAy_todate());
        source.addValue("ay_year", academic.getAy_year());
        source.addValue("ay_active_ind", academic.isAy_active_ind());
        source.addValue("ay_admission_ind", academic.isAy_admission_ind());
        jdbcTemplate.update(queries.getInsertAcademicYear(), source);
        source = new MapSqlParameterSource();
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_batch", academic.getAy_batch());


        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearByBatch(), source, new MAcademicYear());
    }


    public List<AcademicYear> updateAcademicYear(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_batch", academic.getAy_batch());
        source.addValue("ay_clevel", academic.getAy_clevel());
        source.addValue("ay_fromdate", academic.getAy_fromdate());
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_todate", academic.getAy_todate());
        source.addValue("ay_year", academic.getAy_year());
        source.addValue("ay_active_ind", academic.isAy_active_ind());
        source.addValue("ay_admission_ind", academic.isAy_admission_ind());
        source.addValue("ay_id", academic.getAy_id());
        jdbcTemplate.update(queries.getUpdateAcademicYear(), source);
        source = new MapSqlParameterSource();
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_batch", academic.getAy_batch());


        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearByBatch(), source, new MAcademicYear());
    }


    public List<AcademicYear> deleteAcademicYear(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_id", academic.getAy_id());
        jdbcTemplate.update(queries.getDeleteAcademicYear(), source);
        source = new MapSqlParameterSource();
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_batch", academic.getAy_batch());


        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearByBatch(), source, new MAcademicYear());
    }


    public List<AcademicYear> academicYearById(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_id", academic.getAy_id());
        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearById(), source, new MAcademicYear());
    }


    public List<AcademicYear> academicYearByBatch(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_batch", academic.getAy_batch());
        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearByBatch(), source, new MAcademicYear());
    }


    public List<AcademicYear> academicYearByYear(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_year", academic.getAy_year());
        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearByYear(), source, new MAcademicYear());
    }


    public List<AcademicYear> allActiveAcademicYear(AcademicYear academic) throws SQLException {
        BatchesLookup pbatch = new BatchesLookup();
        pbatch.setB_oid(academic.getAy_oid());
        List<BatchesLookup> batches = activeBatches(pbatch);
        List<String> batchlist = batches.stream().map(name -> name.getB_batchtitle()).collect(Collectors.toList());
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_batch", batchlist);

        return (List<AcademicYear>) jdbcTemplate.query(queries.getAllActiveAcademicYear(), source, new MAcademicYear());
    }


    public List<AcademicYear> insertBulkAcademicYear(List<AcademicYear> academics) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(academics.size());
        for (AcademicYear academic : academics) {
            batchValues.add(
                    new MapSqlParameterSource("ay_batch", academic.getAy_batch())
                            .addValue("ay_clevel", academic.getAy_clevel())
                            .addValue("ay_fromdate", academic.getAy_fromdate())
                            .addValue("ay_oid", academic.getAy_oid())
                            .addValue("ay_todate", academic.getAy_todate())
                            .addValue("ay_year", academic.getAy_year())
                            .addValue("ay_active_ind", academic.isAy_active_ind())
                            .addValue("ay_admission_ind", academic.isAy_admission_ind())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertAcademicYear(), batchValues.toArray(new Map[academics.size()]));
        return allActiveAcademicYear(academics.get(0));
    }


    public List<AcademicYear> updateBulkAcademicYear(List<AcademicYear> academics) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(academics.size());
        for (AcademicYear academic : academics) {
            batchValues.add(
                    new MapSqlParameterSource("ay_batch", academic.getAy_batch())
                            .addValue("ay_clevel", academic.getAy_clevel())
                            .addValue("ay_fromdate", academic.getAy_fromdate())
                            .addValue("ay_oid", academic.getAy_oid())
                            .addValue("ay_todate", academic.getAy_todate())
                            .addValue("ay_year", academic.getAy_year())
                            .addValue("ay_active_ind", academic.isAy_active_ind())
                            .addValue("ay_admission_ind", academic.isAy_admission_ind())
                            .addValue("ay_id", academic.getAy_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateAcademicYear(), batchValues.toArray(new Map[academics.size()]));
        return allActiveAcademicYear(academics.get(0));
    }


    public List<AcademicYear> deleteBulkAcademicYear(List<AcademicYear> academics) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(academics.size());
        for (AcademicYear academic : academics) {
            batchValues.add(
                    new MapSqlParameterSource("ay_oid", academic.getAy_oid())
                            .addValue("ay_id", academic.getAy_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteAcademicYear(), batchValues.toArray(new Map[academics.size()]));
        return allActiveAcademicYear(academics.get(0));
    }


    public List<AcademicYear> academicYearByCourse(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_clevel", academic.getAy_clevel());

        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearByCourse(), source, new MAcademicYear());
    }


    public List<AcademicYear> academicYear(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_year", academic.getAy_year());

        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearByYear(), source, new MAcademicYear());
    }


    public List<AcademicYear> aciveAdmissionYear(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("ay_oid", academic.getAy_oid());
        source.addValue("ay_year", academic.getAy_year());

        return (List<AcademicYear>) jdbcTemplate.query(queries.getAciveAdmissionYear(), source, new MAcademicYear());
    }
    public List<AcademicYear> academicYearByOrgId(AcademicYear academic) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("ay_oid", academic.getAy_oid());

        return (List<AcademicYear>) jdbcTemplate.query(queries.getAcademicYearByOrgId(), source, new MAcademicYear());
    }

    public List<Terms> insertTerm(List<Terms> terms) throws Exception {
        List<Map<String, Object>> batchInsValues = new ArrayList<>(terms.size());
        List<Map<String, Object>> batchUpdValues = new ArrayList<>(terms.size());
        SimpleDateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
        SimpleDateFormat dp = new SimpleDateFormat("dd-MM-yyyy");
        String d1 = "";
        String d2 = "";
        int insert=0;
        int update=0;
        for (Terms term : terms) {

            System.out.println(term.toString());

            if (term.getT_id().intValue() == 0) {
                insert+=1;
                d1 = dp.format(term.getT_fromdate());
                d2 = dp.format(term.getT_todate());

                batchInsValues.add(
                        new MapSqlParameterSource(

                                "t_id", term.getT_id())
                                .addValue("t_ay", term.getT_ay())
                                .addValue("t_title", term.getT_title())
                                .addValue("t_cls_id", term.getT_cls_id())
                                .addValue("t_course_category", term.getT_course_category())
                                .addValue("t_course", term.getT_course())
                                .addValue("t_fromdate", d1,Types.VARCHAR)
                                .addValue("t_todate", d2,Types.VARCHAR)
                                .addValue("t_active_ind", term.isT_active_ind())
                                .addValue("t_oid", term.getT_oid())
                                .addValue("t_bid", term.getT_bid())
                                .getValues());
            } else {update+=1;
                d1 = dp.format(term.getT_fromdate());
                d2 = dp.format(term.getT_todate());
                System.out.println(d1+" "+d2);
                batchUpdValues.add(

                        new MapSqlParameterSource(
                                "t_id", term.getT_id())
                                .addValue("t_ay", term.getT_ay())
                                .addValue("t_title", term.getT_title())
                                .addValue("t_cls_id", term.getT_cls_id(),Types.VARCHAR)
                                .addValue("t_course_category", term.getT_course_category(),Types.VARCHAR)
                                .addValue("t_course", term.getT_course(),Types.VARCHAR)
                                .addValue("t_fromdate",d1, Types.VARCHAR)
                                .addValue("t_todate", d2,Types.VARCHAR)
                                .addValue("t_active_ind", term.isT_active_ind())
                                .addValue("t_oid", term.getT_oid())
                                .addValue("t_bid", term.getT_bid())
                                .getValues());
            }
        }
        MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("t_id", terms.get(0).getT_id())
                    .addValue("t_ay", terms.get(0).getT_ay())
                    .addValue("t_title", terms.get(0).getT_title())
                    .addValue("t_cls_id", terms.get(0).getT_cls_id())
                    .addValue("t_course_category", terms.get(0).getT_course_category())
                    .addValue("t_course", terms.get(0).getT_course())
                    .addValue("t_fromdate", terms.get(0).getT_fromdate(),Types.VARCHAR)
                    .addValue("t_todate", terms.get(0).getT_todate(),Types.VARCHAR)
                    .addValue("t_active_ind", terms.get(0).isT_active_ind())
                    .addValue("t_oid", terms.get(0).getT_oid())
                    .addValue("t_bid", terms.get(0).getT_bid());
        System.out.println(batchInsValues.toString());
        System.out.println(batchUpdValues.toString());
        jdbcTemplate.batchUpdate(queries.getInsertTerm(), batchInsValues.toArray(new Map[insert]));
        jdbcTemplate.batchUpdate(queries.getUpdateTerm(),batchUpdValues.toArray(new Map[update]));
        return (List<Terms>) jdbcTemplate.query(queries.getTermByAacademicYear(), source, new MTerms());
    }


    public List<Terms> updateTerm(Terms terms) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("t_id",terms.getT_id());
        source.addValue("t_ay",terms.getT_ay());
        source.addValue("t_title",terms.getT_title());
        source.addValue("t_cls_id",terms.getT_cls_id());
        source.addValue("t_course_category",terms.getT_course_category());
        source.addValue("t_course",terms.getT_course());
        source.addValue("t_fromdate",terms.getT_fromdate());
        source.addValue("t_todate",terms.getT_todate());
        source.addValue("t_active_ind",terms.isT_active_ind());
        source.addValue("t_oid",terms.getT_oid());
        source.addValue("t_bid",terms.getT_bid());
        jdbcTemplate.update(queries.getUpdateTerm(), source);

        return (List<Terms>) jdbcTemplate.query(queries.getTermByAacademicYear(), source, new MTerms());

    }

    public List<Terms> deleteTermList(List<Terms> terms) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(terms.size());

        for (Terms term : terms) {
            batchValues.add(
                    new MapSqlParameterSource("t_id",term.getT_id())
                                    .addValue("t_ay",term.getT_ay())
            .addValue("t_title",term.getT_title())
            .addValue("t_cls_id",term.getT_cls_id())
            .addValue("t_course_category",term.getT_course_category())
            .addValue("t_course",term.getT_course())
            .addValue("t_fromdate",term.getT_fromdate())
            .addValue("t_todate",term.getT_todate())
            .addValue("t_active_ind",term.isT_active_ind())
            .addValue("t_oid",term.getT_oid())
            .addValue("t_bid",term.getT_bid())
                    .getValues());
        }


        jdbcTemplate.batchUpdate(queries.getDeleteTerm(),batchValues.toArray(new Map[terms.size()]));
        return termByAacademicYear(terms.get(0));
    }


    public List<Terms> deleteTerm(Terms terms) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();


        source.addValue("t_id",terms.getT_id());
        source.addValue("t_ay",terms.getT_ay());
        source.addValue("t_title",terms.getT_title());
        source.addValue("t_cls_id",terms.getT_cls_id());
        source.addValue("t_course_category",terms.getT_course_category());
        source.addValue("t_course",terms.getT_course());
        source.addValue("t_fromdate",terms.getT_fromdate());
        source.addValue("t_todate",terms.getT_todate());
        source.addValue("t_active_ind",terms.isT_active_ind());
        source.addValue("t_oid",terms.getT_oid());
        source.addValue("t_bid",terms.getT_bid());

        jdbcTemplate.update(queries.getDeleteTerm(), source);
        return (List<Terms>) jdbcTemplate.query(queries.getTermByAacademicYear(), source, new MTerms());
    }


    public List<Terms> termByAacademicYear(Terms terms) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("t_id",terms.getT_id());
        source.addValue("t_ay",terms.getT_ay());
        source.addValue("t_title",terms.getT_title());
        source.addValue("t_cls_id",terms.getT_cls_id());
        source.addValue("t_course_category",terms.getT_course_category());
        source.addValue("t_course",terms.getT_course());
        source.addValue("t_fromdate",terms.getT_fromdate());
        source.addValue("t_todate",terms.getT_todate());
        source.addValue("t_active_ind",terms.isT_active_ind());
        source.addValue("t_oid",terms.getT_oid());
        source.addValue("t_bid",terms.getT_bid());

        return (List<Terms>) jdbcTemplate.query(queries.getTermByAacademicYear(), source, new MTerms());
    }


    public List<Terms> termById(Terms terms) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("t_id",terms.getT_id());
        source.addValue("t_ay",terms.getT_ay());
        source.addValue("t_title",terms.getT_title());
        source.addValue("t_cls_id",terms.getT_cls_id());
        source.addValue("t_course_category",terms.getT_course_category());
        source.addValue("t_course",terms.getT_course());
        source.addValue("t_fromdate",terms.getT_fromdate());
        source.addValue("t_todate",terms.getT_todate());
        source.addValue("t_active_ind",terms.isT_active_ind());
        source.addValue("t_oid",terms.getT_oid());
        source.addValue("t_bid",terms.getT_bid());

        return (List<Terms>) jdbcTemplate.query(queries.getTermById(), source, new MTerms());
    }


    public List<Terms> termByTitle(Terms terms) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("t_id",terms.getT_id());
        source.addValue("t_ay",terms.getT_ay());
        source.addValue("t_title",terms.getT_title());
        source.addValue("t_cls_id",terms.getT_cls_id());
        source.addValue("t_course_category",terms.getT_course_category());
        source.addValue("t_course",terms.getT_course());
        source.addValue("t_fromdate",terms.getT_fromdate());
        source.addValue("t_todate",terms.getT_todate());
        source.addValue("t_active_ind",terms.isT_active_ind());
        source.addValue("t_oid",terms.getT_oid());
        source.addValue("t_bid",terms.getT_bid());

        return (List<Terms>) jdbcTemplate.query(queries.getTermByTitle(), source, new MTerms());
    }
    public List<Terms> getTermByAyCourseCategory(Terms terms) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("t_id",terms.getT_id());
        source.addValue("t_ay",terms.getT_ay());
        source.addValue("t_title",terms.getT_title());
        source.addValue("t_cls_id",terms.getT_cls_id());
        source.addValue("t_course_category",terms.getT_course_category());
        source.addValue("t_course",terms.getT_course());
        source.addValue("t_fromdate",terms.getT_fromdate());
        source.addValue("t_todate",terms.getT_todate());
        source.addValue("t_active_ind",terms.isT_active_ind());
        source.addValue("t_oid",terms.getT_oid());
        source.addValue("t_bid",terms.getT_bid());
        return jdbcTemplate.query(queries.getTermsAyCourseCategory(),source,new MTerms());
    }
    public List<Terms> getTermsAyCourseClsCategory(Terms terms) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("t_id",terms.getT_id());
        source.addValue("t_ay",terms.getT_ay());
        source.addValue("t_title",terms.getT_title());
        source.addValue("t_cls_id",terms.getT_cls_id());
        source.addValue("t_course_category",terms.getT_course_category());
        source.addValue("t_course",terms.getT_course());
        source.addValue("t_fromdate",terms.getT_fromdate());
        source.addValue("t_todate",terms.getT_todate());
        source.addValue("t_active_ind",terms.isT_active_ind());
        source.addValue("t_oid",terms.getT_oid());
        source.addValue("t_bid",terms.getT_bid());
        return jdbcTemplate.query(queries.getTermsAyCourseClsCategory(),source,new MTerms());
    }

    public List<Terms> getTermsByAyCourseClass(Terms terms) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("t_id",terms.getT_id());
        source.addValue("t_ay",terms.getT_ay());
        source.addValue("t_title",terms.getT_title());
        source.addValue("t_cls_id",terms.getT_cls_id());
        source.addValue("t_course_category",terms.getT_course_category());
        source.addValue("t_course",terms.getT_course());
        source.addValue("t_fromdate",terms.getT_fromdate());
        source.addValue("t_todate",terms.getT_todate());
        source.addValue("t_active_ind",terms.isT_active_ind());
        source.addValue("t_oid",terms.getT_oid());
        source.addValue("t_bid",terms.getT_bid());
        return jdbcTemplate.query(queries.getTermsAyCourseClass(),source,new MTerms());
    }


    public List<Terms> insertBulkTerm(List<Terms> terms) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(terms.size());
        for (Terms term : terms) {
            batchValues.add(
                    new MapSqlParameterSource("t_active_ind", term.isT_active_ind())
                            .addValue("t_id",term.getT_id())
                            .addValue("t_ay",term.getT_ay())
                            .addValue("t_title",term.getT_title())
                            .addValue("t_cls_id",term.getT_cls_id())
                            .addValue("t_course_category",term.getT_course_category())
                            .addValue("t_course",term.getT_course())
                            .addValue("t_fromdate",term.getT_fromdate())
                            .addValue("t_todate",term.getT_todate())
                            .addValue("t_oid",term.getT_oid())
                            .addValue("t_bid",term.getT_bid())
                            .getValues());

        }

        jdbcTemplate.batchUpdate(queries.getInsertTerm(), batchValues.toArray(new Map[terms.size()]));
        return termByAacademicYear(terms.get(0));
    }


    public List<Terms> updateBulkTerm(List<Terms> terms) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(terms.size());
        for (Terms term : terms) {
            batchValues.add(
                    new MapSqlParameterSource("t_active_ind", term.isT_active_ind())
                    .addValue("t_id",term.getT_id())
                    .addValue("t_ay",term.getT_ay())
                    .addValue("t_title",term.getT_title())
                    .addValue("t_cls_id",term.getT_cls_id())
                    .addValue("t_course_category",term.getT_course_category())
                    .addValue("t_course",term.getT_course())
                    .addValue("t_fromdate",term.getT_fromdate())
                    .addValue("t_todate",term.getT_todate())
                    .addValue("t_oid",term.getT_oid())
                    .addValue("t_bid",term.getT_bid())
                                    .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateTerm(), batchValues.toArray(new Map[terms.size()]));
        return termByAacademicYear(terms.get(0));
    }

    /*public List<Terms> deleteTerm(Terms term) throws SQLException {
                 MapSqlParameterSource source =   new MapSqlParameterSource(
                            "t_active_ind", term.isT_active_ind())
                            .addValue("t_id",term.getT_id())
                            .addValue("t_ay",term.getT_ay())
                            .addValue("t_title",term.getT_title())
                            .addValue("t_cls_id",term.getT_cls_id())
                            .addValue("t_course_category",term.getT_course_category())
                            .addValue("t_course",term.getT_course())
                            .addValue("t_fromdate",term.getT_fromdate())
                            .addValue("t_todate",term.getT_todate())
                            .addValue("t_oid",term.getT_oid())
                            .addValue("t_bid",term.getT_bid());



        jdbcTemplate.update(queries.getDeleteTerm(), source);
        return termByAacademicYear(term);
    }
*/
    public List<Terms> deleteBulkTerm(List<Terms> terms) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(terms.size());
        for (Terms term : terms) {
            batchValues.add(
                    new MapSqlParameterSource("t_active_ind", term.isT_active_ind())
                            .addValue("t_id",term.getT_id())
                            .addValue("t_ay",term.getT_ay())
                            .addValue("t_title",term.getT_title())
                            .addValue("t_cls_id",term.getT_cls_id())
                            .addValue("t_course_category",term.getT_course_category())
                            .addValue("t_course",term.getT_course())
                            .addValue("t_fromdate",term.getT_fromdate())
                            .addValue("t_todate",term.getT_todate())
                            .addValue("t_oid",term.getT_oid())
                            .addValue("t_bid",term.getT_bid())
                            .getValues());

        }

        jdbcTemplate.batchUpdate(queries.getDeleteTerm(), batchValues.toArray(new Map[terms.size()]));
        return termByAacademicYear(terms.get(0));
    }


    public List<FeeHeaders> insertFeeHeaders(FeeHeaders feeheader) throws SQLException{
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("fh_fee_title",feeheader.getFh_fee_title());
            source.addValue("fh_id",feeheader.getFh_id());
            source.addValue("fh_oid",feeheader.getFh_oid());
         jdbcTemplate.update(queries.getInsertFeeHeaders(),source);
         return jdbcTemplate.query(queries.getFeeHeadersList(),source,new MFeeHeaders());
    }
    public List<FeeHeaders> updateFeeHeaders(FeeHeaders feeheader) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("fh_fee_title",feeheader.getFh_fee_title());
        source.addValue("fh_id",feeheader.getFh_id());
        source.addValue("fh_oid",feeheader.getFh_oid());
        jdbcTemplate.update(queries.getUpdateFeeHeaders(),source);
        return jdbcTemplate.query(queries.getFeeHeadersList(),source,new MFeeHeaders());
    }
    public List<FeeHeaders> deleteFeeHeaders(FeeHeaders feeheader) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("fh_fee_title",feeheader.getFh_fee_title());
        source.addValue("fh_id",feeheader.getFh_id());
        source.addValue("fh_oid",feeheader.getFh_oid());
        jdbcTemplate.update(queries.getDeleteFeeHeaders(),source);
        return jdbcTemplate.query(queries.getFeeHeadersList(),source,new MFeeHeaders());
    }
    public List<FeeHeaders> deleteFeeHeaderList(List<FeeHeaders> feeheader) throws Exception {
        List<Map<String, Object>> feeValues = new ArrayList<>(feeheader.size());
        for (FeeHeaders fee : feeheader) {
            feeValues.add(
                    new MapSqlParameterSource("fh_id", fee.getFh_id())
                            .addValue("fh_oid", fee.getFh_oid())
                            .addValue("fh_fee_title", fee.getFh_fee_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteFeeHeaders(), feeValues.toArray(new Map[feeValues.size()]));

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("fh_fee_title",feeheader.get(0).getFh_fee_title());
        source.addValue("fh_id",feeheader.get(0).getFh_id());
        source.addValue("fh_oid",feeheader.get(0).getFh_oid());
        return jdbcTemplate.query(queries.getFeeHeadersList(),source,new MFeeHeaders());
    }
    public List<FeeHeaders> insertFeeHeaderList(List<FeeHeaders> feeheader) throws Exception {
        List<Map<String, Object>> feeInsertValues = new ArrayList<>(feeheader.size());
        List<Map<String, Object>> feeUpdateValues = new ArrayList<>(feeheader.size());
        for (FeeHeaders fee : feeheader) {
            if (fee.getFh_id() == 0) {
                feeInsertValues.add(
                        new MapSqlParameterSource("fh_id", fee.getFh_id())
                                .addValue("fh_oid", fee.getFh_oid())
                                .addValue("fh_fee_title", fee.getFh_fee_title())
                                .getValues());
            } else {
                feeUpdateValues.add(
                        new MapSqlParameterSource("fh_id", fee.getFh_id())
                                .addValue("fh_oid", fee.getFh_oid())
                                .addValue("fh_fee_title", fee.getFh_fee_title())
                                .getValues());
            }
        }
        jdbcTemplate.batchUpdate(queries.getInsertFeeHeaders(), feeInsertValues.toArray(new Map[feeInsertValues.size()]));
        jdbcTemplate.batchUpdate(queries.getUpdateFeeHeaders(),feeUpdateValues.toArray(new Map[feeUpdateValues.size()]));

        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("fh_fee_title",feeheader.get(0).getFh_fee_title());
        source.addValue("fh_id",feeheader.get(0).getFh_id());
        source.addValue("fh_oid",feeheader.get(0).getFh_oid());
        return jdbcTemplate.query(queries.getFeeHeadersList(),source,new MFeeHeaders());
    }

    public List<FeeHeaders> feeHeadersList(FeeHeaders feeheader) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("fh_fee_title",feeheader.getFh_fee_title());
        source.addValue("fh_id",feeheader.getFh_id());
        source.addValue("fh_oid",feeheader.getFh_oid());

        return jdbcTemplate.query(queries.getFeeHeadersList(),source,new MFeeHeaders());
    }
    public List<TermFees> insertTermFee(TermFees termfee) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tf_id",termfee.getTf_id());
        source.addValue("tf_oid",termfee.getTf_oid());
        source.addValue("tf_bid",termfee.getTf_bid());
        source.addValue("tf_term_id",termfee.getTf_term_id());
        source.addValue("tf_fee_id",termfee.getTf_fee_id());
        source.addValue("tf_active_ind",termfee.isTf_active_ind());
        source.addValue("tf_amount",termfee.getTf_amount());
        source.addValue("tf_other_amount",termfee.getTf_other_amount());
        jdbcTemplate.update(queries.getInsertTermFee(),source);
        return jdbcTemplate.query(queries.getTermFeeList(),source,new MTermFees());
    }
    public List<TermFees>  updateTermFee(TermFees termfee) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tf_id",termfee.getTf_id());
        source.addValue("tf_oid",termfee.getTf_oid());
        source.addValue("tf_bid",termfee.getTf_bid());
        source.addValue("tf_term_id",termfee.getTf_term_id());
        source.addValue("tf_fee_id",termfee.getTf_fee_id());
        source.addValue("tf_active_ind",termfee.isTf_active_ind());
        source.addValue("tf_amount",termfee.getTf_amount());
        source.addValue("tf_other_amount",termfee.getTf_other_amount());
        jdbcTemplate.update(queries.getUpdateTermFee(),source);
        return jdbcTemplate.query(queries.getTermFeeList(),source,new MTermFees());
    }
    public List<TermFees>  deleteTermFee(TermFees termfee) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tf_id",termfee.getTf_id());
        source.addValue("tf_oid",termfee.getTf_oid());
        source.addValue("tf_bid",termfee.getTf_bid());
        source.addValue("tf_term_id",termfee.getTf_term_id());
        source.addValue("tf_fee_id",termfee.getTf_fee_id());
        source.addValue("tf_active_ind",termfee.isTf_active_ind());
        source.addValue("tf_amount",termfee.getTf_amount());
        source.addValue("tf_other_amount",termfee.getTf_other_amount());
        jdbcTemplate.update(queries.getDeleteTermFee(),source);
        return jdbcTemplate.query(queries.getTermFeeList(),source,new MTermFees());
    }

    public List<TermFees>  deleteTermFeeList(List<TermFees> termfees) throws Exception{
        List<Map<String, Object>> values = new ArrayList<>(termfees.size());
        for (TermFees termfee : termfees) {
                values.add(
                        new MapSqlParameterSource("tf_id",termfee.getTf_id())
                        .addValue("tf_oid",termfee.getTf_oid())
                        .addValue("tf_bid",termfee.getTf_bid())
                        .addValue("tf_term_id",termfee.getTf_term_id())
                        .addValue("tf_fee_id",termfee.getTf_fee_id())
                        .addValue("tf_active_ind",termfee.isTf_active_ind())
                        .addValue("tf_amount",termfee.getTf_amount())
                        .addValue("tf_other_amount",termfee.getTf_other_amount())
                                .getValues());
            }
            jdbcTemplate.batchUpdate(queries.getDeleteTermFee(),values.toArray(new Map[termfees.size()]));
        TermFees termfee = termfees.get(0);
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tf_id",termfee.getTf_id());
        source.addValue("tf_oid",termfee.getTf_oid());
        source.addValue("tf_bid",termfee.getTf_bid());
        source.addValue("tf_term_id",termfee.getTf_term_id());
        source.addValue("tf_fee_id",termfee.getTf_fee_id());
        source.addValue("tf_active_ind",termfee.isTf_active_ind());
        source.addValue("tf_amount",termfee.getTf_amount());
        source.addValue("tf_other_amount",termfee.getTf_other_amount());

        return jdbcTemplate.query(queries.getTermFeeList(),source,new MTermFees());
    }

    public List<TermFees>  termFeeList(TermFees termfee) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tf_id",termfee.getTf_id());
        source.addValue("tf_oid",termfee.getTf_oid());
        source.addValue("tf_bid",termfee.getTf_bid());
        source.addValue("tf_term_id",termfee.getTf_term_id());
        source.addValue("tf_fee_id",termfee.getTf_fee_id());
        source.addValue("tf_active_ind",termfee.isTf_active_ind());
        source.addValue("tf_amount",termfee.getTf_amount());
        source.addValue("tf_other_amount",termfee.getTf_other_amount());
        return jdbcTemplate.query(queries.getTermFeeList(),source,new MTermFees());
    }

    public List<CoursesLookup> insertCourses(CoursesLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("bc_clevelid", course.getBc_clevelid());
        source.addValue("bc_sbranch", course.getBc_sbranch());
        source.addValue("bc_stitle", course.getBc_stitle());
        source.addValue("bc_title", course.getBc_title());
        jdbcTemplate.update(queries.getInsertCourses(), source);
        source = new MapSqlParameterSource();
        source.addValue("bc_clevelid", course.getBc_clevelid());

        return (List<CoursesLookup>) jdbcTemplate.query(queries.getCoursesByCourseLevel(), source, new MCoursesLookup());
    }


    public List<CoursesLookup> updateCourses(CoursesLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("bc_clevelid", course.getBc_clevelid());
        source.addValue("bc_sbranch", course.getBc_sbranch());
        source.addValue("bc_stitle", course.getBc_stitle());
        source.addValue("bc_title", course.getBc_title());
        source.addValue("bc_id", course.getBc_id());
        jdbcTemplate.update(queries.getUpdateCourses(), source);
        source = new MapSqlParameterSource();
        source.addValue("bc_clevelid", course.getBc_clevelid());
        return (List<CoursesLookup>) jdbcTemplate.query(queries.getCoursesByCourseLevel(), source, new MCoursesLookup());
    }


    public List<CoursesLookup> deleteCourses(CoursesLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("bc_id", course.getBc_id());
        jdbcTemplate.update(queries.getDeleteCourses(), source);
        source = new MapSqlParameterSource();
        source.addValue("bc_clevelid", course.getBc_clevelid());
        return (List<CoursesLookup>) jdbcTemplate.query(queries.getCoursesByCourseLevel(), source, new MCoursesLookup());
    }


    public List<CoursesLookup> coursesById(CoursesLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("bc_id", course.getBc_id());
        return (List<CoursesLookup>) jdbcTemplate.query(queries.getCoursesById(), source, new MCoursesLookup());
    }


    public List<CoursesLookup> coursesByTitle(CoursesLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("bc_title", course.getBc_title());
        return (List<CoursesLookup>) jdbcTemplate.query(queries.getCoursesByTitle(), source, new MCoursesLookup());
    }


    public List<CoursesLookup> coursesByStitle(CoursesLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("bc_stitle", course.getBc_stitle());
        return (List<CoursesLookup>) jdbcTemplate.query(queries.getCoursesByStitle(), source, new MCoursesLookup());
    }


    public List<CoursesLookup> coursesByCourseLevel(CoursesLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("bc_clevelid", course.getBc_clevelid());
        return (List<CoursesLookup>) jdbcTemplate.query(queries.getCoursesByCourseLevel(), source, new MCoursesLookup());
    }
    public List<OrgClasses> activeAyBranchClasses(OrgClasses classes) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("bc_cls_id",classes.getBc_cls_id());
        source.addValue("bc_dsply_title",classes.getBc_dsply_title());
        source.addValue("bc_short_title",classes.getBc_short_title());
        source.addValue("bc_cls_code",classes.getBc_cls_code());
        source.addValue("bc_ayid",classes.getBc_ayid());
        source.addValue("bc_bid",classes.getBc_bid());
        source.addValue("bc_oid",classes.getBc_oid());
        return jdbcTemplate.query(queries.getActiveAyBranchClasses(),source,new MOrgClasses());
    }

    public List<CoursesLookup> coursesByBranch(CoursesLookup course) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("bc_sbranch", course.getBc_sbranch());
        return (List<CoursesLookup>) jdbcTemplate.query(queries.getCoursesByBranch(), source, new MCoursesLookup());
    }


    public List<CoursesLookup> insertBulkCourses(List<CoursesLookup> courses) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(courses.size());
        for (CoursesLookup course : courses) {
            batchValues.add(
                    new MapSqlParameterSource("bc_clevelid", course.getBc_clevelid())
                            .addValue("bc_sbranch", course.getBc_sbranch())
                            .addValue("bc_stitle", course.getBc_stitle())
                            .addValue("bc_title", course.getBc_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertCourses(), batchValues.toArray(new Map[courses.size()]));
        return coursesByCourseLevel(courses.get(0));
    }


    public List<CoursesLookup> updateBulkCourses(List<CoursesLookup> courses) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(courses.size());
        for (CoursesLookup course : courses) {
            batchValues.add(
                    new MapSqlParameterSource("bc_clevelid", course.getBc_clevelid())
                            .addValue("bc_sbranch", course.getBc_sbranch())
                            .addValue("bc_stitle", course.getBc_stitle())
                            .addValue("bc_title", course.getBc_title())
                            .addValue("bc_id", course.getBc_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateCourses(), batchValues.toArray(new Map[courses.size()]));
        return coursesByCourseLevel(courses.get(0));
    }


    public List<CoursesLookup> deleteBulkCourses(List<CoursesLookup> courses) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(courses.size());
        for (CoursesLookup course : courses) {
            batchValues.add(
                    new MapSqlParameterSource("bc_id", course.getBc_id())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteCourses(), batchValues.toArray(new Map[courses.size()]));
        return coursesByCourseLevel(courses.get(0));
    }


    public List<TermLookUp> insertTermLookup(TermLookUp term) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("tl_desc", term.getTl_desc());
        source.addValue("tl_oid", term.getTl_oid());
        source.addValue("tl_title", term.getTl_title());

        jdbcTemplate.update(queries.getInsertTermLookup(), source);
        source = new MapSqlParameterSource();
        source.addValue("tl_oid", term.getTl_oid());
        return (List<TermLookUp>) jdbcTemplate.query(queries.getGetTermLookUps(), source, new MTermLookUp());
    }


    public List<TermLookUp> deleteTermLookUp(TermLookUp term) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("tl_desc", term.getTl_desc());
        source.addValue("tl_oid", term.getTl_oid());
        source.addValue("tl_title", term.getTl_title());


        jdbcTemplate.update(queries.getDeleteTermLookUp(), source);
        source = new MapSqlParameterSource();
        source.addValue("tl_oid", term.getTl_oid());
        return (List<TermLookUp>) jdbcTemplate.query(queries.getGetTermLookUps(), source, new MTermLookUp());
    }


    public List<TermLookUp> updateTermLookUp(TermLookUp term) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("tl_desc", term.getTl_desc());
        source.addValue("tl_oid", term.getTl_oid());
        source.addValue("tl_title", term.getTl_title());


        jdbcTemplate.update(queries.getUpdateTermLookUp(), source);
        source = new MapSqlParameterSource();
        source.addValue("tl_oid", term.getTl_oid());
        return (List<TermLookUp>) jdbcTemplate.query(queries.getGetTermLookUps(), source, new MTermLookUp());
    }


    public List<TermLookUp> getTermLookUpTitle(TermLookUp term) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tl_oid", term.getTl_oid());
        source.addValue("tl_title", term.getTl_title());
        return (List<TermLookUp>) jdbcTemplate.query(queries.getGetTermLookUpTitle(), source, new MTermLookUp());
    }


    public List<TermLookUp> getTermLookUps(TermLookUp term) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tl_oid", term.getTl_oid());
        return (List<TermLookUp>) jdbcTemplate.query(queries.getGetTermLookUps(), source, new MTermLookUp());
    }


    public List<TermLookUp> insertBulkTermLookUp(List<TermLookUp> terms) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(terms.size());
        for (TermLookUp term : terms) {
            batchValues.add(
                    new MapSqlParameterSource("tl_desc", term.getTl_desc())
                            .addValue("tl_oid", term.getTl_oid())
                            .addValue("tl_title", term.getTl_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertTermLookup(), batchValues.toArray(new Map[terms.size()]));
        return getTermLookUps(terms.get(0));
    }


    public List<TermLookUp> updateBulkTermLookUp(List<TermLookUp> terms) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(terms.size());
        for (TermLookUp term : terms) {
            batchValues.add(
                    new MapSqlParameterSource("tl_desc", term.getTl_desc())
                            .addValue("tl_oid", term.getTl_oid())
                            .addValue("tl_title", term.getTl_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteTermLookUp(), batchValues.toArray(new Map[terms.size()]));
        return getTermLookUps(terms.get(0));
    }


    public List<TermLookUp> deleteBulkTermLookUp(List<TermLookUp> terms) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(terms.size());
        for (TermLookUp term : terms) {
            batchValues.add(
                    new MapSqlParameterSource("tl_desc", term.getTl_desc())
                            .addValue("tl_oid", term.getTl_oid())
                            .addValue("tl_title", term.getTl_title())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteTermLookUp(), batchValues.toArray(new Map[terms.size()]));
        return getTermLookUps(terms.get(0));
    }


    public List<DesignationCategory> insertDesignationCategory(DesignationCategory dcat) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("dc_active_ind", dcat.isDc_active_ind());
        source.addValue("dc_title", dcat.getDc_title());
        source.addValue("dc_desc", dcat.getDc_desc());
        source.addValue("dc_oid", dcat.getDc_oid());
        jdbcTemplate.update(queries.getInsertDesignationCategory(), source);
        source = new MapSqlParameterSource();
        source.addValue("dc_oid", dcat.getDc_oid());
        return (List<DesignationCategory>) jdbcTemplate.query(queries.getActiveDesignationCategory(), source, new MDesignationCategory());
    }


    public List<DesignationCategory> updateDesignationCategory(DesignationCategory dcat) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("dc_active_ind", dcat.isDc_active_ind());
        source.addValue("dc_title", dcat.getDc_title());
        source.addValue("dc_desc", dcat.getDc_desc());
        source.addValue("dc_oid", dcat.getDc_oid());

        jdbcTemplate.update(queries.getUpdateDesignationCategory(), source);
        source = new MapSqlParameterSource();
        source.addValue("dc_oid", dcat.getDc_oid());
        return (List<DesignationCategory>) jdbcTemplate.query(queries.getActiveDesignationCategory(), source, new MDesignationCategory());
    }


    public List<DesignationCategory> deleteDesignationCategory(DesignationCategory dcat) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("dc_title", dcat.getDc_title());
        source.addValue("dc_oid", dcat.getDc_oid());
        jdbcTemplate.update(queries.getDeleteDesignationCategory(), source);
        source = new MapSqlParameterSource();
        source.addValue("dc_oid", dcat.getDc_oid());
        return (List<DesignationCategory>) jdbcTemplate.query(queries.getActiveDesignationCategory(), source, new MDesignationCategory());
    }


    public List<DesignationCategory> activeDesignationCategory(DesignationCategory dcat) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("dc_oid", dcat.getDc_oid());
        return (List<DesignationCategory>) jdbcTemplate.query(queries.getActiveDesignationCategory(), source, new MDesignationCategory());
    }


    public List<DesignationCategory> listDesignationCategory(DesignationCategory dcat) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("dc_oid", dcat.getDc_oid());
        return (List<DesignationCategory>) jdbcTemplate.query(queries.getActiveDesignationCategory(), source, new MDesignationCategory());
    }


    public List<DesignationCategory> insertBulkDesignationCategory(List<DesignationCategory> dcats) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(dcats.size());
        for (DesignationCategory dcat : dcats) {
            batchValues.add(
                    new MapSqlParameterSource("dc_active_ind", dcat.isDc_active_ind())
                            .addValue("dc_title", dcat.getDc_title())
                            .addValue("dc_desc", dcat.getDc_desc())
                            .addValue("dc_oid", dcat.getDc_oid())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getInsertDesignationCategory(), batchValues.toArray(new Map[dcats.size()]));
        return listDesignationCategory(dcats.get(0));
    }


    public List<DesignationCategory> updateBulkDesignationCategory(List<DesignationCategory> dcats) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(dcats.size());
        for (DesignationCategory dcat : dcats) {
            batchValues.add(
                    new MapSqlParameterSource("dc_active_ind", dcat.isDc_active_ind())
                            .addValue("dc_title", dcat.getDc_title())
                            .addValue("dc_desc", dcat.getDc_desc())
                            .addValue("dc_oid", dcat.getDc_oid())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getUpdateDesignationCategory(), batchValues.toArray(new Map[dcats.size()]));
        return listDesignationCategory(dcats.get(0));
    }


    public List<DesignationCategory> deleteBulkDesignationCategory(List<DesignationCategory> dcats) throws SQLException {
        List<Map<String, Object>> batchValues = new ArrayList<>(dcats.size());
        for (DesignationCategory dcat : dcats) {
            batchValues.add(
                    new MapSqlParameterSource("dc_title", dcat.getDc_title())
                            .addValue("dc_oid", dcat.getDc_oid())
                            .getValues());
        }

        jdbcTemplate.batchUpdate(queries.getDeleteDesignationCategory(), batchValues.toArray(new Map[dcats.size()]));
        return listDesignationCategory(dcats.get(0));
    }

}
