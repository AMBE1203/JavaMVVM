package com.example.javamvvm.data.source.local;

import static com.example.javamvvm.utils.DefineConstants.MY_SHARE_PREFERENCE;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreferences {
    private final Context mContext;

    public MySharePreferences(Context context) {
        this.mContext = context;
    }

    public void putBooleanValue(String key, boolean value) {
        SharedPreferences sharePreferences = mContext.getSharedPreferences(MY_SHARE_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBooleanValue(String key) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARE_PREFERENCE, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public void putStringValue(String key, String value) {
        SharedPreferences sharePreferences = mContext.getSharedPreferences(MY_SHARE_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharePreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getStringValue(String key) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARE_PREFERENCE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }
}
