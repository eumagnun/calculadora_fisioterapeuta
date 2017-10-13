package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Binder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ComplacenciaEstaticaActivity extends AppCompatActivity {

    @BindView(R.id.etVolumeCorrent)
    EditText etVolumeCorrent;

    @BindView(R.id.etPEEP)
    EditText etPEEP;

    @BindView(R.id.etPlato)
    EditText etPlato;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complacencia_estatica);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etPlato.getText().toString().equals("") ||
                etPEEP.getText().toString().equals("") ||
                etVolumeCorrent.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {
            double plato = Double.parseDouble(etPlato.getText().toString());
            double PEEP = Double.parseDouble(etPEEP.getText().toString());
            double volumeCorrente = Double.parseDouble(etVolumeCorrent.getText().toString());

            double result = volumeCorrente / (plato - PEEP);
            tvResult.setText(String.valueOf(result));
        }

    }
}
