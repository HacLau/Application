package com.qingcheng.application;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;



public class SplashActivity extends AppCompatActivity {

    private TextView mTime;
    private int recLen = 3;
    private Timer mTimer = new Timer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        intiView();
        initData();
    }
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    recLen --;
                    mTime.setText("" + recLen);
                    if(recLen == 0)
                    {
                        mTimer.cancel();
                        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                        finish();
                    }
                }
            });

        }
    };

    private void initData() {
        mTimer.schedule(task,1000,1000);
    }

    private void intiView() {
        mTime = (TextView) findViewById(R.id.time);
    }
}
