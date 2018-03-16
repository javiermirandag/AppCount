package es.ulpgc.da.appcount.mainscreen;

import es.ulpgc.da.appcount.Mediator;
import es.ulpgc.da.appcount.framework.I_Model;

public class MainModel implements I_Model, Main.PresenterToModel {
    protected final String TAG = this.getClass().getSimpleName();
    private int contador;

    public MainModel() {
        reset();
    }

    public MainModel(Mediator mediator) {
        mediator.log_d(TAG, "starting MainModel");
        reset();
    }

    @Override
    public void increment() {
        contador++;
    }

    @Override
    public int getContador() {
        return contador;
    }

    @Override
    public void reset() {
        contador = 0;
    }
}
