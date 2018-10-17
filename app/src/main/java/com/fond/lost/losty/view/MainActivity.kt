package com.fond.lost.losty.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.fond.lost.losty.R
import com.fond.lost.losty.presenter.MainScreenPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity(), View.OnClickListener {

    private var mPresenter: MainScreenPresenter = MainScreenPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addContentView(R.layout.activity_main)
        init()
    }

    override fun onResume() {
        super.onResume()
        if(mPresenter.screenNumber > 0)
        {
            mPresenter.PreviousScreen()
        }
    }

    override fun init()
    {
        super.init()
        setupStartPage()
        top_button.setOnClickListener(this)
        lower_button.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v != null) {
            mPresenter.NextScreen(v.id)
            setupView(mPresenter.screenNumber)
        }
    }

    private fun setupView(screenNumber: Int) {
        when (screenNumber) {
            mPresenter.MAIN_SCREEN_NUMBER -> setupStartPage()
        ////
            mPresenter.FOUND_SCREEN_NUMBER -> setupFoundPage()
            mPresenter.FOUND_SCREEN_ONE -> setupFoundPageOne()
            mPresenter.FOUND_PUT_AD -> setupNoView()
            mPresenter.FOUND_SEARCH_BY_LOCATION -> gotoSearchByLocation()
            mPresenter.FOUND_ADVANCE_SEARCH -> gotoAdvenceSearch()
        ///
            mPresenter.LOST_SCREEN_NUMBER -> setupLostPage()
            mPresenter.LOST_SEARCH_SCREEN_NUMBER -> setupSearchPage()
            mPresenter.LOST_PUT_AD -> setupNoView()
            mPresenter.LOST_SEARCH_BY_LOCATION -> gotoSearchByLocation()
            mPresenter.LOST_ADVANCE_SEARCH -> gotoAdvenceSearch()
        }
    }

    private fun setupFoundPage() {
        setupPage(getString(R.string.found_screen_title), getString(R.string.search_owner), getString(R.string.publish))
    }

    private fun setupFoundPageOne() {
        setupPage(getString(R.string.search_owner_title), getString(R.string.by_location), getString(R.string.advanced_search))
    }

    private fun setupStartPage() {
        setupPage(getString(R.string.main_screen_title), getString(R.string.lost), getString(R.string.found))
    }

    private fun setupLostPage() {
        setupPage(getString(R.string.lost_screen_title), getString(R.string.search), getString(R.string.publish))
    }

    private fun setupSearchPage() {
        setupPage(getString(R.string.search_screen_title), getString(R.string.by_location), getString(R.string.advanced_search))
    }

    private fun setupPage(pageTitle: String, topButton: String, lowerButton: String) {
        page_title.setText(pageTitle)
        top_button.setText(topButton)
        lower_button.setText(lowerButton)
    }

    private fun setupNoView() {
        page_title.setText("אין כותרת")
    }

    private fun gotoSearchByLocation() {
        val intent = Intent(this, SearchByLocationActivity::class.java)
        startActivity(intent)
    }

    private fun gotoAdvenceSearch() {
        val intent = Intent(this, AdvenceSearchActivity::class.java)
        startActivity(intent)
    }


    override fun back(): Boolean {
        if (!mPresenter.PreviousScreen())
        {
            setupView(mPresenter.screenNumber)
            return false
        } else {
            return true
        }
    }
}
