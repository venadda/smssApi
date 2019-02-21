package com.smss.api.smssApi.apiclazz;

public class SysUserPermissionParams {
    private int orgid;
    private int userid;

    public SysUserPermissionParams() {
    }

    public SysUserPermissionParams(int orgid, int userid) {
        this.orgid = orgid;
        this.userid = userid;
    }

    public int getOrgid() {
        return orgid;
    }

    public void setOrgid(int orgid) {
        this.orgid = orgid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    @Override
    public String toString() {
        return "SysUserPermissionParams{" +
                "orgid=" + orgid +
                ", userid=" + userid +
                '}';
    }
}
