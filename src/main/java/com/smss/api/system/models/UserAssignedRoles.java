package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAssignedRoles {
    private int ur_id;
    private int ur_uid;
    private int ur_role;
    @JsonProperty
    private boolean ur_active_ind;
    private int ur_org_id;
    private int r_id;
    private String r_title;
    @JsonProperty
    private boolean r_active_ind;
    private String r_desc;

    public UserAssignedRoles() {
    }

    public int getUr_id() {
        return ur_id;
    }

    public void setUr_id(int ur_id) {
        this.ur_id = ur_id;
    }

    public int getUr_uid() {
        return ur_uid;
    }

    public void setUr_uid(int ur_uid) {
        this.ur_uid = ur_uid;
    }

    public int getUr_role() {
        return ur_role;
    }

    public void setUr_role(int ur_role) {
        this.ur_role = ur_role;
    }

    public boolean isUr_active_ind() {
        return ur_active_ind;
    }

    public void setUr_active_ind(boolean ur_active_ind) {
        this.ur_active_ind = ur_active_ind;
    }

    public int getUr_org_id() {
        return ur_org_id;
    }

    public void setUr_org_id(int ur_org_id) {
        this.ur_org_id = ur_org_id;
    }

    public int getR_id() {
        return r_id;
    }

    public void setR_id(int r_id) {
        this.r_id = r_id;
    }

    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public boolean isR_active_ind() {
        return r_active_ind;
    }

    public void setR_active_ind(boolean r_active_ind) {
        this.r_active_ind = r_active_ind;
    }

    public String getR_desc() {
        return r_desc;
    }

    public void setR_desc(String r_desc) {
        this.r_desc = r_desc;
    }

    @Override
    public String toString() {
        return "UserAssignedRoles{" +
                "ur_id=" + ur_id +
                ", ur_uid=" + ur_uid +
                ", ur_role=" + ur_role +
                ", ur_active_ind=" + ur_active_ind +
                ", ur_org_id=" + ur_org_id +
                ", r_id=" + r_id +
                ", r_title='" + r_title + '\'' +
                ", r_active_ind=" + r_active_ind +
                ", r_desc='" + r_desc + '\'' +
                '}';
    }
}
