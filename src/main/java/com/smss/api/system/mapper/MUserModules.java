package com.smss.api.system.mapper;

import com.smss.api.system.models.Usermodule;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MUserModules implements ResultSetExtractor<List<Usermodule>> {

    @Override
    public List<Usermodule> extractData(ResultSet rs) throws SQLException, DataAccessException {
            List<Usermodule> usermodules = new ArrayList<Usermodule>();
            while(rs.next()){
                Usermodule umodule = new Usermodule();
                umodule.setUmid(rs.getInt("id"));
                umodule.setMid(rs.getInt("mid"));
                umodule.setUserid(rs.getInt("userid"));
                umodule.setUview(rs.getString("view"));
                umodule.setUedit(rs.getString("edit"));
                umodule.setUdelete(rs.getString("delete"));
                umodule.setOrgid(rs.getInt("orgid"));
                usermodules.add(umodule);
            }
            return usermodules;
            }
}
