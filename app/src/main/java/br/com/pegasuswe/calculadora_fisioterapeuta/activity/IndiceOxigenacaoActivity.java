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

public class IndiceOxigenacaoActivity extends BaseActivity {

    @BindView(R.id.etPao2)
    EditText etPao2;

    @BindView(R.id.etFio2)
    EditText etFio2;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indice_oxigenacao);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etFio2.getText().toString().equals("") ||
                etPao2.getText().toString().equals("")) {

            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            double fio2 = Double.parseDouble(etFio2.getText().toString());
            double pao2 = Double.parseDouble(etPao2.getText().toString());

            double result =(pao2/fio2);
            tvResult.setText(String.valueOf(result));
        }

    }
}
