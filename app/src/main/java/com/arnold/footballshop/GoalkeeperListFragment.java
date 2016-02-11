package com.arnold.footballshop;

public class GoalkeeperListFragment extends SubListFragment {

	public static final int[] arrayID ={85, 64, 76, 121};
	@Override
	public int[] arrayCatId() {
		return arrayID;
	}
	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_goalkeeper_list);
	}
}

