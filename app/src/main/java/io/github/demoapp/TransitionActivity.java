package io.github.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;

import java.util.Random;

public class TransitionActivity extends AppCompatActivity {

    private ProgressBar mProgressBar;
    private int mProgress;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transition);

        mProgressBar = (ProgressBar)findViewById(R.id.progressBar);
        mProgressBar.setProgress(mProgress);
        mProgress = 0;
        new Thread(new Runnable() {
            public void run() {
                while (mProgress < 100) {
                    Random random = new Random();
                    int randomNumber = random.nextInt(10);
                    handler.post(new Runnable() {
                        public void run() {
                            mProgress += randomNumber;
                            mProgressBar.setProgress(mProgress);
                        }
                    });
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                Intent intent = new Intent(TransitionActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }).start();

    }
}