package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class TermAndTermFees {
    private BigDecimal t_id;
    private BigDecimal t_ay;
    private String t_title;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date t_fromdate;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date t_todate;
    @JsonSetter
    private boolean t_active_ind;
    private String t_cls_id;
    private String t_course_category;
    private String t_course;
    private int t_oid;
    private int t_bid;
    private List<TermFees> termFees;

    public TermAndTermFees() {
    }

    public BigDecimal getT_id() {
        return t_id;
    }

    public void setT_id(BigDecimal t_id) {
        this.t_id = t_id;
    }

    public BigDecimal getT_ay() {
        return t_ay;
    }

    public void setT_ay(BigDecimal t_ay) {
        this.t_ay = t_ay;
    }

    public String getT_title() {
        return t_title;
    }

    public void setT_title(String t_title) {
        this.t_title = t_title;
    }

    public Date getT_fromdate() {
        return t_fromdate;
    }

    public void setT_fromdate(Date t_fromdate) {
        this.t_fromdate = t_fromdate;
    }

    public Date getT_todate() {
        return t_todate;
    }

    public void setT_todate(Date t_todate) {
        this.t_todate = t_todate;
    }

    public boolean isT_active_ind() {
        return t_active_ind;
    }

    public void setT_active_ind(boolean t_active_ind) {
        this.t_active_ind = t_active_ind;
    }

    public String getT_cls_id() {
        return t_cls_id;
    }

    public void setT_cls_id(String t_cls_id) {
        this.t_cls_id = t_cls_id;
    }

    public String getT_course_category() {
        return t_course_category;
    }

    public void setT_course_category(String t_course_category) {
        this.t_course_category = t_course_category;
    }

    public String getT_course() {
        return t_course;
    }

    public void setT_course(String t_course) {
        this.t_course = t_course;
    }

    public int getT_oid() {
        return t_oid;
    }

    public void setT_oid(int t_oid) {
        this.t_oid = t_oid;
    }

    public int getT_bid() {
        return t_bid;
    }

    public void setT_bid(int t_bid) {
        this.t_bid = t_bid;
    }

    public List<TermFees> getTermFees() {
        return termFees;
    }

    public void setTermFees(List<TermFees> termFees) {
        this.termFees = termFees;
    }

    @Override
    public String toString() {
        return "TermAndTermFees{" +
                "t_id=" + t_id +
                ", t_ay=" + t_ay +
                ", t_title='" + t_title + '\'' +
                ", t_fromdate=" + t_fromdate +
                ", t_todate=" + t_todate +
                ", t_active_ind=" + t_active_ind +
                ", t_cls_id='" + t_cls_id + '\'' +
                ", t_course_category='" + t_course_category + '\'' +
                ", t_course='" + t_course + '\'' +
                ", t_oid=" + t_oid +
                ", t_bid=" + t_bid +
                ", termFees=" + termFees +
                '}';
    }
}
