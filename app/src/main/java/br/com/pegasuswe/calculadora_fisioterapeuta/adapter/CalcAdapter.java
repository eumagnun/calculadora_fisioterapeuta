package br.com.pegasuswe.calculadora_fisioterapeuta.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.pegasuswe.calculadora_fisioterapeuta.activity.ComplacenciaDinamicaActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.ComplacenciaEstaticaActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.BaseActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.GlasgowActivity;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.PeMaxActivity;
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


            }else{
                Toast.makeText(context, "Em desenvolvimento", Toast.LENGTH_SHORT).show();
            }

        }

    }
}
