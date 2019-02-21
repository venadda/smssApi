package com.smss.api.system.mapper;


import com.smss.api.system.models.Organization;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MOrganization implements ResultSetExtractor<List<Organization>> {



    @Override
    public List<Organization> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<Organization> orgs = new ArrayList<Organization>();
        while(rs.next()){
            Organization org = new Organization();
            org.setO_active_ind(rs.getBoolean("o_active_ind")==true?"Y":"N");
            org.setO_title(rs.getString("o_title"));
            org.setO_address(rs.getString("o_address"));
            org.setO_city(rs.getString("o_city"));
            org.setO_country(rs.getString("o_country"));
            org.setO_district(rs.getString("o_district"));
            org.setO_id(rs.getInt("o_id"));
            org.setO_location(rs.getString("o_location"));
            org.setO_mandal(rs.getString("o_mandal"));
            org.setO_pcontactno(rs.getString("o_pcontactno"));
            org.setO_pcontactperson(rs.getString("o_pcontactperson"));
            org.setO_pemail(rs.getString("o_pemail"));
            org.setO_pfaxno(rs.getString("o_pfaxno"));
            org.setO_pwebsite(rs.getString("o_pwebsite"));
            org.setO_scontactno(rs.getString("o_scontactno"));
            org.setO_scontactperson(rs.getString("o_scontactperson"));
            org.setO_semail(rs.getString("o_semail"));
            org.setO_sfaxno(rs.getString("o_sfaxno"));
            org.setO_smsurl(rs.getString("o_smsurl"));
            org.setO_state(rs.getString("o_state"));
            org.setO_street(rs.getString("o_street"));
            org.setO_swebsite(rs.getString("o_swebsite"));
            org.setO_type(rs.getString("o_type"));
            org.setO_village(rs.getString("o_village"));
            org.setO_zipcode(rs.getString("o_zipcode"));
            orgs.add(org);
            System.out.println(org.toString());
        }
        return orgs;
    }
}
