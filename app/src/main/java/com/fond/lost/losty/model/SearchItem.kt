package com.fond.lost.losty.model

import android.os.Parcelable
import com.fond.lost.losty.R
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchItem(val mDistance : String = "2.5 קמ",
        val mDescription : String = "כלב שחור עם כתמים לבנים",
        val mLocation : String = "תל אביב, הרצל 4",
        val mItemImage : Int = R.drawable.type_dog
) : Parcelable
