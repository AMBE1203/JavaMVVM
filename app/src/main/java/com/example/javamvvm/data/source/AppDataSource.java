package com.example.javamvvm.data.source;

import com.example.javamvvm.data.model.BaseResponse;
import com.example.javamvvm.data.model.LoginParam;
import com.example.javamvvm.data.model.LoginResponse;
import com.example.javamvvm.data.model.UserModel;

import io.reactivex.Single;

public interface AppDataSource {
    interface Remote {
        Single<BaseResponse<LoginResponse>> login(LoginParam param);
    }

    interface Local {
        // save to database
         void saveUserToDatabase(UserModel userModel);
    }
}
