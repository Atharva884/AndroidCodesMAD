package com.example.georeverse;

import androidx.fragment.app.FragmentActivity;

import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.georeverse.databinding.ActivityMapsBinding;

import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }

    @Override
    public void onMapReady(GoogleMap map){
        mMap = map;

        // GeoCoding
        Geocoder geocoder = new Geocoder(this);
        try {
            String address = "Empire State Building";
            List<Address> coords = geocoder.getFromLocationName(address, 1);
            LatLng latLng = new LatLng(coords.get(0).getLatitude(), coords.get(0).getLongitude());
            mMap.addMarker(new MarkerOptions().position(latLng).title("Empire State Building"));
            mMap.animateCamera(CameraUpdateFactory.newLatLng(latLng));
        }catch (Exception e){
            Log.d("Error", e.toString());
        }



        // Get Location Data As well as Reverse Geocoding
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener(){
           @Override
           public void onMapClick(LatLng latLng){
               try {
                   List<Address> addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1);
                   Toast.makeText(MapsActivity.this, addresses.get(0).getAddressLine(0), Toast.LENGTH_SHORT).show();
               }catch (Exception e){
                   Log.d("Error", e.toString());
               }
           }
        });
    }
}