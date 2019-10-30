package com.example.androidnangcao;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    public MyService() {

    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);

        //hiển thị thông báo khi kích hoạt service
        Toast.makeText(this, "Service mới đang được khởi tạo", Toast.LENGTH_SHORT).show();

        //lấy bundle từ intent
        Bundle b = intent.getBundleExtra("Student");

        //lấy giá trị từ bundle
        int StuID = b.getInt("StuID");
        String StuName = b.getString("StuName");
        String Class = b.getString("Class");

        //hiển thị
        String content = "Thêm sinh viên thành công!\nThông tin sinh viên: \nSinh viên: " + StuID + " - " + StuName;
        content += "\nLớp: " + Class;

        Toast.makeText(this,content,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("onDestroy", "onDestroy");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("onCreate", "onCreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        int a = intent.getIntExtra("a", -1);

        if (a < 0) {
            //không lấy được
        } else {
            //lấy được

        }

        Log.e("onStartCommand", "onStartCommand " + a);

        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
