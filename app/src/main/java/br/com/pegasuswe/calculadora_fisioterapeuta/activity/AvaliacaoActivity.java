package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AvaliacaoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_avaliacao);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btAvaliarDepois)
    public void avaliarDepois(View view){
        loadActivity(this, MainActivity.class);
    }


    @OnClick(R.id.btNaoAvaliar)
    public void naoAvaliar(View view){
        super.marcarMensagemComoLida();
        loadActivity(this, MainActivity.class);
    }

    @OnClick(R.id.ivAvaliar)
    public void avaliar(View view){

        super.marcarMensagemComoLida();

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=br.com.pegasuswe.calculadora_fisioterapeuta&hl=pt_BR"));
        startActivity(intent);
    }
}
