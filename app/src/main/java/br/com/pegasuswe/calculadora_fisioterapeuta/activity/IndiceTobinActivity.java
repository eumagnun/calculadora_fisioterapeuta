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

public class IndiceTobinActivity extends BaseCalculoActivity {

    @BindView(R.id.etFrequenciaRespiratoria)
    EditText etFrequenciaRespiratoria;

    @BindView(R.id.etVolumeCorrenteL)
    EditText etVolumeCorrenteL;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indice_tobin);
        ButterKnife.bind(this);

        initADMob();
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etFrequenciaRespiratoria.getText().toString().equals("") ||
                etVolumeCorrenteL.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {

            String nomeCalculo = getString(R.string.irs);

            double frequenciaRespiratoria = Double.parseDouble(etFrequenciaRespiratoria.getText().toString());
            double volumeCorrenteL = Double.parseDouble(etVolumeCorrenteL.getText().toString());

            double result = (frequenciaRespiratoria / volumeCorrenteL);
            tvResult.setText(String.valueOf(result));

            shareString = nomeCalculo+" = "+String.valueOf(result);

            registrarCalculo(String.valueOf(result), nomeCalculo);
        }

    }

    private void initADMob(){
        MobileAds.initialize(this, "ca-app-pub-5007246500618998/5880660069");
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("889E178D15F2793ACAF1D4F866C416D9").build();

        mAdView.loadAd(adRequest);
    }
}
