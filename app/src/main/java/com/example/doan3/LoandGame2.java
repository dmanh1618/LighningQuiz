package com.example.doan3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LoandGame2 extends AppCompatActivity {
    private TextView tvvong2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loand_game2);
        tvvong2 = findViewById(R.id.tvvong2);


    Timer timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            startActivity(new Intent(com.example.doan3.LoandGame2.this, RoundTwo.class ));
        }
    }, 2000);
}
    }

