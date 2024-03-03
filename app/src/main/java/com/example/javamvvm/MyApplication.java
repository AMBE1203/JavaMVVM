package com.example.javamvvm;

import android.app.Application;

import com.example.javamvvm.data.source.local.DataLocalManager;

import dagger.hilt.android.HiltAndroidApp;

@HiltAndroidApp
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        DataLocalManager.init(getApplicationContext());
    }
}
