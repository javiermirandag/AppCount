package es.ulpgc.da.appcount.masterscreen;

import es.ulpgc.da.appcount.data.ModelDbItem;

public interface Master {

    interface PresenterToModel {
        ModelDbItem[] getData();
    }

    interface ModelToPresenter {

    }

    interface PresenterToView {

    }

    interface ViewToPresenter {
        ModelDbItem[] getData();
    }

}
