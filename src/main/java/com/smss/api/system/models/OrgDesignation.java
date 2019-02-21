package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class OrgDesignation {

    private BigDecimal d_id;
    private BigDecimal d_oid;
    private String d_title;
    @JsonProperty
    private boolean d_active_ind;
    private String d_dcat;

    public OrgDesignation() {

    }

    public OrgDesignation(BigDecimal d_id, BigDecimal d_oid, String d_title, boolean d_active_ind) {
        this.d_id = d_id;
        this.d_oid = d_oid;
        this.d_title = d_title;
        this.d_active_ind = d_active_ind;
    }

    public BigDecimal getD_id() {
        return d_id;
    }

    public void setD_id(BigDecimal d_id) {
        this.d_id = d_id;
    }

    public BigDecimal getD_oid() {
        return d_oid;
    }

    public void setD_oid(BigDecimal d_oid) {
        this.d_oid = d_oid;
    }

    public String getD_title() {
        return d_title;
    }

    public void setD_title(String d_title) {
        this.d_title = d_title;
    }

    public boolean isD_active_ind() {
        return d_active_ind;
    }

    public void setD_active_ind(boolean d_active_ind) {
        this.d_active_ind = d_active_ind;
    }

    public String getD_dcat() {
        return d_dcat;
    }

    public void setD_dcat(String d_dcat) {
        this.d_dcat = d_dcat;
    }

    @Override
    public String toString() {
        return "POrgDesignation{" +
                "d_id=" + d_id +
                ", d_oid=" + d_oid +
                ", d_title='" + d_title + '\'' +
                ", d_active_ind=" + d_active_ind +
                '}';
    }
}
