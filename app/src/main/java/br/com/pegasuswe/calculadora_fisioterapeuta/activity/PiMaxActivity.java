package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
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

public class PiMaxActivity extends BaseCalculoActivity {


    @BindView(R.id.scFem)
    SwitchCompat scFem;

    @BindView(R.id.scMasc)
    SwitchCompat scMasc;

    @BindView(R.id.etAge)
    EditText etAge;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @BindView(R.id.tvResult2)
    TextView tvResult2;

    @BindView(R.id.btCalc)
    Button btCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_max);

        ButterKnife.bind(this);
        scMasc.setChecked(true);

        initADMob();
    }


    @OnClick(R.id.scMasc)
    public void toggleMasc(View view) {
        if (scMasc.isChecked()) {
            scFem.setChecked(false);
        } else {
            scFem.setChecked(true);
        }
    }

    @OnClick(R.id.scFem)
    public void toggleFem(View view) {
        if (scFem.isChecked()) {
            scMasc.setChecked(false);
        } else {
            scMasc.setChecked(true);
        }
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {

        if (etAge.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {


            long age = etAge.getText().toString() == null || "".equals(etAge.getText().toString()) ? 0 : Long.parseLong(etAge.getText().toString());

            if (age < 20 || age > 80) {
                Toast.makeText(this, "A idade deve estar entre 20 e 80 anos", Toast.LENGTH_SHORT).show();
            } else {

                String nomeCalculo = getString(R.string.pimax);

                if (scMasc.isChecked()) {

                    Double r = -0.80 * age + 155.3;
                    String result = String.valueOf(Math.round(r));
                    tvResult.setText("Cálc Padrão="+result);



                    Double r2 = (-1.24 * age) + 232.37;
                    String result2 = String.valueOf(Math.round(r2));
                    tvResult2.setText("Cálc 2010="+result2);

                    registrarCalculo(tvResult.getText().toString()+"\n"+tvResult2.getText().toString(),nomeCalculo);

                    shareString = nomeCalculo+ "-Cálculo Padrão = " + String.valueOf(result);
                    shareString += "\n"+nomeCalculo+ "-Cálculo 2010 = " + String.valueOf(result2);



                } else if (scFem.isChecked()) {

                    Double r =  -0.49 * age + 110.4;
                    String result = String.valueOf(Math.round(r));
                    tvResult.setText("Cálc Padrão="+result);

                    Double r2 = (-0.46 * age) + 74.25;
                    String result2 = String.valueOf(Math.round(r2));
                    tvResult2.setText("Cálc 2010="+result2);

                    registrarCalculo(tvResult.getText().toString()+"\n"+tvResult2.getText().toString(),nomeCalculo);

                    shareString = nomeCalculo + "-Cálculo Padrão = " + String.valueOf(result);
                    shareString += "\n"+nomeCalculo+ "-Cálculo 2010 = " + String.valueOf(result2);
                }
            }
        }
    }


    private void initADMob(){
        MobileAds.initialize(this, "ca-app-pub-5007246500618998/5880660069");
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("889E178D15F2793ACAF1D4F866C416D9").build();

        mAdView.loadAd(adRequest);
    }
}
