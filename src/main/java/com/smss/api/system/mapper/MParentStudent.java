package com.smss.api.system.mapper;

import com.smss.api.system.models.ParentStudent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MParentStudent implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ParentStudent parent = new ParentStudent();
        parent.setP_active_ind(resultSet.getBoolean("p_active_ind"));
        parent.setP_id(resultSet.getBigDecimal("p_id"));
        parent.setP_orgId(resultSet.getBigDecimal("p_orgId"));
        parent.setP_pid(resultSet.getBigDecimal("p_pid"));
        parent.setP_sid(resultSet.getBigDecimal("p_sid"));

        return parent;
    }
}
