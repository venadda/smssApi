package com.smss.api.system.mapper;

import com.smss.api.system.models.Module;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MModules implements ResultSetExtractor<List<Module>> {


    @Override
    public List<Module> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Module> modules = new ArrayList<Module>();
    while(rs.next()){
     Module module = new Module();
        module.setId(rs.getInt("id")) ;
        module.setDesc(rs.getString("desc"));
        module.setKeys(rs.getString("keys"));
        module.setName(rs.getString("name"));
        module.setView(rs.getString("view"));
        modules.add(module);

    }
    return modules;
   }
}
