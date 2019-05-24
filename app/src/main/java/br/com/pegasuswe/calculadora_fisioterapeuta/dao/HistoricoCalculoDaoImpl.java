package br.com.pegasuswe.calculadora_fisioterapeuta.dao;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import br.com.pegasuswe.calculadora_fisioterapeuta.model.Calculo;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.ListenerMessage;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.OperationTypeEnum;
import br.com.pegasuswe.calculadora_fisioterapeuta.observer.PersistListener;
import br.com.pegasuswe.calculadora_fisioterapeuta.utils.Constantes;


/**
 * Created by eumagnun on 20/11/2017.
 */

public class HistoricoCalculoDaoImpl extends BaseDao {

    private ListenerMessage message = null;

    @Override
    public void save(final Object o, final PersistListener listener) {
        Calculo calculo = (Calculo) o;
        FirebaseAuth mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() != null) {
            getDataBaseRef(Constantes.COLLECTION_HISTORICO_CALCULOS)
                    .child(mAuth.getCurrentUser().getUid())
                    .child(calculo.getTime() + "")
                    .setValue(calculo);

            message =
                    new ListenerMessage()
                            .addMessage("Salvo com sucesso!")
                            .addId(OperationTypeEnum.CLICK)
                            .addObject(calculo);
        } else {
            message =
                    new ListenerMessage()
                            .addMessage("Faça login para salvar!")
                            .addId(OperationTypeEnum.CLICK)
                            .addObject(calculo);
        }
        listener.onPersistEvent(message);

    }

    @Override
    public void list(final Object o, final PersistListener listener) {

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        if (mAuth.getCurrentUser() != null) {
            getDataBaseRef(Constantes.COLLECTION_HISTORICO_CALCULOS).child(mAuth.getCurrentUser().getUid()).addValueEventListener(
                    new ValueEventListener() {

                        GenericTypeIndicator<List<Calculo>> t = new GenericTypeIndicator<List<Calculo>>() {
                        };

                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {

                            List<Calculo> list = new ArrayList<>();
                            Iterable<DataSnapshot> musicasSnapshot = dataSnapshot.getChildren();

                            DataSnapshot dataSnapshotErro = null;


                            for (DataSnapshot dataSnapshot1 : musicasSnapshot) {
                                try {
                                    dataSnapshotErro = dataSnapshot1;
                                    Calculo c = dataSnapshot1.getValue(Calculo.class);
                                    list.add(c);
                                } catch (Exception e) {
                                    System.out.println(dataSnapshotErro);
                                    e.printStackTrace();
                                }
                            }

                            ListenerMessage message =
                                    new ListenerMessage()
                                            .addMessage("Dados recuperados!")
                                            .addId(OperationTypeEnum.LIST)
                                            .addObject(list);

                            listener.onPersistEvent(message);
                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            ListenerMessage message =
                                    new ListenerMessage()
                                            .addMessage(databaseError.getMessage() + "-" + databaseError.getDetails())
                                            .addId(OperationTypeEnum.LIST);

                            listener.onPersistEvent(message);
                        }
                    }
            );
        }

    }


    @Override
    public void get(final String idRegistro, final PersistListener listener) {


    }
}
