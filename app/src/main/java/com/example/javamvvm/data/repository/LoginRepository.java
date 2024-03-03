package com.example.javamvvm.data.repository;

import com.example.javamvvm.data.model.BaseResponse;
import com.example.javamvvm.data.model.LoginParam;
import com.example.javamvvm.data.model.LoginResponse;
import com.example.javamvvm.data.model.UserModel;
import com.example.javamvvm.data.source.local.LocalDataSource;
import com.example.javamvvm.data.source.remote.RemoteDataSource;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class LoginRepository implements ILoginRepository {

    private final RemoteDataSource remoteDataSource;
    private final LocalDataSource localDataSource;

    @Inject
    public LoginRepository(RemoteDataSource remoteDataSource, LocalDataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }


    @Override
    public Single<BaseResponse<LoginResponse>> login(LoginParam param) {
        return remoteDataSource.login(param);
    }

    @Override
    public void saveUserToDatabase(UserModel userModel) {
        localDataSource.saveUserToDatabase(userModel);
    }
}
