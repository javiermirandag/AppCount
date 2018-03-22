package es.ulpgc.da.appcount.masterscreen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import es.ulpgc.da.appcount.Mediator;
import es.ulpgc.da.appcount.R;
import es.ulpgc.da.appcount.data.ModelDbItem;
import es.ulpgc.da.appcount.framework.I_View;

public class MasterView extends Activity implements I_View, Master.PresenterToView {
    protected final String TAG = this.getClass().getSimpleName();

    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master);
        Log.d("MainActivity", "starting MainView");

        final Mediator mediator = (Mediator) getApplication();
        final Master.ViewToPresenter myPresenter =
                (Master.ViewToPresenter) mediator.getPresenter(this);

        list = findViewById(R.id.itemsList);

        ArrayAdapter<ModelDbItem> adapter =
                new ArrayAdapter(
                        this,
                        android.R.layout.simple_list_item_1,
                        myPresenter.getData());
        list.setAdapter(adapter);
    }

}
