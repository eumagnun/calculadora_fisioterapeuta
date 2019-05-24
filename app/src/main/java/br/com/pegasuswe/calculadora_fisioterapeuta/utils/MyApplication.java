package br.com.pegasuswe.calculadora_fisioterapeuta.utils;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;

import static com.firebase.ui.auth.AuthUI.getApplicationContext;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-5007246500618998/5880660069");
    }
}
