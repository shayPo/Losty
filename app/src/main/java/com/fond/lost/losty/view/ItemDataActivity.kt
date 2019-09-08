package com.fond.lost.losty.view

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.fond.lost.losty.R
import com.fond.lost.losty.model.SearchItem
import com.fond.lost.losty.presenter.ItemDataPresenter
import kotlinx.android.synthetic.main.activity_item_data.*
import kotlinx.android.synthetic.main.activity_join.view.*

class ItemDataActivity : BaseActivity()
{
    private lateinit var mPresenter : ItemDataPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addContentView(R.layout.activity_item_data)
        init()
    }

    override fun init() {
        super.init()
        mPresenter = ItemDataPresenter(intent.getParcelableExtra("DATA"))
        item_image.setFactory{
            val imageView = ImageView(applicationContext)
            imageView.scaleType = ImageView.ScaleType.FIT_XY
            imageView
        }
        item_image.tag = 0
        item_image.setImageURI(Uri.parse(mPresenter.mData.mItemImage[0]))
    }

    fun nextImage(view : View?)
    {
        mPresenter.nextImage(item_image as ImageView)
    }

    fun previousImage(view : View?)
    {
        mPresenter.previousImage(item_image as ImageView)
    }



}