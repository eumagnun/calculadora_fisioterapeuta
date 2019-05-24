package br.com.pegasuswe.calculadora_fisioterapeuta.dao;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.pegasuswe.calculadora_fisioterapeuta.observer.ListenerMessage;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.OperationTypeEnum;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.PersistListener;


/**
 * Created by eumagnun on 20/11/2017.
 */

public abstract class BaseDao {

    private static FirebaseDatabase database;

    public static DatabaseReference getDataBaseRef(String collection) {
        if (database == null) {
            database = FirebaseDatabase.getInstance();
            database.setPersistenceEnabled(true);
        }

        DatabaseReference collectionRef = database.getReference(collection);

        return collectionRef;
    }

    public abstract void save(final Object o, final PersistListener listener);

    public abstract void list(final Object o, final PersistListener listener);

    public abstract void get(final String idRegistro, final PersistListener listener);

    public void delete(String nomeColecao, final String idRegistro, final PersistListener listener) {
        getDataBaseRef(nomeColecao).child(FirebaseAuth.getInstance().getCurrentUser().getUid()).child(idRegistro).removeValue().addOnCompleteListener(
                new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        listener.onPersistEvent(
                                new ListenerMessage()
                                        .addId(OperationTypeEnum.DELETE)
                                        .addMessage("Registro Excluido!")
                        );

                    }
                }
        );
    }


}
