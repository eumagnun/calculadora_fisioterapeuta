package br.com.pegasuswe.calculadora_fisioterapeuta.observer;

import br.com.pegasuswe.calculadora_fisioterapeuta.observer.ListenerMessage;

/**
 * Created by eumagnun on 20/11/2017.
 */

public interface BusinessListener {

    public void onBusinessEvent(ListenerMessage listenerMessage);
}
