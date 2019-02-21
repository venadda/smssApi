package com.smss.api.system.mapper;

import com.smss.api.system.models.UserDisabilities;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MUserDisabilities implements ResultSetExtractor<List<UserDisabilities>> {
    @Override
    public List<UserDisabilities> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<UserDisabilities> disabilities = new ArrayList<UserDisabilities>();
        while(rs.next()){
            UserDisabilities disability = new UserDisabilities();
            disability.setUd_did(rs.getInt("ud_did"));
            disability.setUd_uid(rs.getInt("ud_uid"));
            disability.setUd_oid(rs.getInt("ud_oid"));
            disability.setUd_dcode(rs.getString("ud_dcode"));
            disabilities.add(disability);
        }
        return disabilities;
    }
}
