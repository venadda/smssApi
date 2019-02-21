package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class AcademicYear {
    private BigDecimal ay_id;
    private BigDecimal ay_oid;
    private String ay_batch;
    private String ay_year;
    private String ay_clevel;
    @JsonProperty
    private boolean ay_active_ind;
    @JsonProperty
    private boolean ay_admission_ind;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date ay_fromdate;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private Date ay_todate;

    public AcademicYear() {
    }

    public BigDecimal getAy_id() {
        return ay_id;
    }

    public void setAy_id(BigDecimal ay_id) {
        this.ay_id = ay_id;
    }

    public BigDecimal getAy_oid() {
        return ay_oid;
    }

    public void setAy_oid(BigDecimal ay_oid) {
        this.ay_oid = ay_oid;
    }

    public String getAy_batch() {
        return ay_batch;
    }

    public void setAy_batch(String ay_batch) {
        this.ay_batch = ay_batch;
    }

    public String getAy_year() {
        return ay_year;
    }

    public void setAy_year(String ay_year) {
        this.ay_year = ay_year;
    }

    public String getAy_clevel() {
        return ay_clevel;
    }

    public void setAy_clevel(String ay_clevel) {
        this.ay_clevel = ay_clevel;
    }

    public boolean isAy_active_ind() {
        return ay_active_ind;
    }

    public void setAy_active_ind(boolean ay_active_ind) {
        this.ay_active_ind = ay_active_ind;
    }

    public boolean isAy_admission_ind() {
        return ay_admission_ind;
    }

    public void setAy_admission_ind(boolean ay_admission_ind) {
        this.ay_admission_ind = ay_admission_ind;
    }

    public Date getAy_fromdate() {
        return ay_fromdate;
    }

    public void setAy_fromdate(Date ay_fromdate) {
        this.ay_fromdate = ay_fromdate;
    }

    public Date getAy_todate() {
        return ay_todate;
    }

    public void setAy_todate(Date ay_todate) {
        this.ay_todate = ay_todate;
    }
}
