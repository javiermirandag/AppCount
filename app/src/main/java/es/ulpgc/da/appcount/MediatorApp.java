package es.ulpgc.da.appcount;

import android.app.Application;

import es.ulpgc.da.appcount.mainscreen.MainModel;
import es.ulpgc.da.appcount.mainscreen.MainPresenter;
import es.ulpgc.da.appcount.mainscreen.MainView;

public class MediatorApp extends Application {
    private MainPresenter myPresenter;
    private MainModel myModel;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public MainPresenter getPresenter(MainView view) {
        if (myPresenter == null) {
            myModel = new MainModel();
            myPresenter = new MainPresenter(this, myModel, view);
        }

        return myPresenter;
    }
}
