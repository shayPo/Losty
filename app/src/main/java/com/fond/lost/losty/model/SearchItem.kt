package com.fond.lost.losty.model

import android.os.Parcelable
import com.fond.lost.losty.R
import kotlinx.android.parcel.Parcelize
import org.json.JSONObject

@Parcelize
data class SearchItem(var mDistance : String = "",
        var mDescription : String = "",
        var mLocation : String = "",
        var mItemImage : Int = 0
) : Parcelable
{
    constructor(data : String) : this() {
        val jsonData = JSONObject(data)
        mDistance = jsonData.getString("mDistance")
        mDescription = jsonData.getString("mDescription")
        mLocation = jsonData.getString("mLocation")
        mItemImage = jsonData.getInt("mItemImage")
    }
}
