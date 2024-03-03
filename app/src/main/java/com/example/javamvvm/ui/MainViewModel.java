package com.example.javamvvm.ui;

import com.example.javamvvm.base.BaseViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;


@HiltViewModel
public class MainViewModel extends BaseViewModel<MainState> {

    @Inject
    public MainViewModel() {
    }


}
