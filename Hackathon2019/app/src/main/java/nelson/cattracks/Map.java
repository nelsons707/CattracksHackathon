package nelson.cattracks;

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
        Intent intent2 = getIntent();
        String message = intent.getStringExtra(IO.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(IO.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView);
        textView.setText(message);

        TextView textView2 = findViewById(R.id.textView2);
        textView2.setText(message);
    }

    /** This class needs to display the map,
     *
     * convert the addresses to coordinates
     * find the closest bus stop to those coordinates
     * and then find the routes
     */
}
