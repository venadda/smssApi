package com.smss.api.system.mapper;

import com.smss.api.system.models.OrgUserRoles;
import com.smss.api.system.models.UserAssignedRoles;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MOrgUserRoles implements ResultSetExtractor<List<OrgUserRoles>> {

    @Override
    public List<OrgUserRoles> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<OrgUserRoles> userroles = new ArrayList<OrgUserRoles>();
        while(rs.next()){
            OrgUserRoles role = new OrgUserRoles();
            role.setUr_id(rs.getInt("ur_id"));
            role.setUr_org_id(rs.getInt("ur_org_id"));
            role.setUr_role(rs.getInt("ur_role"));
            role.setUr_uid(rs.getInt("ur_uid"));
            role.setUr_active_ind(rs.getBoolean("ur_active_ind"));
            userroles.add(role);
        }
        return userroles;
    }
}
