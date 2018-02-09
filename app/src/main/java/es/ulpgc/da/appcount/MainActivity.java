package es.ulpgc.da.appcount;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    protected final String TAG = this.getClass().getSimpleName();

    private TextView pantalla;
    private Button boton1;
    private Presenter myPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Arrancando mi App");

        pantalla = findViewById(R.id.textView);
        boton1 = findViewById(R.id.button);

        myPresenter = new Presenter();
        pantalla.setText("" + myPresenter.getContador());

        // Configurado el observador con una clase anonima
        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "boton pulsado");

                myPresenter.botonMasPulsado();
                pantalla.setText("" + myPresenter.getContador());
            }
        });

    }

}
