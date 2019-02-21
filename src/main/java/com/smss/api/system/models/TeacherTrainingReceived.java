package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

public class TeacherTrainingReceived {

    private int u_id;
    private BigDecimal u_uid;
    private BigDecimal u_oid;
    private String u_training_type;
    private String u_topic_name;
    private String u_institute_name;
    private String u_sponsored_by;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_from_date;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date u_to_date;
    private String u_comment;
    @JsonSetter
    private byte[] u_attachement;

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

    public String getU_training_type() {
        return u_training_type;
    }

    public void setU_training_type(String u_training_type) {
        this.u_training_type = u_training_type;
    }

    public String getU_topic_name() {
        return u_topic_name;
    }

    public void setU_topic_name(String u_topic_name) {
        this.u_topic_name = u_topic_name;
    }

    public String getU_institute_name() {
        return u_institute_name;
    }

    public void setU_institute_name(String u_institute_name) {
        this.u_institute_name = u_institute_name;
    }

    public String getU_sponsored_by() {
        return u_sponsored_by;
    }

    public void setU_sponsored_by(String u_sponsored_by) {
        this.u_sponsored_by = u_sponsored_by;
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

    @Override
    public String toString() {
        return "TeacherTrainingReceived{" +
                "u_id=" + u_id +
                ", u_uid=" + u_uid +
                ", u_oid=" + u_oid +
                ", u_training_type='" + u_training_type + '\'' +
                ", u_topic_name='" + u_topic_name + '\'' +
                ", u_institute_name='" + u_institute_name + '\'' +
                ", u_sponsored_by='" + u_sponsored_by + '\'' +
                ", u_from_date=" + u_from_date +
                ", u_to_date=" + u_to_date +
                ", u_comment='" + u_comment + '\'' +
                ", u_attachement=" + Arrays.toString(u_attachement) +
                '}';
    }
}
