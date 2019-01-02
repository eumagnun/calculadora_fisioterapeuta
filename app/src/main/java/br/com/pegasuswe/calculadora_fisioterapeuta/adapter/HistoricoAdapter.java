package br.com.pegasuswe.calculadora_fisioterapeuta.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.BaseActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.CapacidadeVitalActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.ComplacenciaDinamicaActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.ComplacenciaEstaticaActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.DrivePressureActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.Fio2DesejadaActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.FrequenciaRespiratoriaActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.GlasgowActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.IndiceIwiActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.IndiceOxigenacaoActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.IndiceTobinActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.Pco2Esperado;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.PeMaxActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.PesoPreDitoActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.PiMaxActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.ResistenciaSistemaPulmonarActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.model.Calculo;
import br.com.pegasuswe.calculadora_fisioterapeuta.utils.Formatador;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HistoricoAdapter extends RecyclerView.Adapter {

    private List<Calculo> list;
    private Context context;
    private Calculo currentItem;
    private static final int TYPE_ITEM = 1;

    public HistoricoAdapter(Context context, List<Calculo> list) {
        this.list = list;
        Collections.sort(this.list);
        this.context = context;
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final int positionWithHeader = position;

        if (holder instanceof ItemViewHolder) {
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            currentItem = list.get(positionWithHeader);

            itemViewHolder.tvDataCalculo.setText(Formatador.formatarDataHora(currentItem.getTime()));
            itemViewHolder.tvNomeCalculo.setText(currentItem.getCalculo());
            itemViewHolder.tvPaciente.setText(currentItem.getNomePaciente());
            itemViewHolder.tvValorCalculo.setText(currentItem.getResultado());
        }
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        if (list != null) {
            return list.size();
        }
        return 0;
    }


    private Calculo getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_historico, parent, false);
        return new ItemViewHolder(view);
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvNomeCalculo)
        TextView tvNomeCalculo;

        @BindView(R.id.tvPaciente)
        TextView tvPaciente;

        @BindView(R.id.tvValorCalculo)
        TextView tvValorCalculo;

        @BindView(R.id.tvDataCalculo)
        TextView tvDataCalculo;


        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
