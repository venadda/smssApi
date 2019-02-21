package com.smss.api.system.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.smss.api.system.models.Audit;
import com.smss.api.system.models.Employee;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MAudit implements ResultSetExtractor<List<Audit>> {
    @Override
    public List<Audit> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Audit> audits = new ArrayList<Audit>();
        ObjectMapper objectMapper = new ObjectMapper();

        while(rs.next()){
            Audit audit = new Audit();
            audit.setId( rs.getInt("id"));
            audit.setAction_by(rs.getInt("action_by") );
            audit.setAction_type( rs.getString("action_type"));
            audit.setData(rs.getString("data"));
            audit.setOrgid(rs.getInt("orgid"));
            audit.setUser_name(rs.getString("user_name"));
            audit.setView_name(rs.getString("view_name"));
            audit.setAction_date(rs.getDate("action_date"));
            audit.setAction(rs.getString("action"));
            audits.add(audit) ;
        }
        return audits;
    }
}
