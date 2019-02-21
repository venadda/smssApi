package com.smss.api.smssApi.daos;

import com.smss.api.app.database.EmssDB;
import com.smss.api.smssApi.model.auth.Authentication;
import com.smss.api.system.mapper.MAuthentication;
import com.smss.api.system.mapper.MAuthenticationPhoto;
import com.smss.api.system.mapper.MUserAssignedRoles;
import com.smss.api.system.models.UserAssignedRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;

@Transactional
@Repository
public class AuthenticationDAO implements Serializable {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;
    @Autowired
    private EmssDB queries;
        //not in user
    public Authentication validateAuthentication(Authentication auth) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();

        source.addValue("a_user_loginid", auth.getaLoginId());
        return (Authentication) jdbcTemplate.queryForObject(queries.getIsAuthenticationValidate(), source, new MAuthentication());
    }

    public Authentication validateAuthentication(String loginId) throws SQLException {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("a_user_loginid", loginId);

        return (Authentication) jdbcTemplate.queryForObject(queries.getIsAuthenticationValidate(), source, new MAuthentication());
    }
    public UserAssignedRoles getUserAssignedRoles(int userId) throws Exception {
          MapSqlParameterSource source = new MapSqlParameterSource();
          source.addValue("uid", userId);
          //source.addValue("orgId", orgId);
        System.out.println(queries.getGetUserRoles());
          return (UserAssignedRoles) jdbcTemplate.queryForObject(queries.getGetUserRoles(), source, new MUserAssignedRoles());
    }
    public UserAssignedRoles getSystemUserAssignedRoles(int userId) throws Exception {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("uid", userId);
        //source.addValue("orgId", orgId);
        System.out.println("getSystemUserAssignedRoles");
        System.out.println(queries.getSystemUserRoles());
        return (UserAssignedRoles) jdbcTemplate.queryForObject(queries.getSystemUserRoles(), source, new MUserAssignedRoles());
    }
    public Authentication getSystemUserPhoto(String loginId) throws Exception{
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("a_user_loginid",loginId);
        return (Authentication) jdbcTemplate.queryForObject(queries.getSystemUserPhoto(),source,new MAuthenticationPhoto());
    }
}
