package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import java.text.DecimalFormat;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class PesoPreDitoActivity extends BaseCalculoActivity {


    @BindView(R.id.scFem)
    SwitchCompat scFem;

    @BindView(R.id.scMasc)
    SwitchCompat scMasc;

    @BindView(R.id.etAltura)
    EditText etAltura;

    @BindView(R.id.etVolume)
    EditText etVolume;

    @BindView(R.id.btSelectVolume)
    Button btSelectetVolume;

    @BindView(R.id.tvResultPeso)
    TextView tvResultPeso;

    @BindView(R.id.tvResultVolume)
    TextView tvResultVolume;

    @BindView(R.id.btCalc)
    Button btCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_predito);

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

        if (etAltura.getText().toString().equals("") || etVolume.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {

            String nomeCalculo = getString(R.string.pesoPredito);

            long altura = etAltura.getText().toString() == null || "".equals(etAltura.getText().toString()) ? 0 : Long.parseLong(etAltura.getText().toString());
            double volume= etVolume.getText().toString() == null || "".equals(etVolume.getText().toString()) ? 0 : Double.parseDouble(etVolume.getText().toString());

            DecimalFormat f = new DecimalFormat("##.00");
            if (scMasc.isChecked()) {

                Double r = (50 +0.91 * (altura-152.40));

                String resultPeso =String.valueOf(r);
                tvResultPeso.setText(f.format(r));

                String resultVolume =f.format(r*volume);
                tvResultVolume.setText(f.format(r*volume));

                shareString = nomeCalculo+ " - "+getString(R.string.msg_peso_homem)  + resultPeso+ getString(R.string.msg_volume_homem)+resultVolume;

                registrarCalculo(getString(R.string.msg_peso_homem) + resultPeso+  getString(R.string.msg_volume_homem)+ resultVolume, nomeCalculo);

            } else if (scFem.isChecked()) {

                Double r = (45.50 +0.91 * (altura-152.40));

                String resultPeso =String.valueOf(r);
                tvResultPeso.setText(f.format(r));

                String resultVolume =f.format(r*volume);
                tvResultVolume.setText(f.format(r*volume));

                shareString = nomeCalculo+ " - "+getString(R.string.msg_peso_mulher)  + resultPeso+ getString(R.string.msg_volume_mulher)+resultVolume;

                registrarCalculo(getString(R.string.msg_peso_mulher) + resultPeso+  getString(R.string.msg_volume_mulher) +resultVolume, nomeCalculo);
            }
        }
    }

    @OnClick(R.id.btSelectVolume)
    public void selectVolume(View view) {
        final CharSequence[] items = {"4","5","6", "7", "8"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                etVolume.setText(items[item]);

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }



    private void initADMob(){
        MobileAds.initialize(this, "ca-app-pub-5007246500618998/5880660069");
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("889E178D15F2793ACAF1D4F866C416D9").build();

        mAdView.loadAd(adRequest);
    }

}
