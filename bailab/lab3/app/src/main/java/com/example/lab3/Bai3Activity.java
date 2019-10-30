package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class Bai3Activity extends AppCompatActivity  {
Image image;
    RecyclerView rvImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        rvImage=findViewById(R.id.rvImage);
        rvImage.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        rvImage.setLayoutManager(layoutManager);
    } public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==888){
            Toast.makeText(this,"Nguoi dung da tuong tac voi dialog xin quyen"+grantResults[0],Toast.LENGTH_SHORT).show();
        }
    }

    public void loadImage(View view) {
        if (ContextCompat.checkSelfPermission(Bai3Activity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
//            Toast.makeText(this,"Chua co quyen",Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(Bai3Activity.this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    888);
        }else{
            run();}
    }
    public void run() {
        Uri uri= MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        ArrayList<Image> list=new ArrayList<>();
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            Image image=new Image();
            image.duongdan=cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            list.add(image);
            cursor.moveToNext();
        }
        ImageAdapter adapter=new ImageAdapter(list,getApplicationContext());
        rvImage.setAdapter(adapter);
        cursor.close();


    }

}
