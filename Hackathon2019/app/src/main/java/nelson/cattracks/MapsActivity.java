package nelson.cattracks;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /** This class needs to display the map,
     *
     * convert the addresses to coordinates
     * find the closest bus stop to those coordinates
     * and then find the routes
     */

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Merced and move the camera
        LatLng Merced = new LatLng(37.3022, -120.4830);
        mMap.addMarker(new MarkerOptions().position(Merced).title("Marker in Merced"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Merced));

        //LatLng campusStop = new LatLng(DB.getCoordinatesX("Student Activities and Athletics Center"), DB.getCoordinatesY("Student Activities and Athletics"));
        //mMap.addMarker(new MarkerOptions().position(campusStop).title("Marker on campus"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(campusStop));
    }
}
