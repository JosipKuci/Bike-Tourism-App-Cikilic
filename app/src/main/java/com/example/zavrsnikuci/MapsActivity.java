package com.example.zavrsnikuci;


import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.example.zavrsnikuci.pomagaci.FetchURL;
import com.example.zavrsnikuci.pomagaci.TaskLoadedCallback;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback, TaskLoadedCallback {
    private GoogleMap mMap;
    private MarkerOptions place1, place2;
    private Polyline currentPolyline;
    public static int ruta;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        getSupportActionBar().hide();
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapNearBy);
        mapFragment.getMapAsync(this);

        switch (ruta)
        {
            case 1:
                double[] x={ 45.559528, 45.555435, 45.609459, 45.598840};
                double[] y={ 18.698837, 18.758661, 18.798330, 18.787750};
                for (int i=0;i<(x.length-1);i++)
                {
                    place1 = new MarkerOptions().position(new LatLng(x[i], y[i]));
                    place2 = new MarkerOptions().position(new LatLng(x[i+1], y[i+1]));
                    new FetchURL(MapsActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "walking"), "walking");
                }

                break;
            case 2:
                double[] x2={45.542367, 45.497936, 45.482109, 45.510252, 45.541758};
                double[] y2={18.708950, 18.747271, 18.673296, 18.678160, 18.675023};
                for (int i=0;i<(x2.length-1);i++)
                {
                    place1 = new MarkerOptions().position(new LatLng(x2[i], y2[i]));
                    place2 = new MarkerOptions().position(new LatLng(x2[i+1], y2[i+1]));
                    new FetchURL(MapsActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "walking"), "walking");
                }
                break;
            case 3:
                double[] x3={45.558240, 45.563194, 45.567005};
                double[] y3={18.707477, 18.692151, 18.664918};
                for (int i=0;i<(x3.length-1);i++)
                {
                    place1 = new MarkerOptions().position(new LatLng(x3[i], y3[i]));
                    place2 = new MarkerOptions().position(new LatLng(x3[i+1], y3[i+1]));
                    new FetchURL(MapsActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "walking"), "walking");
                }
                break;
            case 4:
                double[] x4={45.559581, 45.555435, 45.609459, 45.623681, 45.689883, 45.722001};
                double[] y4={18.698885, 18.758661, 18.798330, 18.813347, 18.813658, 18.864821};
                for (int i=0;i<(x4.length-1);i++)
                {
                    place1 = new MarkerOptions().position(new LatLng(x4[i], y4[i]));
                    place2 = new MarkerOptions().position(new LatLng(x4[i+1], y4[i+1]));
                    new FetchURL(MapsActivity.this).execute(getUrl(place1.getPosition(), place2.getPosition(), "walking"), "walking");
                }
        }
    }
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng zoom = new LatLng(45.567144,18.746876);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(zoom, 11f));
        switch(ruta)
        {
            case 1:
                mMap.addMarker(new MarkerOptions().position(new LatLng(45.559506, 18.698765)).title("Početak"));
                mMap.addMarker(new MarkerOptions().position(new LatLng(45.598840, 18.787750)).title("Kraj"));
                break;
            case 2:
                mMap.addMarker(new MarkerOptions().position(new LatLng(45.542367, 18.708950)).title("Početak"));
                mMap.addMarker(new MarkerOptions().position(new LatLng(45.541758, 18.675023)).title("Kraj"));
                break;
            case 3:
                mMap.addMarker(new MarkerOptions().position(new LatLng(45.558240, 18.707477)).title("Početak"));
                mMap.addMarker(new MarkerOptions().position(new LatLng(45.567005, 18.664918)).title("Kraj"));
                break;
            case 4:
                mMap.addMarker(new MarkerOptions().position(new LatLng(45.559581, 18.698885)).title("Početak"));
                mMap.addMarker(new MarkerOptions().position(new LatLng(45.722001, 18.864821)).title("Kraj"));
                break;

        }
    }

    private String getUrl(LatLng origin, LatLng dest, String directionMode) {
        // Origin of route
        String str_origin = "origin=" + origin.latitude + "," + origin.longitude;
        // Destination of route
        String str_dest = "destination=" + dest.latitude + "," + dest.longitude;
        // Mode
        String mode = "mode=" + directionMode;
        // Building the parameters to the web service
        String parameters = str_origin + "&" + str_dest + "&" + mode;
        // Output format
        String output = "json";
        // Building the url to the web service
        String url = "https://maps.googleapis.com/maps/api/directions/" + output + "?" + parameters + "&key=" + getString(R.string.google_maps_key);
        return url;
    }

    @Override
    public void onTaskDone(Object... values) {

        currentPolyline = mMap.addPolyline((PolylineOptions) values[0]);
    }
}