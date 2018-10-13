package com.fond.lost.losty.view.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fond.lost.losty.R
import com.fond.lost.losty.model.SearchItem
import kotlinx.android.synthetic.main.search_item.view.*

/**
 * Created by Sahar on 28/05/2018.
 */
class SearchResults : RecyclerView.Adapter<SearchResults.Holder>
{
    var mItems : ArrayList<SearchItem> = ArrayList<SearchItem>()

    constructor(data : List<SearchItem>)
    {
        mItems = ArrayList()
        mItems.addAll(data)
    }


    override fun getItemCount(): Int {
        return mItems.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
      /*   holder.mDistance.text = "2.5 ק״מ"
        holder.mDescription.text = "two"
        holder.mLocation.text = "three"
        holder.mItemImage.setImageResource(R.drawable.type_dog)*/
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view)
    {
        public val mDistance = view.distance
        public val mDescription = view.description
        public val mLocation = view.location
        public val mItemImage = view.item_image
    }
}