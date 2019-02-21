package com.smss.api.system.mapper;

import com.smss.api.system.models.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MUser implements RowMapper {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setU_userId(rs.getBigDecimal("u_userId"));
        user.setU_userOrgId(rs.getBigDecimal("u_userOrgId"));
        user.setU_first_Name(rs.getString("u_first_Name"));
        user.setU_middle_Name(rs.getString("u_middle_Name"));
        user.setU_last_Name(rs.getString("u_last_Name"));
        user.setU_dob(rs.getDate("u_dob"));
        user.setU_nativity(rs.getString("u_nativity"));
        user.setU_nationality(rs.getString("u_nationality"));
        user.setU_religion(rs.getString("u_religion"));
        user.setU_caste(rs.getString("u_caste"));
        user.setU_subcaste(rs.getString("u_subcaste"));
        user.setU_father_Name(rs.getString("u_father_Name"));
        user.setU_mother_Name(rs.getString("u_mother_Name"));
        user.setU_guardian_Name(rs.getString("u_guardian_Name"));
        user.setU_guardian_Relation(rs.getString("u_guardian_Relation"));
        user.setU_paddress(rs.getString("u_paddress"));
        user.setU_plocation(rs.getString("u_plocation"));
        user.setU_pstreet(rs.getString("u_pstreet"));
        user.setU_pcity(rs.getString("u_pcity"));
        user.setU_pstate(rs.getString("u_pstate"));
        user.setU_pdistrict(rs.getString("u_pdistrict"));
        user.setU_pmandal(rs.getString("u_pmandal"));
        user.setU_pzipcode(rs.getString("u_pzipcode"));
        user.setU_caddress(rs.getString("u_caddress"));
        user.setU_clocation(rs.getString("u_clocation"));
        user.setU_cstreet(rs.getString("u_cstreet"));
        user.setU_ccity(rs.getString("u_ccity"));
        user.setU_cstate(rs.getString("u_cstate"));
        user.setU_cdistrict(rs.getString("u_cdistrict"));
        user.setU_cmandal(rs.getString("u_cmandal"));
        user.setU_czipcode(rs.getString("u_czipcode"));
        user.setU_pcontactno(rs.getString("u_pcontactno"));
        user.setU_scontactno(rs.getString("u_scontactno"));
        user.setU_econtactno(rs.getString("u_econtactno"));
        user.setU_fcontactno(rs.getString("u_fcontactno"));
        user.setU_mcontactno(rs.getString("u_mcontactno"));
        user.setU_gcontactno(rs.getString("u_gcontactno"));
        user.setU_active_ind(rs.getBoolean("u_active_ind"));
        user.setU_email_id(rs.getString("u_email_id"));
        user.setU_alt_email_id(rs.getString("u_alt_email_id"));
        user.setU_social_security_id(rs.getString("u_social_security_id"));
        user.setU_social_security_name(rs.getString("u_social_security_name"));
        user.setU_suffix(rs.getString("u_suffix"));


        return user;
    }
}
