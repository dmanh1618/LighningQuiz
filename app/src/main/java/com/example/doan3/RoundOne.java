package com.example.doan3;

import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.AnimatedImageDrawable;
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
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

public class RoundOne extends AppCompatActivity {
    private FrameLayout Framediem;
    private TextView tvdiem,tvXem50,tvdiemso,tvTroGiup,tvThem30s,tv100d,tvdiem100,tv50d,tvdiem50;
    private FrameLayout frame100diem;
    private FrameLayout frame50diem;
    private FrameLayout btnXemthem30s;
    private TextView tvDoiCauhoi;
    private FrameLayout btnDoiCauhoi;
    private ImageView imgHome;
    private CheckBox imgVolume;
    private TextView tvCauhoi;
    private Button btnluachon;
    private FrameLayout FrameLayoutDapAnA;
    private TextView tvDapAnA;
    private FrameLayout FrameLayoutDapAnB;
    private TextView tvDapAnB;
    private FrameLayout FrameLayoutDapAnC;
    private TextView tvDapAnC;
    private FrameLayout FrameLayoutDapAnD;
    private TextView tvDapAnD;
    private ImageView score10;
    private TextView tvo10;
    private ImageView score9;
    private TextView tvo9;
    private ImageView score8;
    private TextView tvo8;
    private ImageView score7;
    private TextView tvo7;
    private ImageView score6;
    private TextView tvo6;
    private ImageView score5;
    private TextView tvo5;
    private ImageView score4;
    private TextView tvo4;
    private ImageView score3;
    private TextView tvo3;
    private ImageView score2;
    private TextView tvo2;
    private ImageView score1;
    private TextView tvo1;
    private TextView tvCautraLoi;
    private TextView tvThoiGian;
    private TextView tvXem100;
    private ImageView imgAnimation;
    Question Question;
    QuestionHelper questionHelper;
    List<Question> list;
    int qid = 0;
    int timeValue = 0;
    int coinValue = 0;
    AnimatedImageDrawable animatedImageDrawable;
    CountDownTimer countDownTimer;
    MediaPlayer bacgroudmuis = new MediaPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_one);
        khaibao();
        Them30s();
        Doicauhoi();
        onclickDoiCauhoi();
        onclickXemthem30s();
        imgHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReturnMenu();
            }
        });

        ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 650f);
        anim.setDuration(100);
        anim.start();
        bacgroudmuis = MediaPlayer.create(this, R.raw.bensoundinspire);
        bacgroudmuis.start();
        bacgroudmuis.setLooping(true);
        imgVolume.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    bacgroudmuis.pause();
                } else {
                    bacgroudmuis.start();
                }
            }
        });
    }

    // Kh???i t???o bi???n
    private void khaibao() {
        Framediem = findViewById(R.id.Framediem);
        tvdiem = findViewById(R.id.tvdiem);
        tv100d = findViewById(R.id.tv100d);
        tvdiem100 = findViewById(R.id.tvdiem100);
        frame50diem = findViewById(R.id.frame50diem);
        tv50d = findViewById(R.id.tv50d);
        tvdiem50 = findViewById(R.id.tvdiem50);
        frame100diem = findViewById(R.id.frame100diem);
        tvdiemso = findViewById(R.id.tvdiemso);
        tvTroGiup = findViewById(R.id.tvTroGiup);
        tvThem30s = findViewById(R.id.tvThem30s);
        btnXemthem30s = findViewById(R.id.btnXemthem30s);
        tvDoiCauhoi = findViewById(R.id.tvDoiCauhoi);
        btnDoiCauhoi = findViewById(R.id.btnDoiCauhoi);
        imgHome = findViewById(R.id.imgHome);
        imgAnimation = findViewById(R.id.imganimation);
        imgVolume = findViewById(R.id.imgVolume);
        tvCauhoi = findViewById(R.id.tvCauhoi);
        FrameLayoutDapAnA = findViewById(R.id.FrameLayout_DapAnA);
        tvDapAnA = findViewById(R.id.tvDapAn_A);
        FrameLayoutDapAnB = findViewById(R.id.FrameLayout_DapAnB);
        tvDapAnB = findViewById(R.id.tvDapAn_B);
        FrameLayoutDapAnC = findViewById(R.id.FrameLayout_DapAnC);
        tvDapAnC = findViewById(R.id.tvDapAn_C);
        FrameLayoutDapAnD = findViewById(R.id.FrameLayout_DapAnD);
        tvDapAnD = findViewById(R.id.tvDapAn_D);
        score10 = findViewById(R.id.score10);
        tvo10 = findViewById(R.id.tvo10);
        score9 = findViewById(R.id.score9);
        tvo9 = findViewById(R.id.tvo9);
        score8 = findViewById(R.id.score8);
        tvo8 = findViewById(R.id.tvo8);
        score7 = findViewById(R.id.score7);
        tvo7 = findViewById(R.id.tvo7);
        score6 = findViewById(R.id.score6);
        tvo6 = findViewById(R.id.tvo6);
        score5 = findViewById(R.id.score5);
        tvo5 = findViewById(R.id.tvo5);
        score4 = findViewById(R.id.score4);
        tvo4 = findViewById(R.id.tvo4);
        score3 = findViewById(R.id.score3);
        tvo3 = findViewById(R.id.tvo3);
        score2 = findViewById(R.id.score2);
        tvo2 = findViewById(R.id.tvo2);
        score1 = findViewById(R.id.score1);
        tvo1 = findViewById(R.id.tvo1);
        tvThoiGian = findViewById(R.id.tvthoigian);
        tvXem50 = findViewById(R.id.Xem50s);
        tvXem100 = findViewById(R.id.tvxem100);

        // Khai b??o c?? s??? d?? li??u
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

        Collections.shuffle(list);

        Question = list.get(qid);
        //countDownTimer
        countDownTimer = new CountDownTimer(120000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvThoiGian.setText(String.valueOf(timeValue) + "\tgi??y");
// V???i m???i l???n gi???m d???n th???i gian b???ng 1 gi??y
                timeValue -= -1;
//  h???t th???i gian ????? onFinished s??? g???i sau l???n l???p n??y
                if (timeValue == -1) {
                    tvThoiGian.setText("H???t gi???");
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

    private void Them30s() {
        frame100diem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coinValue < 100) {
                    Dungtrogiup();
                } else if (timeValue < 60) {
                    ThoiGianchuadu();
                } else {

                    String a = String.valueOf(coinValue -= 150);
                    tvdiemso.setText(a);
                    timeValue -= 30;
                }
            }
        });
    }

    private void Doicauhoi() {
        frame50diem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coinValue < 100) {
                    Dungtrogiup();
                } else if (timeValue < 60) {
                    ThoiGianchuadu();
                } else {
                    list = questionHelper.getAllofTheQuestion();

                    Collections.shuffle(list);
                    String a = String.valueOf(coinValue -= 100);
                    tvdiemso.setText(a);
                    coinValue -= 100;
                }

            }
        });
    }

    private void ReturnMenu() {
        final Dialog dialog = new Dialog(com.example.doan3.RoundOne.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghome);
        dialog.show();
        TextView tvtextthoat;
        Button btnTiepTuc;
        Button btnMenu;
        tvtextthoat = dialog.findViewById(R.id.tvtextthoat);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        btnMenu = dialog.findViewById(R.id.btnMenu);
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(com.example.doan3.RoundOne.this, Startscreen.class));
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
        tvCauhoi.setText(Question.getQuestion());
        tvDapAnA.setText(Question.getOpta());
        tvDapAnB.setText(Question.getOptb());
        tvDapAnC.setText(Question.getOptc());
        tvDapAnD.setText(Question.getOptd());


// B??y gi???, v?? ng?????i d??ng ???? s???a l???i ch??nh x??c, h??y ?????t l???i b??? h???n gi??? cho m???t h??ng ?????i kh??c b???ng c??ch h???y v?? b???t ?????u
        countDownTimer.cancel();
        countDownTimer.start();

        // ?????t gi?? tr??? ??i???m
        tvdiemso.setText(String.valueOf(coinValue));

// t??ng ??i???m
        coinValue += 50;

    }

    // Ph????ng th???c n??y ???????c g???i khi h???t th???i gian
    private void timeUp() {
        Intent intent = new Intent(this, TimeUp.class);
        startActivity(intent);
        finish();
    }

    // N???u ng?????i d??ng nh???n n??t home v?? v??o game t??? b??? nh??? th??
    // ph????ng ph??p s??? ti???p t???c h???n gi??? t??? l???n tr?????c n?? c??n l???i
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
        tvDapAnA.setEnabled(false);
        tvDapAnB.setEnabled(false);
        tvDapAnC.setEnabled(false);
        tvDapAnD.setEnabled(false);
    }

    // Ph????ng th???c n??y s??? cho ph??p c??c n??t t??y ch???n
    private void enableButton() {
        tvDapAnA.setEnabled(true);
        tvDapAnB.setEnabled(true);
        tvDapAnC.setEnabled(true);
        tvDapAnD.setEnabled(true);
    }


    private void correctDialog() {
        final Dialog dialogCorrect = new Dialog(com.example.doan3.RoundOne.this);
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
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

// lo???i b??? h???p tho???i
                dialogCorrect.dismiss();

// n?? s??? t??ng s??? c??u h???i
                qid++;

                Question = list.get(qid);
                updateQueAndOptions();

// thi???t l???p h??ng ?????i m???i v?? 4 t??y ch???n
                resetColor();
                enableButton();
            }
        });
    }

    // thiet lap mau
    private void resetColor() {
        FrameLayoutDapAnA.setBackgroundResource(R.drawable.fom_start);
        FrameLayoutDapAnB.setBackgroundResource(R.drawable.fom_start);
        FrameLayoutDapAnC.setBackgroundResource(R.drawable.fom_start);
        FrameLayoutDapAnD.setBackgroundResource(R.drawable.fom_start);
    }

    public void FrameLayout_DapAnA(View view) {

        FrameLayoutDapAnA.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));
        if (Question.getOpta().equals(Question.getAnswer())) {
// Ki???m tra xem ng?????i d??ng c?? v?????t qu?? gi???i h???n que kh??ng
            if (qid < list.size() - 1) {

// B??y gi??? v?? hi???u h??a t???t c??? c??c n??t t??y ch???n v?? ans c???a ng?????i d??ng l?? ch??nh x??c
                // ng?????i d??ng s??? kh??ng th??? nh???n n??t t??y ch???n kh??c sau khi nh???n m???t n??t
                disableButton();
                // Hi???n th??? h???p tho???i ans l?? ch??nh x??c
                correctDialog();
            }
            // N???u ng?????i d??ng v?????t qu?? gi???i h???n que ch??? c???n ??i???u h?????ng anh ta ?????n ho???t ?????ng GameWon
        }
        if (qid == 0) {
            score1.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 1) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 585f);
            anim.setDuration(10);
            anim.start();
            score2.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 2) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 510f);
            anim.setDuration(10);
            anim.start();
            score3.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 3) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 435f);
            anim.setDuration(10);
            anim.start();
            score4.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 4) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 360f);
            anim.setDuration(10);
            anim.start();
            score5.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 5) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 285);
            anim.setDuration(10);
            anim.start();
            score6.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 6) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 210f);
            anim.setDuration(10);
            anim.start();
            score7.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 7) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 135f);
            anim.setDuration(10);
            anim.start();
            score8.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 8) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 60f);
            anim.setDuration(10);
            anim.start();
            score9.setBackgroundResource(R.drawable.anim4);
        } else if (qid == 9) {
            ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 0f);
            anim.setDuration(10);
            anim.start();
            score10.setBackgroundResource(R.drawable.anim4);
            gameWon();
        }

// Ans ng?????i d??ng sai r???i ch??? ??i???u h?????ng anh ???y ?????n ho???t ?????ng PlayAgain
        else {

            gameLostPlayAgain();

        }
    }
    //Onclick listener
    public void FrameLayout_DapAnB(View view) {
        FrameLayoutDapAnB.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

        if (Question.getOptb().equals(Question.getAnswer())) {
            if (qid < list.size() - 1) {
                disableButton();
                correctDialog();
            }
            if (qid == 0) {
                score1.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 1) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 585f);
                anim.setDuration(10);
                anim.start();
                score2.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 2) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 510f);
                anim.setDuration(10);
                anim.start();
                score3.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 3) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 435f);
                anim.setDuration(10);
                anim.start();
                score4.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 4) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 360f);
                anim.setDuration(10);
                anim.start();
                score5.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 5) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 285);
                anim.setDuration(10);
                anim.start();
                score6.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 6) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 210f);
                anim.setDuration(10);
                anim.start();
                score7.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 7) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 135f);
                anim.setDuration(10);
                anim.start();
                score8.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 8) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 60f);
                anim.setDuration(10);
                anim.start();
                score9.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 9) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 0f);
                anim.setDuration(10);
                anim.start();
                score10.setBackgroundResource(R.drawable.anim4);
                gameWon();
            }
        } else {
            gameLostPlayAgain();

        }
    }

    //Onclick listener
    public void FrameLayout_DapAnC(View view) {
        FrameLayoutDapAnC.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

        if (Question.getOptc().equals(Question.getAnswer())) {
            if (qid < list.size() - 1) {
                disableButton();
                correctDialog();
            }
            if (qid == 0) {
                score1.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 1) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 585f);
                anim.setDuration(10);
                anim.start();
                score2.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 2) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 510f);
                anim.setDuration(10);
                anim.start();
                score3.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 3) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 435f);
                anim.setDuration(10);
                anim.start();
                score4.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 4) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 360f);
                anim.setDuration(10);
                anim.start();
                score5.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 5) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 285);
                anim.setDuration(10);
                anim.start();
                score6.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 6) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 210f);
                anim.setDuration(10);
                anim.start();
                score7.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 7) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 135f);
                anim.setDuration(10);
                anim.start();
                score8.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 8) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 60f);
                anim.setDuration(10);
                anim.start();
                score9.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 9) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 0f);
                anim.setDuration(10);
                anim.start();
                score10.setBackgroundResource(R.drawable.anim4);
                gameWon();
            }

        } else {

            gameLostPlayAgain();
        }
    }

    //Onclick listener
    public void FrameLayout_DapAnD(View view) {
        FrameLayoutDapAnD.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

        if (Question.getOptd().equals(Question.getAnswer())) {
            if (qid < list.size() - 1) {
                disableButton();
                correctDialog();

            }
            if (qid == 0) {
                score1.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 1) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 585f);
                anim.setDuration(10);
                anim.start();
                score2.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 2) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 510f);
                anim.setDuration(10);
                anim.start();
                score3.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 3) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 435f);
                anim.setDuration(10);
                anim.start();
                score4.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 4) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 360f);
                anim.setDuration(10);
                anim.start();
                score5.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 5) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 285);
                anim.setDuration(10);
                anim.start();
                score6.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 6) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 210f);
                anim.setDuration(10);
                anim.start();
                score7.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 7) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 135f);
                anim.setDuration(10);
                anim.start();
                score8.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 8) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 60f);
                anim.setDuration(10);
                anim.start();
                score9.setBackgroundResource(R.drawable.anim4);
            } else if (qid == 9) {
                ObjectAnimator anim = ObjectAnimator.ofFloat(imgAnimation, "translationY", 0f, 0f);
                anim.setDuration(10);
                anim.start();
                score10.setBackgroundResource(R.drawable.anim4);
                gameWon();
            }

        } else {

            gameLostPlayAgain();
        }
    }
    // Ph????ng th???c n??y ???????c g???i khi ng?????i d??ng ans sai
    // ph????ng ph??p n??y s??? ??i???u h?????ng ng?????i d??ng ?????n ho???t ?????ng PlayAgain
    public void gameLostPlayAgain() {
        Intent intent = new Intent(this, PlayAgain.class);
        startActivity(intent);
        finish();
    }


    // Ph????ng th???c n??y s??? ??i???u h?????ng t??? ho???t ?????ng hi???n t???i sang Qua vong
    public void gameWon() {
        Intent intent = new Intent(this, GameWon.class);
        startActivity(intent);
        finish();
    }


    private void Dungtrogiup() {
        final Dialog dialog = new Dialog(com.example.doan3.RoundOne.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghelp);
        dialog.show();
        TextView tvtextStatus;
        Button btnTiepTuc;

        tvtextStatus = dialog.findViewById(R.id.tvtextStatus);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });


    }

    private void ChucNangChuaCapnhat() {
        final Dialog dialog = new Dialog(com.example.doan3.RoundOne.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghelp);
        dialog.show();
        TextView tvtextStatus;
        Button btnTiepTuc;

        tvtextStatus = dialog.findViewById(R.id.tvtextStatus);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        tvtextStatus.setText("Ch???c n??ng n??y ??ang ???????c c???p nh???p !!");

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

    }

    private void ThoiGianchuadu() {
        final Dialog dialog = new Dialog(com.example.doan3.RoundOne.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialoghelp);
        dialog.show();
        TextView tvtextStatus;
        Button btnTiepTuc;
        tvtextStatus = dialog.findViewById(R.id.tvtextStatus);
        btnTiepTuc = dialog.findViewById(R.id.btnTiepTuc);
        tvtextStatus.setText("Th???i gian ch??a ????? ????? b???n s??? d???ng quy???n tr??? gi??p");
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }

    private void onclickDoiCauhoi() {
        btnDoiCauhoi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChucNangChuaCapnhat();
            }
        });
    }

    private void onclickXemthem30s() {
        btnXemthem30s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChucNangChuaCapnhat();
            }
        });
    }

}
