package com.smss.api.system.mapper;

import com.smss.api.system.models.Generics;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MGenerics implements ResultSetExtractor<List<Generics>> {

    @Override
    public List<Generics> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Generics> generics = new ArrayList<Generics>();
        while(rs.next()){
            Generics generic = new Generics();
            generic.setG_code(rs.getString("g_code"));
            generic.setG_desc(rs.getString("g_desc"));
            generic.setG_title(rs.getString("g_title"));
            generic.setG_type(rs.getString("g_type"));
            generics.add(generic);
        }
        return generics;
    }
}
