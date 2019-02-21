package com.smss.api.smssApi.model.user;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "userphoto", schema = "user", catalog = "user")
public class Userphoto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    @Column(name = "u_id")
    private int uId;

    @Column(name = "u_org_id")
    private int uOrgId;

    @Lob
    @Column(name = "u_photo")
    private byte[] uPhoto;

    public Userphoto() {
    }

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