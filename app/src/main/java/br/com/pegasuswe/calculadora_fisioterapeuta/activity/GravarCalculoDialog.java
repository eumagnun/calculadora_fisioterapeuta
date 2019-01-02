package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.business.BaseBusiness;
import br.com.pegasuswe.calculadora_fisioterapeuta.business.HistoricoCalculoBusinessImpl;
import br.com.pegasuswe.calculadora_fisioterapeuta.model.Calculo;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.BusinessListener;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.ListenerMessage;
import br.com.pegasuswe.calculadora_fisioterapeuta.utils.Formatador;

public class GravarCalculoDialog extends Dialog implements BusinessListener {


    private BaseBusiness business;
    private Calculo calculo;

    public GravarCalculoDialog(Context context, Calculo calculo) {
        super(context);
        this.business = new HistoricoCalculoBusinessImpl(this);
        this.calculo = calculo;
    }

    public void showDialog() {
        final Dialog dialog = new Dialog(getContext(),R.style.Theme_AppCompat_DayNight_Dialog_Alert);
        dialog.setCancelable(true);
        dialog.setContentView(R.layout.dialog_gravar_calculo);

        TextView tvNomeCalculo = (TextView) dialog.findViewById(R.id.tvNomeCalculo);
        tvNomeCalculo.setText(calculo.getCalculo());
        TextView tvValorCalculo = (TextView) dialog.findViewById(R.id.tvValorCalculo);
        tvValorCalculo.setText(calculo.getResultado());

        TextView tvDataCalculo = (TextView) dialog.findViewById(R.id.tvDataCalculo);
        tvDataCalculo.setText(Formatador.formatarDataHora(calculo.getTime()));

        final EditText etNomePaciente = (EditText) dialog.findViewById(R.id.etNomePaciente);

        Button btSalvar = (Button) dialog.findViewById(R.id.btSalvar);
        btSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo.setNomePaciente(etNomePaciente.getText().toString());
                business.save(calculo);
                dialog.dismiss();
            }
        });


        Button btCancelar = (Button) dialog.findViewById(R.id.btCancelar);
        btCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();

    }

    @Override
    public void onBusinessEvent(ListenerMessage listenerMessage) {
        Toast.makeText(getContext(), listenerMessage.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
