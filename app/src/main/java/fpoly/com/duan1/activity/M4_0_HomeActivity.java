package fpoly.com.duan1.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import fpoly.com.duan1.R;

public class M4_0_HomeActivity extends AppCompatActivity {
    private ImageView imgvIconM40;
    private Button btnBatDauM40;
    private Button btnThongKeM40;
    private Button btnAmThanhM40;
    private Button btnHuongDanM40;
    private Button btnChiaSeM40;
    private Button btnDangXuatM40;
    private MediaPlayer mediaPlayer;
    private Button btnThoatM40;
    private AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m4_0__home);


//Ánh xạ các thành phần
        imgvIconM40 = (ImageView) findViewById(R.id.imgvIconM40);
        btnBatDauM40 = (Button) findViewById(R.id.btnBatDauM40);
        btnThongKeM40 = (Button) findViewById(R.id.btnThongKeM40);
        btnAmThanhM40 = (Button) findViewById(R.id.btnAmThanhM40);
        btnHuongDanM40 = (Button) findViewById(R.id.btnHuongDanM40);
        btnChiaSeM40 = (Button) findViewById(R.id.btnChiaSeM40);
        btnDangXuatM40 = (Button) findViewById(R.id.btnDangXuatM40);
        btnThoatM40 = (Button) findViewById(R.id.btnThoatM40);

//Animation
        Animation animation1 = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap);
        animation1.setInterpolator(new LinearInterpolator());
        btnBatDauM40.startAnimation(animation1);
        btnAmThanhM40.startAnimation(animation1);
        btnChiaSeM40.startAnimation(animation1);
        btnThoatM40.startAnimation(animation1);


        Animation animation = AnimationUtils.loadAnimation(this, R.anim.m20_dangnhap0);
        animation.setInterpolator(new LinearInterpolator());
        btnThongKeM40.startAnimation(animation);
        btnHuongDanM40.startAnimation(animation);
        btnDangXuatM40.startAnimation(animation);

//Chạy nhạc nền
        backMusic();

    }

    public void btnAmThanhOnclickM40(View view) {
        String text=btnAmThanhM40.getText().toString();
        if (text.equals("Âm thanh: Bật")){
            btnAmThanhM40.setText("Âm thanh: Tắt");
            stopBackMusic();
        }else {

            btnAmThanhM40.setText("Âm thanh: Bật");
            backMusic();
        }
    }


//click nút Bắt Đầu
    public void btnBatDauM40(View view) {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        View view1= LayoutInflater.from(this).inflate(R.layout.dialog_batdau_m40,null);
        builder.setView(view1);

        builder.create();
       alertDialog= builder.show();

    }

 //Load nhạc nền
    public void backMusic() {
        mediaPlayer = MediaPlayer.create(this, R.raw.background_music);
        mediaPlayer.start();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Log.e("AAAAAAA", "aaaaaaaaa");
                mediaPlayer.start();
            }
        });
    }
 //Dừng nhạc nền
    public void stopBackMusic() {
        mediaPlayer.release();
    }
}