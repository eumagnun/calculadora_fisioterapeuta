package br.com.danielamaral.listamusicaskaraoke.validation;


/**
 * Created by eumagnun on 17/08/2017.
 */

public class GenericTextValidation {

    public static String validate(String txt) {
        if(txt==null || "".equals(txt)) {
            return "Campo Obrigatório";
        }
        return null;
    }
}
