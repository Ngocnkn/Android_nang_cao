package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bai2 extends AppCompatActivity {
EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        editText = findViewById(R.id.edt2);
    }

    public void b2(View view) {
        Intent intent= new Intent(Bai2.this,MyBroadcast.class);

        intent.putExtra("sms",editText.getText().toString());
 sendBroadcast(intent);
    }


}
