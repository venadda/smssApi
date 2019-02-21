package com.smss.api.system.models;

import java.util.Date;
import java.util.List;

public class TermMapTermFee {
    private String bc_cls_id;
    private String bc_dsply_title;
    private String bc_short_title;
    private String bc_cls_code;
    private int bc_ayid;
    private int bc_bid;
    private int bc_oid;
    private List<TermAndTermFees> terms;

    public String getBc_cls_id() {
        return bc_cls_id;
    }

    public void setBc_cls_id(String bc_cls_id) {
        this.bc_cls_id = bc_cls_id;
    }

    public String getBc_dsply_title() {
        return bc_dsply_title;
    }

    public void setBc_dsply_title(String bc_dsply_title) {
        this.bc_dsply_title = bc_dsply_title;
    }

    public String getBc_short_title() {
        return bc_short_title;
    }

    public void setBc_short_title(String bc_short_title) {
        this.bc_short_title = bc_short_title;
    }

    public String getBc_cls_code() {
        return bc_cls_code;
    }

    public void setBc_cls_code(String bc_cls_code) {
        this.bc_cls_code = bc_cls_code;
    }

    public int getBc_ayid() {
        return bc_ayid;
    }

    public void setBc_ayid(int bc_ayid) {
        this.bc_ayid = bc_ayid;
    }

    public int getBc_bid() {
        return bc_bid;
    }

    public void setBc_bid(int bc_bid) {
        this.bc_bid = bc_bid;
    }

    public int getBc_oid() {
        return bc_oid;
    }

    public void setBc_oid(int bc_oid) {
        this.bc_oid = bc_oid;
    }

    public List<TermAndTermFees> getTerms() {
        return terms;
    }

    public void setTerms(List<TermAndTermFees> terms) {
        this.terms = terms;
    }

    @Override
    public String toString() {
        return "TermMapTermFee{" +
                "bc_cls_id='" + bc_cls_id + '\'' +
                ", bc_dsply_title='" + bc_dsply_title + '\'' +
                ", bc_short_title='" + bc_short_title + '\'' +
                ", bc_cls_code='" + bc_cls_code + '\'' +
                ", bc_ayid=" + bc_ayid +
                ", bc_bid=" + bc_bid +
                ", bc_oid=" + bc_oid +
                ", terms=" + terms.toString() +
                '}';
    }
}
