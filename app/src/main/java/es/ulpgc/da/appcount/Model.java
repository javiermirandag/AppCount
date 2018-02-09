package es.ulpgc.da.appcount;

public class Model {
    private int contador;

    public void Model() {
        contador = 0;
    }

    public void increment() {
        contador++;
    }

    public int getContador() {
        return contador;
    }
}
