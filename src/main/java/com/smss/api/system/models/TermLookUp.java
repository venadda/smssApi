package com.smss.api.system.models;

import java.math.BigDecimal;

public class TermLookUp {
    private int tl_id;
    private String tl_title;
    private BigDecimal tl_oid;
    private String tl_desc;

    public TermLookUp() {
    }

    public int getTl_id() {
        return tl_id;
    }

    public void setTl_id(int tl_id) {
        this.tl_id = tl_id;
    }

    public String getTl_title() {
        return tl_title;
    }

    public void setTl_title(String tl_title) {
        this.tl_title = tl_title;
    }

    public BigDecimal getTl_oid() {
        return tl_oid;
    }

    public void setTl_oid(BigDecimal tl_oid) {
        this.tl_oid = tl_oid;
    }

    public String getTl_desc() {
        return tl_desc;
    }

    public void setTl_desc(String tl_desc) {
        this.tl_desc = tl_desc;
    }
}
