package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class Others {
    private int     o_id;
    private String  o_first_name;
    private String  o_last_name;
    private String  o_middle_name;
    private String  o_email_id;
    private String  o_pcontact_no;
    private String  o_scontact_no;
    private String  o_address;
    private String  o_location;
    private String  o_street;
    private String  o_state;
    private String  o_city;
    private String  o_country;
    private String  o_zipcode;
    @JsonProperty
    private boolean o_active_ind;
    private String  o_purpose;
    private String  o_comment;
    private String  o_remark;
    private int     o_org_id;
    private String  o_suffix;
    private int     o_no_visits;

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getO_first_name() {
        return o_first_name;
    }

    public void setO_first_name(String o_first_name) {
        this.o_first_name = o_first_name;
    }

    public String getO_last_name() {
        return o_last_name;
    }

    public void setO_last_name(String o_last_name) {
        this.o_last_name = o_last_name;
    }

    public String getO_middle_name() {
        return o_middle_name;
    }

    public void setO_middle_name(String o_middle_name) {
        this.o_middle_name = o_middle_name;
    }

    public String getO_email_id() {
        return o_email_id;
    }

    public void setO_email_id(String o_email_id) {
        this.o_email_id = o_email_id;
    }

    public String getO_pcontact_no() {
        return o_pcontact_no;
    }

    public void setO_pcontact_no(String o_pcontact_no) {
        this.o_pcontact_no = o_pcontact_no;
    }

    public String getO_scontact_no() {
        return o_scontact_no;
    }

    public void setO_scontact_no(String o_scontact_no) {
        this.o_scontact_no = o_scontact_no;
    }

    public String getO_address() {
        return o_address;
    }

    public void setO_address(String o_address) {
        this.o_address = o_address;
    }

    public String getO_location() {
        return o_location;
    }

    public void setO_location(String o_location) {
        this.o_location = o_location;
    }

    public String getO_street() {
        return o_street;
    }

    public void setO_street(String o_street) {
        this.o_street = o_street;
    }

    public String getO_state() {
        return o_state;
    }

    public void setO_state(String o_state) {
        this.o_state = o_state;
    }

    public String getO_city() {
        return o_city;
    }

    public void setO_city(String o_city) {
        this.o_city = o_city;
    }

    public String getO_country() {
        return o_country;
    }

    public void setO_country(String o_country) {
        this.o_country = o_country;
    }

    public String getO_zipcode() {
        return o_zipcode;
    }

    public void setO_zipcode(String o_zipcode) {
        this.o_zipcode = o_zipcode;
    }

    public Boolean getO_active_ind() {
        return o_active_ind;
    }

    public void setO_active_ind(Boolean o_active_ind) {
        this.o_active_ind = o_active_ind;
    }

    public String getO_purpose() {
        return o_purpose;
    }

    public void setO_purpose(String o_purpose) {
        this.o_purpose = o_purpose;
    }

    public String getO_comment() {
        return o_comment;
    }

    public void setO_comment(String o_comment) {
        this.o_comment = o_comment;
    }

    public String getO_remark() {
        return o_remark;
    }

    public void setO_remark(String o_remark) {
        this.o_remark = o_remark;
    }

    public int getO_org_id() {
        return o_org_id;
    }

    public void setO_org_id(int o_org_id) {
        this.o_org_id = o_org_id;
    }

    public String getO_suffix() {
        return o_suffix;
    }

    public void setO_suffix(String o_suffix) {
        this.o_suffix = o_suffix;
    }

    public int getO_no_visits() {
        return o_no_visits;
    }

    public void setO_no_visits(int o_no_visits) {
        this.o_no_visits = o_no_visits;
    }
}
