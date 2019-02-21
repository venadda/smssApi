package com.smss.api.system.daos;

import com.smss.api.app.database.EmssDB;
import com.smss.api.smssApi.model.auth.Authentication;
import com.smss.api.app.database.AuthenticationDB;
import com.smss.api.system.mapper.MAuthentication;
import com.smss.api.system.mapper.MOthers;
import com.smss.api.system.mapper.MParent;
import com.smss.api.system.mapper.MParentStudent;
import com.smss.api.system.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;

@Transactional
@Repository
public class AuthenticationbDAO {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private EmssDB queries;


    public List<Authentication> getAuthenticatedUsers(long oid) throws SQLException {

        return jdbcTemplate.query(queries.getOrgAuthorizedUsers(), new MapSqlParameterSource("oid", oid), new MAuthentication());
    }


    public UserAuthentication findByName(String name) throws SQLException {

        UserAuthentication uauth = null;
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("a_user_loginid", name);
        List<Roles> roles = null;
        List<Authentication> auth = (List<Authentication>) jdbcTemplate.query("select * from user.authentication where a_user_loginid=:a_user_loginid", source, new MAuthentication());
        if (auth.size() > 0) {
            //roles = (List<Roles>) jdbcTemplate.query("select r_id,r_title,r_desc,r_active_ind from user.role r, user.userroles u where r.r_id = u.ur_role and ur_uid=:u_uid", new MapSqlParameterSource("u_uid", auth.get(0).getA_user_id()), new MUserRoleRoles());

            uauth = new UserAuthentication();
/*            uauth.setA_account_status(auth.get(0).isA_account_status());
            uauth.setA_active_ind(auth.get(0).isA_active_ind());
            uauth.setA_id(auth.get(0).getA_id());
            uauth.setA_login_count(auth.get(0).getA_login_count());
            uauth.setA_user_id(auth.get(0).getA_user_id());
            uauth.setA_user_orgId(auth.get(0).getA_user_orgId());
            uauth.setA_user_pwd(auth.get(0).getA_user_pwd());
            uauth.setA_user_type(auth.get(0).getA_user_type());
            uauth.setA_user_loginid(auth.get(0).getA_user_loginid());
            uauth.setRoles(roles);
            System.out.println(uauth.toString());*/
        }
        return new UserAuthentication(uauth);

    }


    public List<Authentication> getAllOrgAuthenticatedUsers() throws SQLException {
        return jdbcTemplate.query(queries.getOrgAuthorizedUsers(), new MapSqlParameterSource(), new MAuthentication());
    }


    public Authentication validateAuthentication(Authentication auth) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
/*
        source.addValue("a_user_loginid", auth.getA_user_loginid());
        source.addValue("a_user_pwd", auth.getA_user_pwd());*/
        return (Authentication) jdbcTemplate.queryForObject(queries.getIsAuthenticationValidate(), source, new MAuthentication());
    }


    public List<Authentication> addAuthenticatedUser(Authentication user) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
/*
        source.addValue("a_user_id", user.getA_user_id());
        source.addValue("a_user_loginid", user.getA_user_loginid());
        source.addValue("a_user_pwd", user.getA_user_pwd());
        source.addValue("a_active_ind", user.isA_active_ind());
        source.addValue("a_login_count", user.getA_login_count());
        source.addValue("a_account_status", user.isA_account_status());
        source.addValue("a_user_type", user.getA_user_type());
        source.addValue("a_user_orgId", user.getA_user_orgId());
        source.addValue("a_last_logged_in", user.getA_last_logged_in());
        source.addValue("a_user_firstName", user.getA_user_firstName());
        source.addValue("a_user_lastName", user.getA_user_lastName());
        source.addValue("a_user_email_Id", user.getA_user_email_Id());*/
        jdbcTemplate.update(queries.getAddAuthentication(), source);
        // return jdbcTemplate.query(queries.getAllOrgAuthorizedUsers(), new MapSqlParameterSource("oid", user.getA_user_orgId()), new MAuthentication());
        return null;
    }

/*

    public List<Parent> addParent(Parent parent) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("p_first_name", parent.getP_first_name());
        source.addValue("p_last_name", parent.getP_last_name());
        source.addValue("p_middle_name", parent.getP_middle_name());
        source.addValue("p_email_id", parent.getP_email_id());
        source.addValue("p_pcontactno", parent.getP_pcontactno());
        source.addValue("p_scontactno", parent.getP_scontactno());
        source.addValue("p_address", parent.getP_address());
        source.addValue("p_location", parent.getP_location());
        source.addValue("p_street", parent.getP_street());
        source.addValue("p_state", parent.getP_state());
        source.addValue("p_city", parent.getP_city());
        source.addValue("p_country", parent.getP_country());
        source.addValue("p_active_ind", parent.isP_active_ind());
        source.addValue("p_orgId", parent.getP_orgId());
        jdbcTemplate.update(queries.getAddParent(), source);
        return jdbcTemplate.query(queries.getParentList(), new MapSqlParameterSource("oid", parent.getP_orgId()), new MParent());
    }
*/

/*

    public List<Parent> parentList(long oid) throws SQLException {
        return jdbcTemplate.query(queries.getParentList(), new MapSqlParameterSource("oid", oid), new MParent());
    }


    public List<Parent> parentById(long oid, long pid) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("p_orgId", oid);
        source.addValue("p_pid", pid);
        return jdbcTemplate.query(queries.getParentList(), source, new MParent());
    }


    public List<Parent> parentByName(long oid, String name) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("p_orgId", oid);
        source.addValue("firstName", name);
        source.addValue("lastName", name);
        return jdbcTemplate.query(queries.getParentByName(), source, new MParent());
    }


    public List<Parent> parentByNameLike(long oid, String name) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("p_orgId", oid);
        source.addValue("firstName", name);
        source.addValue("lastName", name);
        return jdbcTemplate.query(queries.getParentByNameLike(), source, new MParent());
    }


    public List<Parent> parentByEmailIdIgnoreCase(long oid, String email) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("p_orgId", oid);
        source.addValue("email", email);

        return jdbcTemplate.query(queries.getParentByEmailIdIgnoreCase(), source, new MParent());
    }


    public List<ParentStudent> addParentStud(ParentStudent parentstudent) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("p_pid", parentstudent.getP_pid());
        source.addValue("p_sid", parentstudent.getP_sid());
        source.addValue("p_orgId", parentstudent.getP_orgId());
        source.addValue("p_active_ind", parentstudent.isP_active_ind());
        jdbcTemplate.update(queries.getAddParentStud(), source);
        return parentStudById(Long.parseLong(parentstudent.getP_orgId().toString()), Long.parseLong(parentstudent.getP_pid().toString()));
    }


    public List<ParentStudent> parentStudById(long oid, long pid) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("pid", pid);
        source.addValue("oid", oid);
        return jdbcTemplate.query(queries.getParentStudById(), source, new MParentStudent());
    }

*/
/*
    public List<Others> addOther(Others others) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("o_first_name", others.getO_first_name());
        source.addValue("o_last_name", others.getO_last_name());
        source.addValue("o_middle_name", others.getO_middle_name());
        source.addValue("o_email_id", others.getO_email_id());
        source.addValue("o_pcontactno", others.getO_pcontact_no());
        source.addValue("o_scontactno", others.getO_scontact_no());
        source.addValue("o_address", others.getO_address());
        source.addValue("o_location", others.getO_location());
        source.addValue("o_street", others.getO_street());
        source.addValue("o_state", others.getO_state());
        source.addValue("o_city", others.getO_city());
        source.addValue("o_country", others.getO_country());
        source.addValue("o_active_ind", others.getO_active_ind());
        source.addValue("o_orgId", others.getO_org_id());
        source.addValue("o_purpose", others.getO_purpose());
        source.addValue("o_comment", others.getO_comment());
        source.addValue("o_remark", others.getO_remark());
        jdbcTemplate.update(queries.getAddOther(), source);
        return jdbcTemplate.query(queries.getOtherList(), source, new MOthers());
    }


    public List<Others> otherList(long oid) throws SQLException {
        return jdbcTemplate.query(queries.getOtherList(), new MapSqlParameterSource("oid", oid), new MOthers());
    }


    public List<Others> otherById(long oid, long id) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("oid", oid);
        source.addValue("pid", id);
        return jdbcTemplate.query(queries.getOtherList(), source, new MOthers());
    }


    public List<Others> otherByName(long oid, String name) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("oid", oid);
        source.addValue("firstName", name);
        source.addValue("lastName", name);
        return jdbcTemplate.query(queries.getOtherByName(), source, new MOthers());
    }


    public List<Others> otherByNameLike(long oid, String name) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("oid", oid);
        source.addValue("firstName", name);
        source.addValue("lastName", name);
        return jdbcTemplate.query(queries.getOtherByNameLike(), source, new MOthers());
    }


    public List<Others> otherByEmailIdIgnreCase(long oid, String name) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("oid", oid);
        source.addValue("emailid", name);
        return jdbcTemplate.query(queries.getOtherByEmailIdIgnreCase(), source, new MOthers());
    }*/
}
