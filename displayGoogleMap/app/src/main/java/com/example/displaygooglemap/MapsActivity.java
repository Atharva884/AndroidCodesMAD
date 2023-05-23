package com.example.displaygooglemap;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment supportMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
       mMap = googleMap;
       LatLng msbte = new LatLng(19.020487, 72.840729);
       mMap.addMarker(new MarkerOptions().position(msbte).title("Dadar Boltee"));
       mMap.moveCamera(CameraUpdateFactory.newLatLng(msbte));
       mMap.getUiSettings().setZoomControlsEnabled(true);
    }

}