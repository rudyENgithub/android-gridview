package net.sgoliver.android.gridview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private TextView lblMensaje;
    private GridView grdOpciones;
    public TableAdapter mainActivityAdapter;
    private String[] datos = new String[5];
    public ArrayList<String> listService = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i=1; i<=5; i++)
            datos[i-1] = "Dato " + i;

        listService.add("Market");
        listService.add("Recherche");
        listService.add("Quiz");

        ArrayAdapter<String> adaptador =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos);

     //   lblMensaje = (TextView)findViewById(R.id.LblMensaje);
        grdOpciones = (GridView)findViewById(R.id.GridOpciones);

    /*    grdOpciones.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent,
                                            android.view.View v, int position, long id) {
                        lblMensaje.setText("Opción seleccionada: "
                                + parent.getItemAtPosition(position));
                    }
                });
*/
     //   grdOpciones.setAdapter(adaptador);
        mainActivityAdapter = new TableAdapter(this, listService);
        grdOpciones.setAdapter(mainActivityAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
