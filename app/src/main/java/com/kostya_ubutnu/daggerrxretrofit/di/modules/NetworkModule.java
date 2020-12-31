package com.kostya_ubutnu.daggerrxretrofit.di.modules;

import com.kostya_ubutnu.daggerrxretrofit.model.User;
import com.kostya_ubutnu.daggerrxretrofit.remote.UserServiceApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = ViewModelModule.class)
public abstract class NetworkModule {

    public static final String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Singleton
    @Provides
    static Retrofit provideRetrofit(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                //for rxjava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

    }

    @Singleton
    @Provides
    //Так делать можно (я имею в виду передавать в параметры нужные нам классы,ведь мы уже описали ранне класс Retrofit(см.выше))
    static UserServiceApi provideUserServiceApi(Retrofit retrofit){
        return retrofit.create(UserServiceApi.class);
    }
}
