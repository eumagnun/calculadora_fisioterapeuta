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

public class DrivePressureActivity extends BaseActivity {

    @BindView(R.id.etVolumeCorrente)
    EditText etVolumeCorrente;

    @BindView(R.id.etComplacenciaEstatica)
    EditText etComplacenciaEstatica;

    @BindView(R.id.etPressaoPlato)
    EditText etPressaoPlato;

    @BindView(R.id.etPeep)
    EditText etPeep;

    @BindView(R.id.btCalc)
    Button btCalc;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @BindView(R.id.tvResult2)
    TextView tvResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_pressure);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btCalc)
    public void calc(View view) {
        if (etVolumeCorrente.getText().toString().equals("") ||
                etComplacenciaEstatica.getText().toString().equals("") ||
                etPressaoPlato.getText().toString().equals("") ||
                etPeep.getText().toString().equals("")) {

            Toast.makeText(this, "Todos os campos são obrigatórios!", Toast.LENGTH_SHORT).show();
        } else {
            double volumeCorrente = Double.parseDouble(etVolumeCorrente.getText().toString());
            double complacenciaEstatica = Double.parseDouble(etComplacenciaEstatica.getText().toString());
            double pressaoPlato = Double.parseDouble(etPressaoPlato.getText().toString());
            double peep = Double.parseDouble(etPeep.getText().toString());

            double result =(volumeCorrente/complacenciaEstatica);
            tvResult.setText(" Cálculo A = "+String.valueOf(result));


            double result2 =(pressaoPlato-peep);
            tvResult2.setText(" Cálculo B = "+String.valueOf(result2));


            shareString = getString(R.string.drive_pressure)+" Cálculo A = "+String.valueOf(result);

            shareString += "\n"+getString(R.string.drive_pressure)+" Cálculo B = "+String.valueOf(result2);
        }

    }
}
