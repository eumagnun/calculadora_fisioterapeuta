package br.com.pegasuswe.calculadora_fisioterapeuta.utils;

import android.view.View;

/**
 * Created by eumagnun on 07/01/2018.
 */

public class ViewCommonFunctions {

    public static void toggleItemVisibility(View view) {
        if (view.getVisibility() == View.GONE) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }

}
