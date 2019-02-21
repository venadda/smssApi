package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.util.Date;

public class TrainingInfo {
    private BigDecimal u_id;
    private String u_trainingtype;
    private String u_topicname;
    private String u_institutename;
    private String u_sponsoredBy;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date u_fromdate;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date u_todate;
    private String u_comment;
    @JsonSetter
    private byte[] u_attachement;

    public TrainingInfo() {
    }

    public BigDecimal getU_id() {
        return u_id;
    }

    public void setU_id(BigDecimal u_id) {
        this.u_id = u_id;
    }

    public String getU_trainingtype() {
        return u_trainingtype;
    }

    public void setU_trainingtype(String u_trainingtype) {
        this.u_trainingtype = u_trainingtype;
    }

    public String getU_topicname() {
        return u_topicname;
    }

    public void setU_topicname(String u_topicname) {
        this.u_topicname = u_topicname;
    }

    public String getU_institutename() {
        return u_institutename;
    }

    public void setU_institutename(String u_institutename) {
        this.u_institutename = u_institutename;
    }

    public String getU_sponsoredBy() {
        return u_sponsoredBy;
    }

    public void setU_sponsoredBy(String u_sponsoredBy) {
        this.u_sponsoredBy = u_sponsoredBy;
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

    public String getU_comment() {
        return u_comment;
    }

    public void setU_comment(String u_comment) {
        this.u_comment = u_comment;
    }

    public byte[] getU_attachement() {
        return u_attachement;
    }

    public void setU_attachement(byte[] u_attachement) {
        this.u_attachement = u_attachement;
    }
}
