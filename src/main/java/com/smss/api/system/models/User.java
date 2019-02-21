package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class User {
    private BigDecimal u_userId;
    private BigDecimal u_userOrgId;
    private String u_first_Name;
    private String u_middle_Name;
    private String u_last_Name;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_dob;
    private String u_nativity;
    private String u_nationality;
    private String u_religion;
    private String u_caste;
    private String u_subcaste;
    private String u_father_Name;
    private String u_mother_Name;
    private String u_guardian_Name;
    private String u_guardian_Relation;
    private String u_paddress;
    private String u_plocation;
    private String u_pstreet;
    private String u_pcity;
    private String u_pstate;
    private String u_pdistrict;
    private String u_pmandal;
    private String u_pzipcode;
    private String u_caddress;
    private String u_clocation;
    private String u_cstreet;
    private String u_ccity;
    private String u_cstate;
    private String u_cdistrict;
    private String u_cmandal;
    private String u_czipcode;
    private String u_pcontactno;
    private String u_scontactno;
    private String u_econtactno;
    private String u_fcontactno;
    private String u_mcontactno;
    private String u_gcontactno;
    @JsonProperty
    private boolean u_active_ind;
    private String u_email_id;
    private String u_alt_email_id;
    private String u_social_security_id;
    private String u_social_security_name;
    private String u_suffix;

    public User() {
    }

    public BigDecimal getU_userId() {
        return u_userId;
    }

    public void setU_userId(BigDecimal u_userId) {
        this.u_userId = u_userId;
    }

    public BigDecimal getU_userOrgId() {
        return u_userOrgId;
    }

    public void setU_userOrgId(BigDecimal u_userOrgId) {
        this.u_userOrgId = u_userOrgId;
    }

    public String getU_first_Name() {
        return u_first_Name;
    }

    public void setU_first_Name(String u_first_Name) {
        this.u_first_Name = u_first_Name;
    }

    public String getU_middle_Name() {
        return u_middle_Name;
    }

    public void setU_middle_Name(String u_middle_Name) {
        this.u_middle_Name = u_middle_Name;
    }

    public String getU_last_Name() {
        return u_last_Name;
    }

    public void setU_last_Name(String u_last_Name) {
        this.u_last_Name = u_last_Name;
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

    public String getU_father_Name() {
        return u_father_Name;
    }

    public void setU_father_Name(String u_father_Name) {
        this.u_father_Name = u_father_Name;
    }

    public String getU_mother_Name() {
        return u_mother_Name;
    }

    public void setU_mother_Name(String u_mother_Name) {
        this.u_mother_Name = u_mother_Name;
    }

    public String getU_guardian_Name() {
        return u_guardian_Name;
    }

    public void setU_guardian_Name(String u_guardian_Name) {
        this.u_guardian_Name = u_guardian_Name;
    }

    public String getU_guardian_Relation() {
        return u_guardian_Relation;
    }

    public void setU_guardian_Relation(String u_guardian_Relation) {
        this.u_guardian_Relation = u_guardian_Relation;
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

    public String getU_pcontactno() {
        return u_pcontactno;
    }

    public void setU_pcontactno(String u_pcontactno) {
        this.u_pcontactno = u_pcontactno;
    }

    public String getU_scontactno() {
        return u_scontactno;
    }

    public void setU_scontactno(String u_scontactno) {
        this.u_scontactno = u_scontactno;
    }

    public String getU_econtactno() {
        return u_econtactno;
    }

    public void setU_econtactno(String u_econtactno) {
        this.u_econtactno = u_econtactno;
    }

    public String getU_fcontactno() {
        return u_fcontactno;
    }

    public void setU_fcontactno(String u_fcontactno) {
        this.u_fcontactno = u_fcontactno;
    }

    public String getU_mcontactno() {
        return u_mcontactno;
    }

    public void setU_mcontactno(String u_mcontactno) {
        this.u_mcontactno = u_mcontactno;
    }

    public String getU_gcontactno() {
        return u_gcontactno;
    }

    public void setU_gcontactno(String u_gcontactno) {
        this.u_gcontactno = u_gcontactno;
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

    public String getU_social_security_id() {
        return u_social_security_id;
    }

    public void setU_social_security_id(String u_social_security_id) {
        this.u_social_security_id = u_social_security_id;
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

    @Override
    public String toString() {
        return "PUser{" +
                "u_userId=" + u_userId +
                ", u_userOrgId=" + u_userOrgId +
                ", u_first_Name='" + u_first_Name + '\'' +
                ", u_middle_Name='" + u_middle_Name + '\'' +
                ", u_last_Name='" + u_last_Name + '\'' +
                ", u_dob=" + u_dob +
                ", u_nativity='" + u_nativity + '\'' +
                ", u_nationality='" + u_nationality + '\'' +
                ", u_religion='" + u_religion + '\'' +
                ", u_caste='" + u_caste + '\'' +
                ", u_subcaste='" + u_subcaste + '\'' +
                ", u_father_Name='" + u_father_Name + '\'' +
                ", u_mother_Name='" + u_mother_Name + '\'' +
                ", u_guardian_Name='" + u_guardian_Name + '\'' +
                ", u_guardian_Relation='" + u_guardian_Relation + '\'' +
                ", u_paddress='" + u_paddress + '\'' +
                ", u_plocation='" + u_plocation + '\'' +
                ", u_pstreet='" + u_pstreet + '\'' +
                ", u_pcity='" + u_pcity + '\'' +
                ", u_pstate='" + u_pstate + '\'' +
                ", u_pdistrict='" + u_pdistrict + '\'' +
                ", u_pmandal='" + u_pmandal + '\'' +
                ", u_pzipcode='" + u_pzipcode + '\'' +
                ", u_caddress='" + u_caddress + '\'' +
                ", u_clocation='" + u_clocation + '\'' +
                ", u_cstreet='" + u_cstreet + '\'' +
                ", u_ccity='" + u_ccity + '\'' +
                ", u_cstate='" + u_cstate + '\'' +
                ", u_cdistrict='" + u_cdistrict + '\'' +
                ", u_cmandal='" + u_cmandal + '\'' +
                ", u_czipcode='" + u_czipcode + '\'' +
                ", u_pcontactno='" + u_pcontactno + '\'' +
                ", u_scontactno='" + u_scontactno + '\'' +
                ", u_econtactno='" + u_econtactno + '\'' +
                ", u_fcontactno='" + u_fcontactno + '\'' +
                ", u_mcontactno='" + u_mcontactno + '\'' +
                ", u_gcontactno='" + u_gcontactno + '\'' +
                ", u_active_ind=" + u_active_ind +
                '}';
    }
}
