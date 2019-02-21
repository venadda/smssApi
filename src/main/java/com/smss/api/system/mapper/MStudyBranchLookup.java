package com.smss.api.system.mapper;

import com.smss.api.system.models.StudyBranchLookup;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MStudyBranchLookup implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        StudyBranchLookup branch = new StudyBranchLookup();
        branch.setSb_title(resultSet.getString("sb_title"));
        return branch;
    }
}
