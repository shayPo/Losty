package com.fond.lost.losty.view

import android.os.Bundle
import android.view.View
import com.fond.lost.losty.R
import kotlinx.android.synthetic.main.activity_join.*

/**
 * Created by Sahar on 07/05/2018.
 */
class JoinActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addContentView(R.layout.activity_join)
        init()
    }

    override fun init()
    {
        facebook_login.setOnClickListener(this)
        phone_login.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

    }

}