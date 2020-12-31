package com.kostya_ubutnu.daggerrxretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.kostya_ubutnu.daggerrxretrofit.viewmodel.MainViewModel;

import org.w3c.dom.Text;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {


    MainViewModel mainViewModel;

    @Inject
    ViewModelProvider.Factory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((App) getApplication()).getComponent().inject(this);
        setContentView(R.layout.activity_main);

        mainViewModel = ViewModelProviders.of(this,factory).get(MainViewModel.class);
        mainViewModel.getUserMutableLiveData().observe(this,user-> {
            String name = user.getName();
            String userName = user.getUserName();
            String address = user.getAddress().getCity();
            String phone = user.getPhone();
            String company = user.getCompany().getCatсhPhrase();

            TextView mainView = findViewById(R.id.t);
            mainView.setText(name + "\n" + userName + "\n" + address + "\n" + phone + "\n" + company + "\n");
        });
    }
}
