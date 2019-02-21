package com.smss.api.smssApi.apiclazz;

import org.springframework.web.multipart.MultipartFile;

public class UserphotoParams {

    private int id;
    private int uid;
    private int uorgid;
    private MultipartFile file;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getUorgid() {
        return uorgid;
    }

    public void setUorgid(int uorgid) {
        this.uorgid = uorgid;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return "UserphotoParams{" +
                "id=" + id +
                ", uid=" + uid +
                ", uorgid=" + uorgid +
                ", uphoto=" + file +
                '}';
    }
}