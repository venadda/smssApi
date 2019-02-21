package com.smss.api.system.models;

public class CourseCategory {
    private String cc_code;
    private String cc_desc;
    private String cc_country;

    public String getCc_code() {
        return cc_code;
    }

    public void setCc_code(String cc_code) {
        this.cc_code = cc_code;
    }

    public String getCc_desc() {
        return cc_desc;
    }

    public void setCc_desc(String cc_desc) {
        this.cc_desc = cc_desc;
    }

    public String getCc_country() {
        return cc_country;
    }

    public void setCc_country(String cc_country) {
        this.cc_country = cc_country;
    }

    @Override
    public String toString() {
        return "CourseCategory{" +
                "cc_code='" + cc_code + '\'' +
                ", cc_desc='" + cc_desc + '\'' +
                ", cc_country='" + cc_country + '\'' +
                '}';
    }
}
