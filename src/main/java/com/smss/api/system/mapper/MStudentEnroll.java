package com.smss.api.system.mapper;

import com.smss.api.system.models.StudentEnroll;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MStudentEnroll implements RowMapper {
    @Override
    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        StudentEnroll student = new StudentEnroll();
        student.setS_bid(resultSet.getBigDecimal("s_bid"));
        student.setS_active_ind(resultSet.getBoolean("s_active_ind"));
        student.setS_address(resultSet.getString("s_address"));
        student.setS_applied_for(resultSet.getString("s_applied_for"));
        student.setS_approved_by(resultSet.getBigDecimal("s_approved_by"));
        student.setS_caste(resultSet.getString("s_caste"));
        student.setS_city(resultSet.getString("s_city"));
        student.setS_country(resultSet.getString("s_country"));
        student.setS_created_date(resultSet.getDate("s_created_date"));
        student.setS_date_enrolled(resultSet.getDate("s_date_enrolled"));
        student.setS_district(resultSet.getString("s_district"));
        student.setS_dob(resultSet.getDate("s_dob"));
        student.setS_father_name(resultSet.getString("s_father_name"));
        student.setS_first_name(resultSet.getString("s_first_name"));
        student.setS_gender(resultSet.getString("s_gender"));
        student.setS_guadian_name(resultSet.getString("s_guadian_name"));
        student.setS_guadian_relationship(resultSet.getString("s_guadian_relationship"));
        student.setS_id(resultSet.getBigDecimal("s_id"));
        student.setS_last_name(resultSet.getString("s_last_name"));
        student.setS_location(resultSet.getString("s_location"));
        student.setS_mandal(resultSet.getString("s_mandal"));
        student.setS_middle_name(resultSet.getString("s_middle_name"));
        student.setS_mother_name(resultSet.getString("s_mother_name"));
        student.setS_nationality(resultSet.getString("s_nationality"));
        student.setS_nativity(resultSet.getString("s_nativity"));
        student.setS_orgId(resultSet.getBigDecimal("s_orgId"));
        student.setS_pcontactno(resultSet.getString("s_pcontactno"));
        student.setS_processed_By(resultSet.getBigDecimal("s_processed_By"));
        student.setS_religion(resultSet.getString("s_religion"));
        student.setS_remark(resultSet.getString("s_remark"));
        student.setS_scontactno(resultSet.getString("s_scontactno"));
        student.setS_state(resultSet.getString("s_state"));
        student.setS_status_of_application(resultSet.getString("s_status_of_application"));
        student.setS_street(resultSet.getString("s_street"));
        student.setS_subcaste(resultSet.getString("s_subcaste"));
        student.setS_updated_date(resultSet.getDate("s_updated_date"));
        student.setS_zipcode(resultSet.getString("s_zipcode"));
        student.setS_updated_by(resultSet.getBigDecimal("s_updated_by"));

        return student;
    }
}
