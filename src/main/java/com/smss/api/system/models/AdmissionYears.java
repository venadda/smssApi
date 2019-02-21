package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AdmissionYears {
    private int ay_id;
    private int ay_oid;
    private int ay_bid;
    private String ay_year;
    private String ay_desc;
    @JsonProperty
    private boolean ay_active_ind;

    public int getAy_id() {
        return ay_id;
    }

    public void setAy_id(int ay_id) {
        this.ay_id = ay_id;
    }

    public int getAy_oid() {
        return ay_oid;
    }

    public void setAy_oid(int ay_oid) {
        this.ay_oid = ay_oid;
    }

    public int getAy_bid() {
        return ay_bid;
    }

    public void setAy_bid(int ay_bid) {
        this.ay_bid = ay_bid;
    }

    public String getAy_year() {
        return ay_year;
    }

    public void setAy_year(String ay_year) {
        this.ay_year = ay_year;
    }

    public String getAy_desc() {
        return ay_desc;
    }

    public void setAy_desc(String ay_desc) {
        this.ay_desc = ay_desc;
    }

    public boolean isAy_active_ind() {
        return ay_active_ind;
    }

    public void setAy_active_ind(boolean ay_active_ind) {
        this.ay_active_ind = ay_active_ind;
    }

    @Override
    public String toString() {
        return "AdmissionYears{" +
                "ay_id=" + ay_id +
                ", ay_oid=" + ay_oid +
                ", ay_bid=" + ay_bid +
                ", ay_year='" + ay_year + '\'' +
                ", ay_desc='" + ay_desc + '\'' +
                ", ay_active_ind=" + ay_active_ind +
                '}';
    }
}
