package com.smss.api.system.mapper;

import com.smss.api.system.models.CategoryLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MCategoryLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        CategoryLookup cat = new CategoryLookup();
        cat.setC_country(rs.getString("c_country"));
        cat.setC_title(rs.getString("c_title"));
        return cat;
    }
}
