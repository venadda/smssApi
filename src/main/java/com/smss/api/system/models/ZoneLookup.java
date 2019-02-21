package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ZoneLookup {

    private BigDecimal z_id;
    private String z_title;
    private String z_state;
    private String z_country;
    @JsonProperty
    private boolean z_active_ind;

    public ZoneLookup() {
    }

    public ZoneLookup(BigDecimal z_id, String z_title, String z_state, String z_country, Boolean z_active_ind) {
        this.z_id = z_id;
        this.z_title = z_title;
        this.z_state = z_state;
        this.z_country = z_country;
        this.z_active_ind = z_active_ind;
    }

    public BigDecimal getZ_id() {
        return z_id;
    }

    public void setZ_id(BigDecimal z_id) {
        this.z_id = z_id;
    }

    public String getZ_title() {
        return z_title;
    }

    public void setZ_title(String z_title) {
        this.z_title = z_title;
    }

    public String getZ_state() {
        return z_state;
    }

    public void setZ_state(String z_state) {
        this.z_state = z_state;
    }

    public String getZ_country() {
        return z_country;
    }

    public void setZ_country(String z_country) {
        this.z_country = z_country;
    }

    public boolean isZ_active_ind() {
        return z_active_ind;
    }

    public void setZ_active_ind(boolean z_active_ind) {
        this.z_active_ind = z_active_ind;
    }
}
