package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;

public class Photo {
    private BigDecimal u_id;
    @JsonSetter
    private byte[] u_photo;

    public Photo() {
    }

    public BigDecimal getU_id() {
        return u_id;
    }

    public void setU_id(BigDecimal u_id) {
        this.u_id = u_id;
    }

    public byte[] getU_photo() {
        return u_photo;
    }

    public void setU_photo(byte[] u_photo) {
        this.u_photo = u_photo;
    }
}
