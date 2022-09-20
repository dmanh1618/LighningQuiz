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

// kiểm tra nếu ques, tùy chọn đã được thêm vào trong bảng hay không
// Nếu  không được thêm vào thì getAllOfTheQuestions () sẽ trả về một danh sách có kích thước bằng không
        if (questionHelper.getAllofTheQuestion().size() == 0) {

// Nếu không được thêm thì thêm ques, tùy chọn trong bảng
            questionHelper.allQuestion();
        }

// trả về  danh sách kiểu dữ liệu Question
        list = questionHelper.getAllofTheQuestion();

//  Xáo trộn các phần tử của danh sách để chúng ta sẽ nhận được câu hỏi ngẫu nhiên
        Collections.shuffle(list);

// currentQuestion sẽ giữ tùy chọn que, 4 và ans cho id cụ thể
        currentQuestion = list.get(qid);
        //countDownTimer
        countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvthoigian2.setText(String.valueOf(timeValue) + "\tgiây");

// Với mỗi lần giảm dần thời gian bằng 1 giây
                timeValue -= -1;

//  hết thời gian để onFinished sẽ gọi sau lần lặp này
                if (timeValue == -1) {

// người dùng đã hết thời gian setText làm thời gian
                    tvthoigian2.setText("Hết giờ");
// Vì người dùng hết thời gian nên sẽ không thể nhấp vào bất kỳ nút nào
                    disableButton();
                }
            }

            // người dùng đã hết thời gian
            @Override
            public void onFinish() {
                timeUp();
            }
        }.start();

// Phương thức này sẽ đặt que và bốn tùy chọn
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

    // Khi hoạt động bị hủy thì thao tác này sẽ hủy hẹn giờ
    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }


    // Điều này sẽ tạm dừng thời gian
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
    // Phương thức này sẽ vô hiệu hóa tất cả các nút tùy chọn
    private void disableButton() {
        tvDapAnA2.setEnabled(false);
        tvDapAnB2.setEnabled(false);
        tvDapAnC2.setEnabled(false);
        tvDapAnD2.setEnabled(false);
    }

    // Phương thức này sẽ cho phép các nút tùy chọn
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


// Vì hộp thoại được hiển thị cho người dùng, chỉ cần tạm dừng bộ hẹn giờ ở chế độ nền
        onPause();


        TextView correctText = dialogCorrect.findViewById(R.id.correctText);
        Button buttonNext = dialogCorrect.findViewById(R.id.dialogNext);
        // Thiết lập kiểu chữ cho textview và nút
//        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/UVNBanhMi.TTF");
//        correctText.setTypeface(typeface);
//        buttonNext.setTypeface(typeface);

        //OnCLick listener
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

// loại bỏ hộp thoại
                dialogCorrect.dismiss();

// nó sẽ tăng số câu hỏi
                qid++;
//                if (qid == 2){
//                    gameWon();
//                }

// lấy tùy chọn que và 4 và lưu trữ trong currentQuestion
                currentQuestion = list.get(qid);
                updateQueAndOptions();

// thiết lập hàng đợi mới và 4 tùy chọn
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

        // Phương thức này sẽ setText cho hàng đợi và các tùy chọn
        tvCauhoi2.setText(currentQuestion.getQuestion());
        tvDapAnA2.setText(currentQuestion.getOpta());
        tvDapAnB2.setText(currentQuestion.getOptb());
        tvDapAnC2.setText(currentQuestion.getOptc());
        tvDapAnD2.setText(currentQuestion.getOptd());
        timeValue =0;

// Bây giờ, vì người dùng đã sửa lỗi chính xác, hãy đặt lại bộ hẹn giờ cho một hàng đợi khác bằng cách hủy và bắt đầu
        countDownTimer.cancel();
        countDownTimer.start();

        // đặt giá trị điểm
        tvdiemso2.setText(String.valueOf(coinValue));

// tăng điểm
        coinValue+=50;

    }



    public void FrameLayout_DapAnB2(View view) {

// so sánh tùy chọn với ans nếu có thì làm cho nút màu xanh lá cây
        if (currentQuestion.getOptb().equals(currentQuestion.getAnswer())) {
            FrameLayoutDapAnA2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

// Kiểm tra xem người dùng có vượt quá giới hạn que không
            if (qid < list.size() - 1) {


// Bây giờ vô hiệu hóa tất cả các nút tùy chọn vì ans của người dùng là chính xác
                // người dùng sẽ không thể nhấn nút tùy chọn khác sau khi nhấn một nút
                disableButton();

                // Hiển thị hộp thoại ans là chính xác
                correctDialog();
                timeValue=0;
            }
            // Nếu người dùng vượt quá giới hạn que chỉ cần điều hướng anh ta đến hoạt động GameWon
         else
            gameWon();
        }


// Ans người dùng sai rồi chỉ điều hướng anh ấy đến hoạt động PlayAgain
        else {

            gameLostPlayAgain();

        }
    }

    public void FrameLayout_DapAnA2(View view) {
        // so sánh tùy chọn với ans nếu có thì làm cho nút màu xanh lá cây
        if (currentQuestion.getOpta().equals(currentQuestion.getAnswer())) {
            FrameLayoutDapAnB2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

// Kiểm tra xem người dùng có vượt quá giới hạn que không
            if (qid < list.size() - 1) {


// Bây giờ vô hiệu hóa tất cả các nút tùy chọn vì ans của người dùng là chính xác
                // người dùng sẽ không thể nhấn nút tùy chọn khác sau khi nhấn một nút
                disableButton();

                // Hiển thị hộp thoại ans là chính xác
                correctDialog();
                timeValue=0;
            }
            // Nếu người dùng vượt quá giới hạn que chỉ cần điều hướng anh ta đến hoạt động GameWon
            else
                gameWon();
        }


// Ans người dùng sai rồi chỉ điều hướng anh ấy đến hoạt động PlayAgain
        else {

            gameLostPlayAgain();

        }
    }

    public void FrameLayout_DapAnC2(View view) {
        // so sánh tùy chọn với ans nếu có thì làm cho nút màu xanh lá cây
        if (currentQuestion.getOptc().equals(currentQuestion.getAnswer())) {
            FrameLayoutDapAnC2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

// Kiểm tra xem người dùng có vượt quá giới hạn que không
            if (qid < list.size() - 1) {


// Bây giờ vô hiệu hóa tất cả các nút tùy chọn vì ans của người dùng là chính xác
                // người dùng sẽ không thể nhấn nút tùy chọn khác sau khi nhấn một nút
                disableButton();

                // Hiển thị hộp thoại ans là chính xác
                correctDialog();
                timeValue=0;
            }
            // Nếu người dùng vượt quá giới hạn que chỉ cần điều hướng anh ta đến hoạt động GameWon
            else
                gameWon();
        }


// Ans người dùng sai rồi chỉ điều hướng anh ấy đến hoạt động PlayAgain
        else {

            gameLostPlayAgain();

        }
    }

    public void FrameLayout_DapAnD2(View view) {
        // so sánh tùy chọn với ans nếu có thì làm cho nút màu xanh lá cây
        if (currentQuestion.getOptd().equals(currentQuestion.getAnswer())) {
            FrameLayoutDapAnD2.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorOranger));

// Kiểm tra xem người dùng có vượt quá giới hạn que không
            if (qid < list.size() - 1) {


// Bây giờ vô hiệu hóa tất cả các nút tùy chọn vì ans của người dùng là chính xác
                // người dùng sẽ không thể nhấn nút tùy chọn khác sau khi nhấn một nút
                disableButton();

                // Hiển thị hộp thoại ans là chính xác
                correctDialog();
                timeValue=0;
            }
            // Nếu người dùng vượt quá giới hạn que chỉ cần điều hướng anh ta đến hoạt động GameWon
            else
                gameWon();
        }


// Ans người dùng sai rồi chỉ điều hướng anh ấy đến hoạt động PlayAgain
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
        tvtextStatus.setText("Chức năng này đang được cập nhập !!");
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
        tvtextStatus.setText("Thời gian chưa đủ để bạn sử dụng quyền trợ giúp");

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
