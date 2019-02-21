package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.util.Date;

public class SystemUserDetails {
    private int 	u_id;
    private String  u_first_name;
    private String  u_middle_name;
    private String  u_last_name;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date    u_dob;
    private String  u_nativity;
    private String  u_nationality;
    private String  u_religion;
    private String  u_caste;
    private String  u_subcaste;
    private String  u_father_name;
    private String  u_mother_name;
    private String  u_guardian_name;
    private String  u_guardian_relation;
    private String  u_caddress;
    private String  u_clocation;
    private String  u_cstreet;
    private String  u_ccity;
    private String  u_cstate;
    private String  u_cdistrict;
    private String  u_cmandal;
    private String  u_czipcode;
    private String  u_paddress;
    private String  u_plocation;
    private String  u_pstreet;
    private String  u_pcity;
    private String  u_pstate;
    private String  u_pdistrict;
    private String  u_pmandal;
    private String  u_pzipcode;
    private String  u_pcontact_no;
    private String  u_scontact_no;
    private String  u_econtact_no;
    private String  u_mcontact_no;
    private String  u_fcontact_no;
    private String  u_gcontact_no;
    @JsonProperty
    private boolean u_active_ind;
    private String  u_email_id;
    private String  u_alt_email_id;
    private String  u_social_security_Id;
    private String  u_social_security_name;
    private String  u_suffix;
    private String  u_mother_tongue;
    private String  u_ethnic_group;
    private String  u_ethnic_designation;
    private String  u_decile_group;
    private String  u_tenure;
    private int     r_id;
    private String  r_title;
    private Boolean r_active_ind;
    private String  r_desc;
    @JsonSetter
    private byte[]  u_photo;
    private int     ur_id;
    private int     ur_role;
    @JsonProperty
    private boolean ur_active_ind;
    private BigDecimal a_id;
    private BigDecimal a_user_id;
    private String a_user_loginid;
    private String a_user_pwd;
    @JsonProperty
    private boolean a_active_ind;
    private int a_login_count;
    @JsonProperty
    private boolean a_account_status;
    private String a_user_type;
    private BigDecimal a_user_orgId;
    private Date a_last_logged_in;
    private String a_user_firstName;
    private String a_user_lastName;
    private String a_user_confirm_pwd;
    private String system;
    private int branchid;
    private int orgid;
    private String desg;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public String getU_first_name() {
        return u_first_name;
    }

    public void setU_first_name(String u_first_name) {
        this.u_first_name = u_first_name;
    }

    public String getU_middle_name() {
        return u_middle_name;
    }

    public void setU_middle_name(String u_middle_name) {
        this.u_middle_name = u_middle_name;
    }

    public String getU_last_name() {
        return u_last_name;
    }

    public void setU_last_name(String u_last_name) {
        this.u_last_name = u_last_name;
    }

    public Date getU_dob() {
        return u_dob;
    }

    public void setU_dob(Date u_dob) {
        this.u_dob = u_dob;
    }

    public String getU_nativity() {
        return u_nativity;
    }

    public void setU_nativity(String u_nativity) {
        this.u_nativity = u_nativity;
    }

    public String getU_nationality() {
        return u_nationality;
    }

    public void setU_nationality(String u_nationality) {
        this.u_nationality = u_nationality;
    }

    public String getU_religion() {
        return u_religion;
    }

    public void setU_religion(String u_religion) {
        this.u_religion = u_religion;
    }

    public String getU_caste() {
        return u_caste;
    }

    public void setU_caste(String u_caste) {
        this.u_caste = u_caste;
    }

    public String getU_subcaste() {
        return u_subcaste;
    }

    public void setU_subcaste(String u_subcaste) {
        this.u_subcaste = u_subcaste;
    }

    public String getU_father_name() {
        return u_father_name;
    }

    public void setU_father_name(String u_father_name) {
        this.u_father_name = u_father_name;
    }

    public String getU_mother_name() {
        return u_mother_name;
    }

    public void setU_mother_name(String u_mother_name) {
        this.u_mother_name = u_mother_name;
    }

    public String getU_guardian_name() {
        return u_guardian_name;
    }

    public void setU_guardian_name(String u_guardian_name) {
        this.u_guardian_name = u_guardian_name;
    }

    public String getU_guardian_relation() {
        return u_guardian_relation;
    }

    public void setU_guardian_relation(String u_guardian_relation) {
        this.u_guardian_relation = u_guardian_relation;
    }

    public String getU_caddress() {
        return u_caddress;
    }

    public void setU_caddress(String u_caddress) {
        this.u_caddress = u_caddress;
    }

    public String getU_clocation() {
        return u_clocation;
    }

    public void setU_clocation(String u_clocation) {
        this.u_clocation = u_clocation;
    }

    public String getU_cstreet() {
        return u_cstreet;
    }

    public void setU_cstreet(String u_cstreet) {
        this.u_cstreet = u_cstreet;
    }

    public String getU_ccity() {
        return u_ccity;
    }

    public void setU_ccity(String u_ccity) {
        this.u_ccity = u_ccity;
    }

    public String getU_cstate() {
        return u_cstate;
    }

    public void setU_cstate(String u_cstate) {
        this.u_cstate = u_cstate;
    }

    public String getU_cdistrict() {
        return u_cdistrict;
    }

    public void setU_cdistrict(String u_cdistrict) {
        this.u_cdistrict = u_cdistrict;
    }

    public String getU_cmandal() {
        return u_cmandal;
    }

    public void setU_cmandal(String u_cmandal) {
        this.u_cmandal = u_cmandal;
    }

    public String getU_czipcode() {
        return u_czipcode;
    }

    public void setU_czipcode(String u_czipcode) {
        this.u_czipcode = u_czipcode;
    }

    public String getU_paddress() {
        return u_paddress;
    }

    public void setU_paddress(String u_paddress) {
        this.u_paddress = u_paddress;
    }

    public String getU_plocation() {
        return u_plocation;
    }

    public void setU_plocation(String u_plocation) {
        this.u_plocation = u_plocation;
    }

    public String getU_pstreet() {
        return u_pstreet;
    }

    public void setU_pstreet(String u_pstreet) {
        this.u_pstreet = u_pstreet;
    }

    public String getU_pcity() {
        return u_pcity;
    }

    public void setU_pcity(String u_pcity) {
        this.u_pcity = u_pcity;
    }

    public String getU_pstate() {
        return u_pstate;
    }

    public void setU_pstate(String u_pstate) {
        this.u_pstate = u_pstate;
    }

    public String getU_pdistrict() {
        return u_pdistrict;
    }

    public void setU_pdistrict(String u_pdistrict) {
        this.u_pdistrict = u_pdistrict;
    }

    public String getU_pmandal() {
        return u_pmandal;
    }

    public void setU_pmandal(String u_pmandal) {
        this.u_pmandal = u_pmandal;
    }

    public String getU_pzipcode() {
        return u_pzipcode;
    }

    public void setU_pzipcode(String u_pzipcode) {
        this.u_pzipcode = u_pzipcode;
    }

    public String getU_pcontact_no() {
        return u_pcontact_no;
    }

    public void setU_pcontact_no(String u_pcontact_no) {
        this.u_pcontact_no = u_pcontact_no;
    }

    public String getU_scontact_no() {
        return u_scontact_no;
    }

    public void setU_scontact_no(String u_scontact_no) {
        this.u_scontact_no = u_scontact_no;
    }

    public String getU_econtact_no() {
        return u_econtact_no;
    }

    public void setU_econtact_no(String u_econtact_no) {
        this.u_econtact_no = u_econtact_no;
    }

    public String getU_mcontact_no() {
        return u_mcontact_no;
    }

    public void setU_mcontact_no(String u_mcontact_no) {
        this.u_mcontact_no = u_mcontact_no;
    }

    public String getU_fcontact_no() {
        return u_fcontact_no;
    }

    public void setU_fcontact_no(String u_fcontact_no) {
        this.u_fcontact_no = u_fcontact_no;
    }

    public String getU_gcontact_no() {
        return u_gcontact_no;
    }

    public void setU_gcontact_no(String u_gcontact_no) {
        this.u_gcontact_no = u_gcontact_no;
    }

    public boolean isU_active_ind() {
        return u_active_ind;
    }

    public void setU_active_ind(boolean u_active_ind) {
        this.u_active_ind = u_active_ind;
    }

    public String getU_email_id() {
        return u_email_id;
    }

    public void setU_email_id(String u_email_id) {
        this.u_email_id = u_email_id;
    }

    public String getU_alt_email_id() {
        return u_alt_email_id;
    }

    public void setU_alt_email_id(String u_alt_email_id) {
        this.u_alt_email_id = u_alt_email_id;
    }

    public String getU_social_security_Id() {
        return u_social_security_Id;
    }

    public void setU_social_security_Id(String u_social_security_Id) {
        this.u_social_security_Id = u_social_security_Id;
    }

    public String getU_social_security_name() {
        return u_social_security_name;
    }

    public void setU_social_security_name(String u_social_security_name) {
        this.u_social_security_name = u_social_security_name;
    }

    public String getU_suffix() {
        return u_suffix;
    }

    public void setU_suffix(String u_suffix) {
        this.u_suffix = u_suffix;
    }

    public String getU_mother_tongue() {
        return u_mother_tongue;
    }

    public void setU_mother_tongue(String u_mother_tongue) {
        this.u_mother_tongue = u_mother_tongue;
    }

    public String getU_ethnic_group() {
        return u_ethnic_group;
    }

    public void setU_ethnic_group(String u_ethnic_group) {
        this.u_ethnic_group = u_ethnic_group;
    }

    public String getU_ethnic_designation() {
        return u_ethnic_designation;
    }

    public void setU_ethnic_designation(String u_ethnic_designation) {
        this.u_ethnic_designation = u_ethnic_designation;
    }

    public String getU_decile_group() {
        return u_decile_group;
    }

    public void setU_decile_group(String u_decile_group) {
        this.u_decile_group = u_decile_group;
    }

    public String getU_tenure() {
        return u_tenure;
    }

    public void setU_tenure(String u_tenure) {
        this.u_tenure = u_tenure;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public Boolean getR_active_ind() {
        return r_active_ind;
    }

    public void setR_active_ind(Boolean r_active_ind) {
        this.r_active_ind = r_active_ind;
    }

    public String getR_desc() {
        return r_desc;
    }

    public void setR_desc(String r_desc) {
        this.r_desc = r_desc;
    }

    public byte[] getU_photo() {
        return u_photo;
    }

    public void setU_photo(byte[] u_photo) {
        this.u_photo = u_photo;
    }

    public int getUr_id() {
        return ur_id;
    }

    public void setUr_id(int ur_id) {
        this.ur_id = ur_id;
    }

    public int getUr_role() {
        return ur_role;
    }

    public void setUr_role(int ur_role) {
        this.ur_role = ur_role;
    }

    public boolean isUr_active_ind() {
        return ur_active_ind;
    }

    public void setUr_active_ind(boolean ur_active_ind) {
        this.ur_active_ind = ur_active_ind;
    }

    public BigDecimal getA_id() {
        return a_id;
    }

    public void setA_id(BigDecimal a_id) {
        this.a_id = a_id;
    }

    public BigDecimal getA_user_id() {
        return a_user_id;
    }

    public void setA_user_id(BigDecimal a_user_id) {
        this.a_user_id = a_user_id;
    }

    public String getA_user_loginid() {
        return a_user_loginid;
    }

    public void setA_user_loginid(String a_user_loginid) {
        this.a_user_loginid = a_user_loginid;
    }

    public String getA_user_pwd() {
        return a_user_pwd;
    }

    public void setA_user_pwd(String a_user_pwd) {
        this.a_user_pwd = a_user_pwd;
    }

    public boolean isA_active_ind() {
        return a_active_ind;
    }

    public void setA_active_ind(boolean a_active_ind) {
        this.a_active_ind = a_active_ind;
    }

    public int getA_login_count() {
        return a_login_count;
    }

    public void setA_login_count(int a_login_count) {
        this.a_login_count = a_login_count;
    }

    public boolean isA_account_status() {
        return a_account_status;
    }

    public void setA_account_status(boolean a_account_status) {
        this.a_account_status = a_account_status;
    }

    public String getA_user_type() {
        return a_user_type;
    }

    public void setA_user_type(String a_user_type) {
        this.a_user_type = a_user_type;
    }

    public BigDecimal getA_user_orgId() {
        return a_user_orgId;
    }

    public void setA_user_orgId(BigDecimal a_user_orgId) {
        this.a_user_orgId = a_user_orgId;
    }

    public Date getA_last_logged_in() {
        return a_last_logged_in;
    }

    public void setA_last_logged_in(Date a_last_logged_in) {
        this.a_last_logged_in = a_last_logged_in;
    }

    public String getA_user_firstName() {
        return a_user_firstName;
    }

    public void setA_user_firstName(String a_user_firstName) {
        this.a_user_firstName = a_user_firstName;
    }

    public String getA_user_lastName() {
        return a_user_lastName;
    }

    public void setA_user_lastName(String a_user_lastName) {
        this.a_user_lastName = a_user_lastName;
    }


    public String getA_user_confirm_pwd() {
        return a_user_confirm_pwd;
    }

    public void setA_user_confirm_pwd(String a_user_confirm_pwd) {
        this.a_user_confirm_pwd = a_user_confirm_pwd;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public int getBranchid() {
        return branchid;
    }

    public void setBranchid(int branchid) {
        this.branchid = branchid;
    }

    public int getOrgid() {
        return orgid;
    }

    public void setOrgid(int orgid) {
        this.orgid = orgid;
    }

    public String getDesg() {
        return desg;
    }

    public void setDesg(String desg) {
        this.desg = desg;
    }
}
