package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Bai1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==888){
            Toast.makeText(this,"Nguoi dung da tuong tac voi dialog xin quyen"+grantResults[0],Toast.LENGTH_SHORT).show();
        }
    }

    public void loadContact(View view) {
        if (ContextCompat.checkSelfPermission(Bai1Activity.this, Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Bai1Activity.this,

                    new String[]{Manifest.permission.READ_CONTACTS},
                    888);
        }else{
            run();}
    }
    public void run() {
        Uri uri= ContactsContract.Contacts.CONTENT_URI;
        Cursor cursor=getContentResolver().query(uri,null,null,null,null);
        String data="";
        ArrayList<String> list=new ArrayList<>();
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                Log.i("Names", name);
                if (Integer.parseInt(cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.HAS_PHONE_NUMBER))) > 0)
                {
                    // Query phone here. Covered next
                    Cursor phones = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null,
                            ContactsContract.CommonDataKinds.Phone.CONTACT_ID +" = "+ id,null, null);
                    while (phones.moveToNext()) {
                        String phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                        Log.i("Number", phoneNumber);
                        data =name+" - " +phoneNumber;
                        list.add(data);
                    }

                    phones.close();
                    ListView listView=findViewById(R.id.abc);
                    ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
                    listView.setAdapter(adapter);
                }

            }
        }
        }
//    }
}
