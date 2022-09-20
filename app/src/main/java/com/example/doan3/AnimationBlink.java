package com.example.doan3;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class AnimationBlink extends AppCompatActivity {
    private ImageView imgLogo;
    private TextView tvVuiVe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_blink);
        imgLogo = findViewById(R.id.imgLogo);
        tvVuiVe = findViewById(R.id.tvVuiVe);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.blink);
        imgLogo.startAnimation(animation);
        tvVuiVe.startAnimation(animation);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(com.example.doan3.AnimationBlink.this, RoundOne.class ));
            }
        }, 3000);
    }

    }

