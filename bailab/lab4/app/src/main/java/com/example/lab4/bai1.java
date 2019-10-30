package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class bai1 extends AppCompatActivity implements LocationListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
    }

    public void requestGPS(View view) {
        LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED &&

                ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED


        ) {
            // Bat  cau lenh xin quyen
            ActivityCompat.requestPermissions(bai1.this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION},
                    999);

        }else

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,0,0, (LocationListener) this);
    }
    @Override
    public void onLocationChanged(Location location) {
        double latitude = location.getLatitude();
        double longtitude= location.getLongitude();

        TextView tvLocation =  findViewById(R.id.textView);
        tvLocation.setText(latitude + " : " + longtitude);
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {
        Log.e("ABC",s);
    }

    @Override
    public void onProviderEnabled(String s) {
        Log.e("ABC",s);
    }

    @Override
    public void onProviderDisabled(String s) {
        Log.e("ABC",s);
    }
}
