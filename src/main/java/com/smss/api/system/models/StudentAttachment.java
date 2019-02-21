package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.math.BigDecimal;

public class StudentAttachment {
    private BigDecimal s_said;
    private BigDecimal s_rsaid;
    private String s_desc;
    @JsonSetter
    private byte[] s_attachment;

    public StudentAttachment() {
    }

    public BigDecimal getS_said() {
        return s_said;
    }

    public void setS_said(BigDecimal s_said) {
        this.s_said = s_said;
    }

    public BigDecimal getS_rsaid() {
        return s_rsaid;
    }

    public void setS_rsaid(BigDecimal s_rsaid) {
        this.s_rsaid = s_rsaid;
    }

    public String getS_desc() {
        return s_desc;
    }

    public void setS_desc(String s_desc) {
        this.s_desc = s_desc;
    }

    public byte[] getS_attachment() {
        return s_attachment;
    }

    public void setS_attachment(byte[] s_attachment) {
        this.s_attachment = s_attachment;
    }
}
