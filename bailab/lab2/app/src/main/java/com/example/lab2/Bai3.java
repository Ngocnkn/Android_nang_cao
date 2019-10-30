package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Bai3 extends AppCompatActivity {
    Button button;
    EditText editText;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        button= findViewById(R.id.button);
        editText=findViewById(R.id.edittext);
    }
    public void send(View view) {
         intent = new Intent(Bai3.this,MyReceier.class);
    intent.putExtra("td",editText.getText().toString());
      sendBroadcast(intent);
    }
}
