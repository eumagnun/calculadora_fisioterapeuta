package br.com.pegasuswe.calculadora_fisioterapeuta.business;

import br.com.pegasuswe.calculadora_fisioterapeuta.dao.HistoricoCalculoDaoImpl;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.BusinessListener;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.ListenerMessage;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.PersistListener;


/**
 * Created by eumagnun on 20/11/2017.
 */

public class HistoricoCalculoBusinessImpl implements BaseBusiness, PersistListener {

    private HistoricoCalculoDaoImpl dao;
    private BusinessListener listener;

    public HistoricoCalculoBusinessImpl(BusinessListener listener) {
        this.dao = new HistoricoCalculoDaoImpl();
        this.listener = listener;
    }

    @Override
    public void save(Object o) {
        dao.save(o, this);
    }

    @Override
    public void list(Object o) {
        dao.list(o, this);
    }

    @Override
    public void delete(Object o, String nomeColecao, String idRegistro) {
        dao.delete(nomeColecao, idRegistro, this);
    }

    @Override
    public void onPersistEvent(ListenerMessage listenerMessage) {
        listener.onBusinessEvent(listenerMessage);
    }


}
