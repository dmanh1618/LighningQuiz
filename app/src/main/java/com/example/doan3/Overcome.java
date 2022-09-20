package com.example.doan3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Overcome extends AppCompatActivity {
    private TextView tvchucmung2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_overcome);
        tvchucmung2 = findViewById(R.id.tvchucmung2);


        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(com.example.doan3.Overcome.this, LoandGame2.class ));
            }
        }, 1000);
    }
    }

