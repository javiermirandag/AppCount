package es.ulpgc.da.appcount;

import es.ulpgc.da.appcount.framework.I_Presenter;
import es.ulpgc.da.appcount.framework.I_View;
import es.ulpgc.da.appcount.mainscreen.MainPresenter;
import es.ulpgc.da.appcount.mainscreen.MainView;

public interface Mediator {
    I_Presenter getPresenter(I_View view);

    void resetApp();
    void log_d(String tag, String text);

    interface lifecycle {

    }

    interface navigation {
        void openWebPage(String url);

        void openNextScreen(I_Presenter mainPresenter);
    }

}
