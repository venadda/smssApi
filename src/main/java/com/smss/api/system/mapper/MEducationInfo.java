package com.smss.api.system.mapper;

import com.smss.api.system.models.EducationInfo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MEducationInfo implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        EducationInfo education = new EducationInfo();
        //Blob file = rs.getBlob("u_attachment");
        //education.setU_attachment(file.getBytes(1, (int) file.length()));
        education.setU_attachment(rs.getBytes("u_attachment"));
        education.setU_comment(rs.getString("u_comment"));
        education.setU_course(rs.getString("u_course"));
        education.setU_edu_type(rs.getString("u_edu_type"));
        education.setU_eid(rs.getBigDecimal("u_eid"));
        education.setU_marks(rs.getString("u_marks"));
        education.setU_organization(rs.getString("u_organization"));
        education.setU_medium(rs.getString("u_medium"));
        education.setU_year(rs.getString("u_year"));
        education.setU_grade(rs.getString("u_grade"));
        education.setU_id(rs.getBigDecimal("u_id"));
        education.setU_oid(rs.getBigDecimal("u_oid"));
        education.setU_subjects(rs.getString("u_subjects"));
        return education;
    }
}
