package com.fond.lost.losty.presenter

class AdvancedSearchPresenter(searchObject: Int) {
    var mSearchObject: Int = 0

    init {
        mSearchObject = searchObject
    }

    companion object {
        val FOUND = 2
        val LOST = 1
    }
}