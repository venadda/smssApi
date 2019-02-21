package com.smss.api.system.mapper;

import com.smss.api.system.models.EmployeeDetails;
import com.smss.api.system.models.SystemUserDetails;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MEmployeeDetails implements ResultSetExtractor<List<EmployeeDetails>> {
    @Override
    public List<EmployeeDetails> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<EmployeeDetails> userDetails = new ArrayList<EmployeeDetails>();
        while (rs.next()) {
            EmployeeDetails user = new EmployeeDetails();
            user.setU_active_ind(rs.getBoolean("activeind"));
            user.setU_id(rs.getInt("uid"));
            user.setA_user_orgId(rs.getBigDecimal("orgid"));
            user.setU_first_name(rs.getString("firstname"));
            user.setU_middle_name(rs.getString("middlename"));
            user.setU_last_name(rs.getString("lastname"));
            user.setU_dob(rs.getDate("dob"));
            user.setU_nativity(rs.getString("nativity"));
            user.setU_nationality(rs.getString("nationality"));
            user.setU_religion(rs.getString("religion"));
            user.setU_caste(rs.getString("caste"));
            user.setU_subcaste(rs.getString("subcaste"));
            user.setU_father_name(rs.getString("fathername"));
            user.setU_mother_name(rs.getString("mothername"));
            user.setU_guardian_name(rs.getString("guardianname"));
            user.setU_guardian_relation(rs.getString("guardianrelation"));
            user.setU_caddress(rs.getString("caddress"));
            user.setU_clocation(rs.getString("clocation"));
            user.setU_cstreet(rs.getString("cstreet"));
            user.setU_ccity(rs.getString("ccity"));
            user.setU_cstate(rs.getString("cstate"));
            user.setU_cdistrict(rs.getString("cdistrict"));
            user.setU_cmandal(rs.getString("cmandal"));
            user.setU_czipcode(rs.getString("czipcode"));
            user.setU_paddress(rs.getString("paddress"));
            user.setU_plocation(rs.getString("plocation"));
            user.setU_pstreet(rs.getString("pstreet"));
            user.setU_pcity(rs.getString("pcity"));
            user.setU_pstate(rs.getString("pstate"));
            user.setU_pdistrict(rs.getString("pdistrict"));
            user.setU_pmandal(rs.getString("pmandal"));
            user.setU_pzipcode(rs.getString("pzipcode"));
            user.setU_pcontact_no(rs.getString("pcontactno"));
            user.setU_scontact_no(rs.getString("scontactno"));
            user.setU_econtact_no(rs.getString("econtactno"));
            user.setU_mcontact_no(rs.getString("mcontactno"));
            user.setU_fcontact_no(rs.getString("fcontactno"));
            user.setU_gcontact_no(rs.getString("gcontactno"));
            user.setU_active_ind(rs.getBoolean("activeind"));
            user.setU_email_id(rs.getString("emailid"));
            user.setU_alt_email_id(rs.getString("altemailid"));
            user.setU_social_security_Id(rs.getString("socialsecurityid"));
            user.setU_social_security_name(rs.getString("socialsecurityname"));
            user.setU_suffix(rs.getString("suffix"));
            user.setU_mother_tongue(rs.getString("mothertongue"));
            user.setU_ethnic_group(rs.getString("ethnicgroup"));
            user.setU_ethnic_designation(rs.getString("ethnicdesignation"));
            user.setU_decile_group(rs.getString("decilegroup"));
            user.setU_tenure(rs.getString("tenure"));

            user.setA_account_status(rs.getBoolean("a_account_status"));
            user.setA_active_ind(rs.getBoolean("a_active_ind"));

            user.setA_user_firstName(rs.getString("a_user_firstName"));
            user.setA_id(rs.getBigDecimal("a_id"));
            user.setA_last_logged_in(rs.getDate("a_last_logged_in"));
            user.setA_user_lastName(rs.getString("a_user_lastName"));
            user.setA_login_count(rs.getInt("a_login_count"));
            user.setA_user_loginid(rs.getString("a_user_loginid"));
            user.setA_user_pwd(rs.getString("a_user_pwd"));
            user.setA_user_type(rs.getString("a_user_type"));
            user.setA_user_id(rs.getBigDecimal("a_user_id"));
            user.setR_active_ind(rs.getBoolean("r_active_ind"));
            user.setR_desc(rs.getString("r_desc"));
            user.setR_id(rs.getInt("r_id"));
            user.setR_title(rs.getString("r_title"));
            user.setU_photo(rs.getBytes("photo"));
            user.setOrgid(rs.getInt("uporg_id"));
            user.setBranchid(rs.getInt("ur_branch"));
            user.setDesg(rs.getString("ur_desg"));
            user.setU_height(rs.getString("u_height"));
            user.setU_weight(rs.getString("u_weight"));
            user.setU_blood_group(rs.getString("u_blood_group"));
            user.setU_disease(rs.getBoolean("u_disease"));
            user.setU_formal_soldier(rs.getBoolean("u_formal_soldier"));
            user.setU_handicap(rs.getBoolean("u_handicap"));
            user.setU_panno(rs.getString("u_panno"));
            user.setU_pfuid(rs.getString("u_pfuid"));
            user.setU_certificate(rs.getBoolean("u_certificate"));
            user.setU_cert_name(rs.getString("u_cert_name"));
            user.setU_cert_grade(rs.getString("u_cert_grade"));
            user.setU_cert_type(rs.getString("u_cert_type"));
            user.setU_bestTeacher(rs.getBoolean("u_bestTeacher"));
            user.setU_btdesc(rs.getString("u_btdesc"));
            user.setU_achievement(rs.getBoolean("u_achievement"));
            user.setU_marital_status(rs.getBoolean("u_marital_status"));
            user.setU_spouse_name(rs.getString("u_spouse_name"));
            user.setU_spouse_contact_no(rs.getString("u_spouse_contact_no"));
            user.setU_spouse_working(rs.getBoolean("u_spouse_working"));
            user.setU_children(rs.getInt("u_children"));
            user.setU_child_sons(rs.getInt("u_child_sons"));
            user.setU_child_girls(rs.getInt("u_child_girls"));
            user.setU_f_ref_name(rs.getString("u_f_ref_name"));
            user.setU_f_ref_contact_no(rs.getString("u_f_ref_contact_no"));
            user.setU_f_ref_address(rs.getString("u_f_ref_address"));
            user.setU_f_ref_desc(rs.getString("u_f_ref_desc"));
            user.setU_f_ref_aadharno(rs.getString("u_f_ref_aadharno"));
            user.setU_s_ref_name(rs.getString("u_s_ref_name"));
            user.setU_s_ref_contact_no(rs.getString("u_s_ref_contact_no"));
            user.setU_s_ref_address(rs.getString("u_s_ref_address"));
            user.setU_s_ref_desc(rs.getString("u_s_ref_desc"));
            user.setU_s_ref_aadharno(rs.getString("u_s_ref_aadharno"));
            userDetails.add(user);

        }
        return userDetails;
    }
}
