package com.smss.api.system.mapper;

import com.smss.api.system.models.Roles;
import com.smss.api.system.models.UserPhoto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MUserPhoto implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {

        UserPhoto photo = new UserPhoto();
        photo.setU_photo(resultSet.getBytes("u_photo"));
        return photo;
    }
}
