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

public class Pco2Esperado extends BaseCalculoActivity {

    @BindView(R.id.etAcidoseMetabolica)
    EditText etAcidoseMetabolica;

    @BindView(R.id.etAlcaloseMetabolica)
    EditText etAlcaloseMetabolica;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResultAcidoseMetabolica)
    TextView tvResultAcidoseMetabolica;

    @BindView(R.id.tvResultAlcaloseMetabolica)
    TextView tvResultAlcaloseMetabolica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pco2_esperado);
        ButterKnife.bind(this);

        initADMob();
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etAcidoseMetabolica.getText().toString().equals("") ||
                etAlcaloseMetabolica.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {

            String nomeCalculo = getString(R.string.pco2_esperado);

            double acidoseMetabolica = Double.parseDouble(etAcidoseMetabolica.getText().toString());
            double alcaloseMetabolica = Double.parseDouble(etAlcaloseMetabolica.getText().toString());

            double resultAcidose = (acidoseMetabolica *1.5+8);
            double resultAlcalose = (alcaloseMetabolica*0.7+20);

            tvResultAcidoseMetabolica.setText(String.valueOf(resultAcidose));
            tvResultAlcaloseMetabolica.setText(String.valueOf(resultAlcalose));

            shareString = "PCO² Esperado\n"+"Acidose Metalólica = "+resultAcidose+"\nAlcalose Metabólica = "+resultAlcalose;

            registrarCalculo("Acidose Metalólica = "+resultAcidose+"\nAlcalose Metabólica = "+resultAlcalose, nomeCalculo);
        }

    }


    private void initADMob(){
        MobileAds.initialize(this, "ca-app-pub-5007246500618998/5880660069");
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("889E178D15F2793ACAF1D4F866C416D9").build();

        mAdView.loadAd(adRequest);
    }
}
