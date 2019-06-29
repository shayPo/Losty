package com.fond.lost.losty

import android.app.Application
import android.content.Context
import com.fond.lost.losty.model.SearchItem
import com.fond.lost.losty.presenter.AdvancedSearchPresenter
import com.fond.lost.losty.presenter.DataBasePresenter
import com.google.firebase.database.FirebaseDatabase

//import com.google.firebase.database.FirebaseDatabase

class App : Application() {

    lateinit var mDataBasePresenter : DataBasePresenter

    override fun onCreate() {
        super.onCreate()
        mDataBasePresenter = DataBasePresenter()
        instance = this
    }

    companion object {
        lateinit var instance: App
            private set
    }


}