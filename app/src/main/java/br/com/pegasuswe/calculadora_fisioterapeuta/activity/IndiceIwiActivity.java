package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import java.math.BigDecimal;
import java.math.MathContext;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IndiceIwiActivity extends BaseActivity {

    @BindView(R.id.etComplacenciaEstatica)
    EditText etComplacenciaEstatica;

    @BindView(R.id.etSAO2)
    EditText etSAO2;

    @BindView(R.id.etTobin)
    EditText etTobin;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iwi);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etTobin.getText().toString().equals("") ||
                etSAO2.getText().toString().equals("") ||
                etComplacenciaEstatica.getText().toString().equals("")) {

            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            double complacenciaEstatica = Double.parseDouble(etComplacenciaEstatica.getText().toString());
            double sao2 = Double.parseDouble(etSAO2.getText().toString());
            double tobin = Double.parseDouble(etTobin.getText().toString());

            double result = (complacenciaEstatica * sao2)/ tobin;

            BigDecimal r = new BigDecimal(result);
            tvResult.setText(String.valueOf(r.round(MathContext.DECIMAL32) ));

            shareString = getString(R.string.cdp)+" = "+String.valueOf(result);
        }

    }
}
