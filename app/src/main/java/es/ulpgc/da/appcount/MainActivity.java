package es.ulpgc.da.appcount;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView pantalla;
    private Button boton1;
    private int contador;

    // Esta clase solamente es necesaria si configuramos el observador
    // del boton utilizando el estilo tradicional de Java (podemos
    // borrarla si lo configuramos con una clase anónima)
    class ButtonListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Log.d("MainActivity", "boton pulsado");
            contador++;
            pantalla.setText("" + contador);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Arrancando mi App");

        pantalla = findViewById(R.id.textView);
        contador = 0;
        pantalla.setText("" + contador);

        boton1 = findViewById(R.id.button);

        // Version 1: estilo tradicional de java (visto en el primer curso)
        // boton1.setOnClickListener(new ButtonListener());

        // Version 2: Configurado con una clase anonima
        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "boton pulsado");
                contador++;
                pantalla.setText("" + contador);
            }
        });
    }
}
