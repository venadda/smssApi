package com.smss.api.system.mapper;

import com.smss.api.system.models.Parent;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MParent implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        Parent parent = new Parent();
        parent.setP_id(resultSet.getInt("p_id"));
        parent.setP_father_name(resultSet.getString("p_father_name"));
        parent.setP_mother_name(resultSet.getString("p_mother_name"));
        parent.setP_guardian_name(resultSet.getString("p_guardian_name"));
        parent.setP_email_id(resultSet.getString("p_email_id"));
        parent.setP_father_contactno(resultSet.getString("p_father_contactno"));
        parent.setP_mother_contactno (resultSet.getString("p_mother_contactno"));
        parent.setP_guardian_contactno (resultSet.getString("p_guardian_contactno"));
        parent.setP_address(resultSet.getString("p_address"));
        parent.setP_location(resultSet.getString("p_location"));
        parent.setP_street(resultSet.getString("p_street"));
        parent.setP_state(resultSet.getString("p_state"));
        parent.setP_city(resultSet.getString("p_city"));
        parent.setP_country(resultSet.getString("p_country"));
        parent.setP_zipcode(resultSet.getString("p_zipcode"));
        parent.setP_active_ind(resultSet.getBoolean("p_active_ind"));
        parent.setP_oid(resultSet.getBigDecimal("p_oid"));
        parent.setP_father_profission(resultSet.getString("p_father_profission"));
        parent.setP_mother_profission(resultSet.getString("p_mother_profission"));
        parent.setP_guardian_profission(resultSet.getString("p_guardian_profission"));
        parent.setP_father_qualification(resultSet.getString("p_father_qualification"));
        parent.setP_mother_qualification(resultSet.getString("p_mother_qualification"));
        parent.setP_guardian_qualification(resultSet.getString("p_guardian_qualification"));
        parent.setP_father_income(resultSet.getString("p_father_income"));
        parent.setP_mother_income(resultSet.getString("p_mother_income"));
        parent.setP_guardian_income(resultSet.getString("p_guardian_income"));
        parent.setP_father_aadhar_no(resultSet.getString("p_father_aadhar_no"));
        parent.setP_mother_aadhar_no(resultSet.getString("p_mother_aadhar_no"));
        parent.setP_guardian_aadhar_no(resultSet.getString("p_guardian_aadhar_no"));

        return parent;
    }
}
