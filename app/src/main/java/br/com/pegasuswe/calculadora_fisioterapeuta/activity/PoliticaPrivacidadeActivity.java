package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.webkit.WebView;
import android.widget.TextView;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;

public class PoliticaPrivacidadeActivity extends BaseActivity {


    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_politica_privacidade);

        webView = (WebView) findViewById(R.id.tvPolitica);

        webView.loadUrl("file:///android_asset/politica.html");
    }
}
