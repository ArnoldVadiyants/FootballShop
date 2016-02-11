package com.arnold.footballshop;

public class MedicineListFragment extends SubListFragment {

	public static final int[] arrayID ={108, 107, 109, 110, 111, 112, 117};
	@Override
	public int[] arrayCatId() {
		return arrayID;
	}
	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_medicine_list);
	}
}

