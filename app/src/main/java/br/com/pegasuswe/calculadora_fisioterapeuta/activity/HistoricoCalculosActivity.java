package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.adapter.HistoricoAdapter;
import br.com.pegasuswe.calculadora_fisioterapeuta.business.BaseBusiness;
import br.com.pegasuswe.calculadora_fisioterapeuta.business.HistoricoCalculoBusinessImpl;
import br.com.pegasuswe.calculadora_fisioterapeuta.model.Calculo;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.AdapterItemListener;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.BusinessListener;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.ListenerMessage;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.OperationTypeEnum;
import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoricoCalculosActivity extends BaseActivity implements BusinessListener, AdapterItemListener {

    @BindView(R.id.rvItens)
    RecyclerView rvItens;

    @Nullable
    @BindView(R.id.llNaoLogado)
    public LinearLayout llNaoLogado;

    private List<Calculo> listaRegistros = new ArrayList<Calculo>();

    private BaseBusiness business;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico_calculos);

        ButterKnife.bind(this);

        business = new HistoricoCalculoBusinessImpl(this);

        Calculo calculo = new Calculo();

        business.list(calculo);

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            showProgressDialog();
        }

        logadoOuNaoLogado();

        setTitle(R.string.historico);
    }


    @Override
    public void onResume() {

        logadoOuNaoLogado();

        super.onResume();
    }

    private void logadoOuNaoLogado() {
        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            llNaoLogado.setVisibility(View.VISIBLE);
        } else {
            llNaoLogado.setVisibility(View.GONE);
        }
    }

    private void loadListView(List<Calculo> musicas) {
        HistoricoAdapter adapter = new HistoricoAdapter(this,listaRegistros);
        rvItens.setAdapter(adapter);
        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvItens.setLayoutManager(layout);

    }

    private void updateRecyclerView(ListenerMessage listenerMessage) {
        if (listenerMessage.getOperationType() == OperationTypeEnum.LIST) {

            listaRegistros = (List<Calculo>) listenerMessage.getObject();

            if (listaRegistros != null) {
                loadListView(listaRegistros);

            }
        }
        hideProgressDialog();
    }

    @Override
    public void onAdapterEvent(ListenerMessage message) {

    }

    @Override
    public void onBusinessEvent(ListenerMessage listenerMessage) {
        if (listenerMessage != null && listenerMessage.getOperationType() == OperationTypeEnum.LIST) {
            updateRecyclerView(listenerMessage);
        }
    }
}
