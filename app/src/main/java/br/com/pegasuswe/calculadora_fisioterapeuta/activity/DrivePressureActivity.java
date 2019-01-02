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

public class DrivePressureActivity extends BaseCalculoActivity {

    @BindView(R.id.etVolumeCorrente)
    EditText etVolumeCorrente;

    @BindView(R.id.etComplacenciaEstatica)
    EditText etComplacenciaEstatica;

    @BindView(R.id.etPressaoPlato)
    EditText etPressaoPlato;

    @BindView(R.id.etPeep)
    EditText etPeep;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @BindView(R.id.tvResult2)
    TextView tvResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_pressure);
        ButterKnife.bind(this);

        initADMob();
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etVolumeCorrente.getText().toString().equals("") ||
                etComplacenciaEstatica.getText().toString().equals("") ||
                etPressaoPlato.getText().toString().equals("") ||
                etPeep.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {

            String nomeCalculo = getString(R.string.drive_pressure);
            double volumeCorrente = Double.parseDouble(etVolumeCorrente.getText().toString());
            double complacenciaEstatica = Double.parseDouble(etComplacenciaEstatica.getText().toString());
            double pressaoPlato = Double.parseDouble(etPressaoPlato.getText().toString());
            double peep = Double.parseDouble(etPeep.getText().toString());

            double result = (volumeCorrente / complacenciaEstatica);
            String resultStr = " Cálculo A = " + String.valueOf(result);
            tvResult.setText(resultStr);


            double result2 = (pressaoPlato - peep);
            String resultStr2 = " Cálculo B = " + String.valueOf(result2);
            tvResult2.setText(resultStr2);

            registrarCalculo(resultStr + "\n" + resultStr2, nomeCalculo);

            shareString = getString(R.string.drive_pressure) + " Cálculo A = " + String.valueOf(result);
            shareString += "\n" + nomeCalculo + " Cálculo B = " + String.valueOf(result2);
        }

    }


    private void initADMob() {
        MobileAds.initialize(this, "ca-app-pub-5007246500618998/5880660069");
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("889E178D15F2793ACAF1D4F866C416D9").build();

        mAdView.loadAd(adRequest);
    }
}
