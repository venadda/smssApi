package com.smss.api.system.mapper;

import com.smss.api.system.models.BatchesLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MBatchesLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        BatchesLookup batch = new BatchesLookup();
        batch.setB_id(rs.getBigDecimal("b_id"));
        batch.setB_active_ind(rs.getBoolean("b_active_ind"));
        batch.setB_batchtitle(rs.getString("b_batchtitle"));
        batch.setB_desc(rs.getString("b_desc"));
        batch.setB_oid(rs.getBigDecimal("b_oid"));
        batch.setB_year(rs.getString("b_year"));
        batch.setB_ayid(rs.getInt("b_ayid"));
        return batch;
    }
}
