package com.smss.api.system.mapper;

import com.smss.api.system.models.CourseCategory;
import com.smss.api.system.models.CourseClasses;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MCourseClasses implements ResultSetExtractor<List<CourseClasses>> {
    @Override
    public List<CourseClasses> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<CourseClasses> classes = new ArrayList<CourseClasses>();
        while(rs.next()){
            CourseClasses cclass = new CourseClasses();
            cclass.setCc_code(rs.getString("cc_code"));
            cclass.setCc_cs_code(rs.getString("cc_cs_code"));
            cclass.setCc_desc(rs.getString("cc_desc"));
            cclass.setCc_title(rs.getString("cc_title"));
            cclass.setCc_cc_code(rs.getString("cc_cc_code"));
            classes.add(cclass);
        }
        return classes;
    }
}
