package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.support.v7.app.AppCompatActivity;
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
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PeMaxActivity extends BaseCalculoActivity {


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
        setContentView(R.layout.activity_pe_max);

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

            if(age < 20 || age > 80) {
                Toast.makeText(this, getString(R.string.msg_intervalo_idade), Toast.LENGTH_SHORT).show();
            }else{

                String nomeCalculo = getString(R.string.pemax);

                if (scMasc.isChecked()) {

                    Double r = (165.4-0.81 * age);
                    String result = String.valueOf(Math.round(r));
                    tvResult.setText("Cálc Padrão="+result);


                    Double r2 = (-1.26 * age + 183.31);
                    String result2 = String.valueOf(Math.round(r2));
                    tvResult2.setText("Cálc 2010="+result2);


                    registrarCalculo(tvResult.getText().toString()+"\n"+tvResult2.getText().toString(), nomeCalculo);

                    shareString = getString(R.string.pemax) + getString(R.string.msg_calculo_padrao) + String.valueOf(result);
                    shareString += "\n"+getString(R.string.pemax) + getString(R.string.msg_calculo_2010) + String.valueOf(result2);

                } else if (scFem.isChecked()) {

                    Double r = (115.6-0.61 * age);
                    String result = String.valueOf(Math.round(r));
                    tvResult.setText("Cálc Padrão="+result);

                    Double r2 = (-0.68 * age + 119.35);
                    String result2 = String.valueOf(Math.round(r2));
                    tvResult2.setText("Cálc 2010="+result2);

                    registrarCalculo(tvResult.getText().toString()+"\n"+tvResult2.getText().toString(), nomeCalculo);

                    shareString = getString(R.string.pemax) + getString(R.string.msg_calculo_padrao) + String.valueOf(result);
                    shareString += "\n"+getString(R.string.pemax) + getString(R.string.msg_calculo_2010)  + String.valueOf(result2);
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
