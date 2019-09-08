package com.fond.lost.losty.presenter

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.fond.lost.losty.model.SearchItem

//TODO delete this class ?
class ItemDataPresenter(val mData : SearchItem)
{
    init {

    }

    fun previousImage(v : ImageView)
    {
        var index = v.tag as Int
        index--
        v.tag = index
        v.setImageURI(Uri.parse(mData.mItemImage[index]))
    }

    fun nextImage(v : ImageView)
    {
        var index = v.tag as Int
        index++
        v.tag = index
        v.setImageURI(Uri.parse(mData.mItemImage[index]))
    }
}
