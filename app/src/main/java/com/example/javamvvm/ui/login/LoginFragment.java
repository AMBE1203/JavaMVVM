package com.example.javamvvm.ui.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;


import com.example.javamvvm.base.BaseFragment;
import com.example.javamvvm.databinding.FragmentLoginBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class LoginFragment extends BaseFragment<LoginState, LoginViewModel, FragmentLoginBinding> {

    @NonNull
    @Override
    protected LoginViewModel createViewModel() {
        return new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @NonNull
    @Override
    protected FragmentLoginBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return FragmentLoginBinding.inflate(inflater, container, false);
    }


    @Override
    protected void initViews() {

        binding.mBtnSignIn.setOnClickListener(view -> {

            viewModel.login();

        });

    }

    @Override
    protected void observeVM() {

    }


    @Override
    protected void render(LoginState loginState) {
        if (loginState.isShowLoading()) {
            showLoading();
        } else {
            hideLoading();
        }


    }
}