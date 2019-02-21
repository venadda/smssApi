package com.smss.api.system.mapper;

import com.smss.api.system.models.StudentClsSec;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MStudentClsSec implements ResultSetExtractor<List<StudentClsSec>> {
    @Override
    public List<StudentClsSec> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<StudentClsSec> studentClsSecs = new ArrayList<StudentClsSec>();
        while(rs.next()){
            StudentClsSec studentClsSec = new StudentClsSec();
            studentClsSec.setS_scsid(rs.getInt("s_scsid"));
            studentClsSec.setS_sid (rs.getInt("s_sid"));
            studentClsSec.setS_clsid (rs.getString("s_clsid"));
            studentClsSec.setS_cls_code (rs.getString("s_cls_code"));
            studentClsSec.setS_ayid (rs.getString("s_ayid"));
            studentClsSec.setS_oid (rs.getBigDecimal("s_oid"));
            studentClsSec.setS_bid (rs.getBigDecimal("s_bid"));
            studentClsSec.setS_active_ind(rs.getBoolean("s_active_ind"));
            studentClsSecs.add(studentClsSec);
        }
        return studentClsSecs;
    }
}
