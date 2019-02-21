package com.smss.api.smssApi.apiclazz;

import java.util.Date;

public class AuditParam {
    private int id;
    private int orgid;
    private Date auditDate;
    private Date toDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrgid() {
        return orgid;
    }

    public void setOrgid(int orgid) {
        this.orgid = orgid;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    @Override
    public String toString() {
        return "AuditParam{" +
                "id=" + id +
                ", orgid=" + orgid +
                ", auditDate=" + auditDate +
                ", toDate=" + toDate +
                '}';
    }
}
