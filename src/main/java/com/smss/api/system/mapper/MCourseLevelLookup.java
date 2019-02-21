package com.smss.api.system.mapper;

import com.smss.api.system.models.CourseLevelLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MCourseLevelLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        CourseLevelLookup clevel = new CourseLevelLookup();
        clevel.setC_country(rs.getString("c_country"));
        clevel.setC_desc(rs.getString("c_desc"));
        clevel.setC_title(rs.getString("c_title"));
        return clevel;
    }
}
