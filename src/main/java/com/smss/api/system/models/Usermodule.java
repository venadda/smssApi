package com.smss.api.system.models;

import java.io.Serializable;


public class Usermodule  {
    private int umid;
    private String udelete;
    private String uedit;
    private int userid;
    private String uview;
    private int mid;
    private int orgid;

    public Usermodule() {
    }

    public int getUmid() {
        return umid;
    }

    public void setUmid(int umid) {
        this.umid = umid;
    }

    public String getUdelete() {
        return udelete;
    }

    public void setUdelete(String udelete) {
        this.udelete = udelete;
    }

    public String getUedit() {
        return uedit;
    }

    public void setUedit(String uedit) {
        this.uedit = uedit;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUview() {
        return uview;
    }

    public void setUview(String uview) {
        this.uview = uview;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getOrgid() {
        return orgid;
    }

    public void setOrgid(int orgid) {
        this.orgid = orgid;
    }
}