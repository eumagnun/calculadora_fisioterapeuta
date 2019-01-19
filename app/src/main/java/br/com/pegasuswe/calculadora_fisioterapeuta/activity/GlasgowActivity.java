package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GlasgowActivity extends BaseCalculoActivity {

    @BindView(R.id.etAberturaOcular)
    EditText etAberturaOcular;

    @BindView(R.id.btSelectetAberturaOcular)
    Button btSelectetAberturaOcular;

    @BindView(R.id.etRespostaVerbal)
    EditText etRespostaVerbal;

    @BindView(R.id.btSelectetRespostaVerbal)
    Button btSelectetRespostaVerbal;

    @BindView(R.id.etRespostaMotora)
    EditText etRespostaMotora;

    @BindView(R.id.btSelecteRepostaMotora)
    Button btSelectetRespostaMotora;

    @BindView(R.id.tvResult)
    TextView tvResult;

    @BindView(R.id.btCalc)
    Button btCalc;

    private int aberturaOcularScore = 0;
    private int respostaVerbalScore = 0;
    private int respostaMotoraScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glasgow);
        ButterKnife.bind(this);

        initADMob();
    }

    @OnClick(R.id.btSelectetAberturaOcular)
    public void selectetAberturaOcular(View view) {
        final CharSequence[] items = {getString(R.string.msg_glasgow_abertura_ocular_espontanea), getString(R.string.msg_glasgow_abertura_ocular_voz), getString(R.string.msg_glasgow_abertura_ocular_dor), getString(R.string.msg_glasgow_abertura_ocular_nenhuma)};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.msg_selecione);
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                etAberturaOcular.setText(items[item]);

                switch (item) {
                    case 0:
                        aberturaOcularScore = 4;
                        break;
                    case 1:
                        aberturaOcularScore = 3;
                        break;
                    case 2:
                        aberturaOcularScore = 2;
                        break;
                    case 3:
                        aberturaOcularScore = 1;
                        break;
                }

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @OnClick(R.id.btSelectetRespostaVerbal)
    public void selectetRespostaVerbal(View view) {
        final CharSequence[] items = {getString(R.string.msg_glasgow_resp_verbal_orientada), getString(R.string.msg_glasgow_resp_verbal_confusa), getString(R.string.msg_glasgow_resp_verbal_palavras_inapropriadas), getString(R.string.msg_glasgow_resp_verbal_palavras_incompreensivas), getString(R.string.msg_glasgow_resp_verbal_nenhuma)};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(getString(R.string.msg_selecione));
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                etRespostaVerbal.setText(items[item]);


                switch (item) {
                    case 0:
                        respostaVerbalScore = 5;
                        break;
                    case 1:
                        respostaVerbalScore = 4;
                        break;
                    case 2:
                        respostaVerbalScore = 3;
                        break;
                    case 3:
                        respostaVerbalScore = 2;
                        break;
                    case 4:
                        respostaVerbalScore = 1;
                        break;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @OnClick(R.id.btSelecteRepostaMotora)
    public void selectRespostaMotora(View view) {
        final CharSequence[] items = {getString(R.string.ObedeceComandos), getString(R.string.LocalizaDor), getString(R.string.MovimentoRetirada), getString(R.string.FlexaoAnormal), getString(R.string.ExtensaoAnormal), getString(R.string.Nenhuma)};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Selecione");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                etRespostaMotora.setText(items[item]);

                switch (item) {
                    case 0:
                        respostaMotoraScore = 6;
                        break;
                    case 1:
                        respostaMotoraScore = 5;
                        break;
                    case 2:
                        respostaMotoraScore = 4;
                        break;
                    case 3:
                        respostaMotoraScore = 3;
                        break;
                    case 4:
                        respostaMotoraScore = 2;
                        break;
                    case 5:
                        respostaMotoraScore = 1;
                        break;
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @OnClick(R.id.btCalc)
    public void calc(View view){

        if (etRespostaVerbal.getText().toString().equals("") ||
                etRespostaMotora.getText().toString().equals("") ||
                etAberturaOcular.getText().toString().equals("")) {

            Toast.makeText(this, R.string.campos_obrigatorios, Toast.LENGTH_SHORT).show();
        } else {

            String nomeCalculo = getString(R.string.glasgow);
            int result = aberturaOcularScore + respostaMotoraScore + respostaVerbalScore;
            tvResult.setText(String.valueOf(result));

            shareString = getString(R.string.glasgow)+" = "+String.valueOf(result);

            registrarCalculo(String.valueOf(result), nomeCalculo);
        }
    }

    private void initADMob(){
        MobileAds.initialize(this, "ca-app-pub-5007246500618998/5880660069");
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice("889E178D15F2793ACAF1D4F866C416D9").build();

        mAdView.loadAd(adRequest);
    }
}
