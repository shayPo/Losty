package com.fond.lost.losty.view

import android.os.Bundle
import android.view.View
import com.fond.lost.losty.R
import kotlinx.android.synthetic.main.advench_search_activity.*


/**
 * Created by Sahar on 20/04/2018.
 */
class AdvenceSearchActivity : BaseActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addContentView(R.layout.advench_search_activity)
        init()
    }

    override fun init()
    {
        super.init()
        advanced_search_underline.visibility = View.VISIBLE
        advanced_search.setOnClickListener(this)
        public_transportation.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null && v.id == R.id.advanced_search)
        {
            advanced_search_underline.visibility = View.VISIBLE
            search_public_transportation_underline.visibility = View.INVISIBLE
        }
        else if (v != null && v.id == R.id.public_transportation)
        {
            advanced_search_underline.visibility = View.INVISIBLE
            search_public_transportation_underline.visibility = View.VISIBLE
        }
    }
}