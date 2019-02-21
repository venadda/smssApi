package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class BatchesLookup {
    private BigDecimal b_id;
    private BigDecimal b_oid;
    private String b_batchtitle;
    private String b_desc;
    @JsonProperty
    private boolean b_active_ind;
    private String b_year;
    private int b_ayid;

    public BatchesLookup() {
    }


    public BigDecimal getB_id() {
        return b_id;
    }

    public void setB_id(BigDecimal b_id) {
        this.b_id = b_id;
    }

    public BigDecimal getB_oid() {
        return b_oid;
    }

    public void setB_oid(BigDecimal b_oid) {
        this.b_oid = b_oid;
    }

    public String getB_batchtitle() {
        return b_batchtitle;
    }

    public void setB_batchtitle(String b_batchtitle) {
        this.b_batchtitle = b_batchtitle;
    }

    public String getB_desc() {
        return b_desc;
    }

    public void setB_desc(String b_desc) {
        this.b_desc = b_desc;
    }

    public boolean isB_active_ind() {
        return b_active_ind;
    }

    public void setB_active_ind(boolean b_active_ind) {
        this.b_active_ind = b_active_ind;
    }

    public String getB_year() {
        return b_year;
    }

    public void setB_year(String b_year) {
        this.b_year = b_year;
    }

    public int getB_ayid() {
        return b_ayid;
    }

    public void setB_ayid(int b_ayid) {
        this.b_ayid = b_ayid;
    }
}
