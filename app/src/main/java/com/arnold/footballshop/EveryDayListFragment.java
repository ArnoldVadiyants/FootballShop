package com.arnold.footballshop;

public class EveryDayListFragment extends SubListFragment {

	public static final int[] arrayID ={98, 99, 100};
	@Override
	public int[] arrayCatId() {
		return arrayID;
	}
	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_every_day_list);
	}
}


