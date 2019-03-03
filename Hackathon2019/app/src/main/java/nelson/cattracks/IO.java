package nelson.cattracks;

import android.location.Location;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.model.LatLng;

import com.google.android.gms.common.api.GoogleApiClient;

public class IO extends AppCompatActivity {
    public static final String Source = "com.example.myfirstapp.MESSAGE";
    public static final String Destination = "titty";
    public static String location = " ";
    public static String destination = " ";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_io);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner locationSpinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(IO.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.busStops));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSpinner.setAdapter(myAdapter);
        //location = locationSpinner.getSelectedItem().toString();

        Spinner destinationSpinner = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> myAdapter2 = new ArrayAdapter<String>(IO.this, android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.busStops));
        myAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        destinationSpinner.setAdapter(myAdapter2);
        //destination = destinationSpinner.getSelectedItem().toString();
    }

    /** Called when user taps the Find Your Routes button! **/
    public void sendRoutes(View view) {
        /** Reads the content of the text fields and sends it to the next activity **/
        Intent intent = new Intent(this, Map.class);                                    /** The class of this line is the next activity we want it to run */
        Spinner locationSpinner = (Spinner) findViewById(R.id.spinner1);
        location = locationSpinner.getSelectedItem().toString();

        Spinner destinationSpinner = (Spinner) findViewById(R.id.spinner2);
        destination = destinationSpinner.getSelectedItem().toString();

        intent.putExtra("Location", location);
        intent.putExtra("Destination", destination);
        startActivity(intent);
    }

        /*Intent intent2 = new Intent(this, MapsActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText8);
        String location = locationSpinner.getSelectedItem().toString();
        EditText editText1 = (EditText) findViewById(R.id.editText9);
        String destination = editText1.getText().toString();
        intent.putExtra(Source, location);
        intent2.putExtra(Destination, destination);
        startActivity(intent);
        //startActivity(intent2);*/
   // }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_io, menu);
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
