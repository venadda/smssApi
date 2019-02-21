package com.smss.api.system.daos;

import com.smss.api.app.database.AuthenticationDB;
import com.smss.api.app.database.EmssDB;
import com.smss.api.system.mapper.*;
import com.smss.api.system.models.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public class SystemUserDao {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private EmssDB queries;

    private static Logger logger = LogManager.getLogger();

    public List<SystemUser> getSystemUsers(){
        return (List<SystemUser>) jdbcTemplate.query(queries.getGetAllSystemUsers(),new MapSqlParameterSource(),new MSystemUser());


    }
    public List<SystemUserDetails> getSystemUserDetails() throws Exception {
        logger.debug(queries.getGetAllSystemUserDetails());
        return (List<SystemUserDetails>) jdbcTemplate.query(queries.getGetAllSystemUserDetails(),new MapSqlParameterSource(),new MSystemUserDetails());


    }
    public List<EmployeeDetails> getUserDetails(SystemUserDetails emp) throws Exception{
        logger.debug(queries.getAllUserDetails());
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("orgid",emp.getOrgid());
        return (List<EmployeeDetails>) jdbcTemplate.query(queries.getAllUserDetails(),source,new MEmployeeDetails());


    }
    public List<Employee> getBranchUserDetails(Employee emp) throws Exception{
        logger.debug(queries.getAllBranchUserDetails());
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("u_org_id",emp.getU_org_id());
        source.addValue("u_branchid",emp.getU_branchid());
        return (List<Employee>) jdbcTemplate.query(queries.getAllBranchUserDetails(),source,new MEmployee());


    }
    public List<Employee> getInsertBranchUserDetails(Employee emp) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        employeeInsert(source,emp);
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        jdbcTemplate.update(queries.getInsertUser(),source,holder);
        int id = holder.getKey().intValue();
        MapSqlParameterSource role = new MapSqlParameterSource();
        role.addValue("ur_role",emp.getU_role());
        role.addValue("ur_desg",emp.getU_desg());
        role.addValue("ur_org_id",emp.getU_org_id());
        role.addValue("ur_branch",emp.getU_branchid());
        role.addValue("ur_uid",id);

        jdbcTemplate.update(queries.getInsertUserRoles(),role);
        return (List<Employee>) jdbcTemplate.query(queries.getAllBranchUserDetails(),source,new MEmployee());
    }
    public List<Employee> getInsertUserDetails(Employee emp) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        GeneratedKeyHolder holder = new GeneratedKeyHolder();
        employeeInsert(source,emp);
        jdbcTemplate.update(queries.getInsertUser(),source,holder);
        int id = holder.getKey().intValue();
        MapSqlParameterSource role = new MapSqlParameterSource();
        role.addValue("ur_role",emp.getU_role());
        role.addValue("ur_desg",emp.getU_desg());
        role.addValue("ur_org_id",emp.getU_org_id());
        role.addValue("ur_branch",emp.getU_branchid());
        role.addValue("ur_uid",id);
        jdbcTemplate.update(queries.getInsertUserRoles(),role);
        return (List<Employee>) jdbcTemplate.query(queries.getAllUserDetails(),source,new MEmployee());
    }
    public List<EmployeeDetails> getBranchUpdateUserDetails(Employee emp) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        employeeInsert(source,emp);
        jdbcTemplate.update(queries.getUpdateBranchUser(),source);
        MapSqlParameterSource role = new MapSqlParameterSource();
        role.addValue("ur_role",emp.getU_role());
        role.addValue("ur_desg",emp.getU_desg());
        role.addValue("ur_org_id",emp.getU_org_id());
        role.addValue("ur_active_ind",emp.isUr_active_ind());
        role.addValue("ur_branch",emp.getU_branchid());
        role.addValue("ur_uid",emp.getU_id());
        role.addValue("ur_org_id",emp.getU_org_id());

        jdbcTemplate.update(queries.getUpdateUserRole(),role);
        return (List<EmployeeDetails>) jdbcTemplate.query(queries.getAllUserDetails(),source,new MEmployeeDetails());
    }
    public List<EmployeeDetails> getUpdateUserDetails(Employee emp) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        System.out.println(emp.toString());
        employeeInsert(source,emp);
        System.out.println(queries.getUpdateUser());
        jdbcTemplate.update(queries.getUpdateUser(),source);
        MapSqlParameterSource role = new MapSqlParameterSource();
        role.addValue("ur_role",emp.getU_role());
        role.addValue("ur_desg",emp.getU_desg());
        role.addValue("ur_org_id",emp.getU_org_id());
        role.addValue("ur_active_ind",emp.isUr_active_ind());
        role.addValue("ur_branch",emp.getU_branchid());
        role.addValue("ur_uid",emp.getU_id());
        role.addValue("ur_org_id",emp.getU_org_id());
        jdbcTemplate.update(queries.getUpdateUserRole(),role);
        return (List<EmployeeDetails>) jdbcTemplate.query(queries.getAllUserDetails(),source,new MEmployeeDetails());
    }
    public List<SystemUserModules> getUserAssignedModules(int userId) throws Exception{
            MapSqlParameterSource source = new MapSqlParameterSource();
            source.addValue("userid", userId);
        return (List<SystemUserModules>) jdbcTemplate.query(queries.getGetUserAssignedModules(),source,new MSystemUserModules());
    }

    private void employeeInsert(MapSqlParameterSource source,Employee emp){

        source.addValue("u_id",emp.getU_id());
        source.addValue("u_first_name",emp.getU_first_name());
        source.addValue("u_middle_name",emp.getU_middle_name());
        source.addValue("u_last_name",emp.getU_last_name());
        source.addValue("u_dob",emp.getU_dob());
        source.addValue("u_nativity",emp.getU_nativity());
        source.addValue("u_nationality",emp.getU_nationality());
        source.addValue("u_religion",emp.getU_religion());
        source.addValue("u_caste",emp.getU_caste());
        source.addValue("u_subcaste",emp.getU_subcaste());
        source.addValue("u_father_name",emp.getU_father_name());
        source.addValue("u_mother_name",emp.getU_mother_name());
        source.addValue("u_guardian_name",emp.getU_guardian_name());
        source.addValue("u_guardian_relation",emp.getU_guardian_relation());
        source.addValue("u_caddress",emp.getU_caddress());
        source.addValue("u_clocation",emp.getU_clocation());
        source.addValue("u_cstreet",emp.getU_cstreet());
        source.addValue("u_ccity",emp.getU_ccity());
        source.addValue("u_cstate",emp.getU_cstate());
        source.addValue("u_cdistrict",emp.getU_cdistrict());
        source.addValue("u_cmandal",emp.getU_cmandal());
        source.addValue("u_czipcode",emp.getU_czipcode());
        source.addValue("u_paddress",emp.getU_paddress());
        source.addValue("u_plocation",emp.getU_plocation());
        source.addValue("u_pstreet",emp.getU_pstreet());
        source.addValue("u_pcity",emp.getU_pcity());
        source.addValue("u_pstate",emp.getU_pstate());
        source.addValue("u_pdistrict",emp.getU_pdistrict());
        source.addValue("u_pmandal",emp.getU_pmandal());
        source.addValue("u_pzipcode",emp.getU_pzipcode());
        source.addValue("u_pcontact_no",emp.getU_pcontact_no());
        source.addValue("u_scontact_no",emp.getU_scontact_no());
        source.addValue("u_econtact_no",emp.getU_econtact_no());
        source.addValue("u_mcontact_no",emp.getU_mcontact_no());
        source.addValue("u_fcontact_no",emp.getU_fcontact_no());
        source.addValue("u_gcontact_no",emp.getU_gcontact_no());
        source.addValue("u_active_ind",emp.isU_active_ind());
        source.addValue("u_email_id",emp.getU_email_id());
        source.addValue("u_alt_email_id",emp.getU_alt_email_id());
        source.addValue("u_social_security_Id",emp.getU_social_security_Id());
        source.addValue("u_social_security_name",emp.getU_social_security_name());
        source.addValue("u_suffix",emp.getU_refno());
        source.addValue("u_mother_tongue",emp.getU_mother_tongue());
        source.addValue("u_ethnic_group",emp.getU_ethnic_group());
        source.addValue("u_ethnic_designation",emp.getU_ethnic_designation());
        source.addValue("u_decile_group",emp.getU_decile_group());
        source.addValue("u_tenure",emp.getU_tenure());
        source.addValue("u_branchid",emp.getU_branchid());
        source.addValue("u_org_id",emp.getU_org_id());
        source.addValue("u_gender",emp.getU_gender());
        source.addValue("orgid",emp.getU_org_id());
    }
}
