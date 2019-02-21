package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrgUserRoles {
    private int ur_id;
    private int ur_uid;
    private int ur_role;
    @JsonProperty
    private boolean ur_active_ind;
    private int ur_org_id;

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

}
