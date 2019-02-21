package com.smss.api.system.models;

import java.math.BigDecimal;

public class StudentPhoto {
    private BigDecimal s_id;
    private byte[] s_photo;

    public StudentPhoto() {
    }

    public BigDecimal getS_id() {
        return s_id;
    }

    public void setS_id(BigDecimal s_id) {
        this.s_id = s_id;
    }

    public byte[] getS_photo() {
        return s_photo;
    }

    public void setS_photo(byte[] s_photo) {
        this.s_photo = s_photo;
    }
}
