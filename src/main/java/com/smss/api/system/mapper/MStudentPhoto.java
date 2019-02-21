package com.smss.api.system.mapper;

import com.smss.api.system.models.StudentPhoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MStudentPhoto implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentPhoto photo = new StudentPhoto();
        photo.setS_id(resultSet.getBigDecimal("s_photo"));
        Blob image = resultSet.getBlob("s_photo");
        photo.setS_photo(image.getBytes(1, (int) image.length()));
        return photo;
    }
}
