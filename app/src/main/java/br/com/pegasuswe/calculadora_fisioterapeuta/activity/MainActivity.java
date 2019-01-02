package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.widget.ImageView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.adapter.CalcAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rcCalcItems)
    RecyclerView rcCalcItems;

    private FirebaseAnalytics mFirebaseAnalytics;
    private Menu menu;
    private ImageView foto;

    private FirebaseUser user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<String> listaFormulas = new ArrayList<>();
        listaFormulas.add(getString(R.string.glasgow));
        listaFormulas.add(getString(R.string.pimax));
        listaFormulas.add(getString(R.string.pemax));
        listaFormulas.add(getString(R.string.cep));
        listaFormulas.add(getString(R.string.cdp));
        listaFormulas.add(getString(R.string.rsp));
        listaFormulas.add(getString(R.string.io));
        listaFormulas.add(getString(R.string.fio));
        listaFormulas.add(getString(R.string.fr));
        listaFormulas.add(getString(R.string.irs));
        listaFormulas.add(getString(R.string.capacidade_vital));
        listaFormulas.add(getString(R.string.pesoPredito));
        listaFormulas.add(getString(R.string.pco2_esperado));
        listaFormulas.add(getString(R.string.drive_pressure));
        listaFormulas.add(getString(R.string.iwi));


        CalcAdapter calcAdapter = new CalcAdapter(this, listaFormulas);

        rcCalcItems.setAdapter(calcAdapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcCalcItems.setLayoutManager(layout);

        initADMob();

        user = FirebaseAuth.getInstance().getCurrentUser();

        foto = new ImageView(this);

    }


    @Override
    protected void onResume() {
        super.onResume();

        atualizarFotoUsuario(menu);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal_topo, menu);

        this.menu = menu;

        atualizarFotoUsuario(menu);

        return true;
    }

    private void atualizarFotoUsuario(Menu menu) {
        final Menu m = menu;

        if (user != null && m !=null) {
            Picasso.with(this)
                    .load(user.getPhotoUrl())
                    .into(foto, new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {

                            Bitmap imageBitmap = ((BitmapDrawable) foto.getDrawable()).getBitmap();
                            RoundedBitmapDrawable imageDrawable = RoundedBitmapDrawableFactory.create(getResources(), imageBitmap);
                            imageDrawable.setCircular(true);
                            imageDrawable.setCornerRadius(Math.max(imageBitmap.getWidth(), imageBitmap.getHeight()) / 2.0f);
                            foto.setImageDrawable(imageDrawable);

                            m.getItem(0).setIcon(foto.getDrawable());
                        }

                        @Override
                        public void onError() {
                            m.getItem(0).setIcon(R.drawable.ic_usuario);
                        }
                    });
        }
    }

    private void initADMob() {
        MobileAds.initialize(this, getString(R.string.codigo_admob));
        mAdView = findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder().addTestDevice(getString(R.string.codigo_dispositivo_teste_admob)).build();

        mAdView.loadAd(adRequest);

        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
    }
}
