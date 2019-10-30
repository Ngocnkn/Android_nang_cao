package com.example.slide8;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.pm.ActivityInfoCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    ImageView imv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imv = findViewById(R.id.imv);

    }

    public void Camera(View view) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{
                    Manifest.permission.CAMERA
            }, 888);
        } else {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent, 999);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 999 && requestCode == RESULT_OK) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imv.setImageBitmap(bitmap);
        } else {
            Toast.makeText(this, "chup anh khong thanh cong !!", Toast.LENGTH_SHORT).show();
        }
    }

    public void Media(View view) {
        String url = "https://data.chiasenhac.com/downloads/2040/6/2039924-6b0e07eb/128/Con%20Gi%20Dau%20Hon%20Chu%20Da%20Tung%20-%20Quan%20A_P.mp3";
        Uri uri = Uri.parse(url);
        MediaPlayer mediaPlayer = MediaPlayer.create(this, uri);

        if (mediaPlayer.isLooping()) {
            mediaPlayer.reset();
            mediaPlayer.stop();
        } else {
            try {
                mediaPlayer.prepare();
                mediaPlayer.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        mediaPlayer.start();
    }
}
