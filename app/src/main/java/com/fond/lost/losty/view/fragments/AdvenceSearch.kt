package com.fond.lost.losty.view.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fond.lost.losty.R

/**
 * Created by Sahar on 20/04/2018.
 */
class AdvenceSearch : Fragment()
{
    var mType : Int = 0;

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mType = arguments.getInt(TYPE)
        val view = inflater?.inflate(R.layout.advench_search
                , container, false)
        return view
    }

companion object {

    val TYPE_ADVENCH_SEARCH : Int = 1
    val TYPE_ADVENCH_SEARCH_PUBLIC_TRANSPORTATION : Int = 2
    val TYPE : String = "type"

    fun newInstance(type : Int): Fragment {
        val args: Bundle = Bundle()
        args.putInt(TYPE, type)
        val fragment = AdvenceSearch()
        fragment.arguments = args
        return fragment
    }
}
}