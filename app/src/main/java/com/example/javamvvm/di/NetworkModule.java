package com.example.javamvvm.di;

import android.content.Context;

import com.example.javamvvm.BuildConfig;
import com.example.javamvvm.data.repository.LoginRepository;
import com.example.javamvvm.data.source.local.LocalDataSource;
import com.example.javamvvm.data.source.local.dao.UserDao;
import com.example.javamvvm.data.source.remote.ApiInterface;
import com.example.javamvvm.data.source.remote.RemoteDataSource;
import com.example.javamvvm.data.source.remote.interceptor.HeaderInterceptor;
import com.example.javamvvm.data.source.remote.interceptor.NetworkCheckerInterceptor;
import com.example.javamvvm.utils.DefineConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {
    @Provides
    @Singleton
    ApiInterface provideApiInterface(OkHttpClient client) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(ApiInterface.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideHttpClient(@ApplicationContext Context context) {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        NetworkCheckerInterceptor networkCheckerInterceptor = new NetworkCheckerInterceptor(context);

        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .addInterceptor(headerInterceptor)
                .addInterceptor(networkCheckerInterceptor)
                .connectTimeout(DefineConstants.DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DefineConstants.DEFAULT_CONNECT_TIMEOUT, TimeUnit.SECONDS)
                .build();
    }

//    @Singleton
//    @Provides
//    RemoteDataSource provideRemoteDataSource(
//            ApiInterface apiInterface
//    ) {
//        return new RemoteDataSource(apiInterface);
//    }
//
//
//    @Singleton
//    @Provides
//    LoginRepository provideLoginRepository(
//            RemoteDataSource remoteDataSource, LocalDataSource localDataSource
//    ) {
//        return new LoginRepository(remoteDataSource, localDataSource);
//    }
}
