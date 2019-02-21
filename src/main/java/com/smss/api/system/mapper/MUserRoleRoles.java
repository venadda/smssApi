package com.smss.api.system.mapper;

import com.smss.api.system.models.Roles;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MUserRoleRoles implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        Roles roles = new Roles();
        roles.setR_active_ind(resultSet.getBoolean("r_active_ind"));
        roles.setR_desc(resultSet.getString("r_desc"));
        roles.setR_id(resultSet.getBigDecimal("r_id"));
        roles.setR_title(resultSet.getString("r_title"));
        return roles;
    }
}
