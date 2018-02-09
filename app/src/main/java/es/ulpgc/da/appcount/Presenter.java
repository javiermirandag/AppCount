package es.ulpgc.da.appcount;

public class Presenter {
    private Model myModel;

    public Presenter() {
        myModel = new Model();
    }

    public int getContador() {
        return myModel.getContador();
    }

    public void botonMasPulsado() {
        myModel.increment();
    }
}
