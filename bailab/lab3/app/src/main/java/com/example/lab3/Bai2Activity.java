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

import java.util.ArrayList;

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
//            Toast.makeText(this,"Chua co quyen",Toast.LENGTH_SHORT).show();
            ActivityCompat.requestPermissions(Bai2Activity.this,
                    new String[]{Manifest.permission.READ_CALL_LOG},
                    888);
        } else {
            run();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void run() {
        ArrayList<String> list=new ArrayList<>();
        String[] projection = new String[]{
                CallLog.Calls.DATE,
                CallLog.Calls.NUMBER,
                CallLog.Calls.DURATION
        };
        if (checkSelfPermission(Manifest.permission.READ_CALL_LOG) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        Cursor c = getContentResolver().query(
                CallLog.Calls.CONTENT_URI,
                projection,
                CallLog.Calls.DURATION + "<?", new String[]{"30"},
                CallLog.Calls.DATE + " Asc");
        c.moveToFirst();
        String s="";
        while(c.isAfterLast()==false){
            String a=c.getString(c.getColumnIndex(CallLog.Calls.DURATION));
            String b=c.getString(c.getColumnIndex(CallLog.Calls.DATE));
            String d=c.getString(c.getColumnIndex(CallLog.Calls.NUMBER));
            for(int i=0;i<c.getColumnCount();i++){
                s=b+"-"+d+"-"+a;
            }
//            s+="";
            list.add(s);
            c.moveToNext();
        }
        c.close();
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list);
        ListView listView=findViewById(R.id.lvCalllog);
        listView.setAdapter(adapter);
//        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
        }

}
