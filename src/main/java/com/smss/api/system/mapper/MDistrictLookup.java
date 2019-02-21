package com.smss.api.system.mapper;

import com.smss.api.system.models.DistrictLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MDistrictLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        DistrictLookup lookup = new DistrictLookup();
        lookup.setD_country(rs.getString("d_country"));
        lookup.setD_id(rs.getBigDecimal("d_id"));
        lookup.setD_state(rs.getString("d_state"));
        lookup.setD_title(rs.getString("d_title"));
        return lookup;
    }
}
