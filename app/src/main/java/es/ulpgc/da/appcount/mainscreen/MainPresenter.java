package es.ulpgc.da.appcount.mainscreen;

import es.ulpgc.da.appcount.Mediator;
import es.ulpgc.da.appcount.framework.I_Model;
import es.ulpgc.da.appcount.framework.I_Presenter;
import es.ulpgc.da.appcount.framework.I_View;

public class MainPresenter implements I_Presenter, Main.ViewToPresenter, Main.ModelToPresenter {
    protected final String TAG = this.getClass().getSimpleName();

    private Mediator myMediator;
    private Main.PresenterToModel myModel;
    private Main.PresenterToView  myView;

    public MainPresenter(Mediator mediator,
                         I_Model model,
                         I_View view) {
        mediator.log_d(TAG, "starting MainPresenter");
        myMediator = mediator;
        myModel = (Main.PresenterToModel) model;
        myView = (Main.PresenterToView) view;
    }

    @Override
    public String getTextToDisplay() {
        return "" + myModel.getContador();
    }

    @Override
    public void buttonPlusPressed() {
        myModel.increment();

        if (myModel.getContador() % 4 == 0) {
            myView.displayShortMessage("Congrats!!! You reached " + myModel.getContador());

            ((Mediator.navigation) myMediator).openWebPage("http://www.ulpgc.es");
        }
    }
}
