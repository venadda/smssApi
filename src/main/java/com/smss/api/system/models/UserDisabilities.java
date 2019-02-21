package com.smss.api.system.models;

public class UserDisabilities {
    private int ud_did;
    private int ud_uid;
    private int ud_oid;
    private String ud_dcode;

    public int getUd_did() {
        return ud_did;
    }

    public void setUd_did(int ud_did) {
        this.ud_did = ud_did;
    }

    public int getUd_uid() {
        return ud_uid;
    }

    public void setUd_uid(int ud_uid) {
        this.ud_uid = ud_uid;
    }

    public int getUd_oid() {
        return ud_oid;
    }

    public void setUd_oid(int ud_oid) {
        this.ud_oid = ud_oid;
    }

    public String getUd_dcode() {
        return ud_dcode;
    }

    public void setUd_dcode(String ud_dcode) {
        this.ud_dcode = ud_dcode;
    }
}
