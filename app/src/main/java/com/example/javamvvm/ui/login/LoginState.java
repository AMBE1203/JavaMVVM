package com.example.javamvvm.ui.login;

public class LoginState {


    private boolean isShowLoading;

    public LoginState(boolean isShowLoading) {
        this.isShowLoading = isShowLoading;

    }

    public boolean isShowLoading() {
        return isShowLoading;
    }

    public void setShowLoading(boolean showLoading) {
        isShowLoading = showLoading;
    }

}
