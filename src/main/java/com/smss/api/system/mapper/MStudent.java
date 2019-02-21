package com.smss.api.system.mapper;

import com.smss.api.system.models.*;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MStudent implements ResultSetExtractor<List<Student>> {

    @Override
    public List<Student> extractData(ResultSet resultSet) throws SQLException, DataAccessException {
        List<Student> students = new ArrayList<Student>();
        while(resultSet.next()) {
            Student student = new Student();

            student.setS_id(resultSet.getBigDecimal("s_id"));
            student.setS_admission_no(resultSet.getString("s_admission_no"));
            student.setS_roll_no(resultSet.getInt("s_roll_no"));
            student.setS_oid(resultSet.getBigDecimal("s_oid"));
            student.setS_bid(resultSet.getBigDecimal("s_bid"));
            student.setS_first_name(resultSet.getString("s_first_name"));
            student.setS_middle_name(resultSet.getString("s_middle_name"));
            student.setS_last_name(resultSet.getString("s_last_name"));
            student.setS_dob(resultSet.getDate("s_dob"));
            student.setS_nativity(resultSet.getString("s_nativity"));
            student.setS_nationality(resultSet.getString("s_nationality"));
            student.setS_religion(resultSet.getString("s_religion"));
            student.setS_caste(resultSet.getString("s_caste"));
            student.setS_subcaste(resultSet.getString("s_subcaste"));
            student.setS_bp_village(resultSet.getString("s_bp_village"));
            student.setS_bp_taluka(resultSet.getString("s_bp_taluka"));
            student.setS_bp_district(resultSet.getString("s_bp_district"));
            student.setS_bp_state(resultSet.getString("s_bp_state"));
            student.setS_current_address(resultSet.getString("s_current_address"));
            student.setS_current_location(resultSet.getString("s_current_location"));
            student.setS_current_street(resultSet.getString("s_current_street"));
            student.setS_current_city(resultSet.getString("s_current_city"));
            student.setS_current_state(resultSet.getString("s_current_state"));
            student.setS_current_country(resultSet.getString("s_current_country"));
            student.setS_current_zipcode(resultSet.getString("s_current_zipcode"));
            student.setS_current_mandal(resultSet.getString("s_current_mandal"));
            student.setS_current_district(resultSet.getString("s_current_district"));
            student.setS_pcontactno(resultSet.getString("s_pcontactno"));
            student.setS_scontactno(resultSet.getString("s_scontactno"));
            student.setS_econtactno(resultSet.getString("s_econtactno"));
            student.setS_present_address(resultSet.getString("s_present_address"));
            student.setS_present_location(resultSet.getString("s_present_location"));
            student.setS_present_street(resultSet.getString("s_present_street"));
            student.setS_present_city(resultSet.getString("s_present_city"));
            student.setS_present_state(resultSet.getString("s_present_state"));
            student.setS_present_country(resultSet.getString("s_present_country"));
            student.setS_present_zipcode(resultSet.getString("s_present_zipcode"));
            student.setS_present_mandal(resultSet.getString("s_present_mandal"));
            student.setS_present_district(resultSet.getString("s_present_district"));
            student.setS_gender(resultSet.getString("s_gender"));
            student.setS_created_date(resultSet.getDate("s_created_date"));
            student.setS_date_joined(resultSet.getDate("s_date_joined"));
            student.setS_created_By(resultSet.getInt("s_created_By"));
            student.setS_approved_by(resultSet.getInt("s_approved_by"));
            student.setS_remark(resultSet.getString("s_remark"));
            student.setS_updated_date(resultSet.getDate("s_updated_date"));
            student.setS_updated_by(resultSet.getInt("s_updated_by"));
            student.setS_active_ind(resultSet.getBoolean("s_active_ind"));
            student.setS_mother_tongue(resultSet.getString("s_mother_tongue"));
            student.setS_height(resultSet.getString("s_height"));
            student.setS_weight(resultSet.getString("s_weight"));
            student.setS_bloodgroup(resultSet.getString("s_bloodgroup"));
            student.setS_physically_handicap(resultSet.getBoolean("s_physically_handicap"));
            student.setS_isOrphan(resultSet.getBoolean("s_isOrphan"));
            student.setS_aadharno(resultSet.getString("s_aadharno"));
            student.setS_photo(resultSet.getBytes("s_photo"));
            student.setS_pid(resultSet.getInt("s_pid"));
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
            student.setParent(parent);
            StudentClsSec studentClsSec = new StudentClsSec();
            studentClsSec.setS_scsid(resultSet.getInt("s_scsid"));
            studentClsSec.setS_sid (resultSet.getInt("s_sid"));
            studentClsSec.setS_clsid (resultSet.getString("s_clsid"));
            studentClsSec.setS_cls_code (resultSet.getString("s_cls_code"));
            studentClsSec.setS_ayid (resultSet.getString("s_ayid"));
            studentClsSec.setS_oid (resultSet.getBigDecimal("s_oid"));
            studentClsSec.setS_bid (resultSet.getBigDecimal("s_bid"));
            studentClsSec.setS_active_ind(resultSet.getBoolean("s_active_ind"));
            student.setStudentClsSec(studentClsSec);

          /*  StudentAcademicHistory academic = new StudentAcademicHistory();
            academic.setS_sahid(resultSet.getBigDecimal("s_sahid"));
            academic.setS_id(resultSet.getBigDecimal("s_id"));
            academic.setS_courseName(resultSet.getString("s_courseName"));
            academic.setS_organization(resultSet.getString("s_organization"));
            academic.setS_marks (resultSet.getString("s_marks"));
            academic.setS_year (resultSet.getString("s_year"));
            academic.setS_grade (resultSet.getString("s_grade"));
            academic.setS_stream (resultSet.getString("s_stream"));
            academic.setS_comment(resultSet.getString("s_comment"));
            academic.setS_attachment(resultSet.getBytes("s_attachment"));
            academic.setS_oid (resultSet.getInt("s_oid"));
            academic.setS_bid (resultSet.getInt("s_bid"));
            student.setAcademic(academic);*/
            students.add(student);
        }
return students;
    }
}
