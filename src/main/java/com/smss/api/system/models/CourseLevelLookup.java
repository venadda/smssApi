package com.smss.api.system.models;

public class CourseLevelLookup {

    private String c_title;
    private String c_country;
    private String c_desc;
    private String c_group;

    public CourseLevelLookup() {
    }

    public String getC_title() {
        return c_title;
    }

    public void setC_title(String c_title) {
        this.c_title = c_title;
    }

    public String getC_country() {
        return c_country;
    }

    public void setC_country(String c_country) {
        this.c_country = c_country;
    }

    public String getC_desc() {
        return c_desc;
    }

    public void setC_desc(String c_desc) {
        this.c_desc = c_desc;
    }

    public String getC_group() {
        return c_group;
    }

    public void setC_group(String c_group) {
        this.c_group = c_group;
    }

    @Override
    public String toString() {
        return "CourseLevelLookup{" +
                "c_title='" + c_title + '\'' +
                ", c_country='" + c_country + '\'' +
                ", c_desc='" + c_desc + '\'' +
                ", c_group='" + c_group + '\'' +
                '}';
    }
}
