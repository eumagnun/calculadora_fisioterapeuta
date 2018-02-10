package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;
import br.com.pegasuswe.calculadora_fisioterapeuta.activity.BaseActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoActivity extends BaseActivity {


    @BindView(R.id.ivRating)
    public ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        ButterKnife.bind(this);

        ImageView img = (ImageView)findViewById(R.id.ivRating);
        img.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://play.google.com/store/apps/details?id=br.com.pegasuswe.calculadora_fisioterapeuta&hl=pt_BR"));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        return true;
    }


}
