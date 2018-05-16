package com.fond.lost.losty.view

import android.app.Fragment
import android.os.Bundle
import android.view.View
import com.fond.lost.losty.R
import com.fond.lost.losty.view.fragments.AdvenceSearch
import kotlinx.android.synthetic.main.advench_search_activity.*


/**
 * Created by Sahar on 20/04/2018.
 */
class AdvenceSearchActivity : BaseActivity(), View.OnClickListener {

    var SearchType : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addContentView(R.layout.advench_search_activity)
        init()
    }

    override fun init() {
        super.init()
        advanced_search.setOnClickListener(this)
        search_public_transportation.setOnClickListener(this)
        switchSearchType(AdvenceSearch.TYPE_ADVENCH_SEARCH)
    }

    override fun onClick(v: View?) {

        if(v == null)
        {
            return;
        }

        if (v!!.id == R.id.advanced_search) {
            advanced_search_underline.visibility = View.VISIBLE
            search_public_transportation_underline.visibility = View.INVISIBLE
        } else if (v!!.id == R.id.search_public_transportation) {
            advanced_search_underline.visibility = View.INVISIBLE
            search_public_transportation_underline.visibility = View.VISIBLE
        }
    }

    fun switchSearchType(type : Int)
    {

        putFragment(AdvenceSearch.newInstance(), R.id.search_frame)
    }
}