package com.example.slide3;

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
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 888) {
            Toast.makeText(this, "nguoi doc da tuong tac voi dialog xin quen" + grantResults[0], Toast.LENGTH_SHORT).show();
        }
    }

    public void ShowAllContact(View view) {
        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_CONTACTS)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},
                    888);
        } else
            run();
    }

    private void run() {
        Uri uri = ContactsContract.Contacts.CONTENT_URI;
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        String data = "";
        if (cursor != null) {
            if (cursor.getCount() > 0) {
                cursor.moveToFirst();
                while (cursor.isAfterLast() == false) {
                    String id = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));
                    String name = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME));
                    data += id + "-" + name + "\n";
                    cursor.moveToNext();
                }
                cursor.close();
                TextView tv = findViewById(R.id.tv);
                tv.setText(data);
            }
        }
    }

    public void AccessTheAllCallLog(View view) {
    }
}
