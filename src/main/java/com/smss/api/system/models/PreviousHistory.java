package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class PreviousHistory {
    private BigDecimal u_sh;
    private BigDecimal u_id;
    private String u_organization;
    private String u_designation;
    private String u_department;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_fromdate;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_todate;
    private String u_reasontoleave;
    private String u_comment;
    private byte[] u_attachment;

    public PreviousHistory() {
    }

    public BigDecimal getU_sh() {
        return u_sh;
    }

    public void setU_sh(BigDecimal u_sh) {
        this.u_sh = u_sh;
    }

    public BigDecimal getU_id() {
        return u_id;
    }

    public void setU_id(BigDecimal u_id) {
        this.u_id = u_id;
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

    public Date getU_fromdate() {
        return u_fromdate;
    }

    public void setU_fromdate(Date u_fromdate) {
        this.u_fromdate = u_fromdate;
    }

    public Date getU_todate() {
        return u_todate;
    }

    public void setU_todate(Date u_todate) {
        this.u_todate = u_todate;
    }

    public String getU_reasontoleave() {
        return u_reasontoleave;
    }

    public void setU_reasontoleave(String u_reasontoleave) {
        this.u_reasontoleave = u_reasontoleave;
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
