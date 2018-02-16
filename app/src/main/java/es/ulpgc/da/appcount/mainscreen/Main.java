package es.ulpgc.da.appcount.mainscreen;

public interface Main {

    interface ModelToPresenter {
    }

    interface PresenterToModel {
        void increment();

        int getContador();
    }

    interface PresenterToView {
    }

    interface ViewToPresenter {
        String getTextToDisplay();

        void buttonPlusPressed();
    }

}
