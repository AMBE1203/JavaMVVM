package com.example.javamvvm.base;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import kotlinx.coroutines.flow.MutableStateFlow;

public abstract class BaseViewModel<State> extends ViewModel {


    protected final MutableLiveData<String> _message = new MutableLiveData<>();
    protected final LiveData<String> message = _message;

    protected final MutableLiveData<String> _toastMsg = new MutableLiveData<>();
    protected final LiveData<String> toastMsg = _toastMsg;


    protected MutableLiveData<State> _state = new MutableLiveData<>(null);

    protected State currentState() {
        return _state.getValue();
    }

    protected LiveData<State> state() {
        return _state;
    }

    protected void update(){
        _state.postValue(currentState());
    }

}
