package com.example.doan3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuideOne extends AppCompatActivity {
private TextView tvhuongdan1;
private Button btnChoingay1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_play);
        tvhuongdan1 = findViewById(R.id.tvhuongdan);
        btnChoingay1 = findViewById(R.id.btnchoingay1);


        btnChoingay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                        startActivity(new Intent(com.example.doan3.GuideOne.this, AnimationBlink.class));

            }
        });

    }
}
