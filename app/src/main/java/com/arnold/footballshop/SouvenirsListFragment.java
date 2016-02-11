package com.arnold.footballshop;

public class SouvenirsListFragment extends SubListFragment {
	public static final int[] arrayID ={ 92, 94};
	@Override
	public int[] arrayCatId() {
		return arrayID;
	}

	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_souvenirs_list);
	}
}
