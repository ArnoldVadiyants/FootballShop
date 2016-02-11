package com.arnold.footballshop;

import android.support.v4.app.ListFragment;

public class ProductListFragment extends ListFragment {
	/*private static final String TAG = "ProductListFragment";
	private ArrayList<Offer> mProducts;
	private boolean mSubtitleVisible;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setHasOptionsMenu(true);
		getActivity().setTitle(R.string.products_title);
		mProducts = ProductLab.get(getActivity()).getProducts();
		ProductAdapter adapter = new ProductAdapter(getActivity(),mProducts);
		setListAdapter(adapter);
		setRetainInstance(true);
		mSubtitleVisible = false;
		Log.d(TAG, "onCreate");
	//	getActivity().startService(new Intent(getActivity(), ProductService.class));
		ProductService.setServiceAlarm(getActivity(), true);
		
	}

	@TargetApi(11)
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//View v = super.onCreateView(inflater, container, savedInstanceState);
		View v = inflater.inflate(R.layout.product_list_fagment, null);
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			if (mSubtitleVisible) {
				getActivity().getActionBar().setSubtitle(R.string.subtitle);
			}
		}
		
		ListView listView = (ListView)v.findViewById(android.R.id.list);
		
		
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
// ����������� ���� ��� Froyo � Gingerbread
			registerForContextMenu(listView);
			} else {
			// ����������� ������ �������� ��� Honeycomb � ����
			listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
			listView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
				
				@Override
				public boolean onPrepareActionMode(ActionMode mode, Menu menu) {return false;}
				@Override
				public void onDestroyActionMode(ActionMode mode) {}
				@Override
				public boolean onCreateActionMode(ActionMode mode, Menu menu) {
					MenuInflater inflater = mode.getMenuInflater();
					inflater.inflate(R.menu.product_list_item_context, menu);
					return true;
				}
				
				@Override
				public boolean onActionItemClicked(ActionMode mode,
						MenuItem item) {
					switch (item.getItemId()) {
					case R.id.menu_item_delete_product:
							ProductAdapter adapter = (ProductAdapter) getListAdapter();
						ProductLab productLab = ProductLab.get(getActivity());
						for (int i = adapter.getCount() - 1; i >= 0; i--) {
							if (getListView().isItemChecked(i)) {
								productLab.deleteProduct(adapter.getItem(i));
							}
						}
						mode.finish();
						adapter.notifyDataSetChanged();
						return true;
					default:
						return false;
					}

				}

				@Override
				public void onItemCheckedStateChanged(ActionMode mode, int position,
						long id, boolean checked) {
					// TODO Auto-generated method stub
					
				}
			});
			}
		
		return v;
	}
@Override
public void setEmptyText(CharSequence text) {
	// TODO Auto-generated method stub
	super.setEmptyText(text);
}
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		// TODO Auto-generated method stub
		super.onCreateOptionsMenu(menu, inflater);
		inflater.inflate(R.menu.fragment_product_list, menu);
		*//*MenuItem showSubtitle = menu.findItem(R.id.menu_item_show_subtitle);
		if (mSubtitleVisible && showSubtitle != null) {
		showSubtitle.setTitle(R.string.hide_subtitle);
		}*//*
	}
	
	@TargetApi(11)
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.menu_item_new_remind:
			Offer product = new Offer();
			ProductLab.get(getActivity()).addProduct(product);
			Intent i = new Intent(getActivity(), ProductPagerActivity.class);
			i.putExtra(ProductFragment.EXTRA_Offer_ID, product.getId());
			startActivityForResult(i, 0);
			return true;
		case R.id.menu_item_settings:
			Intent intent = new Intent(getActivity(), SettingsFragmentAcitivity.class);
			startActivity(intent);
			return true;
	*//*	case R.id.menu_item_show_subtitle:
			if (getActivity().getActionBar().getSubtitle() == null) {
				getActivity().getActionBar().setSubtitle(R.string.subtitle);
				mSubtitleVisible = true;
				item.setTitle(R.string.hide_subtitle);
				} else {
				getActivity().getActionBar().setSubtitle(null);
				mSubtitleVisible = false;
				item.setTitle(R.string.show_subtitle);
				}
			return true;*//*
			default:
			return super.onOptionsItemSelected(item);
		}
	}
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		getActivity().getMenuInflater().inflate(
				R.menu.product_list_item_context, menu);
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
				.getMenuInfo();
		int position = info.position;
		ProductAdapter adapter = (ProductAdapter) getListAdapter();
		Offer product = adapter.getItem(position);
		switch (item.getItemId()) {
		case R.id.menu_item_delete_product:
			ProductLab.get(getActivity()).deleteProduct(product);
			adapter.notifyDataSetChanged();
			return true;
		}
		return super.onContextItemSelected(item);
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		Offer product = ((ProductAdapter) getListAdapter()).getItem(position);
		
		Intent intent  = new Intent(getActivity(), ProductPagerActivity.class);
		intent.putExtra(ProductFragment.EXTRA_Offer_ID, product.getId());
		startActivity(intent);

	}	

	
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.d(TAG, "onResume");
		((ProductAdapter)getListAdapter()).notifyDataSetChanged();
	}
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		ProductLab.get(getActivity()).saveProducts();
	}*/
	
}
