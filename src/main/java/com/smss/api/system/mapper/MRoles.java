package com.smss.api.system.mapper;

import com.smss.api.system.models.CourseClasses;
import com.smss.api.system.models.Roles;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MRoles implements ResultSetExtractor<List<Roles>> {
    @Override
    public List<Roles> extractData(ResultSet rs) throws SQLException, DataAccessException {

        List<Roles> roles = new ArrayList<Roles>();
        while(rs.next()){
            Roles role = new Roles();
            role.setR_active_ind(rs.getBoolean("r_active_ind"));
            role.setR_desc(rs.getString("r_desc"));
            role.setR_id(rs.getBigDecimal("r_id"));
            role.setR_title(rs.getString("r_title"));
            roles.add(role);
        }
        return roles;
    }

}
