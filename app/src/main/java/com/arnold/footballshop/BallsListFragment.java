package com.arnold.footballshop;

public class BallsListFragment extends SubListFragment {
	public static final int[] arrayID ={60, 61, 122, 120, 125, 78};
	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_balls_list);
	}

	@Override
	public int[] arrayCatId() {
		return arrayID;
	}



}
