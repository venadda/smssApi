package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class Achievements {

    private int u_id;
    private BigDecimal u_uid;
    private BigDecimal u_oid;
    private String u_category;
    private String u_achievement;
    private String u_leavel;
    private String u_rank;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date u_date;
    private String u_sponsor;
    private String u_remark;

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public BigDecimal getU_uid() {
        return u_uid;
    }

    public void setU_uid(BigDecimal u_uid) {
        this.u_uid = u_uid;
    }

    public BigDecimal getU_oid() {
        return u_oid;
    }

    public void setU_oid(BigDecimal u_oid) {
        this.u_oid = u_oid;
    }

    public String getU_category() {
        return u_category;
    }

    public void setU_category(String u_category) {
        this.u_category = u_category;
    }

    public String getU_achievement() {
        return u_achievement;
    }

    public void setU_achievement(String u_achievement) {
        this.u_achievement = u_achievement;
    }

    public String getU_leavel() {
        return u_leavel;
    }

    public void setU_leavel(String u_leavel) {
        this.u_leavel = u_leavel;
    }

    public String getU_rank() {
        return u_rank;
    }

    public void setU_rank(String u_rank) {
        this.u_rank = u_rank;
    }

    public Date getU_date() {
        return u_date;
    }

    public void setU_date(Date u_date) {
        this.u_date = u_date;
    }

    public String getU_sponsor() {
        return u_sponsor;
    }

    public void setU_sponsor(String u_sponsor) {
        this.u_sponsor = u_sponsor;
    }

    public String getU_remark() {
        return u_remark;
    }

    public void setU_remark(String u_remark) {
        this.u_remark = u_remark;
    }
}
