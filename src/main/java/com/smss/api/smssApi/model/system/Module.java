package com.smss.api.smssApi.model.system;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * The persistent class for the modules database table.
 */
@Entity
@Table(name = "modules", schema = "system", catalog = "system")

//@NamedQuery(name="Module.findAll", query="SELECT m FROM Module m")
public class Module implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String desc;

    private String keys;

    private String name;

    private String view;

    //bi-directional one-to-one association to Usermodule
  /*  @OneToOne(mappedBy="module")
    private Usermodule usermodule;*/

    public Module() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getKeys() {
        return this.keys;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getView() {
        return this.view;
    }

    public void setView(String view) {
        this.view = view;
    }

  /*  public Usermodule getUsermodule() {
        return this.usermodule;
    }

    public void setUsermodule(Usermodule usermodule) {
        this.usermodule = usermodule;
    }*/

  /*  @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                ", keys='" + keys + '\'' +
                ", name='" + name + '\'' +
                ", view='" + view + '\'' +
                ", usermodule=" + usermodule +
                '}';
    }*/
}