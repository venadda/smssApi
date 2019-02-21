package com.smss.api.smssApi.model.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
//@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
@Table(name = "role", schema = "user", catalog = "user")
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "r_id")
    private int rId;

    @Column(name = "r_active_ind")
    private byte rActiveInd;

    @Column(name = "r_desc")
    private String rDesc;

    @Column(name = "r_title")
    private String rTitle;

    public Role() {
    }

    public int getRId() {
        return this.rId;
    }

    public void setRId(int rId) {
        this.rId = rId;
    }

    public byte getRActiveInd() {
        return this.rActiveInd;
    }

    public void setRActiveInd(byte rActiveInd) {
        this.rActiveInd = rActiveInd;
    }

    public String getRDesc() {
        return this.rDesc;
    }

    public void setRDesc(String rDesc) {
        this.rDesc = rDesc;
    }

    public String getRTitle() {
        return this.rTitle;
    }

    public void setRTitle(String rTitle) {
        this.rTitle = rTitle;
    }

}