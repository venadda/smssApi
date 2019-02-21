package com.smss.api.smssApi.model.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the usermodule database table.
 */
@Entity
@Table(name = "usermodule", schema = "system", catalog = "system")
//@NamedQuery(name="Usermodule.findAll", query="SELECT u FROM Usermodule u")
public class Usermodule implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "id")
    private int umid;

    private String delete;

    private String edit;

    private int orgid;

    private int userid;
    @Column(name = "view")
    private String uview;

    private int mid;
    //bi-directional one-to-one association to Module
    //  @OneToOne(fetch = FetchType.LAZY, optional = false)
    //  @JoinColumn(name="mid")
    //   private Module module;

    public Usermodule() {
    }

    public int getUmid() {
        return this.umid;
    }

    public void setUmid(int umid) {
        this.umid = umid;
    }

    public String getDelete() {
        return this.delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getEdit() {
        return this.edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public int getOrgid() {
        return this.orgid;
    }

    public void setOrgid(int orgid) {
        this.orgid = orgid;
    }

    public int getUserid() {
        return this.userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUview() {
        return this.uview;
    }

    public void setUview(String uview) {
        this.uview = uview;
    }

       /* public Module getModule() {
            return this.module;
        }

        public void setModule(Module module) {
            this.module = module;
        }*/

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

/* @Override
    public String toString() {
        return "Usermodule{" +
                "id=" + id +
                ", delete='" + delete + '\'' +
                ", edit='" + edit + '\'' +
                ", orgid=" + orgid +
                ", userid=" + userid +
                ", view='" + view + '\'' +
                ", module=" + module +
                '}';
    }*/
}