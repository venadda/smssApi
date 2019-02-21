package com.smss.api.system.models;

import java.math.BigDecimal;

public class Roles {

    private BigDecimal r_id;
    private String r_title;
    private Boolean r_active_ind;
    private String r_desc;

    public Roles() {
    }

    public BigDecimal getR_id() {
        return r_id;
    }

    public void setR_id(BigDecimal r_id) {
        this.r_id = r_id;
    }

    public String getR_title() {
        return r_title;
    }

    public void setR_title(String r_title) {
        this.r_title = r_title;
    }

    public Boolean getR_active_ind() {
        return r_active_ind;
    }

    public void setR_active_ind(Boolean r_active_ind) {
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
        return "PRoles{" +
                "r_id=" + r_id +
                ", r_title='" + r_title + '\'' +
                ", r_active_ind=" + r_active_ind +
                ", r_desc='" + r_desc + '\'' +
                '}';
    }
}
