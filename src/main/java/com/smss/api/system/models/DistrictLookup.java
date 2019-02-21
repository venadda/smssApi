package com.smss.api.system.models;

import java.math.BigDecimal;

public class DistrictLookup {
    private BigDecimal d_id;
    private String d_title;
    private String d_state;
    private String d_country;

    public DistrictLookup() {
    }

    public BigDecimal getD_id() {
        return d_id;
    }

    public void setD_id(BigDecimal d_id) {
        this.d_id = d_id;
    }

    public String getD_title() {
        return d_title;
    }

    public void setD_title(String d_title) {
        this.d_title = d_title;
    }

    public String getD_state() {
        return d_state;
    }

    public void setD_state(String d_state) {
        this.d_state = d_state;
    }

    public String getD_country() {
        return d_country;
    }

    public void setD_country(String d_country) {
        this.d_country = d_country;
    }
}
