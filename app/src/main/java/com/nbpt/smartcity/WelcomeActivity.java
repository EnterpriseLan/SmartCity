package com.nbpt.smartcity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    TextView tvSkip;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        tvSkip = findViewById(R.id.tvskip);


        countDownTimer.start();
    }

    CountDownTimer countDownTimer = new CountDownTimer(4000, 1000) {

        @Override
        public void onTick(long l) {
            tvSkip.setText(getString(R.string.skip_wait, (l / 1000)));
        }

        @Override
        public void onFinish() {
            tvSkip.setText("正在跳转");
            //redirect();
        }
    };

    public void onSkipClick(View view)
    {
        if(countDownTimer != null)
            countDownTimer.cancel();
        redirect();
    }

    public void redirect()
    {
        finish();
        Intent intent = new Intent(WelcomeActivity.this, IndexActivity.class);
        startActivity(intent);
    }

}
