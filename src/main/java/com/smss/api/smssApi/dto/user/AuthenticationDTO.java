package com.smss.api.smssApi.dto.user;

import java.io.Serializable;
import java.util.Date;

public class AuthenticationDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private int aId;
    private byte aAccountStatus;
    private byte aActiveInd;
    private String aEmailId;
    private String aFirstName;
    private Date aLastLoggedIn;
    private String aLastName;
    private int aLoginCount;
    private String aLoginId;
    private int aOrgId;
    private String aPwd;
    private int aRole;
    private String aType;
    private int aUserId;

    public AuthenticationDTO() {
    }

    public int getAId() {
        return this.aId;
    }

    public void setAId(int aId) {
        this.aId = aId;
    }

    public byte getAAccountStatus() {
        return this.aAccountStatus;
    }

    public void setAAccountStatus(byte aAccountStatus) {
        this.aAccountStatus = aAccountStatus;
    }

    public byte getAActiveInd() {
        return this.aActiveInd;
    }

    public void setAActiveInd(byte aActiveInd) {
        this.aActiveInd = aActiveInd;
    }

    public String getAEmailId() {
        return this.aEmailId;
    }

    public void setAEmailId(String aEmailId) {
        this.aEmailId = aEmailId;
    }

    public String getAFirstName() {
        return this.aFirstName;
    }

    public void setAFirstName(String aFirstName) {
        this.aFirstName = aFirstName;
    }

    public Date getALastLoggedIn() {
        return this.aLastLoggedIn;
    }

    public void setALastLoggedIn(Date aLastLoggedIn) {
        this.aLastLoggedIn = aLastLoggedIn;
    }

    public String getALastName() {
        return this.aLastName;
    }

    public void setALastName(String aLastName) {
        this.aLastName = aLastName;
    }

    public int getALoginCount() {
        return this.aLoginCount;
    }

    public void setALoginCount(int aLoginCount) {
        this.aLoginCount = aLoginCount;
    }

    public String getALoginId() {
        return this.aLoginId;
    }

    public void setALoginId(String aLoginId) {
        this.aLoginId = aLoginId;
    }

    public int getAOrgId() {
        return this.aOrgId;
    }

    public void setAOrgId(int aOrgId) {
        this.aOrgId = aOrgId;
    }

    public String getAPwd() {
        return this.aPwd;
    }

    public void setAPwd(String aPwd) {
        this.aPwd = aPwd;
    }

    public int getARole() {
        return this.aRole;
    }

    public void setARole(int aRole) {
        this.aRole = aRole;
    }

    public String getAType() {
        return this.aType;
    }

    public void setAType(String aType) {
        this.aType = aType;
    }

    public int getAUserId() {
        return this.aUserId;
    }

    public void setAUserId(int aUserId) {
        this.aUserId = aUserId;
    }


}
