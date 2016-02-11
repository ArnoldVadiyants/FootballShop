package com.arnold.footballshop;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public abstract class SubListFragment extends ListFragment implements OnBackPressedListener {

	public List<CatalogItem> getItems() {
		return items;
	}

	private  final List<CatalogItem> items = new ArrayList<CatalogItem>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
	{
		return inflater.inflate(R.layout.listview, container, false);
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		initializeItems();
		ListAdapter adapter = new CatalogItemAdapter(getActivity(), items, false);
		setListAdapter(adapter);
	}
	public void initializeItems()
	{
		String[] title_list = arrayTitles();
		if(!items.isEmpty())
		{
		items.clear();
		}
		for(String title : title_list)
		{
			items.add(new CatalogItem(title, R.drawable.ic_catalog_2_ball,View.INVISIBLE));
		}
	}
	public abstract String[] arrayTitles();
	public abstract int[] arrayCatId();

	@Override
	public void onBackPressed() {
		MainActivity.startFragment(new CatalogListFragment());
	}

	@Override
	public void setInitialSavedState(SavedState state) {
	//	Fragment myFragment = getActivity().getSupportFragmentManager().findFragmentById(R.id.fragmentContainer);
		Fragment.SavedState myFragmentState = getFragmentManager().saveFragmentInstanceState(this);
		setInitialSavedState(myFragmentState);
	}
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		int []arrayID = arrayCatId();
		//CatalogItem item = ((CatalogItemAdapter) getListAdapter()).getItem(position);
		//       FragmentManager fm = getActivity().getSupportFragmentManager();
		//    Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
		Fragment fragment = null;
		for (int i = -1; i < arrayID.length; i++) {
			if (position == i + 1) {
				if (i == -1) {
					fragment = OfferListFragment.newInstance(arrayID);
				} else {
					int ids[] = {arrayID[i]};
					fragment = OfferListFragment.newInstance(ids);
				}
			}
		}

		MainActivity.startFragment(fragment);
	}
}