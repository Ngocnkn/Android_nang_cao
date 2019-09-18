package com.example.lab1.bai3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lab1.R;

public class Bai3Activity extends AppCompatActivity {
    private EditText edt_nhap;
    private Button btn_timvana, btn_timvanb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);
        initview();
        handling();
    }

    private void handling() {
        btn_timvana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edt_nhap.getText().toString();
                if (text.trim().equals("")) {
                    Toast.makeText(Bai3Activity.this, "không được để trống ", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    char kyTu = 'a';
                    int count = 0;
                    for (int i = 0; i < text.length(); i++) {
                        if (text.charAt(i) == kyTu) {
                            count++;
                        }
                    }
                    Toast.makeText(Bai3Activity.this,
                            "Số lần xuất hiện của ký tự  " + kyTu +
                                    " trong chuỗi " + text + " = " + count,
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
        btn_timvanb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edt_nhap.getText().toString();
                if (text.trim().equals("")) {
                    Toast.makeText(Bai3Activity.this, "không được để trống ", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    char kyTu = 'b';
                    int count = 0;
                    for (int i = 0; i < text.length(); i++) {
                        if (text.charAt(i) == kyTu) {
                            count++;
                        }
                    }
                    Toast.makeText(Bai3Activity.this,
                            "Số lần xuất hiện của ký tự  " + kyTu +
                                    " trong chuỗi " + text + " = " + count,
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

    private void initview() {
        edt_nhap = findViewById(R.id.edt_nhap);
        btn_timvana = findViewById(R.id.btn_timvana);
        btn_timvanb = findViewById(R.id.btn_timvanb);
    }

}
