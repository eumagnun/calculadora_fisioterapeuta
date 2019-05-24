package br.com.pegasuswe.calculadora_fisioterapeuta.observer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by eumagnun on 20/11/2017.
 */

public class ListenerMessage {
    private OperationTypeEnum operationType;
    private String message = "";
    private int uiComponentId;
    private Object object;
    private Map<String, Object> extras;

    public ListenerMessage addId(OperationTypeEnum id) {
        this.operationType = id;
        return this;
    }

    public ListenerMessage addMessage(String message) {
        this.message = message;
        return this;
    }

    public ListenerMessage addUiComponentId(int uiComponentId) {
        this.uiComponentId = uiComponentId;
        return this;
    }

    public ListenerMessage addObject(Object object) {
        this.object = object;
        return this;
    }

    public ListenerMessage addExtras(HashMap<String, Object> extras) {
        this.extras = extras;
        return this;
    }

    public OperationTypeEnum getOperationType() {
        return operationType;
    }

    public String getMessage() {
        return message;
    }

    public Object getObject() {
        return object;
    }

    public Map<String, Object> getExtras() {
        return extras;
    }

    public int getUiComponentId() {
        return uiComponentId;
    }
}
