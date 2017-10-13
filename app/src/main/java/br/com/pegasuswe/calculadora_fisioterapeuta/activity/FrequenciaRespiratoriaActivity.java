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

public class FrequenciaRespiratoriaActivity extends BaseActivity {

    @BindView(R.id.etPaco2Conhecida)
    EditText etPaco2Conhecida;

    @BindView(R.id.etFrConhecida)
    EditText etFrConhecida;

    @BindView(R.id.etPaco2Desejada)
    EditText etPaco2Desejada;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frequencia_respiratoria);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etPaco2Conhecida.getText().toString().equals("") ||
                etPaco2Desejada.getText().toString().equals("") ||
                etFrConhecida.getText().toString().equals("")) {

            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            double paco2Conhecida = Double.parseDouble(etPaco2Conhecida.getText().toString());
            double fFrConhecida = Double.parseDouble(etFrConhecida.getText().toString());
            double paco2Desejada = Double.parseDouble(etPaco2Desejada.getText().toString());

            double result =(paco2Conhecida * fFrConhecida)/paco2Desejada;
            tvResult.setText(String.valueOf(result));

            shareString = getString(R.string.fr)+" = "+String.valueOf(result);
        }

    }
}
