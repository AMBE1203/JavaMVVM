package com.example.javamvvm.di;

import android.content.Context;

import androidx.room.Room;

import com.example.javamvvm.data.source.local.AppDatabase;
import com.example.javamvvm.data.source.local.LocalDataSource;
import com.example.javamvvm.data.source.local.dao.UserDao;
import com.example.javamvvm.utils.DefineConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@InstallIn(SingletonComponent.class)
@Module
public class DatabaseModule {
    @Provides
    @Singleton
    public AppDatabase provideMyAppDatabase(@ApplicationContext Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, DefineConstants.MY_APP_DATABASE).allowMainThreadQueries().build();
    }

    @Provides
    @Singleton
    public UserDao provideUserDao(AppDatabase database) {
        return database.userDao();
    }

//    @Singleton
//    @Provides
//    LocalDataSource provideLocalDataSource(
//            UserDao dao
//    ) {
//        return new LocalDataSource(dao);
//    }

}
