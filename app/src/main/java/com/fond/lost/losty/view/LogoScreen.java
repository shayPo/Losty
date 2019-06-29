package com.fond.lost.losty.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.fond.lost.losty.R;

/**
 * Created by Sahar on 19/04/2018.
 */

public class LogoScreen extends AppCompatActivity
{

    private Handler mHandler = new Handler();
    private final int mDelay = 2000;

    private Runnable mLaunchTask = new Runnable()
    {
        public void run()
        {
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
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
        mHandler.postDelayed(mLaunchTask, mDelay);
    }


    @Override
    public void onBackPressed()
    {

    }
}
