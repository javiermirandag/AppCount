package es.ulpgc.da.appcount.mainscreen;

public class MainModel implements Main.PresenterToModel {
    private int contador;

    public MainModel() {
        contador = 0;
    }

    @Override
    public void increment() {
        contador++;
    }

    @Override
    public int getContador() {
        return contador;
    }
}
