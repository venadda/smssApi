package com.smss.api.system.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.smss.api.system.models.AdmissionYears;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MAdmissionYears implements ResultSetExtractor<List<AdmissionYears>> {

    @Override
    public List<AdmissionYears> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<AdmissionYears> admissions = new ArrayList<AdmissionYears>();
        while(rs.next()) {
            AdmissionYears admission = new AdmissionYears();
            admission.setAy_active_ind(rs.getBoolean("ay_active_ind"));
            admission.setAy_bid(rs.getInt("ay_bid"));
            admission.setAy_desc(rs.getString("ay_desc"));
            admission.setAy_id(rs.getInt("ay_id"));
            admission.setAy_oid(rs.getInt("ay_oid"));
            admission.setAy_year(rs.getString("ay_year"));
            admissions.add(admission);
        }
        return admissions;
    }
}
