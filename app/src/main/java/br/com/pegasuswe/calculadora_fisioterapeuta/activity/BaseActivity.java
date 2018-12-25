package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import br.com.pegasuswe.calculadora_fisioterapeuta.R;

public class BaseActivity extends AppCompatActivity {

    protected String shareString = "";

    public void loadActivity(Activity context, Class activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        shareString = "";
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_share:
                if (!shareString.equals("")) {
                    shareString += "\n\n https://play.google.com/store/apps/details?id=br.com.pegasuswe.calculadora_fisioterapeuta";
                    share(shareString);
                }
                return true;
            case R.id.action_info:
                loadActivity(this, InfoActivity.class);
                return true;
            default:
                break;
        }
        return false;
    }


    protected void share(String text) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }


    protected boolean isMensagemJaLida(){

        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        int isMensagemJaLida = sharedPref.getInt(getString(R.string.param_msg_ja_lida), 0);
        return isMensagemJaLida >0;
    }

    protected void marcarMensagemComoLida(){
        Context context = this;
        SharedPreferences sharedPref = context.getSharedPreferences(
                getString(R.string.preference_file_key), Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(getString(R.string.param_msg_ja_lida), 1);

        editor.commit();
    }
}
