package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.support.design.widget.FloatingActionButton;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Date;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.model.Calculo;
import butterknife.BindView;
import butterknife.OnClick;

public class BaseCalculoActivity extends BaseActivity {

    @BindView(R.id.fabGravar)
    FloatingActionButton fabGravar;


    protected Calculo calculo;

    protected void registrarCalculo(String result, String nomeCalculo) {
        this.calculo = new Calculo(new Date().getTime(), "", nomeCalculo, result);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_telas_calculo, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_historico:
                loadActivity(this, HistoricoCalculosActivity.class);
                return true;
            default:
                break;
        }
        return false;
    }

    @OnClick(R.id.fabGravar)
    public void gravarCalculo() {
        if (calculo != null) {
            GravarCalculoDialog dialog = new GravarCalculoDialog(this, calculo);
            dialog.showDialog();
        } else {
            Toast.makeText(this, getString(R.string.msg_calculo_nao_efetuado), Toast.LENGTH_SHORT).show();
        }
    }
}
