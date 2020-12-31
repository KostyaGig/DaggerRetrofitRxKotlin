package com.kostya_ubutnu.daggerrxretrofit.di.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.kostya_ubutnu.daggerrxretrofit.di.ViewModelKey;
import com.kostya_ubutnu.daggerrxretrofit.viewmodel.MainViewModel;
import com.kostya_ubutnu.daggerrxretrofit.viewmodel.MainViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel.class)
    abstract ViewModel bindViewModel(MainViewModel userViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindFactory(MainViewModelFactory factory);
}
