package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IndiceOxigenacaoActivity extends BaseCalculoActivity {

    @BindView(R.id.etPao2)
    EditText etPao2;

    @BindView(R.id.etFio2)
    EditText etFio2;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indice_oxigenacao);
        ButterKnife.bind(this);

        initADMob();
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etFio2.getText().toString().equals("") ||
                etPao2.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {

            String nomeCalculo = getString(R.string.io);

            double fio2 = Double.parseDouble(etFio2.getText().toString());
            double pao2 = Double.parseDouble(etPao2.getText().toString());

            double result =(pao2/fio2);
            tvResult.setText(String.valueOf(result));

            shareString = nomeCalculo+" = "+String.valueOf(result);

            registrarCalculo(String.valueOf(result), nomeCalculo);
        }

    }


    private void initADMob(){
        
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("889E178D15F2793ACAF1D4F866C416D9").build();

        mAdView.loadAd(adRequest);
    }
}
