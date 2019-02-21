package com.smss.api.smssApi.model.system;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the usertypes database table.
 */
@Entity
@Table(name = "usertypes", schema = "system", catalog = "system")
//@NamedQuery(name="Usertype.findAll", query="SELECT u FROM Usertype u")
public class Usertype implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "r_id")
    private String rId;

    @Column(name = "r_access")
    private String rAccess;

    @Column(name = "r_title")
    private String rTitle;

    public Usertype() {
    }

    public String getRId() {
        return this.rId;
    }

    public void setRId(String rId) {
        this.rId = rId;
    }

    public String getRAccess() {
        return this.rAccess;
    }

    public void setRAccess(String rAccess) {
        this.rAccess = rAccess;
    }

    public String getRTitle() {
        return this.rTitle;
    }

    public void setRTitle(String rTitle) {
        this.rTitle = rTitle;
    }

}