package com.example.javamvvm.data.source.local;

import com.example.javamvvm.data.model.UserModel;
import com.example.javamvvm.data.source.AppDataSource;
import com.example.javamvvm.data.source.local.dao.UserDao;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class LocalDataSource implements AppDataSource.Local {

    private final UserDao userDao;

    @Inject
    public LocalDataSource(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public void saveUserToDatabase(UserModel userModel) {
        userDao.insert(userModel);
    }
}
