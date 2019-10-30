package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class bai2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
    }

    public void checkInternet(View view) {
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);


        boolean isWifi = networkInfo.isConnected();
        if (isWifi) Toast.makeText(this,"Wifi is Connected",Toast.LENGTH_SHORT).show();

        networkInfo  = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);


        boolean isMobie = networkInfo.isConnected();

        if (isMobie) Toast.makeText(this,"Mobie is Connected",Toast.LENGTH_SHORT).show();
    }
    }

