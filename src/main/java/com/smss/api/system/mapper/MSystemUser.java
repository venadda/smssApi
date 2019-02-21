package com.smss.api.system.mapper;

import com.smss.api.system.models.SystemUser;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MSystemUser implements ResultSetExtractor<List<SystemUser>> {




    @Override
    public List<SystemUser> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<SystemUser> users = new ArrayList<SystemUser>();
        while(rs.next()) {
            SystemUser user = new SystemUser();
            user.setU_active_ind(rs.getBoolean("activeind"));
            user.setU_id(rs.getInt("uid"));
          //  user.setU_org_id(rs.getInt("orgid"));
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
            user.setU_pcontact_no(rs.getString("pcontatcno"));
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
            user.setU_decile_group(rs.getString("dcilegroup"));
            user.setU_tenure(rs.getString("tenure"));
            users.add(user);
        }
        return users;
    }
}
