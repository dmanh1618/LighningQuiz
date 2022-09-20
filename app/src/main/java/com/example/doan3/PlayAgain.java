package com.example.doan3;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayAgain extends AppCompatActivity {
    Button playAgain;
    TextView wrongAnsText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_again);

// Khởi tạo
        playAgain =  findViewById(R.id.playAgainButton);
        wrongAnsText = findViewById(R.id.wrongAns);


// phát lại nút onclick listener
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(com.example.doan3.PlayAgain.this, Startscreen.class);
                startActivity(intent);
                finish();
            }
        });



    }

    @Override
    public void onBackPressed() {
        finish();
    }
    }

