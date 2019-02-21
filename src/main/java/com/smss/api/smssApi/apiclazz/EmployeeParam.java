package com.smss.api.smssApi.apiclazz;

import java.util.List;

public class EmployeeParam {
    private int orgId;
    private int userId;
    private String uname;
    private String email;
    private List<String> roles;

    public int getOrgId() {
        return orgId;
    }

    public void setOrgId(int orgId) {
        this.orgId = orgId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "EmployeeParam{" +
                "orgId=" + orgId +
                ", userId=" + userId +
                ", uname='" + uname + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + roles +
                '}';
    }
}
