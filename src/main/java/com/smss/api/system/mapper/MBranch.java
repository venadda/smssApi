package com.smss.api.system.mapper;

import com.smss.api.system.models.Branch;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MBranch implements ResultSetExtractor<List<Branch>> {



    @Override
    public List<Branch> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Branch> branches = new ArrayList<Branch>();
        while(resultSet.next()) {
            Branch branch = new Branch();
            branch.setB_active_ind(resultSet.getBoolean("b_active_ind")==true?"Y":"N");
            branch.setB_address(resultSet.getString("b_address"));
            branch.setB_city(resultSet.getString("b_city"));
            branch.setB_district(resultSet.getString("b_district"));
            branch.setB_location(resultSet.getString("b_location"));
            branch.setB_mandal(resultSet.getString("b_mandal"));
            branch.setB_pfaxNumber(resultSet.getString("b_pfaxnumber"));
            branch.setB_pphoneNumber(resultSet.getString("b_pphonenumber"));
            branch.setB_refId(resultSet.getBigDecimal("b_refid"));
            branch.setB_sphoneNumber(resultSet.getString("b_sphonenumber"));
            branch.setB_state(resultSet.getString("b_state"));
            branch.setB_street(resultSet.getString("b_street"));
            branch.setB_title(resultSet.getString("b_title"));
            branch.setB_zipcode(resultSet.getString("b_zipcode"));
            branch.setB_oid(resultSet.getBigDecimal("b_oid"));
            branch.setB_id(resultSet.getBigDecimal("b_id"));
            branch.setB_village(resultSet.getString("b_village"));
            branch.setB_zone(resultSet.getString("b_zone"));
            branches.add(branch);
        }
        return branches;

    }
}
