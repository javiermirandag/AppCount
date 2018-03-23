package es.ulpgc.da.appcount.masterscreen;

import es.ulpgc.da.appcount.Mediator;
import es.ulpgc.da.appcount.data.DatabaseFacade;
import es.ulpgc.da.appcount.data.ModelDbItem;
import es.ulpgc.da.appcount.framework.I_Model;

public class MasterModel implements I_Model, Master.PresenterToModel {
    protected final String TAG = this.getClass().getSimpleName();

    private DatabaseFacade db;

    public MasterModel() {
        reset();
    }

    public MasterModel(Mediator mediator) {
        mediator.log_d(TAG, "starting MainModel");
        reset();
    }

    @Override
    public void reset() {
        // db = new DatabaseFacade();
        db = DatabaseFacade.getInstance();

        for (int j=1; j < 100; j++) {
            int randomNumber = (int)(Math.random() * 100);
            ModelDbItem item =
                    new ModelDbItem(
                            randomNumber + " contents",
                            randomNumber + " description");
            db.insertDatabaseItem(item);
        }
    }

    @Override
    public ModelDbItem[] getData() {
        return db.getAllItemsArrayFromDatabase();
    }
}
