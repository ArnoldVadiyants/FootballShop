package com.arnold.footballshop;

public class ChildrenListFragment extends SubListFragment {
	public static final int[] arrayID ={104, 105, 106, 118, 115, 119};
	@Override
	public int[] arrayCatId() {
		return arrayID;
	}

	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_children_list);
	}

}
