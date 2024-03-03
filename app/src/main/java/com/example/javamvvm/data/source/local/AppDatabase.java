package com.example.javamvvm.data.source.local;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.javamvvm.data.model.UserModel;
import com.example.javamvvm.data.source.local.dao.UserDao;

@Database(entities = {UserModel.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
