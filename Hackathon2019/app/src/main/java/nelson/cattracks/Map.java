package nelson.cattracks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }

    /** This class needs to display the map,
     *
     * convert the addresses to coordinates
     * find the closest bus stop to those coordinates
     * and then find the routes
     */
}
