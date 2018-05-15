package com.fond.lost.losty.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.fond.lost.losty.R;

/**
 * Created by Sahar on 19/04/2018.
 */

public class LogoScreen extends AppCompatActivity
{

    Handler mHandler = new Handler();

    private Runnable mLaunchTask = new Runnable() {
        public void run() {
//            Intent i = new Intent(getApplicationContext(), MainActivity.class);
//            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//            startActivity(i);

            Intent i = new Intent(getApplicationContext(), SearchByLocationActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_screen);
        init();
    }

    private void init()
    {
        mHandler.postDelayed(mLaunchTask, 2500);
    }

    @Override
    public void onBackPressed()
    {

    }
}
