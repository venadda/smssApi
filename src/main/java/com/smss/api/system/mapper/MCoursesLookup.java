package com.smss.api.system.mapper;

import com.smss.api.system.models.CoursesLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MCoursesLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        CoursesLookup course = new CoursesLookup();
        course.setBc_clevelid(resultSet.getString("bc_clevelid"));
        course.setBc_id(resultSet.getBigDecimal("bc_id"));
        course.setBc_sbranch(resultSet.getString("bc_sbranch"));
        course.setBc_stitle(resultSet.getString("bc_title"));
        course.setBc_title(resultSet.getString("bc_title"));
        return course;
    }
}
