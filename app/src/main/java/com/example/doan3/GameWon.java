package com.example.doan3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class GameWon extends AppCompatActivity {
    private Button btntieptucchoicm;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_won);
        btntieptucchoicm = findViewById(R.id.btntieptucchoiCm);
        textView = findViewById(R.id.tvchucmung);
        btntieptucchoicm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        startActivity(new Intent(com.example.doan3.GameWon.this, Overcome.class));
                    }
                },1000);

            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
