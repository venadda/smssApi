package com.smss.api.system.models;

public class CourseClasses {

    private String cc_title;
    private String cc_desc;
    private String cc_code;
    private String cc_cs_code;
    private String cc_cc_code;

    public String getCc_title() {
        return cc_title;
    }

    public void setCc_title(String cc_title) {
        this.cc_title = cc_title;
    }

    public String getCc_desc() {
        return cc_desc;
    }

    public void setCc_desc(String cc_desc) {
        this.cc_desc = cc_desc;
    }

    public String getCc_code() {
        return cc_code;
    }

    public void setCc_code(String cc_code) {
        this.cc_code = cc_code;
    }

    public String getCc_cs_code() {
        return cc_cs_code;
    }

    public void setCc_cs_code(String cc_cs_code) {
        this.cc_cs_code = cc_cs_code;
    }

    public String getCc_cc_code() {
        return cc_cc_code;
    }

    public void setCc_cc_code(String cc_cc_code) {
        this.cc_cc_code = cc_cc_code;
    }

    @Override
    public String toString() {
        return "CourseClasses{" +
                "cc_title='" + cc_title + '\'' +
                ", cc_desc='" + cc_desc + '\'' +
                ", cc_code='" + cc_code + '\'' +
                ", cc_cs_code='" + cc_cs_code + '\'' +
                ", cc_cc_code='" + cc_cc_code + '\'' +
                '}';
    }
}
