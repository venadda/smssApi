package com.smss.api.system.mapper;

import com.smss.api.system.models.OrgClasses;
import com.smss.api.system.models.TermMapTermFee;
import com.smss.api.system.models.Terms;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class MTermMapTermFee implements ResultSetExtractor<TermMapTermFee> {
    @Override
    public TermMapTermFee extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<TermMapTermFee> termMapTermFee = new ArrayList<TermMapTermFee>();
        while(rs.next()){

            Set<OrgClasses> orgClasses = new LinkedHashSet<>();
            OrgClasses ocls = new OrgClasses();
            ocls.setBc_oid(rs.getInt("bc_oid"));
            ocls.setBc_ayid(rs.getInt("bc_ayid"));
            ocls.setBc_bid(rs.getInt("bc_bid"));
            ocls.setBc_cls_code(rs.getString("bc_cls_code"));
            ocls.setBc_cls_id(rs.getString("bc_cls_id"));
            ocls.setBc_dsply_title(rs.getString("bc_dsply_title"));
            ocls.setBc_short_title(rs.getString("bc_short_title"));
            orgClasses.add(ocls);
            List<Terms> terms = new ArrayList<Terms>();

        }
        return null;
    }
}
