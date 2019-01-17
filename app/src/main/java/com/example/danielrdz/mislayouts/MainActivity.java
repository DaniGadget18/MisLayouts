package com.example.danielrdz.mislayouts;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.view.Gravity.RIGHT;
import static android.view.Gravity.TOP;

public class MainActivity extends AppCompatActivity {

    TextView lbl1;
    Button btn1;
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.btn);
        lbl1 = findViewById(R.id.lbl1);


        View.OnClickListener clickbtn = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                lbl1.setText(String.valueOf(contador));
            }
        };
        btn1.setOnClickListener(clickbtn);
        lbl1.setOnClickListener(clickbtn);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                Random ran = new Random();
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                Random aleatorio = new Random();
                int num = aleatorio.nextInt(5) + 1;
                Log.d("num",String.valueOf(aleatorio));
                switch (num) {
                    case 0:
                        lp.gravity = Gravity.TOP;
                        break;
                    case 1:
                        lp.gravity = Gravity.CENTER | Gravity.RIGHT;
                        break;
                    case 2:
                        lp.gravity = Gravity.BOTTOM | Gravity.LEFT;
                        break;
                    case 3:
                        lp.gravity = Gravity.TOP | RIGHT;
                        break;
                    case 4:
                        lp.gravity = Gravity.CENTER | RIGHT;
                        break;
                }
                btn1.setLayoutParams(lp);
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "Se termino", Toast.LENGTH_LONG).show();
            }
        }.start();

    }
}
