package com.smss.api.system.mapper;

import com.smss.api.system.models.ClassesLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MClassesLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        ClassesLookup classes = new ClassesLookup();
        classes.setC_courseId(resultSet.getBigDecimal("c_courseId"));
        classes.setC_desc(resultSet.getString("c_desc"));
        classes.setC_title(resultSet.getString("c_title"));
        return classes;
    }
}
