package com.kostya_ubutnu.daggerrxretrofit.di.modules;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class ContextModule {

    private final Context context;

    public ContextModule(Context context) {
        this.context = context;
    }

    //Так можно прокинуть контекст
    @Binds
    abstract Context bindContext(Application application);

}
