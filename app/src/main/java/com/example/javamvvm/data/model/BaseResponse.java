package com.example.javamvvm.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class BaseResponse<T> implements Parcelable {

    private int errorCode;
    private String errorMsg;

    private T data;


    public BaseResponse(int errorCode, String errorMsg, T data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    protected BaseResponse(Parcel in) {
        errorCode = in.readInt();
        errorMsg = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(errorCode);
        dest.writeString(errorMsg);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<BaseResponse> CREATOR = new Creator<BaseResponse>() {
        @Override
        public BaseResponse createFromParcel(Parcel in) {
            return new BaseResponse(in);
        }

        @Override
        public BaseResponse[] newArray(int size) {
            return new BaseResponse[size];
        }
    };

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
