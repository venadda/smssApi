package com.smss.api.system.mapper;

import com.smss.api.system.models.DesignationCategory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MDesignationCategory implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        DesignationCategory cat = new DesignationCategory();
        cat.setDc_active_ind(resultSet.getBoolean("dc_active_ind"));
        cat.setDc_desc(resultSet.getString("dc_desc"));
        cat.setDc_oid(resultSet.getBigDecimal("dc_oid"));
        cat.setDc_title(resultSet.getString("dc_title"));


        return cat;
    }
}
