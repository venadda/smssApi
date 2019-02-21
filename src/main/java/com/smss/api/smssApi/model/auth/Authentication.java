package com.smss.api.smssApi.model.auth;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.Arrays;
import java.util.Date;

public class Authentication  {
    private int aId;
    private boolean aAccountStatus;
    private boolean aActiveInd;
    private String aEmailId;
    private String aFirstName;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date aLastLoggedIn;
    private String aLastName;
    private int aLoginCount;
    private String aLoginId;
    private int aOrgId;
    private String aPwd;
    private int aRole;
    private String aType;
    private int aUserId;
    @JsonSetter
    private byte[] aPhoto;
    private String system;

    public Authentication() {
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public boolean isaAccountStatus() {
        return aAccountStatus;
    }

    public void setaAccountStatus(boolean aAccountStatus) {
        this.aAccountStatus = aAccountStatus;
    }

    public boolean isaActiveInd() {
        return aActiveInd;
    }

    public void setaActiveInd(boolean aActiveInd) {
        this.aActiveInd = aActiveInd;
    }

    public String getaEmailId() {
        return aEmailId;
    }

    public void setaEmailId(String aEmailId) {
        this.aEmailId = aEmailId;
    }

    public String getaFirstName() {
        return aFirstName;
    }

    public void setaFirstName(String aFirstName) {
        this.aFirstName = aFirstName;
    }

    public Date getaLastLoggedIn() {
        return aLastLoggedIn;
    }

    public void setaLastLoggedIn(Date aLastLoggedIn) {
        this.aLastLoggedIn = aLastLoggedIn;
    }

    public String getaLastName() {
        return aLastName;
    }

    public void setaLastName(String aLastName) {
        this.aLastName = aLastName;
    }

    public int getaLoginCount() {
        return aLoginCount;
    }

    public void setaLoginCount(int aLoginCount) {
        this.aLoginCount = aLoginCount;
    }

    public String getaLoginId() {
        return aLoginId;
    }

    public void setaLoginId(String aLoginId) {
        this.aLoginId = aLoginId;
    }

    public int getaOrgId() {
        return aOrgId;
    }

    public void setaOrgId(int aOrgId) {
        this.aOrgId = aOrgId;
    }

    public String getaPwd() {
        return aPwd;
    }

    public void setaPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    public int getaRole() {
        return aRole;
    }

    public void setaRole(int aRole) {
        this.aRole = aRole;
    }

    public String getaType() {
        return aType;
    }

    public void setaType(String aType) {
        this.aType = aType;
    }

    public int getaUserId() {
        return aUserId;
    }

    public void setaUserId(int aUserId) {
        this.aUserId = aUserId;
    }

    public byte[] getaPhoto() {
        return aPhoto;
    }

    public void setaPhoto(byte[] aPhoto) {
        this.aPhoto = aPhoto;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "Authentication{" +
                "aId=" + aId +
                ", aAccountStatus=" + aAccountStatus +
                ", aActiveInd=" + aActiveInd +
                ", aEmailId='" + aEmailId + '\'' +
                ", aFirstName='" + aFirstName + '\'' +
                ", aLastLoggedIn=" + aLastLoggedIn +
                ", aLastName='" + aLastName + '\'' +
                ", aLoginCount=" + aLoginCount +
                ", aLoginId='" + aLoginId + '\'' +
                ", aOrgId=" + aOrgId +
                ", aPwd='" + aPwd + '\'' +
                ", aRole=" + aRole +
                ", aType='" + aType + '\'' +
                ", aUserId=" + aUserId +
                ", aPhoto=" + Arrays.toString(aPhoto) +
                '}';
    }
}