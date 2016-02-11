package com.arnold.footballshop;

public class KitListFragment extends SubListFragment {

	public static final int[] arrayID ={72, 71, 73, 114, 116};
	@Override
	public int[] arrayCatId() {
		return arrayID;
	}
	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_kit_list);
	}
}

