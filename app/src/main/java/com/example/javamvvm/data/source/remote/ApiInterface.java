package com.example.javamvvm.data.source.remote;

import com.example.javamvvm.data.model.BaseResponse;
import com.example.javamvvm.data.model.LoginParam;
import com.example.javamvvm.data.model.LoginResponse;

import javax.inject.Singleton;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

@Singleton
public interface ApiInterface {

    @POST("auth/login")
    Single<BaseResponse<LoginResponse>> login(@Body LoginParam param);
}
