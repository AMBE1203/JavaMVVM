package com.example.javamvvm.views;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewbinding.ViewBinding;

import com.example.javamvvm.base.BaseDialogFragment;
import com.example.javamvvm.databinding.DialogLoadingBinding;
import com.example.javamvvm.databinding.FragmentLoginBinding;

public class LoadingDialog extends BaseDialogFragment {

    private static LoadingDialog instance;

    private LoadingDialog() {
    }

    public static synchronized LoadingDialog getInstance() {
        if (instance == null) {
            instance = new LoadingDialog();
        }
        return instance;
    }


    @NonNull
    @Override
    protected ViewBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        return DialogLoadingBinding.inflate(inflater, container, false);
    }

    @Override
    public void initViews() {

    }


    @Override
    public void observeVM() {

    }
}
