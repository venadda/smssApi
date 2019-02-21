package com.smss.api.system.models;

import java.math.BigDecimal;
import java.util.Arrays;

public class EducationInfo {

    private BigDecimal u_eid;
    private BigDecimal u_oid;
    private String u_course;
    private String u_organization;
    private String u_marks;
    private String u_year;
    private String u_medium;
    private String u_grade;
    private BigDecimal u_id;
    private String u_edu_type;
    private String u_subjects;
    private String u_comment;
    private byte[] u_attachment;

    public EducationInfo() {
    }

    public BigDecimal getU_eid() {
        return u_eid;
    }

    public void setU_eid(BigDecimal u_eid) {
        this.u_eid = u_eid;
    }

    public BigDecimal getU_oid() {
        return u_oid;
    }

    public void setU_oid(BigDecimal u_oid) {
        this.u_oid = u_oid;
    }

    public String getU_course() {
        return u_course;
    }

    public void setU_course(String u_course) {
        this.u_course = u_course;
    }

    public String getU_organization() {
        return u_organization;
    }

    public void setU_organization(String u_organization) {
        this.u_organization = u_organization;
    }

    public String getU_marks() {
        return u_marks;
    }

    public void setU_marks(String u_marks) {
        this.u_marks = u_marks;
    }

    public String getU_year() {
        return u_year;
    }

    public void setU_year(String u_year) {
        this.u_year = u_year;
    }

    public String getU_medium() {
        return u_medium;
    }

    public void setU_medium(String u_medium) {
        this.u_medium = u_medium;
    }

    public String getU_grade() {
        return u_grade;
    }

    public void setU_grade(String u_grade) {
        this.u_grade = u_grade;
    }

    public BigDecimal getU_id() {
        return u_id;
    }

    public void setU_id(BigDecimal u_id) {
        this.u_id = u_id;
    }

    public String getU_edu_type() {
        return u_edu_type;
    }

    public void setU_edu_type(String u_edu_type) {
        this.u_edu_type = u_edu_type;
    }

    public String getU_subjects() {
        return u_subjects;
    }

    public void setU_subjects(String u_subjects) {
        this.u_subjects = u_subjects;
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

    @Override
    public String toString() {
        return "EducationInfo{" +
                "u_eid=" + u_eid +
                ", u_oid=" + u_oid +
                ", u_course='" + u_course + '\'' +
                ", u_organization='" + u_organization + '\'' +
                ", u_marks='" + u_marks + '\'' +
                ", u_year='" + u_year + '\'' +
                ", u_medium='" + u_medium + '\'' +
                ", u_grade='" + u_grade + '\'' +
                ", u_id=" + u_id +
                ", u_edu_type='" + u_edu_type + '\'' +
                ", u_subjects='" + u_subjects + '\'' +
                ", u_comment='" + u_comment + '\'' +
                ", u_attachment=" + Arrays.toString(u_attachment) +
                '}';
    }
}
