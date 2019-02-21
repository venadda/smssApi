package com.smss.api.system.mapper;

import com.smss.api.system.models.Others;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MOthers implements ResultSetExtractor<List<Others>> {

    @Override
    public List<Others> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Others> others = new ArrayList<Others>();
        while(resultSet.next()) {
            Others other = new Others();
            other.setO_id(resultSet.getInt("o_id"));
            other.setO_first_name(resultSet.getString("o_first_name"));
            other.setO_last_name(resultSet.getString("o_last_name"));
            other.setO_middle_name(resultSet.getString("o_middle_name"));
            other.setO_email_id(resultSet.getString("o_email_id"));
            other.setO_pcontact_no(resultSet.getString("o_pcontact_no"));
            other.setO_scontact_no(resultSet.getString("o_scontact_no"));
            other.setO_address(resultSet.getString("o_address"));
            other.setO_location(resultSet.getString("o_location"));
            other.setO_street(resultSet.getString("o_street"));
            other.setO_state(resultSet.getString("o_state"));
            other.setO_city(resultSet.getString("o_city"));
            other.setO_country(resultSet.getString("o_country"));
            other.setO_zipcode(resultSet.getString("o_zipcode"));
            other.setO_active_ind(resultSet.getBoolean("o_active_ind"));
            other.setO_org_id(resultSet.getInt("o_org_id"));
            other.setO_purpose(resultSet.getString("o_purpose"));
            other.setO_comment(resultSet.getString("o_comment"));
            other.setO_remark(resultSet.getString("o_remark"));
            other.setO_suffix(resultSet.getString("o_suffix"));
            other.setO_no_visits(resultSet.getInt("o_no_visits"));
            others.add(other);
        }
        return others;
    }
}
