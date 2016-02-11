package com.arnold.footballshop;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ListView;

public class InfoListFragment extends SubListFragment {
    private static final String DIALOG_INFO = "info";

    @Override
    public String[] arrayTitles() {
        return getActivity().getResources().getStringArray(R.array.information_list);
    }

    @Override
    public int[] arrayCatId() {
        return new int[0];
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        DialogFragment dialog = null;
        if (position == 0) {
            dialog = new InfoPayFragment();
        } else if (position == 1) {
            dialog = new InfoDeliveryFragment();
        } else if (position == 2) {

        } else if (position == 3) {
        } else if (position == 4) {

        } else if (position == 5) {
         Fragment mMapFragment = new InfoAdressFragment();
            MainActivity.startFragment(mMapFragment);
            return;
        }


        		if (dialog!=null)
		{
			FragmentManager fm = getActivity().getSupportFragmentManager();
			dialog.setTargetFragment(InfoListFragment.this, 0);
			dialog.show(fm, DIALOG_INFO);
		}


	}
}