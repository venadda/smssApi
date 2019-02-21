package com.smss.api.system.mapper;

import com.smss.api.system.models.UserRoles;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MUserRoles implements ResultSetExtractor<List<UserRoles>> {
    @Override
    public List<UserRoles> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<UserRoles> userroles = new ArrayList<UserRoles>();
        System.out.println(rs.getMetaData().getColumnCount());
        while(rs.next()){
            System.out.println("ok");
            UserRoles userrole = new UserRoles();
            userrole.setU_id(rs.getInt("u_id"));
            userrole.setU_org_id(rs.getInt("u_org_id"));
            userrole.setU_first_name(rs.getString("u_first_name"));
            userrole.setU_middle_name (rs.getString("u_middle_name"));
            userrole.setU_last_name(rs.getString("u_last_name"));
            userrole.setU_dob(rs.getDate("u_dob"));
            userrole.setU_nativity(rs.getString("u_nativity"));
            userrole.setU_nationality(rs.getString("u_nationality"));
            userrole.setU_religion(rs.getString("u_religion"));
            userrole.setU_caste(rs.getString("u_caste"));
            userrole.setU_subcaste(rs.getString("u_subcaste"));
            userrole.setU_father_name(rs.getString("u_father_name"));
            userrole.setU_mother_name(rs.getString("u_mother_name"));
            userrole.setU_guardian_name(rs.getString("u_guardian_name"));
            userrole.setU_guardian_relation(rs.getString("u_guardian_relation"));
            userrole.setU_caddress(rs.getString("u_caddress"));
            userrole.setU_clocation(rs.getString("u_clocation"));
            userrole.setU_cstreet(rs.getString("u_cstreet"));
            userrole.setU_ccity(rs.getString("u_ccity"));
            userrole.setU_cstate(rs.getString("u_cstate"));
            userrole.setU_cdistrict(rs.getString("u_cdistrict"));
            userrole.setU_cmandal(rs.getString("u_cmandal"));
            userrole.setU_czipcode(rs.getString("u_czipcode"));
            userrole.setU_paddress(rs.getString("u_paddress"));
            userrole.setU_plocation(rs.getString("u_plocation"));
            userrole.setU_pstreet(rs.getString("u_pstreet"));
            userrole.setU_pcity(rs.getString("u_pcity"));
            userrole.setU_pstate(rs.getString("u_pstate"));
            userrole.setU_pdistrict(rs.getString("u_pdistrict"));
            userrole.setU_pmandal(rs.getString("u_pmandal"));
            userrole.setU_pzipcode(rs.getString("u_pzipcode"));
            userrole.setU_pcontact_no(rs.getString("u_pcontact_no"));
            userrole.setU_scontact_no(rs.getString("u_scontact_no"));
            userrole.setU_econtact_no(rs.getString("u_econtact_no"));
            userrole.setU_mcontact_no(rs.getString("u_mcontact_no"));
            userrole.setU_fcontact_no(rs.getString("u_fcontact_no"));
            userrole.setU_gcontact_no(rs.getString("u_gcontact_no"));
            userrole.setU_active_ind(rs.getBoolean("u_active_ind"));
            userrole.setU_email_id(rs.getString("u_email_id"));
            userrole.setU_alt_email_id(rs.getString("u_alt_email_id"));
            userrole.setU_social_security_Id(rs.getString("u_social_security_Id"));
            userrole.setU_social_security_name(rs.getString("u_social_security_name"));
            userrole.setU_suffix(rs.getString("u_suffix"));
            userrole.setU_mother_tongue(rs.getString("u_mother_tongue"));
            userrole.setU_ethnic_group(rs.getString("u_ethnic_group"));
            userrole.setU_ethnic_designation(rs.getString("u_ethnic_designation"));
            userrole.setU_decile_group(rs.getString("u_decile_group"));
            userrole.setU_tenure(rs.getString("u_tenure"));
            userrole.setR_id(rs.getInt("r_id"));
            userrole.setR_title(rs.getString("r_title"));
            userrole.setR_active_ind(rs.getBoolean("r_active_ind"));
            userrole.setR_desc(rs.getString("r_desc"));
            userrole.setUr_id(rs.getInt("ur_id"));
            userrole.setUr_uid(rs.getInt("ur_uid"));
            userrole.setUr_role(rs.getInt("ur_role"));
            userrole.setUr_active_ind(rs.getBoolean("ur_active_ind"));
            userrole.setUr_org_id(rs.getInt("ur_org_id"));
            userroles.add(userrole);
        }
        return userroles;
    }
}
