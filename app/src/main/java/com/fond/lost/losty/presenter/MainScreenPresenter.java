package com.fond.lost.losty.presenter;

import com.fond.lost.losty.R;

import java.util.Stack;

/**
 * Created by Sahar on 09/04/2018.
 */

public class MainScreenPresenter
{
    private Stack<Integer> mScreenList = new Stack<>();
    private int mScreenNumber = 0;

    public final int MAIN_SCREEN_NUMBER = 0;

    public final int FOUND_SCREEN_NUMBER = 101;
    public final int FOUND_SCREEN_ONE = 103;
    public final int FOUND_SCREEN_TWO = 110;
    public final int FOUND_ADVANCE_SEARCH = 104;
    public final int FOUND_SEARCH_BY_LOCATION = 105;


    public final int LOST_SCREEN_NUMBER = 202;
    public final int LOST_SEARCH_SCREEN_NUMBER = 204;//
    public final int LOST_PUBLISH_SCREEN_NUMBER = 203;
    public final int LOST_SEARCH_BY_LOCATION = 206;
    public final int LOST_ADVANCE_SEARCH = 205;


    public int getScreenNumber()
    {
        return mScreenNumber;
    }

    public void NextScreen(int id)
    {
        mScreenList.push(mScreenNumber);

        if (id == R.id.top_button)
        {
            if (mScreenNumber == 0)
            {
                mScreenNumber += 200;
            }
            mScreenNumber += 2;
        } else
        {
            if (mScreenNumber == 0)
            {
                mScreenNumber += 100;
            }
            mScreenNumber++;
        }
    }

    public boolean PreviousScreen()
    {
        boolean exit = false;
        if (mScreenList.size() == 0)
        {
            exit = true;
        }
        else
        {
//            mScreenNumber = mScreenList.size() > 0 ? mScreenList.pop() : 0;
            mScreenNumber = mScreenList.pop();
        }
        return exit;
    }
}
