package com.example.jhyuk.ma_whereiserror;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps2);
        setTitle("구글지도");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0,1,0,"일반 지도");
        menu.add(0,2,0,"광운대학교 바로 가기");
        return true;
    }


    public boolean onOptionItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                return true;
            case 2:
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(37.619539, 127.058931), 15));
                return true;
        }
        return false;
    }

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



        LatLng KWU = new LatLng(37.619539, 127.058931);
        mMap.addMarker(new MarkerOptions().position(KWU).title("KW university"));
        LatLng Bima = new LatLng(37.619801, 127.057552);
        mMap.addMarker(new MarkerOptions().position(Bima).title("Bima"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Bima));


        CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
        googleMap.animateCamera(zoom);

        MarkerOptions marker = new MarkerOptions();
        marker.position(new LatLng(37.619539, 127.058931));

    }

}
