package com.example.doan3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class Loadgame extends AppCompatActivity {
    private TextView tvvong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_game);

        tvvong = findViewById(R.id.tvvong);

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(com.example.doan3.Loadgame.this,  GuideOne.class ));
            }
        }, 1000);
    }
}
