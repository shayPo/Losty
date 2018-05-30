package com.fond.lost.losty.view.fragments

import android.app.AlertDialog
import android.app.Fragment
import android.content.DialogInterface
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.fond.lost.losty.R
import com.fond.lost.losty.model.SearchItem
import com.fond.lost.losty.view.adapters.SearchResults
import kotlinx.android.synthetic.main.advench_search.*


/**
 * Created by Sahar on 20/04/2018.
 */
class AdvenceSearch : Fragment(), View.OnClickListener, DialogInterface.OnClickListener {

    var mType: Int = 0
    var mDialogItems: Array<String>? = null
    var mButton: TextView? = null
    var mNumberOfResulte: Int = 0;

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mType = arguments.getInt(TYPE)
        val view = inflater?.inflate(R.layout.advench_search
                , container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (view != null) {
            initView()
        }
    }

    private fun initView() {
        if (mType == TYPE_ADVENCH_SEARCH) {
            title_type.setText(R.string.select_object)
            selected_type.setText(R.string.item)
            selected_type.setOnClickListener(this)

            title_city.setText(R.string.select_city)
            selected_city.setText(R.string.city)
            selected_city.setOnClickListener(this)
        } else if (mType == TYPE_ADVENCH_SEARCH_PUBLIC_TRANSPORTATION) {
            title_type.setText(R.string.select_transportin_type)
            selected_type.setText(R.string.transportin_type)
            selected_type.setOnClickListener(this)

            title_city.setText(R.string.select_line)
            selected_city.setText(R.string.line)
            selected_city.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        mButton = v as TextView?
        if (v!!.id == R.id.selected_city) {
            createDialog(R.array.cities, getString(R.string.select_city))
        } else if (v!!.id == R.id.selected_type) {
            createDialog(R.array.types, getString(R.string.select_object))
        }
    }

    private fun createDialog(items: Int, title: String) {
        val builderSingle = AlertDialog.Builder(activity)
        builderSingle.setTitle(title)
        mDialogItems = resources.getStringArray(items)
        var adapter: ArrayAdapter<String> = ArrayAdapter(activity, R.layout.display_item, mDialogItems)
        builderSingle.setAdapter(adapter, this)
        builderSingle.show()
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {
        if (mButton != null) {
            if (mButton!!.tag != null) {
                mButton!!.tag = null
                mNumberOfResulte++
            }
            mButton!!.setText(mDialogItems!![p1])
            mButton = null
            mDialogItems = null
            if (p0 != null) {
                p0.dismiss()
            }
        }
        if (mNumberOfResulte > 1) {
            var searchPramters = StringBuilder()
            searchPramters.append(selected_type.text)
            searchPramters.append(" | ")
            searchPramters.append(selected_city.text)
            search_pramters.text = searchPramters.toString()
            temp()
        }
    }

    private fun temp() {
        var results = ArrayList<SearchItem>()
        results.add(SearchItem(""))
        results.add(SearchItem(""))
        results.add(SearchItem(""))
        results.add(SearchItem(""))
        results.add(SearchItem(""))
        setupresults(results)
    }

    private fun setupresults(results: ArrayList<SearchItem>)
    {
        number_of_results.text = ""+ results.size + " תוצאות "
        results_display.layoutManager = GridLayoutManager(activity, 1)
        results_display.adapter = SearchResults(results)
    }

    companion object {

        val TYPE_ADVENCH_SEARCH: Int = 1
        val TYPE_ADVENCH_SEARCH_PUBLIC_TRANSPORTATION: Int = 2
        val TYPE: String = "type"

        fun newInstance(type: Int): Fragment {
            val args: Bundle = Bundle()
            args.putInt(TYPE, type)
            val fragment = AdvenceSearch()
            fragment.arguments = args
            return fragment
        }
    }
}