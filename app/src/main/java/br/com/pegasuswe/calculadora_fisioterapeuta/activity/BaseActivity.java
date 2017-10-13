package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.app.Activity;
import android.content.Intent;
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
                    share(shareString);
                }
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
}
