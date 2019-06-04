package com.fond.lost.losty.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fond.lost.losty.R
import com.fond.lost.losty.model.SearchItem
import kotlinx.android.synthetic.main.search_item.view.*
import java.lang.ref.WeakReference

/**
 * Created by Sahar on 28/05/2018.
 */
class SearchResults(data: List<SearchItem>) : RecyclerView.Adapter<SearchResults.Holder>() {
    private var mItems: ArrayList<SearchItem> = ArrayList()
    private var mListener: View.OnClickListener? = null

    init {
        mItems = ArrayList()
        mItems.addAll(data)
    }

    constructor(data: List<SearchItem>, listener: View.OnClickListener?) : this(data) {
        mListener = listener
    }

    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(mItems[position], mListener)
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        private val mDistance = view?.distance
        private val mDescription = view?.description
        private val mLocation = view?.location
        private val mItemImage = view?.item_image
        private val mBack = view

        fun bind(data: SearchItem, listener: View.OnClickListener?) {
            mBack?.setOnClickListener(listener)
            mBack?.tag = data
            mDistance?.text = data.mDistance
            mDescription?.text = data.mDescription
            mLocation?.text = data.mLocation
            mItemImage?.setImageResource(data.mItemImage)
        }
    }
}