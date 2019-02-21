package com.smss.api.system.mapper;

import com.smss.api.system.models.TermLookUp;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MTermLookUp implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        TermLookUp lookup = new TermLookUp();
        lookup.setTl_id(rs.getInt("tl_id"));
        lookup.setTl_desc(rs.getString("tl_desc"));
        lookup.setTl_oid(rs.getBigDecimal("tl_oid"));
        lookup.setTl_title(rs.getString("tl_title"));
        return lookup;
    }
}
