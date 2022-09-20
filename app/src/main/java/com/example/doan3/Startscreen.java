package com.example.doan3;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Startscreen extends AppCompatActivity {
Button btnBatDau;
    private Button btnthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnBatDau = findViewById(R.id.btnbatdau);
        btnthoat = findViewById(R.id.btnthoat);

        btnBatDau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(com.example.doan3.Startscreen.this, Loadgame.class));
            }
        });
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exitdialog();
            }
        });
    }
    private void Exitdialog(){
        final Dialog dialog = new Dialog(com.example.doan3.Startscreen.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghome);
        dialog.show();
        TextView tvtextthoat;
        Button btnTiepTuc;
        Button btnMenu;

        tvtextthoat = dialog.findViewById(R.id.tvtextthoat);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        btnMenu = dialog.findViewById(R.id.btnMenu);

       tvtextthoat.setText("Bạn có muốn thoát không ???");
        btnMenu.setText("Thoát");

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.doan3.Startscreen.class);
                startActivity(intent);
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}
