package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

public class UserAuthentication {
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
    private List<Roles> roles;


    public UserAuthentication() {
    }

    public UserAuthentication(UserAuthentication auth) {

        this.setA_user_pwd(auth.getA_user_pwd());
        this.setA_user_loginid(auth.getA_user_loginid());
        this.setA_id(auth.getA_id());
        this.setA_active_ind(auth.isA_active_ind());
        this.setA_account_status(auth.isA_account_status());
        this.setRoles(auth.getRoles());
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

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "PUserAuthentication{" +
                "a_id=" + a_id +
                ", a_user_id=" + a_user_id +
                ", a_user_loginid='" + a_user_loginid + '\'' +
                ", a_user_pwd='" + a_user_pwd + '\'' +
                ", a_active_ind=" + a_active_ind +
                ", a_login_count=" + a_login_count +
                ", a_account_status=" + a_account_status +
                ", a_user_type='" + a_user_type + '\'' +
                ", a_user_orgId=" + a_user_orgId +
                ", roles=" + roles.toString() +
                '}';
    }
}
