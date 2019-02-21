package com.smss.api.system.models;

public class FeeHeaders {
   private int fh_id;
   private int fh_oid;
   private String fh_fee_title;

   public FeeHeaders(){}

    public int getFh_id() {
        return fh_id;
    }

    public void setFh_id(int fh_id) {
        this.fh_id = fh_id;
    }

    public int getFh_oid() {
        return fh_oid;
    }

    public void setFh_oid(int fh_oid) {
        this.fh_oid = fh_oid;
    }

    public String getFh_fee_title() {
        return fh_fee_title;
    }

    public void setFh_fee_title(String fh_fee_title) {
        this.fh_fee_title = fh_fee_title;
    }
}
