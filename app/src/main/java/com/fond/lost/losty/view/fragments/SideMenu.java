package com.fond.lost.losty.view.fragments;


import android.os.Bundle;
//import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.fond.lost.losty.R;

/**
 * Created by Sahar on 06/05/2018.
 */

public class SideMenu extends Fragment implements View.OnClickListener
{

    private static SideMenu myFragment;
    private MenuClickListener MenuListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.side_menu, container, false);

        view.findViewById(R.id.join).setOnClickListener(this);
        view.findViewById(R.id.my_adds).setOnClickListener(this);
        view.findViewById(R.id.share).setOnClickListener(this);
        view.findViewById(R.id.write_us).setOnClickListener(this);
        view.findViewById(R.id.terms_and_conditions).setOnClickListener(this);

        return view;
    }

    public static Fragment newInstance(MenuClickListener itemClickListener)
    {
//        if(myFragment == null)
//        {
//            myFragment = new SideMenu();
//        }

        myFragment = new SideMenu();
        myFragment.setMenuListener(itemClickListener);
        return myFragment;
    }

    public void setMenuListener(MenuClickListener menuListener)
    {
        MenuListener = menuListener;
    }

    @Override
    public void onClick(View view)
    {
        MenuListener.OnItemClick(view);
    }

    public interface MenuClickListener
    {
        void OnItemClick(View v);
    }
}
