package br.com.pegasuswe.calculadora_fisioterapeuta.observer;

/**
 * Created by eumagnun on 21/11/2017.
 */

public enum OperationTypeEnum {


    SAVE(1), UPDATE(2), DELETE(3), LIST(4), GET(5), CLICK(6), SIGNUP(7), SIGNIN(7), SIGNOUT(9);

    private final int operationType;

    OperationTypeEnum(int operationType) {
        this.operationType = operationType;
    }

    public int getOperationType() {
        return operationType;

    }
}
