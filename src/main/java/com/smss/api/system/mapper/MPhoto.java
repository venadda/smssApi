package com.smss.api.system.mapper;

import com.smss.api.system.models.Photo;
import org.springframework.jdbc.core.RowMapper;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MPhoto implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        Photo photo = new Photo();
        photo.setU_id(rs.getBigDecimal("u_id"));
        Blob file = rs.getBlob("u_photo");
        photo.setU_photo(file.getBytes(1, (int) file.length()));
        return photo;
    }
}
