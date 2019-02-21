package com.smss.api.system.models;

import java.io.Serializable;
import java.math.BigDecimal;

public class Organization implements Serializable {

    private int o_id;
    private String o_title;
    private String o_active_ind;
    private String o_address;
    private String o_location;
    private String o_street;
    private String o_city;
    private String o_state;
    private String o_country;
    private String o_zipcode;
    private String o_district;
    private String o_mandal;
    private String o_village;
    private String o_pcontactno;
    private String o_scontactno;
    private String o_pfaxno;
    private String o_sfaxno;
    private String o_pemail;
    private String o_semail;
    private String o_pcontactperson;
    private String o_scontactperson;
    private String o_pwebsite;
    private String o_swebsite;
    private String o_smsurl;
    private String o_type;


    public Organization() {
    }

    public int getO_id() {
        return o_id;
    }

    public void setO_id(int o_id) {
        this.o_id = o_id;
    }

    public String getO_title() {
        return o_title;
    }

    public void setO_title(String o_title) {
        this.o_title = o_title;
    }


    public String getO_active_ind() {
        return o_active_ind;
    }

    public void setO_active_ind(String o_active_ind) {
        this.o_active_ind = o_active_ind;
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

    public String getO_city() {
        return o_city;
    }

    public void setO_city(String o_city) {
        this.o_city = o_city;
    }

    public String getO_state() {
        return o_state;
    }

    public void setO_state(String o_state) {
        this.o_state = o_state;
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

    public String getO_district() {
        return o_district;
    }

    public void setO_district(String o_district) {
        this.o_district = o_district;
    }

    public String getO_mandal() {
        return o_mandal;
    }

    public void setO_mandal(String o_mandal) {
        this.o_mandal = o_mandal;
    }

    public String getO_village() {
        return o_village;
    }

    public void setO_village(String o_village) {
        this.o_village = o_village;
    }

    public String getO_pcontactno() {
        return o_pcontactno;
    }

    public void setO_pcontactno(String o_pcontactno) {
        this.o_pcontactno = o_pcontactno;
    }

    public String getO_scontactno() {
        return o_scontactno;
    }

    public void setO_scontactno(String o_scontactno) {
        this.o_scontactno = o_scontactno;
    }

    public String getO_pfaxno() {
        return o_pfaxno;
    }

    public void setO_pfaxno(String o_pfaxno) {
        this.o_pfaxno = o_pfaxno;
    }

    public String getO_sfaxno() {
        return o_sfaxno;
    }

    public void setO_sfaxno(String o_sfaxno) {
        this.o_sfaxno = o_sfaxno;
    }

    public String getO_pemail() {
        return o_pemail;
    }

    public void setO_pemail(String o_pemail) {
        this.o_pemail = o_pemail;
    }

    public String getO_semail() {
        return o_semail;
    }

    public void setO_semail(String o_semail) {
        this.o_semail = o_semail;
    }

    public String getO_pcontactperson() {
        return o_pcontactperson;
    }

    public void setO_pcontactperson(String o_pcontactperson) {
        this.o_pcontactperson = o_pcontactperson;
    }

    public String getO_scontactperson() {
        return o_scontactperson;
    }

    public void setO_scontactperson(String o_scontactperson) {
        this.o_scontactperson = o_scontactperson;
    }

    public String getO_pwebsite() {
        return o_pwebsite;
    }

    public void setO_pwebsite(String o_pwebsite) {
        this.o_pwebsite = o_pwebsite;
    }

    public String getO_swebsite() {
        return o_swebsite;
    }

    public void setO_swebsite(String o_swebsite) {
        this.o_swebsite = o_swebsite;
    }

    public String getO_smsurl() {
        return o_smsurl;
    }

    public void setO_smsurl(String o_smsurl) {
        this.o_smsurl = o_smsurl;
    }

    public String getO_type() {
        return o_type;
    }

    public void setO_type(String o_type) {
        this.o_type = o_type;
    }

    @Override
    public String toString() {
        return "Organization{" +
                "o_id=" + o_id +
                ", o_title='" + o_title + '\'' +
                ", o_active_ind='" + o_active_ind + '\'' +
                ", o_address='" + o_address + '\'' +
                ", o_location='" + o_location + '\'' +
                ", o_street='" + o_street + '\'' +
                ", o_city='" + o_city + '\'' +
                ", o_state='" + o_state + '\'' +
                ", o_country='" + o_country + '\'' +
                ", o_zipcode='" + o_zipcode + '\'' +
                ", o_district='" + o_district + '\'' +
                ", o_mandal='" + o_mandal + '\'' +
                ", o_village='" + o_village + '\'' +
                ", o_pcontactno='" + o_pcontactno + '\'' +
                ", o_scontactno='" + o_scontactno + '\'' +
                ", o_pfaxno='" + o_pfaxno + '\'' +
                ", o_sfaxno='" + o_sfaxno + '\'' +
                ", o_pemail='" + o_pemail + '\'' +
                ", o_semail='" + o_semail + '\'' +
                ", o_pcontactperson='" + o_pcontactperson + '\'' +
                ", o_scontactperson='" + o_scontactperson + '\'' +
                ", o_pwebsite='" + o_pwebsite + '\'' +
                ", o_swebsite='" + o_swebsite + '\'' +
                ", o_smsurl='" + o_smsurl + '\'' +
                ", o_type='" + o_type + '\'' +
                '}';
    }
}
