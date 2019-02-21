package com.smss.api.system.mapper;

import com.smss.api.system.models.OrgDepartment;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MOrgDepartment implements ResultSetExtractor<List<OrgDepartment>> {

    @Override
    public List<OrgDepartment> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<OrgDepartment> depts = new ArrayList<OrgDepartment>();
        while(resultSet.next()){
            OrgDepartment depart = new OrgDepartment();
            depart.setD_id(resultSet.getBigDecimal("d_id"));
            depart.setD_oid(resultSet.getBigDecimal("d_oid"));
            depart.setD_title(resultSet.getString("d_title"));
            depart.setD_active_ind(resultSet.getBoolean("d_active_ind"));
            depts.add(depart);
        }
        return depts;
    }
}
