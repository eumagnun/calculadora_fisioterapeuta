package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Bundle;
import android.view.WindowManager;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        // Set the status bar to dark-semi-transparentish
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);


        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {

                    if(isMensagemJaLida()){
                        loadActivity(SplashActivity.this, MainActivity.class);
                    }else {
                        loadActivity(SplashActivity.this, AvaliacaoActivity.class);
                    }
                }
            }
        };
        timerThread.start();

    }
}