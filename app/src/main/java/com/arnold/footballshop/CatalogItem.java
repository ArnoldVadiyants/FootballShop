package com.arnold.footballshop;

import android.view.View;

/**
 * Created by Arnold on 16.01.2016.
 */
public class CatalogItem {
    private String mTitle;
    private int mNextVisibility;
    private int mIconId;
CatalogItem()
{
 mTitle = "Title";
    mIconId = R.drawable.ic_catalog_2_ball;
    mNextVisibility = View.VISIBLE;
}

    public CatalogItem(String title, int iconId, int nextVisibility) {
        this.mTitle = title;
        this.mNextVisibility = nextVisibility;
        this.mIconId = iconId;
    }

    public String getTitle() {
        return mTitle;
    }
    public void setTitle(String title) {
        mTitle = title;
    }
    public int getIconId() {
        return mIconId;
    }
    public void setIconId(int iconId) {
        mIconId = iconId;
    }
    public int getNextVisibility() {
        if(mNextVisibility == View.VISIBLE)
        {
            return View.VISIBLE;
        }
        else
        {
            return View.INVISIBLE;
        }

    }
    public void setNextVisibility(int nextVisibility) {
        mNextVisibility = nextVisibility;
    }


}

