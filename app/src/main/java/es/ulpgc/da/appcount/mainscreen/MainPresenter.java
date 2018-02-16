package es.ulpgc.da.appcount.mainscreen;

import es.ulpgc.da.appcount.MediatorApp;

public class MainPresenter implements Main.ViewToPresenter, Main.ModelToPresenter {
    private MediatorApp myMediator;
    private MainModel myModel;
    private MainView  myView;

    public MainPresenter(MediatorApp mediator,
                         MainModel model,
                         MainView view) {
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
