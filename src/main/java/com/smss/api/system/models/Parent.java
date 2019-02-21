package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Parent {
    private int p_id;
    private String p_father_name;
    private String p_mother_name;
    private String p_guardian_name;
    private String p_email_id;
    private String p_father_contactno;
    private String p_mother_contactno;
    private String p_guardian_contactno;
    private String p_address;
    private String p_location;
    private String p_street;
    private String p_state;
    private String p_city;
    private String p_country;
    private String p_zipcode;
    @JsonProperty
    private boolean p_active_ind;
    private BigDecimal p_oid;
    private String p_father_profission;
    private String p_mother_profission;
    private String p_guardian_profission;
    private String p_father_qualification;
    private String p_mother_qualification;
    private String p_guardian_qualification;
    private String p_father_income;
    private String p_mother_income;
    private String p_guardian_income;
    private String p_father_aadhar_no;
    private String p_mother_aadhar_no;
    private String p_guardian_aadhar_no;


    public Parent() {
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_father_name() {
        return p_father_name;
    }

    public void setP_father_name(String p_father_name) {
        this.p_father_name = p_father_name;
    }

    public String getP_mother_name() {
        return p_mother_name;
    }

    public void setP_mother_name(String p_mother_name) {
        this.p_mother_name = p_mother_name;
    }

    public String getP_guardian_name() {
        return p_guardian_name;
    }

    public void setP_guardian_name(String p_guardian_name) {
        this.p_guardian_name = p_guardian_name;
    }

    public String getP_email_id() {
        return p_email_id;
    }

    public void setP_email_id(String p_email_id) {
        this.p_email_id = p_email_id;
    }

    public String getP_father_contactno() {
        return p_father_contactno;
    }

    public void setP_father_contactno(String p_father_contactno) {
        this.p_father_contactno = p_father_contactno;
    }

    public String getP_mother_contactno() {
        return p_mother_contactno;
    }

    public void setP_mother_contactno(String p_mother_contactno) {
        this.p_mother_contactno = p_mother_contactno;
    }

    public String getP_guardian_contactno() {
        return p_guardian_contactno;
    }

    public void setP_guardian_contactno(String p_guardian_contactno) {
        this.p_guardian_contactno = p_guardian_contactno;
    }

    public String getP_address() {
        return p_address;
    }

    public void setP_address(String p_address) {
        this.p_address = p_address;
    }

    public String getP_location() {
        return p_location;
    }

    public void setP_location(String p_location) {
        this.p_location = p_location;
    }

    public String getP_street() {
        return p_street;
    }

    public void setP_street(String p_street) {
        this.p_street = p_street;
    }

    public String getP_state() {
        return p_state;
    }

    public void setP_state(String p_state) {
        this.p_state = p_state;
    }

    public String getP_city() {
        return p_city;
    }

    public void setP_city(String p_city) {
        this.p_city = p_city;
    }

    public String getP_country() {
        return p_country;
    }

    public void setP_country(String p_country) {
        this.p_country = p_country;
    }

    public String getP_zipcode() {
        return p_zipcode;
    }

    public void setP_zipcode(String p_zipcode) {
        this.p_zipcode = p_zipcode;
    }

    public boolean isP_active_ind() {
        return p_active_ind;
    }

    public void setP_active_ind(boolean p_active_ind) {
        this.p_active_ind = p_active_ind;
    }

    public BigDecimal getP_oid() {
        return p_oid;
    }

    public void setP_oid(BigDecimal p_oid) {
        this.p_oid = p_oid;
    }

    public String getP_father_profission() {
        return p_father_profission;
    }

    public void setP_father_profission(String p_father_profission) {
        this.p_father_profission = p_father_profission;
    }

    public String getP_mother_profission() {
        return p_mother_profission;
    }

    public void setP_mother_profission(String p_mother_profission) {
        this.p_mother_profission = p_mother_profission;
    }

    public String getP_guardian_profission() {
        return p_guardian_profission;
    }

    public void setP_guardian_profission(String p_guardian_profission) {
        this.p_guardian_profission = p_guardian_profission;
    }

    public String getP_father_qualification() {
        return p_father_qualification;
    }

    public void setP_father_qualification(String p_father_qualification) {
        this.p_father_qualification = p_father_qualification;
    }

    public String getP_mother_qualification() {
        return p_mother_qualification;
    }

    public void setP_mother_qualification(String p_mother_qualification) {
        this.p_mother_qualification = p_mother_qualification;
    }

    public String getP_guardian_qualification() {
        return p_guardian_qualification;
    }

    public void setP_guardian_qualification(String p_guardian_qualification) {
        this.p_guardian_qualification = p_guardian_qualification;
    }

    public String getP_father_income() {
        return p_father_income;
    }

    public void setP_father_income(String p_father_income) {
        this.p_father_income = p_father_income;
    }

    public String getP_mother_income() {
        return p_mother_income;
    }

    public void setP_mother_income(String p_mother_income) {
        this.p_mother_income = p_mother_income;
    }

    public String getP_guardian_income() {
        return p_guardian_income;
    }

    public void setP_guardian_income(String p_guardian_income) {
        this.p_guardian_income = p_guardian_income;
    }

    public String getP_father_aadhar_no() {
        return p_father_aadhar_no;
    }

    public void setP_father_aadhar_no(String p_father_aadhar_no) {
        this.p_father_aadhar_no = p_father_aadhar_no;
    }

    public String getP_mother_aadhar_no() {
        return p_mother_aadhar_no;
    }

    public void setP_mother_aadhar_no(String p_mother_aadhar_no) {
        this.p_mother_aadhar_no = p_mother_aadhar_no;
    }

    public String getP_guardian_aadhar_no() {
        return p_guardian_aadhar_no;
    }

    public void setP_guardian_aadhar_no(String p_guardian_aadhar_no) {
        this.p_guardian_aadhar_no = p_guardian_aadhar_no;
    }
}
