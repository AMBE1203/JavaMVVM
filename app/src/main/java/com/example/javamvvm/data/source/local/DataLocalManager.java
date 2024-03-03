package com.example.javamvvm.data.source.local;

import android.content.Context;

public class DataLocalManager {
    private static DataLocalManager instance;
    private MySharePreferences mySharePreferences;

    public static void init(Context context) {
        instance = new DataLocalManager();
        instance.mySharePreferences = new MySharePreferences(context);

    }

    public static DataLocalManager getInstance() {
        if (instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setAccessToken(String token) {
        DataLocalManager.getInstance().mySharePreferences.putStringValue("accessToken", token);
    }

    public static String getAccessToken() {
        return DataLocalManager.getInstance().mySharePreferences.getStringValue("accessToken");
    }

}
