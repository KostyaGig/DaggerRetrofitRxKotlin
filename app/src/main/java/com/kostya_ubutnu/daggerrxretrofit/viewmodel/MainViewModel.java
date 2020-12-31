package com.kostya_ubutnu.daggerrxretrofit.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kostya_ubutnu.daggerrxretrofit.model.User;
import com.kostya_ubutnu.daggerrxretrofit.repository.MainRepository;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {

    private MainRepository repository;
    private CompositeDisposable disposable = new CompositeDisposable();
    private MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();

    @Inject
    public MainViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<User> getUserMutableLiveData() {
        loadData();
        return userMutableLiveData;
    }

    private void loadData(){
        disposable.add(
                repository.getUser().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableSingleObserver<User>() {
                    @Override
                    public void onSuccess(User user) {
                        getUserMutableLiveData().setValue(user);
                    }

                    @Override
                 public void onError(Throwable e) {

                    }
                })
        );
    }
}
