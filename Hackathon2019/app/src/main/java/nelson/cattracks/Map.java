package nelson.cattracks;

import android.location.Location;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        Intent intent = getIntent();
        String locationMessage = intent.getStringExtra("Location");
        TextView textView = findViewById(R.id.textView);
        textView.setText(locationMessage);


        //Intent intent2 = getIntent();
        String destinationMessage = intent.getStringExtra("Destination");
        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(destinationMessage);
        // Capture the layout's TextView and set the string as its text



    }

    /** This class needs to display the map,
     *
     * convert the addresses to coordinates
     * find the closest bus stop to those coordinates
     * and then find the routes
     */
}
