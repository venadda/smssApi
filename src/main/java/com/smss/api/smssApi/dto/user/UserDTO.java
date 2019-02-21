package com.smss.api.smssApi.dto.user;


import java.util.Date;

public class UserDTO {
    private long rid;
    private String rdesc;
    private String rtitle;
    private boolean ractiveInd;
    private boolean aaccountStatus;
    private long aid;
    private String afirstName;
    private String aloginId;
    private long aorgId;
    private String apwd;
    private long auserId;
    private String aemailId;
    private String alastName;
    private String atype;
    private boolean aactiveInd;
    private Date alastLoggedIn;
    private int aloginCount;
    private byte[] photo;

    public UserDTO() {
    }

    public long getRid() {
        return rid;
    }

    public void setRid(long rid) {
        this.rid = rid;
    }

    public String getRdesc() {
        return rdesc;
    }

    public void setRdesc(String rdesc) {
        this.rdesc = rdesc;
    }

    public String getRtitle() {
        return rtitle;
    }

    public void setRtitle(String rtitle) {
        this.rtitle = rtitle;
    }

    public boolean isRactiveInd() {
        return ractiveInd;
    }

    public void setRactiveInd(boolean ractiveInd) {
        this.ractiveInd = ractiveInd;
    }

    public boolean isAaccountStatus() {
        return aaccountStatus;
    }

    public void setAaccountStatus(boolean aaccountStatus) {
        this.aaccountStatus = aaccountStatus;
    }

    public long getAid() {
        return aid;
    }

    public void setAid(long aid) {
        this.aid = aid;
    }

    public String getAfirstName() {
        return afirstName;
    }

    public void setAfirstName(String afirstName) {
        this.afirstName = afirstName;
    }

    public String getAloginId() {
        return aloginId;
    }

    public void setAloginId(String aloginId) {
        this.aloginId = aloginId;
    }

    public long getAorgId() {
        return aorgId;
    }

    public void setAorgId(long aorgId) {
        this.aorgId = aorgId;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public long getAuserId() {
        return auserId;
    }

    public void setAuserId(long auserId) {
        this.auserId = auserId;
    }

    public String getAemailId() {
        return aemailId;
    }

    public void setAemailId(String aemailId) {
        this.aemailId = aemailId;
    }

    public String getAlastName() {
        return alastName;
    }

    public void setAlastName(String alastName) {
        this.alastName = alastName;
    }

    public String getAtype() {
        return atype;
    }

    public void setAtype(String atype) {
        this.atype = atype;
    }

    public boolean isAactiveInd() {
        return aactiveInd;
    }

    public void setAactiveInd(boolean aactiveInd) {
        this.aactiveInd = aactiveInd;
    }

    public Date getAlastLoggedIn() {
        return alastLoggedIn;
    }

    public void setAlastLoggedIn(Date alastLoggedIn) {
        this.alastLoggedIn = alastLoggedIn;
    }

    public int getAloginCount() {
        return aloginCount;
    }

    public void setAloginCount(int aloginCount) {
        this.aloginCount = aloginCount;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "rid=" + rid +
                ", rdesc='" + rdesc + '\'' +
                ", rtitle='" + rtitle + '\'' +
                ", ractiveInd=" + ractiveInd +
                ", aaccountStatus=" + aaccountStatus +
                ", aid=" + aid +
                ", afirstName='" + afirstName + '\'' +
                ", aloginId='" + aloginId + '\'' +
                ", aorgId=" + aorgId +
                ", apwd='" + apwd + '\'' +
                ", auserId=" + auserId +
                ", aemailId='" + aemailId + '\'' +
                ", alastName='" + alastName + '\'' +
                ", atype='" + atype + '\'' +
                ", aactiveInd=" + aactiveInd +
                ", alastLoggedIn=" + alastLoggedIn +
                ", aloginCount=" + aloginCount +
                '}';
    }
}
