package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class StudentClsSec {

    private int s_scsid;
    private int s_sid;
    private String s_clsid;
    private String s_cls_code;
    private String s_ayid;
    private BigDecimal s_oid;
    private BigDecimal s_bid;
    @JsonProperty
    private boolean s_active_ind;

    public int getS_scsid() {
        return s_scsid;
    }

    public void setS_scsid(int s_scsid) {
        this.s_scsid = s_scsid;
    }

    public int getS_sid() {
        return s_sid;
    }

    public void setS_sid(int s_sid) {
        this.s_sid = s_sid;
    }

    public String getS_clsid() {
        return s_clsid;
    }

    public void setS_clsid(String s_clsid) {
        this.s_clsid = s_clsid;
    }

    public String getS_cls_code() {
        return s_cls_code;
    }

    public void setS_cls_code(String s_cls_code) {
        this.s_cls_code = s_cls_code;
    }

    public String getS_ayid() {
        return s_ayid;
    }

    public void setS_ayid(String s_ayid) {
        this.s_ayid = s_ayid;
    }

    public BigDecimal getS_oid() {
        return s_oid;
    }

    public void setS_oid(BigDecimal s_oid) {
        this.s_oid = s_oid;
    }

    public BigDecimal getS_bid() {
        return s_bid;
    }

    public void setS_bid(BigDecimal s_bid) {
        this.s_bid = s_bid;
    }

    public boolean isS_active_ind() {
        return s_active_ind;
    }

    public void setS_active_ind(boolean s_active_ind) {
        this.s_active_ind = s_active_ind;
    }

    @Override
    public String toString() {
        return "StudentClsSec{" +
                "s_scsid=" + s_scsid +
                ", s_sid=" + s_sid +
                ", s_clsid='" + s_clsid + '\'' +
                ", s_cls_code='" + s_cls_code + '\'' +
                ", s_ayid='" + s_ayid + '\'' +
                ", s_oid=" + s_oid +
                ", s_bid=" + s_bid +
                ", s_active_ind=" + s_active_ind +
                '}';
    }
}
