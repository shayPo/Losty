package com.fond.lost.losty.view

import android.os.Bundle
import android.view.View
import com.fond.lost.losty.R
import com.fond.lost.losty.presenter.AdvancedSearchPresenter
import com.fond.lost.losty.presenter.ItemDataPresenter
import com.fond.lost.losty.view.fragments.AdvancedSearch
import kotlinx.android.synthetic.main.advanced_search_activity.*


/**
 * Created by Sahar on 20/04/2018.
 */
class AdvancedSearchActivity : BaseActivity(), View.OnClickListener {

    var mSearchType: Int = 0
    private lateinit var mPresenter : AdvancedSearchPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = AdvancedSearchPresenter(intent.getIntExtra(getString(R.string.search_object), 0))
        addContentView(R.layout.advanced_search_activity)
        init()
    }

    override fun init() {
        super.init()
        advanced_search.setOnClickListener(this)
        search_public_transportation.setOnClickListener(this)
        switchSearchType(AdvancedSearch.TYPE_ADVANCED_SEARCH)
    }

    override fun onClick(v: View?) {
        if (v?.id == R.id.advanced_search) {
            advanced_search_text.alpha = 1f
            search_public_transportation_text.alpha = 0.2f
            advanced_search_underline.visibility = View.VISIBLE
            search_public_transportation_underline.visibility = View.INVISIBLE
            switchSearchType(AdvancedSearch.TYPE_ADVANCED_SEARCH)
        } else if (v?.id == R.id.search_public_transportation) {
            advanced_search_text.alpha = 0.2f
            search_public_transportation_text.alpha = 1f
            advanced_search_underline.visibility = View.INVISIBLE
            search_public_transportation_underline.visibility = View.VISIBLE
            switchSearchType(AdvancedSearch.TYPE_ADVANCED_SEARCH_PUBLIC_TRANSPORTATION)
        }
    }

    private fun switchSearchType(type : Int)
    {
        if(type != mSearchType) {
            mSearchType = type
            putFragment(AdvancedSearch.newInstance(mSearchType), R.id.search_frame)
        }
    }
}