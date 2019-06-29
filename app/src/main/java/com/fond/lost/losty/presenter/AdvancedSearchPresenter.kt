package com.fond.lost.losty.presenter

import android.app.Application
import android.content.Context
import com.fond.lost.losty.App
import com.google.firebase.database.ValueEventListener

class AdvancedSearchPresenter(searchObject: Int) {

    var mSearchObject: Int = 0

    init {
        mSearchObject = searchObject
    }

    companion object {
        val FOUND = 2
        val LOST = 1
    }

    fun getData(type: String, location: String, SearchType : Int, listener : ValueEventListener) {
        val database = App.instance.mDataBasePresenter
        database.getItems(type, location, SearchType, listener)
    }
}