package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.adapter.CalcAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rcCalcItems)
    RecyclerView rcCalcItems;

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

        CalcAdapter calcAdapter = new CalcAdapter(this, listaFormulas);

        rcCalcItems.setAdapter(calcAdapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rcCalcItems.setLayoutManager(layout);

    }

}
