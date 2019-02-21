package com.smss.api.system.mapper;

import com.smss.api.system.models.AcademicYear;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MAcademicYear implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        AcademicYear ay = new AcademicYear();
        ay.setAy_active_ind(rs.getBoolean("ay_active_ind"));
        ay.setAy_admission_ind(rs.getBoolean("ay_admission_ind"));
        ay.setAy_batch(rs.getString("ay_batch"));
        ay.setAy_clevel(rs.getString("ay_clevel"));
        ay.setAy_fromdate(rs.getDate("ay_fromdate"));
        ay.setAy_id(rs.getBigDecimal("ay_id"));
        ay.setAy_oid(rs.getBigDecimal("ay_oid"));
        ay.setAy_todate(rs.getDate("ay_todate"));
        ay.setAy_year(rs.getString("ay_year"));
        return ay;
    }
}
