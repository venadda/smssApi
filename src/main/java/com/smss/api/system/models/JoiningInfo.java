package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class JoiningInfo {
    private int u_jid;
    private BigDecimal u_oid;
    private BigDecimal u_id;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_doj;
    private String u_desg;
    private String u_department;
    private String u_category;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_doa;
    private String u_order_no;
    private String u_init_off_name;
    private String u_recruitment_mode;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_dor;
    private String u_comment;
    @JsonProperty
    private boolean u_active_ind;

    public int getU_jid() {
        return u_jid;
    }

    public void setU_jid(int u_jid) {
        this.u_jid = u_jid;
    }

    public BigDecimal getU_oid() {
        return u_oid;
    }

    public void setU_oid(BigDecimal u_oid) {
        this.u_oid = u_oid;
    }

    public BigDecimal getU_id() {
        return u_id;
    }

    public void setU_id(BigDecimal u_id) {
        this.u_id = u_id;
    }

    public Date getU_doj() {
        return u_doj;
    }

    public void setU_doj(Date u_doj) {
        this.u_doj = u_doj;
    }

    public String getU_desg() {
        return u_desg;
    }

    public void setU_desg(String u_desg) {
        this.u_desg = u_desg;
    }

    public String getU_department() {
        return u_department;
    }

    public void setU_department(String u_department) {
        this.u_department = u_department;
    }

    public String getU_category() {
        return u_category;
    }

    public void setU_category(String u_category) {
        this.u_category = u_category;
    }

    public Date getU_doa() {
        return u_doa;
    }

    public void setU_doa(Date u_doa) {
        this.u_doa = u_doa;
    }

    public String getU_order_no() {
        return u_order_no;
    }

    public void setU_order_no(String u_order_no) {
        this.u_order_no = u_order_no;
    }

    public String getU_init_off_name() {
        return u_init_off_name;
    }

    public void setU_init_off_name(String u_init_off_name) {
        this.u_init_off_name = u_init_off_name;
    }

    public String getU_recruitment_mode() {
        return u_recruitment_mode;
    }

    public void setU_recruitment_mode(String u_recruitment_mode) {
        this.u_recruitment_mode = u_recruitment_mode;
    }

    public Date getU_dor() {
        return u_dor;
    }

    public void setU_dor(Date u_dor) {
        this.u_dor = u_dor;
    }

    public String getU_comment() {
        return u_comment;
    }

    public void setU_comment(String u_comment) {
        this.u_comment = u_comment;
    }

    public boolean isU_active_ind() {
        return u_active_ind;
    }

    public void setU_active_ind(boolean u_active_ind) {
        this.u_active_ind = u_active_ind;
    }
}
