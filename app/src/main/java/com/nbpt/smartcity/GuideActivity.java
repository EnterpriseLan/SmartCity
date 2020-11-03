package com.nbpt.smartcity;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

public class GuideActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        Intent intent = new Intent(GuideActivity.this,IndexActivity.class);
        startActivity(intent);

    }

}
