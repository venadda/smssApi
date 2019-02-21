package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonSetter;

public class TermFees {
    private int tf_id;
    private int tf_oid;
    private int tf_bid;
    private int tf_term_id;
    private int tf_fee_id;
    @JsonSetter
    private boolean tf_active_ind;
    private double tf_amount;
    private double tf_other_amount;
    private String tf_cls_id;
    private String tf_course_id;
    private String tf_cls_code;
    private int tf_ay_id;

    public TermFees() {
    }

    public int getTf_id() {
        return tf_id;
    }

    public void setTf_id(int tf_id) {
        this.tf_id = tf_id;
    }

    public int getTf_oid() {
        return tf_oid;
    }

    public void setTf_oid(int tf_oid) {
        this.tf_oid = tf_oid;
    }

    public int getTf_bid() {
        return tf_bid;
    }

    public void setTf_bid(int tf_bid) {
        this.tf_bid = tf_bid;
    }

    public int getTf_term_id() {
        return tf_term_id;
    }

    public void setTf_term_id(int tf_term_id) {
        this.tf_term_id = tf_term_id;
    }

    public int getTf_fee_id() {
        return tf_fee_id;
    }

    public void setTf_fee_id(int tf_fee_id) {
        this.tf_fee_id = tf_fee_id;
    }

    public boolean isTf_active_ind() {
        return tf_active_ind;
    }

    public void setTf_active_ind(boolean tf_active_ind) {
        this.tf_active_ind = tf_active_ind;
    }

    public double getTf_amount() {
        return tf_amount;
    }

    public void setTf_amount(double tf_amount) {
        this.tf_amount = tf_amount;
    }

    public double getTf_other_amount() {
        return tf_other_amount;
    }

    public void setTf_other_amount(double tf_other_amount) {
        this.tf_other_amount = tf_other_amount;
    }

    public String getTf_cls_id() {
        return tf_cls_id;
    }

    public void setTf_cls_id(String tf_cls_id) {
        this.tf_cls_id = tf_cls_id;
    }

    public String getTf_course_id() {
        return tf_course_id;
    }

    public void setTf_course_id(String tf_course_id) {
        this.tf_course_id = tf_course_id;
    }

    public String getTf_cls_code() {
        return tf_cls_code;
    }

    public void setTf_cls_code(String tf_cls_code) {
        this.tf_cls_code = tf_cls_code;
    }

    public int getTf_ay_id() {
        return tf_ay_id;
    }

    public void setTf_ay_id(int tf_ay_id) {
        this.tf_ay_id = tf_ay_id;
    }

    @Override
    public String toString() {
        return "TermFees{" +
                "tf_id=" + tf_id +
                ", tf_oid=" + tf_oid +
                ", tf_bid=" + tf_bid +
                ", tf_term_id=" + tf_term_id +
                ", tf_fee_id=" + tf_fee_id +
                ", tf_active_ind=" + tf_active_ind +
                ", tf_amount=" + tf_amount +
                ", tf_other_amount=" + tf_other_amount +
                '}';
    }
}
