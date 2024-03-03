package com.example.javamvvm.data.source.remote;

import com.example.javamvvm.data.model.BaseResponse;
import com.example.javamvvm.data.model.LoginParam;
import com.example.javamvvm.data.model.LoginResponse;
import com.example.javamvvm.data.source.AppDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;


@Singleton
public class RemoteDataSource implements AppDataSource.Remote {

    private final ApiInterface apiInterface;

    @Inject
    public RemoteDataSource(ApiInterface apiInterface) {
        this.apiInterface = apiInterface;
    }

    @Override
    public Single<BaseResponse<LoginResponse>> login(LoginParam param) {
        return apiInterface.login(param).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
