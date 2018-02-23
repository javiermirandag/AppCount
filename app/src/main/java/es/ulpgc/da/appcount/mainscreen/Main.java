package es.ulpgc.da.appcount.mainscreen;

public interface Main {

    interface PresenterToModel {
        void increment();

        int getContador();
    }

    interface ModelToPresenter {
    }

    interface PresenterToView {
    }

    interface ViewToPresenter {
        String getTextToDisplay();

        void buttonPlusPressed();
    }

}
