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

public class Fio2DesejadaActivity extends BaseActivity {

    @BindView(R.id.etPao2Desejada)
    EditText etPao2Desejada;

    @BindView(R.id.etFio2Conhecida)
    EditText etFio2Conhecida;

    @BindView(R.id.etPao2Conhecida)
    EditText etPao2Conhecida;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fio2_desejada);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etFio2Conhecida.getText().toString().equals("") ||
                etPao2Desejada.getText().toString().equals("") ||
                etPao2Conhecida.getText().toString().equals("")) {

            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            double fio2Conhecida = Double.parseDouble(etFio2Conhecida.getText().toString());
            double pao2Desejada = Double.parseDouble(etPao2Desejada.getText().toString());
            double pao2Conhecida = Double.parseDouble(etPao2Conhecida.getText().toString());

            double result =(pao2Desejada * fio2Conhecida)/pao2Conhecida;
            tvResult.setText(String.valueOf(result));

            shareString = getString(R.string.fio)+" = "+String.valueOf(result);
        }

    }
}
