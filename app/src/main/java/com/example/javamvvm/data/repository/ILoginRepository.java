package com.example.javamvvm.data.repository;

import com.example.javamvvm.data.model.BaseResponse;
import com.example.javamvvm.data.model.LoginParam;
import com.example.javamvvm.data.model.LoginResponse;
import com.example.javamvvm.data.model.UserModel;

import io.reactivex.Single;

public interface ILoginRepository {
    Single<BaseResponse<LoginResponse>> login(LoginParam param);

    void saveUserToDatabase(UserModel userModel);

}
