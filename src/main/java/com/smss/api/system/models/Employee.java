package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Arrays;
import java.util.Date;

public class Employee {
    private int     u_id;
    private int     u_org_id;
    private String  u_first_name;
    private String  u_middle_name;
    private String  u_last_name;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date    u_dob;
    private String  u_gender;
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
    private String  u_refno;
    private String  u_mother_tongue;
    private String  u_ethnic_group;
    private String  u_ethnic_designation;
    private String  u_decile_group;
    private String  u_tenure;
    private int     u_branchid;
    @JsonSetter
    private byte[]  u_photo;
    private String  u_desg;
    private int u_role;
    private String u_designation;
    @JsonProperty
    private boolean ur_active_ind;

    private String u_height;
    private String u_weight;
    private String u_blood_group;
    @JsonProperty
    private boolean u_disease;
    @JsonProperty
    private boolean u_formal_soldier;
    @JsonProperty
    private boolean u_handicap;
    private String u_panno;
    private String u_pfuid;
    @JsonProperty
    private boolean u_certificate;
    private String u_cert_name;
    private String u_cert_grade;
    private String u_cert_type;
    @JsonProperty
    private boolean u_bestTeacher;
    private String u_btdesc;

    private boolean u_achievement;
    private boolean u_marital_status;
    private String u_spouse_name;
    private String u_spouse_contact_no;
    private boolean u_spouse_working;
    private int u_children;
    private int u_child_sons;
    private int u_child_girls;
    private String u_f_ref_name;
    private String u_f_ref_contact_no;
    private String u_f_ref_address;
    private String u_f_ref_desc;
    private String u_f_ref_aadharno;
    private String u_s_ref_name;
    private String u_s_ref_contact_no;
    private String u_s_ref_address;
    private String u_s_ref_desc;
    private String u_s_ref_aadharno;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getU_org_id() {
        return u_org_id;
    }

    public void setU_org_id(int u_org_id) {
        this.u_org_id = u_org_id;
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

    public String getU_gender() {
        return u_gender;
    }

    public void setU_gender(String u_gender) {
        this.u_gender = u_gender;
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

    public String getU_refno() {
        return u_refno;
    }

    public void setU_refno(String u_refno) {
        this.u_refno = u_refno;
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

    public int getU_branchid() {
        return u_branchid;
    }

    public void setU_branchid(int u_branchid) {
        this.u_branchid = u_branchid;
    }

    public byte[] getU_photo() {
        return u_photo;
    }

    public void setU_photo(byte[] u_photo) {
        this.u_photo = u_photo;
    }

    public String getU_desg() {
        return u_desg;
    }

    public void setU_desg(String u_desg) {
        this.u_desg = u_desg;
    }

    public int getU_role() {
        return u_role;
    }

    public void setU_role(int u_role) {
        this.u_role = u_role;
    }

    public String getU_designation() {
        return u_designation;
    }

    public void setU_designation(String u_designation) {
        this.u_designation = u_designation;
    }

    public boolean isUr_active_ind() {
        return ur_active_ind;
    }

    public void setUr_active_ind(boolean ur_active_ind) {
        this.ur_active_ind = ur_active_ind;
    }

    public String getU_height() {
        return u_height;
    }

    public void setU_height(String u_height) {
        this.u_height = u_height;
    }

    public String getU_weight() {
        return u_weight;
    }

    public void setU_weight(String u_weight) {
        this.u_weight = u_weight;
    }

    public String getU_blood_group() {
        return u_blood_group;
    }

    public void setU_blood_group(String u_blood_group) {
        this.u_blood_group = u_blood_group;
    }

    public boolean isU_disease() {
        return u_disease;
    }

    public void setU_disease(boolean u_disease) {
        this.u_disease = u_disease;
    }

    public boolean isU_formal_soldier() {
        return u_formal_soldier;
    }

    public void setU_formal_soldier(boolean u_formal_soldier) {
        this.u_formal_soldier = u_formal_soldier;
    }

    public boolean isU_handicap() {
        return u_handicap;
    }

    public void setU_handicap(boolean u_handicap) {
        this.u_handicap = u_handicap;
    }

    public String getU_panno() {
        return u_panno;
    }

    public void setU_panno(String u_panno) {
        this.u_panno = u_panno;
    }

    public String getU_pfuid() {
        return u_pfuid;
    }

    public void setU_pfuid(String u_pfuid) {
        this.u_pfuid = u_pfuid;
    }

    public boolean isU_certificate() {
        return u_certificate;
    }

    public void setU_certificate(boolean u_certificate) {
        this.u_certificate = u_certificate;
    }

    public String getU_cert_name() {
        return u_cert_name;
    }

    public void setU_cert_name(String u_cert_name) {
        this.u_cert_name = u_cert_name;
    }

    public String getU_cert_grade() {
        return u_cert_grade;
    }

    public void setU_cert_grade(String u_cert_grade) {
        this.u_cert_grade = u_cert_grade;
    }

    public String getU_cert_type() {
        return u_cert_type;
    }

    public void setU_cert_type(String u_cert_type) {
        this.u_cert_type = u_cert_type;
    }

    public boolean isU_bestTeacher() {
        return u_bestTeacher;
    }

    public void setU_bestTeacher(boolean u_bestTeacher) {
        this.u_bestTeacher = u_bestTeacher;
    }

    public String getU_btdesc() {
        return u_btdesc;
    }

    public void setU_btdesc(String u_btdesc) {
        this.u_btdesc = u_btdesc;
    }

    public boolean isU_achievement() {
        return u_achievement;
    }

    public void setU_achievement(boolean u_achievement) {
        this.u_achievement = u_achievement;
    }

    public boolean isU_marital_status() {
        return u_marital_status;
    }

    public void setU_marital_status(boolean u_marital_status) {
        this.u_marital_status = u_marital_status;
    }

    public String getU_spouse_name() {
        return u_spouse_name;
    }

    public void setU_spouse_name(String u_spouse_name) {
        this.u_spouse_name = u_spouse_name;
    }

    public String getU_spouse_contact_no() {
        return u_spouse_contact_no;
    }

    public void setU_spouse_contact_no(String u_spouse_contact_no) {
        this.u_spouse_contact_no = u_spouse_contact_no;
    }

    public boolean isU_spouse_working() {
        return u_spouse_working;
    }

    public void setU_spouse_working(boolean u_spouse_working) {
        this.u_spouse_working = u_spouse_working;
    }

    public int getU_children() {
        return u_children;
    }

    public void setU_children(int u_children) {
        this.u_children = u_children;
    }

    public int getU_child_sons() {
        return u_child_sons;
    }

    public void setU_child_sons(int u_child_sons) {
        this.u_child_sons = u_child_sons;
    }

    public int getU_child_girls() {
        return u_child_girls;
    }

    public void setU_child_girls(int u_child_girls) {
        this.u_child_girls = u_child_girls;
    }

    public String getU_f_ref_name() {
        return u_f_ref_name;
    }

    public void setU_f_ref_name(String u_f_ref_name) {
        this.u_f_ref_name = u_f_ref_name;
    }

    public String getU_f_ref_contact_no() {
        return u_f_ref_contact_no;
    }

    public void setU_f_ref_contact_no(String u_f_ref_contact_no) {
        this.u_f_ref_contact_no = u_f_ref_contact_no;
    }

    public String getU_f_ref_address() {
        return u_f_ref_address;
    }

    public void setU_f_ref_address(String u_f_ref_address) {
        this.u_f_ref_address = u_f_ref_address;
    }

    public String getU_f_ref_desc() {
        return u_f_ref_desc;
    }

    public void setU_f_ref_desc(String u_f_ref_desc) {
        this.u_f_ref_desc = u_f_ref_desc;
    }

    public String getU_f_ref_aadharno() {
        return u_f_ref_aadharno;
    }

    public void setU_f_ref_aadharno(String u_f_ref_aadharno) {
        this.u_f_ref_aadharno = u_f_ref_aadharno;
    }

    public String getU_s_ref_name() {
        return u_s_ref_name;
    }

    public void setU_s_ref_name(String u_s_ref_name) {
        this.u_s_ref_name = u_s_ref_name;
    }

    public String getU_s_ref_contact_no() {
        return u_s_ref_contact_no;
    }

    public void setU_s_ref_contact_no(String u_s_ref_contact_no) {
        this.u_s_ref_contact_no = u_s_ref_contact_no;
    }

    public String getU_s_ref_address() {
        return u_s_ref_address;
    }

    public void setU_s_ref_address(String u_s_ref_address) {
        this.u_s_ref_address = u_s_ref_address;
    }

    public String getU_s_ref_desc() {
        return u_s_ref_desc;
    }

    public void setU_s_ref_desc(String u_s_ref_desc) {
        this.u_s_ref_desc = u_s_ref_desc;
    }

    public String getU_s_ref_aadharno() {
        return u_s_ref_aadharno;
    }

    public void setU_s_ref_aadharno(String u_s_ref_aadharno) {
        this.u_s_ref_aadharno = u_s_ref_aadharno;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "u_id=" + u_id +
                ", u_org_id=" + u_org_id +
                ", u_first_name='" + u_first_name + '\'' +
                ", u_middle_name='" + u_middle_name + '\'' +
                ", u_last_name='" + u_last_name + '\'' +
                ", u_dob=" + u_dob +
                ", u_gender='" + u_gender + '\'' +
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
                ", u_refno='" + u_refno + '\'' +
                ", u_mother_tongue='" + u_mother_tongue + '\'' +
                ", u_ethnic_group='" + u_ethnic_group + '\'' +
                ", u_ethnic_designation='" + u_ethnic_designation + '\'' +
                ", u_decile_group='" + u_decile_group + '\'' +
                ", u_tenure='" + u_tenure + '\'' +
                ", u_branchid=" + u_branchid +
                ", u_photo=" + Arrays.toString(u_photo) +
                ", u_desg='" + u_desg + '\'' +
                ", u_role=" + u_role +
                ", u_designation='" + u_designation + '\'' +
                ", ur_active_ind=" + ur_active_ind +
                '}';
    }
}
