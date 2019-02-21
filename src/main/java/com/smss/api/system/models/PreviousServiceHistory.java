package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.util.Date;

public class PreviousServiceHistory {

    private int u_sh;
    private BigDecimal u_id;
    private BigDecimal u_oid;
    private String u_organization;
    private String u_designation;
    private String u_department;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_from_date;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_to_date;
    private String u_exp_in_years;
    private String u_sub_cls_taught;
    private String u_reason_to_leave;
    private String u_comment;
    @JsonSetter
    private byte[] u_attachment;

    public int getU_sh() {
        return u_sh;
    }

    public void setU_sh(int u_sh) {
        this.u_sh = u_sh;
    }

    public BigDecimal getU_id() {
        return u_id;
    }

    public void setU_id(BigDecimal u_id) {
        this.u_id = u_id;
    }

    public BigDecimal getU_oid() {
        return u_oid;
    }

    public void setU_oid(BigDecimal u_oid) {
        this.u_oid = u_oid;
    }

    public String getU_organization() {
        return u_organization;
    }

    public void setU_organization(String u_organization) {
        this.u_organization = u_organization;
    }

    public String getU_designation() {
        return u_designation;
    }

    public void setU_designation(String u_designation) {
        this.u_designation = u_designation;
    }

    public String getU_department() {
        return u_department;
    }

    public void setU_department(String u_department) {
        this.u_department = u_department;
    }

    public Date getU_from_date() {
        return u_from_date;
    }

    public void setU_from_date(Date u_from_date) {
        this.u_from_date = u_from_date;
    }

    public Date getU_to_date() {
        return u_to_date;
    }

    public void setU_to_date(Date u_to_date) {
        this.u_to_date = u_to_date;
    }

    public String getU_exp_in_years() {
        return u_exp_in_years;
    }

    public void setU_exp_in_years(String u_exp_in_years) {
        this.u_exp_in_years = u_exp_in_years;
    }

    public String getU_sub_cls_taught() {
        return u_sub_cls_taught;
    }

    public void setU_sub_cls_taught(String u_sub_cls_taught) {
        this.u_sub_cls_taught = u_sub_cls_taught;
    }

    public String getU_reason_to_leave() {
        return u_reason_to_leave;
    }

    public void setU_reason_to_leave(String u_reason_to_leave) {
        this.u_reason_to_leave = u_reason_to_leave;
    }

    public String getU_comment() {
        return u_comment;
    }

    public void setU_comment(String u_comment) {
        this.u_comment = u_comment;
    }

    public byte[] getU_attachment() {
        return u_attachment;
    }

    public void setU_attachment(byte[] u_attachment) {
        this.u_attachment = u_attachment;
    }
}
