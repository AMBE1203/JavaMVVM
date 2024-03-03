package com.example.javamvvm.data.source.local.dao;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.javamvvm.data.model.UserModel;

import java.util.ArrayList;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public Long insert(UserModel userModel);

    @Query("SELECT * FROM User")
    public UserModel[] loadAll();

}
