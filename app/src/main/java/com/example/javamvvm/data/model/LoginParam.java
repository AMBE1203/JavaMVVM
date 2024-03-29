package com.example.javamvvm.data.model;

import com.google.gson.annotations.SerializedName;

public class LoginParam {
    @SerializedName("username")
    private String userName;
    private String password;

    public LoginParam(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
