package com.smss.api.system.mapper;


import com.smss.api.smssApi.model.auth.Authentication;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MAuthenticationPhoto implements RowMapper {

    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Authentication authentication = new Authentication();
        authentication.setaId(resultSet.getInt("a_id"));
        authentication.setaUserId(resultSet.getInt("a_user_id"));
        authentication.setaLoginId(resultSet.getString("a_user_loginid"));
        authentication.setaPwd(resultSet.getString("a_user_pwd"));
        authentication.setaActiveInd(resultSet.getBoolean("a_active_ind"));
        authentication.setaLoginCount(resultSet.getInt("a_login_count"));
        authentication.setaAccountStatus(resultSet.getBoolean("a_account_status"));
        authentication.setaType(resultSet.getString("a_user_type"));
        authentication.setaOrgId(resultSet.getInt("a_user_orgId"));
        authentication.setaLastLoggedIn(resultSet.getDate("a_last_logged_in"));
        authentication.setaFirstName(resultSet.getString("a_user_firstName"));
        authentication.setaLastName(resultSet.getString("a_user_lastName"));
        authentication.setaEmailId(resultSet.getString("a_user_email_Id"));
        authentication.setaPhoto(resultSet.getBytes("photo"));
        authentication.setSystem(resultSet.getString("system"));
        return authentication;
    }
}