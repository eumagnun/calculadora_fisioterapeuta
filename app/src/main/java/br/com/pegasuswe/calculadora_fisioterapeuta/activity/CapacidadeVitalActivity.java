package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CapacidadeVitalActivity extends BaseActivity {


    @BindView(R.id.scFem)
    SwitchCompat scFem;

    @BindView(R.id.scMasc)
    SwitchCompat scMasc;

    @BindView(R.id.etAge)
    EditText etAge;

    @BindView(R.id.etAltura)
    EditText etAltura;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @BindView(R.id.btCalc)
    Button btCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capacidade_vital);

        ButterKnife.bind(this);
        scMasc.setChecked(true);
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

            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {


            long age = etAge.getText().toString() == null || "".equals(etAge.getText().toString()) ? 0 : Long.parseLong(etAge.getText().toString());
            double altura= etAltura.getText().toString() == null || "".equals(etAltura.getText().toString()) ? 0 : Double.parseDouble(etAltura.getText().toString());

            if (scMasc.isChecked()) {

                Double r = (0.05211-0.022 * age - 3.60 * altura);
                String result = String.valueOf(Math.round(r));
                tvResult.setText(result);
                shareString = getString(R.string.capacidade_vital)+ " = " + String.valueOf(result);

            } else if (scFem.isChecked()) {

                Double r = (0.04111-0.018 * age - 2.69 * altura);
                String result = String.valueOf(Math.round(r));
                tvResult.setText(result);

                shareString = getString(R.string.capacidade_vital) + " = " + String.valueOf(result);
            }
        }
    }
}
