package com.smss.api.system.mapper;

import com.smss.api.system.models.UserAssignedRoles;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MUserAssignedRoles implements RowMapper {
    @Override
    public UserAssignedRoles mapRow(ResultSet rs, int i) throws SQLException {
        UserAssignedRoles role = new UserAssignedRoles();
        role.setR_desc(rs.getString("r_desc"));
        role.setR_id(rs.getInt("r_id"));
        role.setR_title(rs.getString("r_title"));
        role.setUr_id(rs.getInt("ur_id"));
        //role.setUr_org_id(rs.getInt("ur_org_id"));
        role.setUr_role(rs.getInt("ur_role"));
        role.setUr_uid(rs.getInt("ur_id"));
        role.setUr_active_ind(rs.getBoolean("ur_active_ind"));

        return role;
    }
}
