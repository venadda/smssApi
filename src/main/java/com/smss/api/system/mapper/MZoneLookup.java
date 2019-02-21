package com.smss.api.system.mapper;

import com.smss.api.system.models.ZoneLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MZoneLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        ZoneLookup lookup = new ZoneLookup();
        lookup.setZ_active_ind(rs.getBoolean("z_active_ind"));
        lookup.setZ_country(rs.getString("z_country"));
        lookup.setZ_id(rs.getBigDecimal("z_id"));
        lookup.setZ_state(rs.getString("z_state"));
        lookup.setZ_title(rs.getString("z_title"));

        return lookup;
    }
}
