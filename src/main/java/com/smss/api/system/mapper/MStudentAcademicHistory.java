package com.smss.api.system.mapper;

import com.smss.api.system.models.StudentAcademicHistory;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MStudentAcademicHistory implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        StudentAcademicHistory history = new StudentAcademicHistory();
        history.setS_sahid(rs.getBigDecimal("s_sahid"));
        history.setS_comment(rs.getString("s_comment"));
        history.setS_courseName(rs.getString("s_courseName"));
        history.setS_grade(rs.getString("s_grade"));
        history.setS_id(rs.getBigDecimal("s_id"));
        history.setS_marks(rs.getString("s_marks"));
        history.setS_organization(rs.getString("s_organization"));
        history.setS_stream(rs.getString("s_stream"));
        history.setS_year(rs.getString("s_year"));
        history.setS_attachment(rs.getBytes("s_attachment"));
        history.setS_oid(rs.getInt("s_oid"));
        history.setS_bid(rs.getInt("s_bid"));
        return history;
    }
}
