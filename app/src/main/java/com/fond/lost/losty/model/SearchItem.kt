package com.fond.lost.losty.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import org.json.JSONArray
import org.json.JSONObject

@Parcelize
data class SearchItem(var mDistance: String = "",
                      var mDescription: String = "",
                      var mLocation: String = "",
                      var mItemImage: MutableList<String>
) : Parcelable {

    companion object {
        public fun parseJson(data : String) : SearchItem {
            val jsonData = JSONObject(data)
            val distance = jsonData.getString("mDistance")
            val description = jsonData.getString("mDescription")
            val location = jsonData.getString("mLocation")
            val array: JSONArray = jsonData.getJSONArray("mItemImage")
            var imageArray = mutableListOf<String>()
            for (i in 0..array.length()) {
                imageArray.add(array.get(i).toString())
            }
            return SearchItem(distance, description, location, imageArray)
        }
    }
}