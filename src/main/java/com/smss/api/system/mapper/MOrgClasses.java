package com.smss.api.system.mapper;

import com.smss.api.system.models.OrgClasses;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MOrgClasses implements ResultSetExtractor<List<OrgClasses>> {
    @Override
    public List<OrgClasses> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<OrgClasses> classes = new ArrayList<OrgClasses>();
        try {
            while (rs.next()) {
                OrgClasses oclass = new OrgClasses();

                oclass.setBc_cls_code(rs.getString("bc_cls_code"));
                oclass.setBc_cls_id(rs.getString("bc_cls_id"));
                oclass.setBc_dsply_title(rs.getString("bc_dsply_title"));
                oclass.setBc_bid(rs.getInt("bc_bid"));
                oclass.setBc_short_title(rs.getString("bc_short_title"));
                oclass.setBc_ayid(rs.getInt("bc_ayid"));
                oclass.setBc_oid(rs.getInt("bc_oid"));
                classes.add(oclass);

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return classes;
    }
}
