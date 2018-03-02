package es.ulpgc.da.appcount.mainscreen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import es.ulpgc.da.appcount.R;
import es.ulpgc.da.appcount.Mediator;

public class MainView extends Activity implements Main.PresenterToView {
    protected final String TAG = this.getClass().getSimpleName();

    private TextView timeTextView;
    private TextView pantalla;
    private Button boton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "starting MainView");

        timeTextView = findViewById(R.id.timeTextView);
        pantalla = findViewById(R.id.textView);
        boton1 = findViewById(R.id.button);

        final Mediator mediator = (Mediator) getApplication();
        final Main.ViewToPresenter myPresenter = mediator.getPresenter(this);

        pantalla.setText(mediator.getPresenter(this).getTextToDisplay());

        // Configurado el observador con una clase anonima
        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Log.d(TAG, "boton pulsado");

                myPresenter.buttonPlusPressed();
                pantalla.setText(myPresenter.getTextToDisplay());
            }
        });

        displayCurrentTime();
    }


    @Override
    public void displayShortMessage(String text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    private void displayCurrentTime() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        String formattedDate = df.format(c.getTime());
        timeTextView.setText("" + formattedDate);

        enableHandler();
    }

    public void enableHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                displayCurrentTime();
            }
        }, 1000);

    }
}
