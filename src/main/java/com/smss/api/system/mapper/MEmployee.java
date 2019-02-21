package com.smss.api.system.mapper;

import com.smss.api.system.models.Employee;
import org.reflections.util.Utils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MEmployee implements ResultSetExtractor<List<Employee>> {
    @Override
    public List<Employee> extractData(ResultSet rs) throws SQLException, DataAccessException {

            List<Employee> users = new ArrayList<Employee>();
                while (rs.next()) {
                    Employee user = new Employee();
                    user.setU_id(rs.getInt("u_id"));
                    user.setU_org_id(rs.getInt("u_org_id"));
                    user.setU_first_name(rs.getString("u_first_name"));
                    user.setU_middle_name(Objects.isNull(rs.getString("u_middle_name"))?"":rs.getString("u_middle_name"));
                    user.setU_last_name(Objects.isNull(rs.getString("u_last_name"))?"":rs.getString("u_last_name"));
                    user.setU_dob(rs.getDate("u_dob"));
                    user.setU_nativity(Objects.isNull(rs.getString("u_nativity"))?"":rs.getString("u_nativity"));
                    user.setU_nationality(Objects.isNull(rs.getString("u_nationality"))?"":rs.getString("u_nationality"));
                    user.setU_religion(Objects.isNull(rs.getString("u_religion"))?"":rs.getString("u_religion"));
                    user.setU_caste(Objects.isNull(rs.getString("u_caste"))?"":rs.getString("u_caste"));
                    user.setU_subcaste(Objects.isNull(rs.getString("u_subcaste"))?"":rs.getString("u_subcaste"));
                    user.setU_father_name(Objects.isNull(rs.getString("u_father_name"))?"":rs.getString("u_father_name"));
                    user.setU_mother_name(Objects.isNull(rs.getString("u_mother_name"))?"":rs.getString("u_mother_name"));
                    user.setU_guardian_name(Objects.isNull(rs.getString("u_guardian_name"))?"":rs.getString("u_guardian_name"));
                    user.setU_guardian_relation(Objects.isNull(rs.getString("u_guardian_relation"))?"":rs.getString("u_guardian_relation"));
                    user.setU_caddress(Objects.isNull(rs.getString("u_caddress"))?"":rs.getString("u_caddress"));
                    user.setU_clocation(Objects.isNull(rs.getString("u_clocation"))?"":rs.getString("u_clocation"));
                    user.setU_cstreet(Objects.isNull(rs.getString("u_cstreet"))?"":rs.getString("u_cstreet"));
                    user.setU_ccity(Objects.isNull(rs.getString("u_ccity"))?"":rs.getString("u_ccity"));
                    user.setU_cstate(Objects.isNull(rs.getString("u_cstate"))?"":rs.getString("u_cstate"));
                    user.setU_cdistrict(Objects.isNull(rs.getString("u_cdistrict"))?"":rs.getString("u_cdistrict"));
                    user.setU_cmandal(Objects.isNull(rs.getString("u_cmandal"))?"":rs.getString("u_cmandal"));
                    user.setU_czipcode(Objects.isNull(rs.getString("u_czipcode"))?"":rs.getString("u_czipcode"));
                    user.setU_paddress(Objects.isNull(rs.getString("u_paddress"))?"":rs.getString("u_paddress"));
                    user.setU_plocation(Objects.isNull(rs.getString("u_plocation"))?"":rs.getString("u_plocation"));
                    user.setU_pstreet(Objects.isNull(rs.getString("u_pstreet"))?"":rs.getString("u_pstreet"));
                    user.setU_pcity(Objects.isNull(rs.getString("u_pcity"))?"":rs.getString("u_pcity"));
                    user.setU_pstate(Objects.isNull(rs.getString("u_pstate"))?"":rs.getString("u_pstate"));
                    user.setU_pdistrict(Objects.isNull(rs.getString("u_pdistrict"))?"":rs.getString("u_pdistrict"));
                    user.setU_pmandal(Objects.isNull(rs.getString("u_pmandal"))?"":rs.getString("u_pmandal"));
                    user.setU_pzipcode(Objects.isNull(rs.getString("u_pzipcode"))?"":rs.getString("u_pzipcode"));
                    user.setU_pcontact_no(Objects.isNull(rs.getString("u_pcontact_no"))?"":rs.getString("u_pcontact_no"));
                    user.setU_scontact_no(Objects.isNull(rs.getString("u_scontact_no"))?"":rs.getString("u_scontact_no"));
                    user.setU_econtact_no(Objects.isNull(rs.getString("u_econtact_no"))?"":rs.getString("u_econtact_no"));
                    user.setU_mcontact_no(Objects.isNull(rs.getString("u_mcontact_no"))?"":rs.getString("u_mcontact_no"));
                    user.setU_fcontact_no(Objects.isNull(rs.getString("u_fcontact_no"))?"":rs.getString("u_fcontact_no"));
                    user.setU_gcontact_no(Objects.isNull(rs.getString("u_gcontact_no"))?"":rs.getString("u_gcontact_no"));
                    user.setU_active_ind(rs.getBoolean("u_active_ind"));
                    user.setU_email_id(Objects.isNull(rs.getString("u_email_id"))?"":rs.getString("u_email_id"));
                    user.setU_alt_email_id(Objects.isNull(rs.getString("u_alt_email_id"))?"":rs.getString("u_alt_email_id"));
                    user.setU_social_security_Id(Objects.isNull(rs.getString("u_social_security_Id"))?"":rs.getString("u_social_security_Id"));
                    user.setU_social_security_name(Objects.isNull(rs.getString("u_social_security_name"))?"":rs.getString("u_social_security_name"));
                    user.setU_refno(Objects.isNull(rs.getString("u_refno"))?"":rs.getString("u_refno"));
                    user.setU_mother_tongue(Objects.isNull(rs.getString("u_mother_tongue"))?"":rs.getString("u_mother_tongue"));
                    user.setU_ethnic_group(Objects.isNull(rs.getString("u_ethnic_group"))?"":rs.getString("u_ethnic_group"));
                    user.setU_ethnic_designation(Objects.isNull(rs.getString("u_ethnic_designation"))?"":rs.getString("u_ethnic_designation"));
                    user.setU_decile_group(Objects.isNull(rs.getString("u_decile_group"))?"":rs.getString("u_decile_group"));
                    user.setU_tenure(Objects.isNull(rs.getString("u_tenure"))?"":rs.getString("u_tenure"));
                    user.setU_branchid(rs.getInt("u_branchid"));
                    user.setU_gender(Objects.isNull(rs.getString("u_gender"))?"":rs.getString("u_gender"));
                    user.setU_photo(rs.getBytes("u_photo"));
                    user.setU_desg(Objects.isNull(rs.getString("ur_desg"))?"":rs.getString("ur_desg"));
                    user.setU_role(rs.getInt("ur_role"));
                    user.setU_designation(Objects.isNull(rs.getString("d_title"))?"":rs.getString("d_title"));
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

                    users.add(user);
                }
            return users;
    }
}
