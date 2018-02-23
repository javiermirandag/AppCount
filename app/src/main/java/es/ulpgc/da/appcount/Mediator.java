package es.ulpgc.da.appcount;

import es.ulpgc.da.appcount.mainscreen.MainPresenter;
import es.ulpgc.da.appcount.mainscreen.MainView;

public interface Mediator {
    MainPresenter getPresenter(MainView view);

    public interface lifecycle {

    }

    public interface navigation {

    }

}
