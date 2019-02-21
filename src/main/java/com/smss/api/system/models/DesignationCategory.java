package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class DesignationCategory {
    private String dc_title;
    private BigDecimal dc_oid;
    private String dc_desc;
    @JsonProperty
    private boolean dc_active_ind;

    public DesignationCategory() {
    }

    public String getDc_title() {
        return dc_title;
    }

    public void setDc_title(String dc_title) {
        this.dc_title = dc_title;
    }

    public BigDecimal getDc_oid() {
        return dc_oid;
    }

    public void setDc_oid(BigDecimal dc_oid) {
        this.dc_oid = dc_oid;
    }

    public String getDc_desc() {
        return dc_desc;
    }

    public void setDc_desc(String dc_desc) {
        this.dc_desc = dc_desc;
    }

    public boolean isDc_active_ind() {
        return dc_active_ind;
    }

    public void setDc_active_ind(boolean dc_active_ind) {
        this.dc_active_ind = dc_active_ind;
    }
}
