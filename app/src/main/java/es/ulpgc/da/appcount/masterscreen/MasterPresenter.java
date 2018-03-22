package es.ulpgc.da.appcount.masterscreen;

import es.ulpgc.da.appcount.Mediator;
import es.ulpgc.da.appcount.data.ModelDbItem;
import es.ulpgc.da.appcount.framework.I_Model;
import es.ulpgc.da.appcount.framework.I_Presenter;
import es.ulpgc.da.appcount.framework.I_View;

public class MasterPresenter implements I_Presenter, Master.ViewToPresenter, Master.ModelToPresenter {
    protected final String TAG = this.getClass().getSimpleName();

    private Mediator myMediator;
    private Master.PresenterToModel myModel;
    private Master.PresenterToView  myView;

    public MasterPresenter(Mediator mediator,
                           I_Model model,
                           I_View view) {
        mediator.log_d(TAG, "starting MainPresenter");
        myMediator = mediator;
        myModel = (Master.PresenterToModel) model;
        myView = (Master.PresenterToView) view;
    }


    @Override
    public ModelDbItem[] getData() {
        return myModel.getData();
    }
}
