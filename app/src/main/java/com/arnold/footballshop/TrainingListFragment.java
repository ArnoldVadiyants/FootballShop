package com.arnold.footballshop;

public class TrainingListFragment extends SubListFragment {

	public static final int[] arrayID ={89, 95, 96};
	@Override
	public int[] arrayCatId() {
		return arrayID;
	}
	@Override
	public String[] arrayTitles() {
		return getActivity().getResources().getStringArray(R.array.catalog_training_list);
	}
}
