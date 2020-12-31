package com.kostya_ubutnu.daggerrxretrofit.di.components;

import com.kostya_ubutnu.daggerrxretrofit.MainActivity;
import com.kostya_ubutnu.daggerrxretrofit.di.modules.ContextModule;
import com.kostya_ubutnu.daggerrxretrofit.di.modules.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, ContextModule.class})
public interface MainComponent {

    void inject(MainActivity mainActivity);

}
