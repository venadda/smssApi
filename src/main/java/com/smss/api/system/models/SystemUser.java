package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class SystemUser {
    private int 	u_id;
  //  private int 	u_org_id;
    private String u_first_name;
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
    private boolean  u_active_ind;
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

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    /*public int getU_org_id() {
        return u_org_id;
    }

    public void setU_org_id(int u_org_id) {
        this.u_org_id = u_org_id;
    }*/

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

    @Override
    public String toString() {
        return "SystemUser{" +
                "u_id=" + u_id +
                ", u_first_name='" + u_first_name + '\'' +
                ", u_middle_name='" + u_middle_name + '\'' +
                ", u_last_name='" + u_last_name + '\'' +
                ", u_dob=" + u_dob +
                ", u_nativity='" + u_nativity + '\'' +
                ", u_nationality='" + u_nationality + '\'' +
                ", u_religion='" + u_religion + '\'' +
                ", u_caste='" + u_caste + '\'' +
                ", u_subcaste='" + u_subcaste + '\'' +
                ", u_father_name='" + u_father_name + '\'' +
                ", u_mother_name='" + u_mother_name + '\'' +
                ", u_guardian_name='" + u_guardian_name + '\'' +
                ", u_guardian_relation='" + u_guardian_relation + '\'' +
                ", u_caddress='" + u_caddress + '\'' +
                ", u_clocation='" + u_clocation + '\'' +
                ", u_cstreet='" + u_cstreet + '\'' +
                ", u_ccity='" + u_ccity + '\'' +
                ", u_cstate='" + u_cstate + '\'' +
                ", u_cdistrict='" + u_cdistrict + '\'' +
                ", u_cmandal='" + u_cmandal + '\'' +
                ", u_czipcode='" + u_czipcode + '\'' +
                ", u_paddress='" + u_paddress + '\'' +
                ", u_plocation='" + u_plocation + '\'' +
                ", u_pstreet='" + u_pstreet + '\'' +
                ", u_pcity='" + u_pcity + '\'' +
                ", u_pstate='" + u_pstate + '\'' +
                ", u_pdistrict='" + u_pdistrict + '\'' +
                ", u_pmandal='" + u_pmandal + '\'' +
                ", u_pzipcode='" + u_pzipcode + '\'' +
                ", u_pcontact_no='" + u_pcontact_no + '\'' +
                ", u_scontact_no='" + u_scontact_no + '\'' +
                ", u_econtact_no='" + u_econtact_no + '\'' +
                ", u_mcontact_no='" + u_mcontact_no + '\'' +
                ", u_fcontact_no='" + u_fcontact_no + '\'' +
                ", u_gcontact_no='" + u_gcontact_no + '\'' +
                ", u_active_ind=" + u_active_ind +
                ", u_email_id='" + u_email_id + '\'' +
                ", u_alt_email_id='" + u_alt_email_id + '\'' +
                ", u_social_security_Id='" + u_social_security_Id + '\'' +
                ", u_social_security_name='" + u_social_security_name + '\'' +
                ", u_suffix='" + u_suffix + '\'' +
                ", u_mother_tongue='" + u_mother_tongue + '\'' +
                ", u_ethnic_group='" + u_ethnic_group + '\'' +
                ", u_ethnic_designation='" + u_ethnic_designation + '\'' +
                ", u_decile_group='" + u_decile_group + '\'' +
                ", u_tenure='" + u_tenure + '\'' +
                '}';
    }
}
