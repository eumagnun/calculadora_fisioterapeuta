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

public class PiMaxActivity extends BaseActivity {


    @BindView(R.id.scFem)
    SwitchCompat scFem;

    @BindView(R.id.scMasc)
    SwitchCompat scMasc;

    @BindView(R.id.etAge)
    EditText etAge;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @BindView(R.id.btCalc)
    Button btCalc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pi_max);

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

            if (age < 20 || age > 80) {
                Toast.makeText(this, "A idade deve estar entre 20 e 80 anos", Toast.LENGTH_SHORT).show();
            } else {
                if (scMasc.isChecked()) {

                    Double r = (-1.24 * age) + 232.37;
                    String result = String.valueOf(Math.round(r));
                    tvResult.setText(result);
                    shareString = getString(R.string.pimax) + " = " + String.valueOf(result);

                } else if (scFem.isChecked()) {

                    Double r = (-0.46 * age) + 74.25;
                    String result = String.valueOf(Math.round(r));
                    tvResult.setText(result);

                    shareString = getString(R.string.pimax) + " = " + String.valueOf(result);
                }
            }
        }
    }
}
