package com.smss.api.system.models;

import java.math.BigDecimal;

public class ClassesLookup {
    private String c_title;
    private String c_desc;
    private BigDecimal c_courseId;

    public ClassesLookup() {
    }

    public String getC_title() {
        return c_title;
    }

    public void setC_title(String c_title) {
        this.c_title = c_title;
    }

    public String getC_desc() {
        return c_desc;
    }

    public void setC_desc(String c_desc) {
        this.c_desc = c_desc;
    }

    public BigDecimal getC_courseId() {
        return c_courseId;
    }

    public void setC_courseId(BigDecimal c_courseId) {
        this.c_courseId = c_courseId;
    }
}
