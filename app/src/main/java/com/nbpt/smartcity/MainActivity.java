package com.nbpt.smartcity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "enter onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "enter onStart()");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "enter onRestart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "enter onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "enter onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "enter onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "enter onDestroy()");
    }
}
