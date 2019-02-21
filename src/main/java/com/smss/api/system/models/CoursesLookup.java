package com.smss.api.system.models;

import java.math.BigDecimal;

public class CoursesLookup {
    private BigDecimal bc_id;
    private String bc_title;
    private String bc_stitle;
    private String bc_clevelid;
    private String bc_sbranch;

    public CoursesLookup() {
    }

    public BigDecimal getBc_id() {
        return bc_id;
    }

    public void setBc_id(BigDecimal bc_id) {
        this.bc_id = bc_id;
    }

    public String getBc_title() {
        return bc_title;
    }

    public void setBc_title(String bc_title) {
        this.bc_title = bc_title;
    }

    public String getBc_stitle() {
        return bc_stitle;
    }

    public void setBc_stitle(String bc_stitle) {
        this.bc_stitle = bc_stitle;
    }

    public String getBc_clevelid() {
        return bc_clevelid;
    }

    public void setBc_clevelid(String bc_clevelid) {
        this.bc_clevelid = bc_clevelid;
    }

    public String getBc_sbranch() {
        return bc_sbranch;
    }

    public void setBc_sbranch(String bc_sbranch) {
        this.bc_sbranch = bc_sbranch;
    }
}
