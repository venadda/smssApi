package com.smss.api.system.models;


public class Module  {
    private int id;
    private String desc;
    private String keys;
    private String name;
    private String view;

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


}