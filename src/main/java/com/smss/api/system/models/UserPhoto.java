package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonSetter;

public class UserPhoto {
    private int id;
    @JsonSetter
    private byte[] u_photo;

    private int u_id;
    private int u_org_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public byte[] getU_photo() {
        return u_photo;
    }

    public void setU_photo(byte[] u_photo) {
        this.u_photo = u_photo;
    }

    public int getU_id() {
        return u_id;
    }

    public void setU_id(int u_id) {
        this.u_id = u_id;
    }

    public int getU_org_id() {
        return u_org_id;
    }

    public void setU_org_id(int u_org_id) {
        this.u_org_id = u_org_id;
    }
}
