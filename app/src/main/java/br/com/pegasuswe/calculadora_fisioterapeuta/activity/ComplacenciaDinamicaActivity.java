package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Binder;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import java.util.Date;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.model.Calculo;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComplacenciaDinamicaActivity extends BaseCalculoActivity {

    @BindView(R.id.etVolumeCorrent)
    EditText etVolumeCorrent;

    @BindView(R.id.etPEEP)
    EditText etPEEP;

    @BindView(R.id.etPico)
    EditText etPico;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complacencia_dinamica);
        ButterKnife.bind(this);

        initADMob();
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {

        String nomeCalculo = getString(R.string.cdp);
        if (etPico.getText().toString().equals("") ||
                etPEEP.getText().toString().equals("") ||
                etVolumeCorrent.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {
            double pico = Double.parseDouble(etPico.getText().toString());
            double PEEP = Double.parseDouble(etPEEP.getText().toString());
            double volumeCorrente = Double.parseDouble(etVolumeCorrent.getText().toString());

            double result = volumeCorrente / (pico - PEEP);
            tvResult.setText(String.valueOf(result));

            shareString = nomeCalculo + " = " + String.valueOf(result);

            registrarCalculo(String.valueOf(result), nomeCalculo);
        }

    }

    private void initADMob() {
        MobileAds.initialize(this, "ca-app-pub-5007246500618998/5880660069");
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("889E178D15F2793ACAF1D4F866C416D9").build();

        mAdView.loadAd(adRequest);
    }

}
