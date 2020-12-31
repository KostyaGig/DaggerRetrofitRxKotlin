package com.kostya_ubutnu.daggerrxretrofit.remote;

import com.kostya_ubutnu.daggerrxretrofit.model.User;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface UserServiceApi {
    //С английского remote - удаленный(здесь используется название пакета remote(подразумевается удаленный,а именно сервер))

    @GET("/Users/2")
    Single<User> getUser();
}
