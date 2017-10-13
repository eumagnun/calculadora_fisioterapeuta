package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Binder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComplacenciaDinamicaActivity extends BaseActivity {

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
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etPico.getText().toString().equals("") ||
                etPEEP.getText().toString().equals("") ||
                etVolumeCorrent.getText().toString().equals("")) {

            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            double pico = Double.parseDouble(etPico.getText().toString());
            double PEEP = Double.parseDouble(etPEEP.getText().toString());
            double volumeCorrente = Double.parseDouble(etVolumeCorrent.getText().toString());

            double result = volumeCorrente / (pico - PEEP);
            tvResult.setText(String.valueOf(result));

            shareString = getString(R.string.cdp)+" = "+String.valueOf(result);
        }

    }
}
