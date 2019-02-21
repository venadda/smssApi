package com.smss.api.system.mapper;

import com.smss.api.system.models.MandalLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MMandalLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        MandalLookup lookup = new MandalLookup();
        lookup.setM_country(rs.getString("m_country"));
        lookup.setM_district(rs.getString("m_district"));
        lookup.setM_id(rs.getBigDecimal("m_id"));
        lookup.setM_state(rs.getString("m_state"));
        lookup.setM_title(rs.getString("m_title"));

        return lookup;
    }
}
