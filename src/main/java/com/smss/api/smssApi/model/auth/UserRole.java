package com.smss.api.smssApi.model.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the userroles database table.
 */
@Entity
@Table(name = "userroles", schema = "user", catalog = "user")
//@NamedQuery(name="Userrole.findAll", query="SELECT u FROM Userrole u")
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ur_id")
    private int urId;

    @Column(name = "ur_active_ind")
    private byte urActiveInd;

    @Column(name = "ur_role")
    private int urRole;

    @Column(name = "ur_uid")
    private int urUid;

    @Column(name = "ur_org_id")
    private int urOrgId;

    public UserRole() {
    }

    public int getUrId() {
        return this.urId;
    }

    public void setUrId(int urId) {
        this.urId = urId;
    }

    public byte getUrActiveInd() {
        return this.urActiveInd;
    }

    public void setUrActiveInd(byte urActiveInd) {
        this.urActiveInd = urActiveInd;
    }

    public int getUrRole() {
        return this.urRole;
    }

    public void setUrRole(int urRole) {
        this.urRole = urRole;
    }

    public int getUrUid() {
        return this.urUid;
    }

    public void setUrUid(int urUid) {
        this.urUid = urUid;
    }

    public int getUrOrgId() {
        return urOrgId;
    }

    public void setUrOrgId(int urOrgId) {
        this.urOrgId = urOrgId;
    }
}