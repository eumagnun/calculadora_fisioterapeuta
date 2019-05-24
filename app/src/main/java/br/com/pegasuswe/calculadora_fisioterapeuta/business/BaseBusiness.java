package br.com.pegasuswe.calculadora_fisioterapeuta.business;


/**
 * Created by eumagnun on 20/11/2017.
 */

public interface BaseBusiness {

    public abstract void save(final Object o);

    public abstract void list(final Object o);

    public abstract void delete(final Object o, String nomeColecao, String idRegistro);
}
