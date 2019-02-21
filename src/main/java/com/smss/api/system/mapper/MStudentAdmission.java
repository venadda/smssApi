package com.smss.api.system.mapper;

import com.smss.api.system.models.StudentAdmission;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MStudentAdmission implements ResultSetExtractor<List<StudentAdmission>> {
    @Override
    public List<StudentAdmission> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<StudentAdmission> admissions = new ArrayList<StudentAdmission>();
        while(rs.next()){
            StudentAdmission admission = new StudentAdmission();
            admission.setS_id(rs.getInt("s_id"));
            admission.setS_oid(rs.getInt("s_oid"));
            admission.setS_bid(rs.getInt("s_bid"));
            admission.setS_first_name(rs.getString("s_first_name"));
            admission.setS_middle_name(rs.getString("s_middle_name"));
            admission.setS_last_name(rs.getString("s_last_name"));
            admission.setS_dob(rs.getDate("s_dob"));
            admission.setS_nativity(rs.getString("s_nativity"));
            admission.setS_nationality(rs.getString("s_nationality"));
            admission.setS_religion(rs.getString("s_religion"));
            admission.setS_caste(rs.getString("s_caste"));
            admission.setS_subcaste(rs.getString("s_subcaste"));
            admission.setS_father_name(rs.getString("s_father_name"));
            admission.setS_mother_name(rs.getString("s_mother_name"));
            admission.setS_guadian_name(rs.getString("s_guadian_name"));
            admission.setS_guadian_relationship(rs.getString("s_guadian_relationship"));
            admission.setS_address(rs.getString("s_address"));
            admission.setS_location(rs.getString("s_location"));
            admission.setS_street(rs.getString("s_street"));
            admission.setS_city(rs.getString("s_city"));
            admission.setS_state(rs.getString("s_state"));
            admission.setS_country(rs.getString("s_country"));
            admission.setS_zipcode(rs.getString("s_zipcode"));
            admission.setS_mandal(rs.getString("s_mandal"));
            admission.setS_district(rs.getString("s_district"));
            admission.setS_pcontactno(rs.getString("s_pcontactno"));
            admission.setS_scontactno(rs.getString("s_scontactno"));
            admission.setS_gender(rs.getString("s_gender"));
            admission.setS_created_date(rs.getDate("s_created_date"));
            admission.setS_date_enrolled(rs.getDate("s_date_enrolled"));
            admission.setS_applied_for(rs.getString("s_applied_for"));
            admission.setS_status_of_application(rs.getString("s_status_of_application"));
            admission.setS_processed_By(rs.getInt("s_processed_By"));
            admission.setS_approved_by(rs.getInt("s_approved_by"));
            admission.setS_remark(rs.getString("s_remark"));
            admission.setS_updated_date(rs.getDate("s_updated_date"));
            admission.setS_updated_by(rs.getInt("s_updated_by"));
            admission.setS_active_ind(rs.getBoolean("s_active_ind"));
            admission.setS_application_status(rs.getString("s_application_status"));
            admission.setS_doa(rs.getDate("s_doa"));
            admission.setS_coursename(rs.getString("s_coursename"));
            admission.setS_admission_year(rs.getString("s_admission_year"));
            admission.setS_admission_for(rs.getString("s_admission_for"));
            admission.setS_email_id(rs.getString("s_email_id"));
            admissions.add(admission);
        }
        return admissions;
    }
}
