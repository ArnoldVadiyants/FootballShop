package com.arnold.footballshop;

public class BootsListFragment extends SubListFragment {
	public static final int[] arrayID ={67, 68, 69};

	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_boots_list);
	}

	@Override
	public int[] arrayCatId() {
		return arrayID;
	}
}
