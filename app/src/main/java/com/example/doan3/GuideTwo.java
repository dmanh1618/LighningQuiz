package com.example.doan3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuideTwo extends AppCompatActivity {
    private TextView tvhuongdanvong2;
    private Button btnchoingay2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_play_roundtwo);


    }
    private void intit(){
        tvhuongdanvong2 = findViewById(R.id.tvhuongdanvong2);
        btnchoingay2 = findViewById(R.id.btnchoingay2);

        btnchoingay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.doan3.GuideTwo.this, RoundTwo.class));
            }
        });
    }
}
