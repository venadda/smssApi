package com.smss.api.system.mapper;

import com.smss.api.system.models.ClassSubject;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MClassSubject implements ResultSetExtractor<List<ClassSubject>> {

    @Override
    public List<ClassSubject> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<ClassSubject> subjects  = new ArrayList<ClassSubject>();
        while(rs.next()){
            ClassSubject subject = new ClassSubject();
            subject.setS_clid(rs.getString("s_clid"));
            subject.setS_code(rs.getString("s_code"));
            subject.setS_desc(rs.getString("s_desc"));
            subject.setS_title(rs.getString("s_title"));
            subjects.add(subject);
        }
        return subjects;
    }
}
