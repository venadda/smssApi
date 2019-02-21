package com.smss.api.smssApi.dto.user;

public class UserphotoDTO {

    private int id;
    private int uId;
    private int uOrgId;
    private byte[] uPhoto;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUId() {
        return this.uId;
    }

    public void setUId(int uId) {
        this.uId = uId;
    }

    public int getUOrgId() {
        return this.uOrgId;
    }

    public void setUOrgId(int uOrgId) {
        this.uOrgId = uOrgId;
    }

    public byte[] getUPhoto() {
        return this.uPhoto;
    }

    public void setUPhoto(byte[] uPhoto) {
        this.uPhoto = uPhoto;
    }

}