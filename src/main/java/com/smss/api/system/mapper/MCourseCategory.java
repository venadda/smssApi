package com.smss.api.system.mapper;

import com.smss.api.system.models.CourseCategory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MCourseCategory implements ResultSetExtractor<List<CourseCategory>> {
    @Override
    public List<CourseCategory> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<CourseCategory> courses = new ArrayList<CourseCategory>();
        while(rs.next()){
            CourseCategory course = new CourseCategory();
            course.setCc_code(rs.getString("cc_code"));
            course.setCc_desc(rs.getString("cc_desc"));
            course.setCc_country(rs.getString("cc_country"));
            courses.add(course);
        }
        return courses;
    }
}
