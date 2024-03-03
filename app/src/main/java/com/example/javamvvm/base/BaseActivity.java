package com.example.javamvvm.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewbinding.ViewBinding;

import com.example.javamvvm.R;
import com.example.javamvvm.utils.DeviceUtil;
import com.example.javamvvm.utils.DialogHelper;
import com.example.javamvvm.views.LoadingDialog;

public abstract class BaseActivity<State, VM extends BaseViewModel<State>, VB extends ViewBinding> extends AppCompatActivity {

    protected VB binding;
    protected VM viewModel;

    private LoadingDialog loadingDialog;

    protected abstract void initViews();

    protected abstract void observeVM();

    protected State oldState;

    protected abstract void render(State state);



    protected abstract VB createViewBinding(LayoutInflater layoutInflater);

    protected abstract VM createViewModel();



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = createViewBinding(LayoutInflater.from(this));
        setContentView(binding.getRoot());
        viewModel = createViewModel();
        loadingDialog = LoadingDialog.getInstance();
        viewModel.state().observe(this, state -> {
            if (state == null) return;
            render(state);
            oldState = state;
        });

        viewModel.message.observe(this, msg -> {
            if (msg != null && !msg.isEmpty()) {
                DialogHelper.dialog(this,
                        R.string.text_error,
                        null,
                        null,
                        msg,
                        R.string.text_ok,
                        null,
                        null,
                        true,
                        null,
                        null,
                        null);
            }
        });
        viewModel.toastMsg.observe(this, toast -> {
            if (toast != null && !toast.isEmpty()) {
                Toast.makeText(this, toast, Toast.LENGTH_LONG).show();
            }
        });
        observeVM();
        initViews();

    }


    public void showLoading() {
        if (!loadingDialog.isAdded() && getSupportFragmentManager().findFragmentByTag(loadingDialog.getTag()) == null) {
            loadingDialog.setCancelable(false);
            loadingDialog.show(getSupportFragmentManager(), loadingDialog.getTag());
            getSupportFragmentManager().executePendingTransactions();
        }
    }

    public void hideKeyboard() {
        DeviceUtil.hideSoftKeyboard(this);
    }

    public void hideLoading() {
        try {
            loadingDialog.dismiss();
        } catch (Exception ex) {

        }
    }
}
