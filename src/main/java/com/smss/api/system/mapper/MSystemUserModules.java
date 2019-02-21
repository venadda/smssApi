package com.smss.api.system.mapper;

import com.smss.api.system.models.SystemUserModules;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MSystemUserModules implements ResultSetExtractor<List<SystemUserModules>> {
    @Override
    public List<SystemUserModules> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<SystemUserModules> modules = new ArrayList<SystemUserModules>();

        while(rs.next()){

            SystemUserModules module = new SystemUserModules();
            module.setUdelete(rs.getString("udelete"));
            module.setMdesc(rs.getString("mdesc"));
            module.setUedit(rs.getString("uedit"));
            module.setId(rs.getInt("id"));
            module.setMkeys(rs.getString("mkeys"));
            module.setMid(rs.getInt("mid"));
            module.setMname(rs.getString("title"));
            module.setUadd(rs.getString("uadd"));
            module.setUserid(rs.getInt("userid"));
            module.setUview(rs.getString("uview"));
            module.setMview(rs.getString("mview"));
            module.setOrgid(rs.getInt("orgid"));
            modules.add(module);

        }
        return modules;
    }
}
