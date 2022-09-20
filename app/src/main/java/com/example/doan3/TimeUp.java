package com.example.doan3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TimeUp extends AppCompatActivity {
    private TextView timeup;
    private ImageView imgTimeup;
    private Button btnTimeUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_up);
        timeup = findViewById(R.id.timeup);
        imgTimeup = findViewById(R.id.imgTimeup);
        btnTimeUp = findViewById(R.id.btnTimeUp);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");
//        timeup.setTypeface(typeface);
//        btnTimeUp.setTypeface(typeface);
        btnTimeUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.doan3.TimeUp.this, Startscreen.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
