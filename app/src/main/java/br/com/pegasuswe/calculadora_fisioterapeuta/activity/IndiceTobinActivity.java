package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

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

public class IndiceTobinActivity extends BaseActivity {

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
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etFrequenciaRespiratoria.getText().toString().equals("") ||
                etVolumeCorrenteL.getText().toString().equals("")) {

            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            double frequenciaRespiratoria = Double.parseDouble(etFrequenciaRespiratoria.getText().toString());
            double volumeCorrenteL = Double.parseDouble(etVolumeCorrenteL.getText().toString());

            double result = (frequenciaRespiratoria / volumeCorrenteL);
            tvResult.setText(String.valueOf(result));
        }

    }
}
