package com.smss.api.system.mapper;

import com.smss.api.system.models.OrgDesignation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MOrgDesignation implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        OrgDesignation depart = new OrgDesignation();
        depart.setD_id(resultSet.getBigDecimal("d_id"));
        depart.setD_oid(resultSet.getBigDecimal("d_oid"));
        depart.setD_title(resultSet.getString("d_title"));
        depart.setD_active_ind(resultSet.getBoolean("d_active_ind"));
        depart.setD_dcat(resultSet.getString("d_dcat"));
        return depart;
    }
}

