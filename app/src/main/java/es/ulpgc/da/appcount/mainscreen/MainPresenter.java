package es.ulpgc.da.appcount.mainscreen;

import es.ulpgc.da.appcount.Mediator;

public class MainPresenter implements Main.ViewToPresenter, Main.ModelToPresenter {
    private Mediator myMediator;
    private Main.PresenterToModel myModel;
    private Main.PresenterToView  myView;

    public MainPresenter(Mediator mediator,
                         Main.PresenterToModel model,
                         Main.PresenterToView view) {
        myMediator = mediator;
        myModel = model;
        myView = view;
    }

    @Override
    public String getTextToDisplay() {
        return "" + myModel.getContador();
    }

    @Override
    public void buttonPlusPressed() {
        myModel.increment();
    }
}
