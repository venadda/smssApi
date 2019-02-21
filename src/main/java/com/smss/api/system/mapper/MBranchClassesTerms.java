package com.smss.api.system.mapper;

import com.smss.api.system.models.BranchClassesTerms;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MBranchClassesTerms implements ResultSetExtractor<List<BranchClassesTerms>> {
    @Override
    public List<BranchClassesTerms> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<BranchClassesTerms> branchClassesTerms = new ArrayList<BranchClassesTerms>();
        while(rs.next()){

        }
        return null;
    }
}
