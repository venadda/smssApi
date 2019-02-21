package com.smss.api.system.mapper;

import com.smss.api.system.models.SubjectsLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MSubjectsLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        SubjectsLookup lookup = new SubjectsLookup();
        lookup.setS_clid(resultSet.getString("s_clid"));
        lookup.setS_code(resultSet.getString("s_code"));
        lookup.setS_desc(resultSet.getString("s_desc"));
        lookup.setS_title(resultSet.getString("s_title"));
        return lookup;
    }
}
