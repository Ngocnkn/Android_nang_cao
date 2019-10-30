package com.example.lab3;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Browser;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.telecom.Call;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Bai2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 888) {
            Toast.makeText(this, "Nguoi dung da tuong tac voi dialog xin quyen" + grantResults[0], Toast.LENGTH_SHORT).show();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void loadBookmark(View view) {
        if (ContextCompat.checkSelfPermission(Bai2Activity.this, Manifest.permission.READ_CALL_LOG)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Bai2Activity.this,
                    new String[]{Manifest.permission.READ_CALL_LOG},
                    888);
        } else {
            run();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void run() {
        ArrayList<String> list = new ArrayList<>();
        String[] projection = new String[]{
                CallLog.Calls.CACHED_NAME,
                CallLog.Calls.NUMBER,
                CallLog.Calls.DURATION
        };
        if (checkSelfPermission(Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {

            return;
        }

        Cursor c = getContentResolver().query(CallLog.Calls.CONTENT_URI, projection,
                CallLog.Calls.DURATION + "<?", new String[]{"30"},
                CallLog.Calls.DATE + " Asc");
        c.moveToFirst();
        String s = "";
        while (c.isAfterLast() == false) {
            String b = c.getString(c.getColumnIndex(CallLog.Calls.CACHED_NAME));
            String d = c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
            for (int i = 0; i < c.getColumnCount(); i++) {
                s = b +  " - " + d  ;
            }

            list.add(s);
            c.moveToNext();
        }
        c.close();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
        ListView listView = findViewById(R.id.lvCalllog);
        listView.setAdapter(adapter);
    }

}
