package br.com.pegasuswe.calculadora_fisioterapeuta.utils;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eumagnun on 15/10/2017.
 */

public class Formatador {


    public static String formatarDataHora(long time){
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy-HH:mm");
        return sdf.format(new Date(time));
    }


    public static String formatarMoeda(double valor){
        DecimalFormat df = new DecimalFormat("0.00");
        return  "R$ "+df.format(valor);
    }
}
