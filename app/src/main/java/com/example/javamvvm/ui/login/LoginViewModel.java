package com.example.javamvvm.ui.login;

import androidx.lifecycle.MutableLiveData;

import com.example.javamvvm.base.BaseViewModel;
import com.example.javamvvm.data.model.BaseResponse;
import com.example.javamvvm.data.model.LoginParam;
import com.example.javamvvm.data.model.LoginResponse;
import com.example.javamvvm.data.repository.LoginRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;

@HiltViewModel
public class LoginViewModel extends BaseViewModel<LoginState> {

    private LoginState loginState = new LoginState(false);
    private LoginRepository loginRepository;

    @Inject
    public LoginViewModel(LoginRepository repository) {
        this.loginRepository = repository;
        _state = new MutableLiveData<>(loginState);

    }

    public void login() {
        loginState.setShowLoading(true);
        update();
        loginRepository.login(new LoginParam("kminchelle", "0lelplR"))
                .subscribe(new SingleObserver<BaseResponse<LoginResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(BaseResponse<LoginResponse> loginResponseBaseResponse) {
                        loginState.setShowLoading(false);
                        update();
                    }

                    @Override
                    public void onError(Throwable e) {
                        loginState.setShowLoading(false);
                        _message.postValue(e.getLocalizedMessage());
                        update();

                    }
                });
    }


}
