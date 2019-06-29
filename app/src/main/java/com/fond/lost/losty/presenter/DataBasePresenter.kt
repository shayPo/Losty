package com.fond.lost.losty.presenter

import com.fond.lost.losty.model.SearchItem
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.DatabaseReference


class DataBasePresenter {

    private var mDataBase : FirebaseDatabase

    fun addValue(type: String, location: String, SearchType: Int, item: SearchItem) {
//        mDataBase.getReference(FOUND_TABLE).child(location).child(type).setValue(item)
//        ref.
    }

    init {
        mDataBase = FirebaseDatabase.getInstance()
    }

    fun getItems(type: String, location: String, SearchType: Int, listener : ValueEventListener) {
        var tableName = ""
        when (SearchType) {
            AdvancedSearchPresenter.FOUND -> tableName = FOUND_TABLE
            AdvancedSearchPresenter.LOST -> tableName = LOST_TABLE
        }

        var itemsQuery = mDataBase.getReference(tableName).child(location).child(type).orderByChild(type)
        itemsQuery.addListenerForSingleValueEvent(listener)
    }

    companion object {
        val FOUND_TABLE = "foundItems"
        val LOST_TABLE = "lostItems"
    }
}