package com.fond.lost.losty.view.fragments

import android.app.AlertDialog
import android.app.Fragment
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.fond.lost.losty.R
import kotlinx.android.synthetic.main.advench_search.*



/**
 * Created by Sahar on 20/04/2018.
 */
class AdvenceSearch : Fragment(), View.OnClickListener, DialogInterface.OnClickListener {

    var mType : Int = 0;

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mType = arguments.getInt(TYPE)
        val view = inflater?.inflate(R.layout.advench_search
                , container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(view != null) {
            initView()
        }
    }

    private fun initView()
    {
        if(mType == TYPE_ADVENCH_SEARCH) {
            title_type.setText(R.string.select_object)
            selected_type.setText(R.string.item)
            selected_type.setOnClickListener(this)

            title_city.setText(R.string.select_city)
            selected_city.setText(R.string.city)
            selected_city.setOnClickListener(this)
        }
        else if(mType == TYPE_ADVENCH_SEARCH_PUBLIC_TRANSPORTATION)
        {
            title_type.setText(R.string.select_transportin_type)
            selected_type.setText(R.string.transportin_type)
            selected_type.setOnClickListener(this)

            title_city.setText(R.string.select_line)
            selected_city.setText(R.string.line)
            selected_city.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
         if(v!!.id == R.id.selected_city)
         {
             createDialog(R.array.cities, getString(R.string.select_city))
         }
          else if(v!!.id == R.id.selected_type)
         {
             createDialog(R.array.types, getString(R.string.select_object))
         }
    }

    private fun createDialog(items: Int, title : String) {
        val builderSingle = AlertDialog.Builder(activity)
        builderSingle.setTitle(title)
        var adapter : ArrayAdapter<String> = ArrayAdapter(activity, R.layout.display_item, resources.getStringArray(items))
        builderSingle.setAdapter(adapter, this)
        builderSingle.show()
    }

    override fun onClick(p0: DialogInterface?, p1: Int) {

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