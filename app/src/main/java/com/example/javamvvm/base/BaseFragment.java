package com.example.javamvvm.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

import com.example.javamvvm.R;
import com.example.javamvvm.utils.DialogHelper;
import com.example.javamvvm.views.LoadingDialog;

public abstract class BaseFragment<State, VM extends BaseViewModel<State>, VB extends ViewBinding> extends Fragment {
    protected VM viewModel;
    protected VB binding;

    protected State oldState;


    @NonNull
    protected abstract VM createViewModel();

    @NonNull
    protected abstract VB inflateBinding(LayoutInflater inflater, ViewGroup container);

    protected abstract void initViews();

    protected abstract void observeVM();


    protected abstract void render(State state);

    private LoadingDialog loadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = inflateBinding(inflater, container);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews();

        viewModel = createViewModel();
        loadingDialog = LoadingDialog.getInstance();
        viewModel.state().observe(getViewLifecycleOwner(), state -> {
            if (state == null) return;
            render(state);
            oldState = state;
        });

        viewModel.message.observe(getViewLifecycleOwner(), msg -> {
            if (msg != null && !msg.isEmpty()) {
                DialogHelper.dialog(requireContext(),
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
        viewModel.toastMsg.observe(getViewLifecycleOwner(), toast -> {
            if (toast != null && !toast.isEmpty()) {
                Toast.makeText(getActivity(), toast, Toast.LENGTH_LONG).show();
            }
        });
        observeVM();
    }

    public void showLoading() {
        if (!loadingDialog.isAdded() && getParentFragmentManager().findFragmentByTag(loadingDialog.getTag()) == null) {
            loadingDialog.setCancelable(false);
            loadingDialog.show(getParentFragmentManager(), loadingDialog.getTag());
            getParentFragmentManager().executePendingTransactions();
        }
    }

    public void hideLoading() {
        try {
            loadingDialog.dismiss();
        } catch (Exception ex) {

        }
    }
}
