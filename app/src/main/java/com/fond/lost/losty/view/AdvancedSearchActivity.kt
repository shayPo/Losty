package com.fond.lost.losty.view

import android.os.Bundle
import android.view.View
import com.fond.lost.losty.R
import com.fond.lost.losty.view.fragments.AdvenceSearch
import kotlinx.android.synthetic.main.advanced_search_activity.*


/**
 * Created by Sahar on 20/04/2018.
 */
class AdvancedSearchActivity : BaseActivity(), View.OnClickListener {

    var mSearchType: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addContentView(R.layout.advanced_search_activity)
        init()
    }

    override fun init() {
        super.init()
        advanced_search.setOnClickListener(this)
        search_public_transportation.setOnClickListener(this)
        switchSearchType(AdvenceSearch.TYPE_ADVENCH_SEARCH)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.advanced_search) {
            advanced_search_underline.visibility = View.VISIBLE
            search_public_transportation_underline.visibility = View.INVISIBLE
            switchSearchType(AdvenceSearch.TYPE_ADVENCH_SEARCH)
        } else if (v?.id == R.id.search_public_transportation) {
            advanced_search_underline.visibility = View.INVISIBLE
            search_public_transportation_underline.visibility = View.VISIBLE
            switchSearchType(AdvenceSearch.TYPE_ADVENCH_SEARCH_PUBLIC_TRANSPORTATION)
        }
    }

    fun switchSearchType(type : Int)
    {
        if(type != mSearchType) {
            mSearchType = type
            putFragment(AdvenceSearch.newInstance(mSearchType), R.id.search_frame)
        }
    }
}