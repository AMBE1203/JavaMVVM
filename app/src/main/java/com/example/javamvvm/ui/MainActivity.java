package com.example.javamvvm.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.javamvvm.R;
import com.example.javamvvm.base.BaseActivity;
import com.example.javamvvm.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends BaseActivity<MainState, MainViewModel, ActivityMainBinding> {

//
//    @Inject
//    ViewModelProvider.Factory viewModelFactory;


    @Override
    protected void initViews() {

    }

    @Override
    protected void observeVM() {

    }

    @Override
    protected void render(MainState mainState) {


    }

    @Override
    protected ActivityMainBinding createViewBinding(LayoutInflater layoutInflater) {
        return ActivityMainBinding.inflate(layoutInflater);
    }

    @Override
    protected MainViewModel createViewModel() {
        return new ViewModelProvider(this).get(MainViewModel.class);
    }
}