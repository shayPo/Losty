package com.fond.lost.losty.view.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fond.lost.losty.model.SearchItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sahar on 21/05/2018.
 */

public class SearchResults extends RecyclerView.Adapter<SearchResults.Holder>
{

    private ArrayList<SearchItem> mData = new ArrayList<>();

    public SearchResults(List<SearchItem> list)
    {
       if(list != null)
       {
           mData.addAll(list);
       }
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return mData == null ? 0 : mData.size();
    }

    public class Holder extends RecyclerView.ViewHolder
    {


        public Holder(View itemView)
        {
            super(itemView);

        }
    }

}
