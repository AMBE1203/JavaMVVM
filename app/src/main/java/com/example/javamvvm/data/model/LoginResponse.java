package com.example.javamvvm.data.model;

public class LoginResponse {

    private String accessToken;
    private UserModel userModel;

    public LoginResponse(String accessToken, UserModel userModel) {
        this.accessToken = accessToken;
        this.userModel = userModel;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }
}
