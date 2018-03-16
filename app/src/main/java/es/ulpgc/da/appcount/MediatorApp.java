package es.ulpgc.da.appcount;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

import es.ulpgc.da.appcount.framework.I_Model;
import es.ulpgc.da.appcount.framework.I_Presenter;
import es.ulpgc.da.appcount.framework.I_View;
import es.ulpgc.da.appcount.mainscreen.MainModel;
import es.ulpgc.da.appcount.mainscreen.MainPresenter;
import es.ulpgc.da.appcount.mainscreen.MainView;

public class MediatorApp extends Application implements Mediator, Mediator.lifecycle, Mediator.navigation {

    private class Screen {
        private I_Model model;
        private I_View view;
        private I_Presenter presenter;

        public Screen (I_Model model, I_View view, I_Presenter presenter) {
           this.model = model;
           this.view = view;
           this.presenter = presenter;
        }

        public I_Model getModel() {
            return model;
        }

        public void setModel(I_Model model) {
            this.model = model;
        }

        public I_View getView() {
            return view;
        }

        public void setView(I_View view) {
            this.view = view;
        }

        public I_Presenter getPresenter() {
            return presenter;
        }

        public void setPresenter(I_Presenter presenter) {
            this.presenter = presenter;
        }
    }

    private ArrayList<Screen> appScreens;

    private I_Model getModel (I_Presenter presenter) {
        for (Screen screen : appScreens) {
            if (screen.getPresenter() == presenter) {
                return screen.getModel();
            }
        }

        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appScreens = new ArrayList<Screen>();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public I_Presenter getPresenter(I_View view) {
        I_Presenter myPresenter = null;
        I_Model myModel;

        for (Screen screen : appScreens) {
            if (screen.getView() == view) {
                myPresenter = screen.getPresenter();
            }
        }

        if (myPresenter == null) {
            myModel = new MainModel(this);
            myPresenter = new MainPresenter(this, myModel, view);

            Screen newScreen = new Screen(myModel, view, myPresenter);

            appScreens.add(newScreen);
        }

        return myPresenter;
    }

    @Override
    public void resetApp() {
        for (Screen screen : appScreens) {
            screen.getModel().reset();
        }
    }

    @Override
    public void log_d(String tag, String text) {
        Log.d(tag, text);
    }

    @Override
    public void openWebPage(String url) {
        Uri uri = Uri.parse(url);
        Intent intent = new Intent();
        intent.setData(uri);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
