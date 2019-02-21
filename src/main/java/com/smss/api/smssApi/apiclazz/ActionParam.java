package com.smss.api.smssApi.apiclazz;

public class ActionParam {
    private int userid;
    private String user_name;
    private String view_name;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getView_name() {
        return view_name;
    }

    public void setView_name(String view_name) {
        this.view_name = view_name;
    }

    @Override
    public String toString() {
        return "ActionParam{" +
                "userid=" + userid +
                ", user_name='" + user_name + '\'' +
                ", view_name='" + view_name + '\'' +
                '}';
    }
}
