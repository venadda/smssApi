package com.smss.api.system.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Blob;
import java.util.Date;

public class Audit {
    private int id;
    private int orgid;
    private String action_type;
    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date action_date;
    private int action_by;
    private String user_name;
    private String data;
    private String view_name;
    private String action;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrgid() {
        return orgid;
    }

    public void setOrgid(int orgid) {
        this.orgid = orgid;
    }

    public String getAction_type() {
        return action_type;
    }

    public void setAction_type(String action_type) {
        this.action_type = action_type;
    }

    public Date getAction_date() {
        return action_date;
    }

    public void setAction_date(Date action_date) {
        this.action_date = action_date;
    }

    public int getAction_by() {
        return action_by;
    }

    public void setAction_by(int action_by) {
        this.action_by = action_by;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getView_name() {
        return view_name;
    }

    public void setView_name(String view_name) {
        this.view_name = view_name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", orgid=" + orgid +
                ", action_type='" + action_type + '\'' +
                ", action_date=" + action_date +
                ", action_by=" + action_by +
                ", user_name='" + user_name + '\'' +
                ", data='" + data + '\'' +
                ", view_name='" + view_name + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}
