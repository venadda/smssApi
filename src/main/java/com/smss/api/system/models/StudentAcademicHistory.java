package com.smss.api.system.models;

import java.math.BigDecimal;
import java.util.Arrays;

public class StudentAcademicHistory {
    private BigDecimal s_sahid;
    private BigDecimal s_id;
    private String s_courseName;
    private String s_organization;
    private String s_marks;
    private String s_year;
    private String s_grade;
    private String s_stream;
    private String s_comment;
    private byte[] s_attachment;
    private int s_oid;
    private int s_bid;

    public StudentAcademicHistory() {
    }

    public int getS_oid() {
        return s_oid;
    }

    public void setS_oid(int s_oid) {
        this.s_oid = s_oid;
    }

    public int getS_bid() {
        return s_bid;
    }

    public void setS_bid(int s_bid) {
        this.s_bid = s_bid;
    }

    public BigDecimal getS_sahid() {
        return s_sahid;
    }

    public void setS_sahid(BigDecimal s_sahid) {
        this.s_sahid = s_sahid;
    }

    public BigDecimal getS_id() {
        return s_id;
    }

    public void setS_id(BigDecimal s_id) {
        this.s_id = s_id;
    }

    public String getS_courseName() {
        return s_courseName;
    }

    public void setS_courseName(String s_courseName) {
        this.s_courseName = s_courseName;
    }

    public String getS_organization() {
        return s_organization;
    }

    public void setS_organization(String s_organization) {
        this.s_organization = s_organization;
    }

    public String getS_marks() {
        return s_marks;
    }

    public void setS_marks(String s_marks) {
        this.s_marks = s_marks;
    }

    public String getS_year() {
        return s_year;
    }

    public void setS_year(String s_year) {
        this.s_year = s_year;
    }

    public String getS_grade() {
        return s_grade;
    }

    public void setS_grade(String s_grade) {
        this.s_grade = s_grade;
    }

    public String getS_stream() {
        return s_stream;
    }

    public void setS_stream(String s_stream) {
        this.s_stream = s_stream;
    }

    public String getS_comment() {
        return s_comment;
    }

    public void setS_comment(String s_comment) {
        this.s_comment = s_comment;
    }

    public byte[] getS_attachment() {
        return s_attachment;
    }

    public void setS_attachment(byte[] s_attachment) {
        this.s_attachment = s_attachment;
    }

    @Override
    public String toString() {
        return "StudentAcademicHistory{" +
                "s_sahid=" + s_sahid +
                ", s_id=" + s_id +
                ", s_courseName='" + s_courseName + '\'' +
                ", s_organization='" + s_organization + '\'' +
                ", s_marks='" + s_marks + '\'' +
                ", s_year='" + s_year + '\'' +
                ", s_grade='" + s_grade + '\'' +
                ", s_stream='" + s_stream + '\'' +
                ", s_comment='" + s_comment + '\'' +
                ", s_attachment=" + Arrays.toString(s_attachment) +
                '}';
    }
}
