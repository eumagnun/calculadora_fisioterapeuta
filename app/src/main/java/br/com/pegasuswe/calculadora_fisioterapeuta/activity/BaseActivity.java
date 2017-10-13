package br.com.pegasuswe.calculadora_fisioterapeuta.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class BaseActivity extends AppCompatActivity {


    public void loadActivity(Activity context, Class activity) {
        Intent intent = new Intent(context, activity);
        context.startActivity(intent);
    }

    protected void validateEditText(ViewGroup group) {
        for (int i = 0, count = group.getChildCount(); i < count; ++i) {
            View view = group.getChildAt(i);
            if (view instanceof EditText) {
                if (
                        ((EditText) view) == null ||
                        ((EditText) view).getText().toString().equals("")) {

                    ((EditText) view).setText("Campo obrigatório");

                }
            }

            if (view instanceof ViewGroup && (((ViewGroup) view).getChildCount() > 0))
                validateEditText((ViewGroup) view);
        }

    }

}
