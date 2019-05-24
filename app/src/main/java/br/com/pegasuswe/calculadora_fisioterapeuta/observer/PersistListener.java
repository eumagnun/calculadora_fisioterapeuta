package br.com.pegasuswe.calculadora_fisioterapeuta.observer;

/**
 * Created by eumagnun on 20/11/2017.
 */

public interface PersistListener {
    public static final String PARAMETER_MESSAGE = "PARAMETER_MESSAGE";
    public static final String PARAMETER_OPERATION = "PARAMETER_OPERATION";
    public static final String PARAMETER_OBJECT = "PARAMETER_OBJECT";

    public void onPersistEvent(ListenerMessage listenerMessage);
}
