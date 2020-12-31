package com.kostya_ubutnu.daggerrxretrofit.repository;

import com.kostya_ubutnu.daggerrxretrofit.model.User;
import com.kostya_ubutnu.daggerrxretrofit.remote.UserServiceApi;

import javax.inject.Inject;

import io.reactivex.Single;

public class MainRepository {

    private UserServiceApi userServiceApi;

    @Inject
    public MainRepository(UserServiceApi userServiceApi) {
        this.userServiceApi = userServiceApi;
    }

    public Single<User> getUser(){
        return userServiceApi.getUser();
    }

}
