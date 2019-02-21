package com.smss.api.system.models;

import java.math.BigDecimal;

public class TeacherTrainingGiven {
    private int tg_id;
    private BigDecimal tg_uid;
    private BigDecimal tg_oid;
    private int tg_ayid;
    private String tg_trainingname;
    private String tg_givenas;
    private int tg_days;
    private String tg_remarks;
    private String tg_comment;

    public int getTg_id() {
        return tg_id;
    }

    public void setTg_id(int tg_id) {
        this.tg_id = tg_id;
    }

    public BigDecimal getTg_uid() {
        return tg_uid;
    }

    public void setTg_uid(BigDecimal tg_uid) {
        this.tg_uid = tg_uid;
    }

    public BigDecimal getTg_oid() {
        return tg_oid;
    }

    public void setTg_oid(BigDecimal tg_oid) {
        this.tg_oid = tg_oid;
    }

    public int getTg_ayid() {
        return tg_ayid;
    }

    public void setTg_ayid(int tg_ayid) {
        this.tg_ayid = tg_ayid;
    }

    public String getTg_trainingname() {
        return tg_trainingname;
    }

    public void setTg_trainingname(String tg_trainingname) {
        this.tg_trainingname = tg_trainingname;
    }

    public String getTg_givenas() {
        return tg_givenas;
    }

    public void setTg_givenas(String tg_givenas) {
        this.tg_givenas = tg_givenas;
    }

    public int getTg_days() {
        return tg_days;
    }

    public void setTg_days(int tg_days) {
        this.tg_days = tg_days;
    }

    public String getTg_remarks() {
        return tg_remarks;
    }

    public void setTg_remarks(String tg_remarks) {
        this.tg_remarks = tg_remarks;
    }

    public String getTg_comment() {
        return tg_comment;
    }

    public void setTg_comment(String tg_comment) {
        this.tg_comment = tg_comment;
    }
}
