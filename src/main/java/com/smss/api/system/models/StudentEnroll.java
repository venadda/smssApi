package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class StudentEnroll {

    private BigDecimal s_id;
    private BigDecimal s_orgId;
    private BigDecimal s_bid;
    private String s_first_name;
    private String s_middle_name;
    private String s_last_name;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date s_dob;
    private String s_nativity;
    private String s_nationality;
    private String s_religion;
    private String s_caste;
    private String s_subcaste;
    private String s_father_name;
    private String s_mother_name;
    private String s_guadian_name;
    private String s_guadian_relationship;
    private String s_address;
    private String s_location;
    private String s_street;
    private String s_city;
    private String s_state;
    private String s_country;
    private String s_zipcode;
    private String s_mandal;
    private String s_district;
    private String s_pcontactno;
    private String s_scontactno;
    private String s_gender;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date s_created_date;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date s_date_enrolled;
    private String s_applied_for;
    private String s_status_of_application;
    private BigDecimal s_processed_By;
    private BigDecimal s_approved_by;
    private String s_remark;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date s_updated_date;
    @JsonProperty
    private boolean s_active_ind;
    private BigDecimal s_updated_by;

    public StudentEnroll() {
    }

    public BigDecimal getS_id() {
        return s_id;
    }

    public void setS_id(BigDecimal s_id) {
        this.s_id = s_id;
    }

    public BigDecimal getS_orgId() {
        return s_orgId;
    }

    public void setS_orgId(BigDecimal s_orgId) {
        this.s_orgId = s_orgId;
    }

    public String getS_first_name() {
        return s_first_name;
    }

    public void setS_first_name(String s_first_name) {
        this.s_first_name = s_first_name;
    }

    public String getS_middle_name() {
        return s_middle_name;
    }

    public void setS_middle_name(String s_middle_name) {
        this.s_middle_name = s_middle_name;
    }

    public String getS_last_name() {
        return s_last_name;
    }

    public void setS_last_name(String s_last_name) {
        this.s_last_name = s_last_name;
    }

    public Date getS_dob() {
        return s_dob;
    }

    public void setS_dob(Date s_dob) {
        this.s_dob = s_dob;
    }

    public String getS_nativity() {
        return s_nativity;
    }

    public void setS_nativity(String s_nativity) {
        this.s_nativity = s_nativity;
    }

    public String getS_nationality() {
        return s_nationality;
    }

    public void setS_nationality(String s_nationality) {
        this.s_nationality = s_nationality;
    }

    public String getS_religion() {
        return s_religion;
    }

    public void setS_religion(String s_religion) {
        this.s_religion = s_religion;
    }

    public String getS_caste() {
        return s_caste;
    }

    public void setS_caste(String s_caste) {
        this.s_caste = s_caste;
    }

    public String getS_subcaste() {
        return s_subcaste;
    }

    public void setS_subcaste(String s_subcaste) {
        this.s_subcaste = s_subcaste;
    }

    public String getS_father_name() {
        return s_father_name;
    }

    public void setS_father_name(String s_father_name) {
        this.s_father_name = s_father_name;
    }

    public String getS_mother_name() {
        return s_mother_name;
    }

    public void setS_mother_name(String s_mother_name) {
        this.s_mother_name = s_mother_name;
    }

    public String getS_guadian_name() {
        return s_guadian_name;
    }

    public void setS_guadian_name(String s_guadian_name) {
        this.s_guadian_name = s_guadian_name;
    }

    public String getS_guadian_relationship() {
        return s_guadian_relationship;
    }

    public void setS_guadian_relationship(String s_guadian_relationship) {
        this.s_guadian_relationship = s_guadian_relationship;
    }

    public String getS_address() {
        return s_address;
    }

    public void setS_address(String s_address) {
        this.s_address = s_address;
    }

    public String getS_location() {
        return s_location;
    }

    public void setS_location(String s_location) {
        this.s_location = s_location;
    }

    public String getS_street() {
        return s_street;
    }

    public void setS_street(String s_street) {
        this.s_street = s_street;
    }

    public String getS_city() {
        return s_city;
    }

    public void setS_city(String s_city) {
        this.s_city = s_city;
    }

    public String getS_state() {
        return s_state;
    }

    public void setS_state(String s_state) {
        this.s_state = s_state;
    }

    public String getS_country() {
        return s_country;
    }

    public void setS_country(String s_country) {
        this.s_country = s_country;
    }

    public String getS_zipcode() {
        return s_zipcode;
    }

    public void setS_zipcode(String s_zipcode) {
        this.s_zipcode = s_zipcode;
    }

    public String getS_mandal() {
        return s_mandal;
    }

    public void setS_mandal(String s_mandal) {
        this.s_mandal = s_mandal;
    }

    public String getS_district() {
        return s_district;
    }

    public void setS_district(String s_district) {
        this.s_district = s_district;
    }

    public String getS_pcontactno() {
        return s_pcontactno;
    }

    public void setS_pcontactno(String s_pcontactno) {
        this.s_pcontactno = s_pcontactno;
    }

    public String getS_scontactno() {
        return s_scontactno;
    }

    public void setS_scontactno(String s_scontactno) {
        this.s_scontactno = s_scontactno;
    }

    public String getS_gender() {
        return s_gender;
    }

    public void setS_gender(String s_gender) {
        this.s_gender = s_gender;
    }

    public Date getS_created_date() {
        return s_created_date;
    }

    public void setS_created_date(Date s_created_date) {
        this.s_created_date = s_created_date;
    }

    public Date getS_date_enrolled() {
        return s_date_enrolled;
    }

    public void setS_date_enrolled(Date s_date_enrolled) {
        this.s_date_enrolled = s_date_enrolled;
    }

    public String getS_applied_for() {
        return s_applied_for;
    }

    public void setS_applied_for(String s_applied_for) {
        this.s_applied_for = s_applied_for;
    }

    public String getS_status_of_application() {
        return s_status_of_application;
    }

    public void setS_status_of_application(String s_status_of_application) {
        this.s_status_of_application = s_status_of_application;
    }

    public BigDecimal getS_processed_By() {
        return s_processed_By;
    }

    public void setS_processed_By(BigDecimal s_processed_By) {
        this.s_processed_By = s_processed_By;
    }

    public BigDecimal getS_approved_by() {
        return s_approved_by;
    }

    public void setS_approved_by(BigDecimal s_approved_by) {
        this.s_approved_by = s_approved_by;
    }

    public String getS_remark() {
        return s_remark;
    }

    public void setS_remark(String s_remark) {
        this.s_remark = s_remark;
    }

    public Date getS_updated_date() {
        return s_updated_date;
    }

    public void setS_updated_date(Date s_updated_date) {
        this.s_updated_date = s_updated_date;
    }

    public boolean isS_active_ind() {
        return s_active_ind;
    }

    public void setS_active_ind(boolean s_active_ind) {
        this.s_active_ind = s_active_ind;
    }

    public BigDecimal getS_updated_by() {
        return s_updated_by;
    }

    public void setS_updated_by(BigDecimal s_updated_by) {
        this.s_updated_by = s_updated_by;
    }

    public BigDecimal getS_bid() {
        return s_bid;
    }

    public void setS_bid(BigDecimal s_bid) {
        this.s_bid = s_bid;
    }
}
