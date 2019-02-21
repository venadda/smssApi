package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ParentStudent {
    private BigDecimal p_id;
    private BigDecimal p_pid;
    private BigDecimal p_sid;
    @JsonProperty
    private boolean p_active_ind;
    private BigDecimal p_orgId;

    public ParentStudent() {
    }

    public BigDecimal getP_id() {
        return p_id;
    }

    public void setP_id(BigDecimal p_id) {
        this.p_id = p_id;
    }

    public BigDecimal getP_pid() {
        return p_pid;
    }

    public void setP_pid(BigDecimal p_pid) {
        this.p_pid = p_pid;
    }

    public BigDecimal getP_sid() {
        return p_sid;
    }

    public void setP_sid(BigDecimal p_sid) {
        this.p_sid = p_sid;
    }


    public boolean isP_active_ind() {
        return p_active_ind;
    }

    public void setP_active_ind(boolean p_active_ind) {
        this.p_active_ind = p_active_ind;
    }

    public BigDecimal getP_orgId() {
        return p_orgId;
    }

    public void setP_orgId(BigDecimal p_orgId) {
        this.p_orgId = p_orgId;
    }
}
