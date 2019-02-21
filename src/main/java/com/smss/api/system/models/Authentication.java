package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class Authentication {

    private BigDecimal a_id;
    private BigDecimal a_user_id;
    private String a_user_loginid;
    private String a_user_pwd;
    @JsonProperty
    private boolean a_active_ind;
    private int a_login_count;
    private boolean a_account_status;
    private String a_user_type;
    private BigDecimal a_user_orgId;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date a_last_logged_in;
    private String a_user_firstName;
    private String a_user_lastName;
    private String a_user_email_Id;
    private String a_user_confirm_pwd;

    public Authentication() {
    }

    public Authentication(Authentication auth) {
        this.setA_user_confirm_pwd(auth.getA_user_confirm_pwd());
        this.setA_user_pwd(auth.getA_user_pwd());
        this.setA_user_loginid(auth.getA_user_loginid());
        this.setA_id(auth.getA_id());
        this.setA_active_ind(auth.isA_active_ind());
        this.setA_account_status(auth.isA_account_status());
        this.setA_last_logged_in(auth.getA_last_logged_in());
        this.setA_user_email_Id(auth.getA_user_email_Id());
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

    public String getA_user_email_Id() {
        return a_user_email_Id;
    }

    public void setA_user_email_Id(String a_user_email_Id) {
        this.a_user_email_Id = a_user_email_Id;
    }

    public String getA_user_confirm_pwd() {
        return a_user_confirm_pwd;
    }

    public void setA_user_confirm_pwd(String a_user_confirm_pwd) {
        this.a_user_confirm_pwd = a_user_confirm_pwd;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "a_id=" + a_id +
                ", a_user_id=" + a_user_id +
                ", a_user_loginid='" + a_user_loginid + '\'' +
                ", a_user_pwd='" + a_user_pwd + '\'' +
                ", a_active_ind=" + a_active_ind +
                ", a_login_count=" + a_login_count +
                ", a_account_status=" + a_account_status +
                ", a_user_type='" + a_user_type + '\'' +
                ", a_user_orgId=" + a_user_orgId +
                ", a_last_logged_in=" + a_last_logged_in +
                ", a_user_firstName='" + a_user_firstName + '\'' +
                ", a_user_lastName='" + a_user_lastName + '\'' +
                ", a_user_email_Id='" + a_user_email_Id + '\'' +
                ", a_user_confirm_pwd='" + a_user_confirm_pwd + '\'' +
                '}';
    }
}
