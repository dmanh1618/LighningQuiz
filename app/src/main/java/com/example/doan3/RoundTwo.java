package com.example.doan3;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RoundTwo extends AppCompatActivity {
    private FrameLayout Framediem2;
    private TextView tvdiem2;
    private TextView tvdiemso2;
    private TextView tvthoigian2;
    private TextView tvgiay2;
    private TextView tvTroGiup;
    private TextView tvDoiCauhoi;
    private FrameLayout btnDoiCauhoi2;
    private TextView Xem100s2;
    private FrameLayout frame100diem2;
    private TextView tv100d2;
    private TextView tvdiem1002;
    private ImageView imgHome2;
    private CheckBox imgVolume2;
    private TextView tvCauhoi2;
    private Button btnluachon2;
    private FrameLayout FrameLayoutDapAnA2;
    private TextView tvDapAnA2;
    private FrameLayout FrameLayoutDapAnB2;
    private TextView tvDapAnB2;
    private FrameLayout FrameLayoutDapAnC2;
    private TextView tvDapAnC2;
    private FrameLayout FrameLayoutDapAnD2;
    private TextView tvDapAnD2;
    Question currentQuestion;
    QuestionHelper questionHelper;
    List<Question> list;
    int qid = 0;
    int timeValue = 0;
    int coinValue = 0;
    CountDownTimer countDownTimer;
    MediaPlayer bacgroudmuis = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_two);
        intit();
//        bacgroudmuis = MediaPlayer.create(this, R.raw.bensoundinspire);
//        bacgroudmuis.start();
//        bacgroudmuis.setLooping(true);
//        imgVolume2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked){
//                    bacgroudmuis.pause();
//                }else {
//                    bacgroudmuis.start();
//                }
//            }
//        });
        imgHome2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReturnMenu();
            }
        });
    }

    private void intit(){
        Framediem2 = findViewById(R.id.Framediem2);
        tvdiem2 = findViewById(R.id.tvdiem2);
        tvdiemso2 = findViewById(R.id.tvdiemso2);
        tvthoigian2 = findViewById(R.id.tvthoigian2);
        tvgiay2 = findViewById(R.id.tvgiay2);
        tvTroGiup = findViewById(R.id.tvTroGiup);
        tvDoiCauhoi = findViewById(R.id.tvDoiCauhoi);
        btnDoiCauhoi2 = findViewById(R.id.btnDoiCauhoi2);
        Xem100s2 = findViewById(R.id.Xem100s2);
        frame100diem2 = findViewById(R.id.frame100diem2);
        tv100d2 = findViewById(R.id.tv100d2);
        tvdiem1002 = findViewById(R.id.tvdiem1002);
        imgHome2 = findViewById(R.id.imgHome2);
        imgVolume2 = findViewById(R.id.imgVolume2);
        tvCauhoi2 = findViewById(R.id.tvCauhoi2);
        btnluachon2 = findViewById(R.id.btnluachon2);
        FrameLayoutDapAnA2 = findViewById(R.id.FrameLayout_DapAnA2);
        tvDapAnA2 = findViewById(R.id.tvDapAn_A2);
        FrameLayoutDapAnB2 = findViewById(R.id.FrameLayout_DapAnB2);
        tvDapAnB2 = findViewById(R.id.tvDapAn_B2);
        FrameLayoutDapAnC2 = findViewById(R.id.FrameLayout_DapAnC2);
        tvDapAnC2 = findViewById(R.id.tvDapAn_C2);
        FrameLayoutDapAnD2 = findViewById(R.id.FrameLayout_DapAnD2);
        tvDapAnD2 = findViewById(R.id.tvDapAn_D2);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");
//        tv100d2.setTypeface(typeface);
//        tvCauhoi2.setTypeface(typeface);
//        tvDoiCauhoi.setTypeface(typeface);
//        tvdiem2.setTypeface(typeface);
//        tvdiemso2.setTypeface(typeface);
//        tvdiem1002.setTypeface(typeface);
//        tvgiay2.setTypeface(typeface);
//        tvTroGiup.setTypeface(typeface);
//        tvthoigian2.setTypeface(typeface);
//        tvDapAnA2.setTypeface(typeface);
//        tvDapAnB2.setTypeface(typeface);
//        tvDapAnC2.setTypeface(typeface);
//        tvDapAnD2.setTypeface(typeface);
//        Xem100s2.setTypeface(typeface);

        frame100diem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coinValue < 100){
                    Dungtrogiup();
                }else if (timeValue < 60){
                    ThoiGianchuadu();
                }
                else {
                    list = questionHelper.getAllofTheQuestion();

                    Collections.shuffle(list);
                    String a = String.valueOf(coinValue-=100);
                    tvdiemso2.setText(a);
                    coinValue-=100;

                }

            }
        });
        btnDoiCauhoi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChucNangChuaCapnhat();
            }
        });

        questionHelper = new QuestionHelper(this);
        questionHelper.getWritableDatabase();

// ki???m tra n???u ques, t??y ch???n ???? ???????c th??m v??o trong b???ng hay kh??ng
// N???u  kh??ng ???????c th??m v??o th?? getAllOfTheQuestions () s??? tr??? v??? m???t danh s??ch c?? k??ch th?????c b???ng kh??ng
        if (questionHelper.getAllofTheQuestion().size() == 0) {

// N???u kh??ng ???????c th??m th?? th??m ques, t??y ch???n trong b???ng
            questionHelper.allQuestion();
        }

// tr??? v???  danh s??ch ki???u d??? li???u Question
        list = questionHelper.getAllofTheQuestion();

//  X??o tr???n c??c ph???n t??? c???a danh s??ch ????? ch??ng ta s??? nh???n ???????c c??u h???i ng???u nhi??n
        Collections.shuffle(list);

// currentQuestion s??? gi??? t??y ch???n que, 4 v?? ans cho id c??? th???
        currentQuestion = list.get(qid);
        //countDownTimer
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvthoigian2.setText(String.valueOf(timeValue) + "\tgi??y");

// V???i m???i l???n gi???m d???n th???i gian b???ng 1 gi??y
                timeValue -= -1;

//  h???t th???i gian ????? onFinished s??? g???i sau l???n l???p n??y
                if (timeValue == -1) {

// ng?????i d??ng ???? h???t th???i gian setText l??m th???i gian
                    tvthoigian2.setText("H???t gi???");
// V?? ng?????i d??ng h???t th???i gian n??n s??? kh??ng th??? nh???p v??o b???t k??? n??t n??o
                    disableButton();
                }
            }

            // ng?????i d??ng ???? h???t th???i gian
            @Override
            public void onFinish() {
                timeUp();
            }
        }.start();

// Ph????ng th???c n??y s??? ?????t que v?? b???n t??y ch???n
        updateQueAndOptions();


    }
    private void timeUp() {
        Intent intent = new Intent(this, TimeUp.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        countDownTimer.start();
    }

    // Khi ho???t ?????ng b??? h???y th?? thao t??c n??y s??? h???y h???n gi???
    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }


    // ??i???u n??y s??? t???m d???ng th???i gian
    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this, Startscreen.class);
        startActivity(intent);
        finish();
    }
    // Ph????ng th???c n??y s??? v?? hi???u h??a t???t c??? c??c n??t t??y ch???n
    private void disableButton() {
        tvDapAnA2.setEnabled(false);
        tvDapAnB2.setEnabled(false);
        tvDapAnC2.setEnabled(false);
        tvDapAnD2.setEnabled(false);
    }

    // Ph????ng th???c n??y s??? cho ph??p c??c n??t t??y ch???n
    private void enableButton() {
        tvDapAnA2.setEnabled(true);
        tvDapAnB2.setEnabled(true);
        tvDapAnC2.setEnabled(true);
        tvDapAnD2.setEnabled(true);
    }
    private void correctDialog() {
        final Dialog dialogCorrect = new Dialog(com.example.doan3.RoundTwo.this);
        dialogCorrect.requestWindowFeature(Window.FEATURE_NO_TITLE);
        if (dialogCorrect.getWindow() != null) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.TRANSPARENT);
            dialogCorrect.getWindow().setBackgroundDrawable(colorDrawable);
        }
        dialogCorrect.setContentView(R.layout.dialog_correct);
        dialogCorrect.setCancelable(false);
        dialogCorrect.show();


// V?? h???p tho???i ???????c hi???n th??? cho ng?????i d??ng, ch??? c???n t???m d???ng b??? h???n gi??? ??? ch??? ????? n???n
        onPause();


        TextView correctText = dialogCorrect.findViewById(R.id.correctText);
        Button buttonNext = dialogCorrect.findViewById(R.id.dialogNext);
        // Thi???t l???p ki???u ch??? cho textview v?? n??t
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");
//        correctText.setTypeface(typeface);
//        buttonNext.setTypeface(typeface);

        //OnCLick listener
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

// lo???i b??? h???p tho???i
                dialogCorrect.dismiss();

// n?? s??? t??ng s??? c??u h???i
                qid++;
//                if (qid == 2){
//                    gameWon();
//                }

// l???y t??y ch???n que v?? 4 v?? l??u tr??? trong currentQuestion
                currentQuestion = list.get(qid);
                updateQueAndOptions();

// thi???t l???p h??ng ?????i m???i v?? 4 t??y ch???n
                resetColor();
                //Enable button - remember we had disable them when user ans was correct in there particular button methods
                enableButton();
            }
        });
    }
    private void resetColor() {
        FrameLayoutDapAnA2.setBackgroundResource(R.drawable.fom_start);
        FrameLayoutDapAnB2.setBackgroundResource(R.drawable.fom_start);
        FrameLayoutDapAnC2.setBackgroundResource(R.drawable.fom_start);
        FrameLayoutDapAnD2.setBackgroundResource(R.drawable.fom_start);
    }
    private void ReturnMenu() {
        final Dialog dialog = new Dialog(com.example.doan3.RoundTwo.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghome);
        dialog.show();
        TextView tvtextthoat;
        Button btnTiepTuc;
        Button btnMenu;

        tvtextthoat = dialog.findViewById(R.id.tvtextthoat);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        btnMenu = dialog.findViewById(R.id.btnMenu);
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");
//        tvtextthoat.setTypeface(typeface);
//        btnTiepTuc.setTypeface(typeface);
//        btnMenu.setTypeface(typeface);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.doan3.RoundTwo.this, Startscreen.class));
            }
        });
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }


    private void updateQueAndOptions() {

        // Ph????ng th???c n??y s??? setText cho h??ng ?????i v?? c??c t??y ch???n
        tvCauhoi2.setText(currentQuestion.getQuestion());
        tvDapAnA2.setText(currentQuestion.getOpta());
        tvDapAnB2.setText(currentQuestion.getOptb());
        tvDapAnC2.setText(currentQuestion.getOptc());
        tvDapAnD2.setText(currentQuestion.getOptd());
        timeValue =0;

// B??y gi???, v?? ng?????i d??ng ???? s???a l???i ch??nh x??c, h??y ?????t l???i b??? h???n gi??? cho m???t h??ng ?????i kh??c b???ng c??ch h???y v?? b???t ?????u
        countDownTimer.cancel();
        countDownTimer.start();

        // ?????t gi?? tr??? ??i???m
        tvdiemso2.setText(String.valueOf(coinValue));

// t??ng ??i???m
        coinValue+=50;

    }



    public void FrameLayout_DapAnB2(View view) {

// so s??nh t??y ch???n v???i ans n???u c?? th?? l??m cho n??t m??u xanh l?? c??y
        if (currentQuestion.getOptb().equals(currentQuestion.getAnswer())) {
            FrameLayoutDapAnA2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

// Ki???m tra xem ng?????i d??ng c?? v?????t qu?? gi???i h???n que kh??ng
            if (qid < list.size() - 1) {


// B??y gi??? v?? hi???u h??a t???t c??? c??c n??t t??y ch???n v?? ans c???a ng?????i d??ng l?? ch??nh x??c
                // ng?????i d??ng s??? kh??ng th??? nh???n n??t t??y ch???n kh??c sau khi nh???n m???t n??t
                disableButton();

                // Hi???n th??? h???p tho???i ans l?? ch??nh x??c
                correctDialog();
                timeValue=0;
            }
            // N???u ng?????i d??ng v?????t qu?? gi???i h???n que ch??? c???n ??i???u h?????ng anh ta ?????n ho???t ?????ng GameWon
         else
            gameWon();
        }


// Ans ng?????i d??ng sai r???i ch??? ??i???u h?????ng anh ???y ?????n ho???t ?????ng PlayAgain
        else {

            gameLostPlayAgain();

        }
    }

    public void FrameLayout_DapAnA2(View view) {
        // so s??nh t??y ch???n v???i ans n???u c?? th?? l??m cho n??t m??u xanh l?? c??y
        if (currentQuestion.getOpta().equals(currentQuestion.getAnswer())) {
            FrameLayoutDapAnB2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

// Ki???m tra xem ng?????i d??ng c?? v?????t qu?? gi???i h???n que kh??ng
            if (qid < list.size() - 1) {


// B??y gi??? v?? hi???u h??a t???t c??? c??c n??t t??y ch???n v?? ans c???a ng?????i d??ng l?? ch??nh x??c
                // ng?????i d??ng s??? kh??ng th??? nh???n n??t t??y ch???n kh??c sau khi nh???n m???t n??t
                disableButton();

                // Hi???n th??? h???p tho???i ans l?? ch??nh x??c
                correctDialog();
                timeValue=0;
            }
            // N???u ng?????i d??ng v?????t qu?? gi???i h???n que ch??? c???n ??i???u h?????ng anh ta ?????n ho???t ?????ng GameWon
            else
                gameWon();
        }


// Ans ng?????i d??ng sai r???i ch??? ??i???u h?????ng anh ???y ?????n ho???t ?????ng PlayAgain
        else {

            gameLostPlayAgain();

        }
    }

    public void FrameLayout_DapAnC2(View view) {
        // so s??nh t??y ch???n v???i ans n???u c?? th?? l??m cho n??t m??u xanh l?? c??y
        if (currentQuestion.getOptc().equals(currentQuestion.getAnswer())) {
            FrameLayoutDapAnC2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

// Ki???m tra xem ng?????i d??ng c?? v?????t qu?? gi???i h???n que kh??ng
            if (qid < list.size() - 1) {


// B??y gi??? v?? hi???u h??a t???t c??? c??c n??t t??y ch???n v?? ans c???a ng?????i d??ng l?? ch??nh x??c
                // ng?????i d??ng s??? kh??ng th??? nh???n n??t t??y ch???n kh??c sau khi nh???n m???t n??t
                disableButton();

                // Hi???n th??? h???p tho???i ans l?? ch??nh x??c
                correctDialog();
                timeValue=0;
            }
            // N???u ng?????i d??ng v?????t qu?? gi???i h???n que ch??? c???n ??i???u h?????ng anh ta ?????n ho???t ?????ng GameWon
            else
                gameWon();
        }


// Ans ng?????i d??ng sai r???i ch??? ??i???u h?????ng anh ???y ?????n ho???t ?????ng PlayAgain
        else {

            gameLostPlayAgain();

        }
    }

    public void FrameLayout_DapAnD2(View view) {
        // so s??nh t??y ch???n v???i ans n???u c?? th?? l??m cho n??t m??u xanh l?? c??y
        if (currentQuestion.getOptd().equals(currentQuestion.getAnswer())) {
            FrameLayoutDapAnD2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

// Ki???m tra xem ng?????i d??ng c?? v?????t qu?? gi???i h???n que kh??ng
            if (qid < list.size() - 1) {


// B??y gi??? v?? hi???u h??a t???t c??? c??c n??t t??y ch???n v?? ans c???a ng?????i d??ng l?? ch??nh x??c
                // ng?????i d??ng s??? kh??ng th??? nh???n n??t t??y ch???n kh??c sau khi nh???n m???t n??t
                disableButton();

                // Hi???n th??? h???p tho???i ans l?? ch??nh x??c
                correctDialog();
                timeValue=0;
            }
            // N???u ng?????i d??ng v?????t qu?? gi???i h???n que ch??? c???n ??i???u h?????ng anh ta ?????n ho???t ?????ng GameWon
            else
                gameWon();
        }


// Ans ng?????i d??ng sai r???i ch??? ??i???u h?????ng anh ???y ?????n ho???t ?????ng PlayAgain
        else {

            gameLostPlayAgain();

        }
    }
    public void gameLostPlayAgain() {
        Intent intent = new Intent(this, PlayAgain.class);
        startActivity(intent);
        finish();
    }
    public void gameWon() {
        Intent intent = new Intent(this, GuideTwo.class);
        startActivity(intent);
        finish();
    }
    private void Dungtrogiup(){
        final Dialog dialog = new Dialog(com.example.doan3.RoundTwo.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghelp);
        dialog.show();
        TextView tvtextStatus;
        Button btnTiepTuc;

        tvtextStatus = dialog.findViewById(R.id.tvtextStatus);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);

//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");
//        tvtextStatus.setTypeface(typeface);
//        btnTiepTuc.setTypeface(typeface);
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }
    private void ChucNangChuaCapnhat(){
        final Dialog dialog = new Dialog(com.example.doan3.RoundTwo.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghelp);
        dialog.show();
        TextView tvtextStatus;
        Button btnTiepTuc;

        tvtextStatus = dialog.findViewById(R.id.tvtextStatus);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        tvtextStatus.setText("Ch???c n??ng n??y ??ang ???????c c???p nh???p !!");
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");
//        tvtextStatus.setTypeface(typeface);
//        btnTiepTuc.setTypeface(typeface);
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }
    private void ThoiGianchuadu(){
        final Dialog dialog = new Dialog(com.example.doan3.RoundTwo.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghelp);
        dialog.show();
        TextView tvtextStatus;
        Button btnTiepTuc;

        tvtextStatus = dialog.findViewById(R.id.tvtextStatus);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        tvtextStatus.setText("Th???i gian ch??a ????? ????? b???n s??? d???ng quy???n tr??? gi??p");

//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");
//        tvtextStatus.setTypeface(typeface);
//        btnTiepTuc.setTypeface(typeface);
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

}
