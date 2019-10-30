package com.example.lab1.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lab1.R;

public class Bai2Activity extends AppCompatActivity {
    Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        btn1 = findViewById(R.id.btn1);
        btn1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {

                //khởi tạo Intent
                Intent intent = new Intent(Bai2Activity.this, MyService.class);

                //khởi tạo Bundle
                Bundle b = new Bundle();

                //khai báo bộ giá trị và gán vào Bundle
                b.putInt("StuID", 1);
                b.putString("StuName", "Ngô Khắc Ngọc");
                b.putString("Class", "PT14353");

                //gắn Bundle vào Intent
                intent.putExtra("Student", b);

                //khởi tạo service
                startService(intent);

            }
        });
    }

    public void stopServicee(View view) {

    }
}
