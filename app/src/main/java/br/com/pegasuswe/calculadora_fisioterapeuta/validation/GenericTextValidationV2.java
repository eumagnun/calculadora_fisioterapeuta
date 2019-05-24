package br.com.danielamaral.listamusicaskaraoke.validation;


import android.widget.EditText;

/**
 * Created by eumagnun on 17/08/2017.
 */

public class GenericTextValidationV2 {

    public static String validate(final EditText editText) {
        if (editText.getText() == null || "".equals(editText.getText())) {
            String message = "Campo Obrigatório";
            editText.setError(message);
            return message;
        }
        return null;
    }
}
