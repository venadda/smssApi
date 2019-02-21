package com.smss.api.system.mapper;

import com.smss.api.system.models.StudentAttachment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MStudentAttachment implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        StudentAttachment attach = new StudentAttachment();
        Blob file = rs.getBlob("s_attachment");
        attach.setS_attachment(file.getBytes(1, (int) file.length()));
        attach.setS_desc(rs.getString("s_desc"));
        attach.setS_rsaid(rs.getBigDecimal("s_rsaid"));
        attach.setS_said(rs.getBigDecimal("s_said"));
        return attach;
    }
}
