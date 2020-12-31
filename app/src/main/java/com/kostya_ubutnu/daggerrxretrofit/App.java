package com.kostya_ubutnu.daggerrxretrofit;

import android.app.Application;

import com.kostya_ubutnu.daggerrxretrofit.di.components.DaggerMainComponent;
import com.kostya_ubutnu.daggerrxretrofit.di.components.MainComponent;

public class App extends Application {

    public MainComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMainComponent.create();
    }

    public  MainComponent getComponent(){
        return component;
    }
}
