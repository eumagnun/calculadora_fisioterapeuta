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

import br.com.pegasuswe.calculadora_fisioterapeuta.activity.CapacidadeVitalActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.ComplacenciaDinamicaActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.ComplacenciaEstaticaActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.BaseActivity;
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
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CalcAdapter extends RecyclerView.Adapter {

    private List<String> list;
    private Context context;
    private String currentItem;
    private static final int TYPE_ITEM = 1;

    public CalcAdapter(Context context, List<String> list) {
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
            itemViewHolder.tvCalcName.setText(currentItem);
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


    private String getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getItemViewType(int position) {
        return TYPE_ITEM;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_calc, parent, false);
        return new ItemViewHolder(view);
    }


    public class ItemViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tvCalcName)
        TextView tvCalcName;


        public ItemViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

        @OnClick(R.id.cvStringItemRoot)
        public void showCalc(View view) {

            if(tvCalcName.getText().toString().equals(context.getString(R.string.pimax))) {
                ((BaseActivity) context).loadActivity(((BaseActivity) context), PiMaxActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.glasgow))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), GlasgowActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.pemax))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), PeMaxActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.cdp))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), ComplacenciaDinamicaActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.cep))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), ComplacenciaEstaticaActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.rsp))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), ResistenciaSistemaPulmonarActivity.class);


            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.io))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), IndiceOxigenacaoActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.fio))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), Fio2DesejadaActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.irs))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), IndiceTobinActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.capacidade_vital))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), CapacidadeVitalActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.fr))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), FrequenciaRespiratoriaActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.pesoPredito))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), PesoPreDitoActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.pco2_esperado))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), Pco2Esperado.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.drive_pressure))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), DrivePressureActivity.class);

            }else if(tvCalcName.getText().toString().equals(context.getString(R.string.iwi))){
                ((BaseActivity) context).loadActivity(((BaseActivity) context), IndiceIwiActivity.class);

            }else{
                Toast.makeText(context, "Em desenvolvimento", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
