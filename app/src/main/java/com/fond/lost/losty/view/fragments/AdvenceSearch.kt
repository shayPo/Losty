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
    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {


        val view = inflater?.inflate(R.layout.advench_search
                , container, false)
        return view
    }
}