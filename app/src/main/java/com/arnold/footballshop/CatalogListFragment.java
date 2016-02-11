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

public class CatalogListFragment extends ListFragment {
    public static final int  GAITERS_ID = 62;
    public static final int  SHIELDS_ID = 65;
    public static final int  THERMO_ID = 86;
    public static final int  ACCESS_ID = 83;
    public static final int  BACK_PACK_ID = 90;
    public static final int  JUDGE_ID =  101;

    private final List<CatalogItem> items = new ArrayList<CatalogItem>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.listview, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initializeItems();
        ListAdapter adapter = new CatalogItemAdapter(getActivity(), items, true);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub
        //CatalogItem item = ((CatalogItemAdapter) getListAdapter()).getItem(position);
 //       FragmentManager fm = getActivity().getSupportFragmentManager();
    //    Fragment fragment = fm.findFragmentById(R.id.fragmentContainer);
Fragment fragment = null;
        position = position + 1;
        if (position == 0) {
            return;
        } else if (position == 1) {
            fragment = new BallsListFragment();
        } else if (position == 2) {
            fragment = new KitListFragment();
        } else if (position == 3) {
            fragment = OfferListFragment.newInstance(new int[]{GAITERS_ID});
        } else if (position == 4) {
            fragment = OfferListFragment.newInstance(new int[]{SHIELDS_ID});
        } else if (position == 5) {
            fragment = new GoalkeeperListFragment();
        } else if (position == 6) {
            fragment = new BootsListFragment();
        } else if (position == 7) {
            fragment = new MedicineListFragment();
        } else if (position == 8) {
            fragment = new TrainingListFragment();
        } else if (position == 9) {
            fragment = OfferListFragment.newInstance(new int[]{THERMO_ID});
        } else if (position == 10) {
            fragment = OfferListFragment.newInstance(new int[]{ACCESS_ID});
        } else if (position == 11) {
            fragment = OfferListFragment.newInstance(new int[]{BACK_PACK_ID});
        } else if (position == 12) {
            fragment = new SouvenirsListFragment();
        } else if (position == 13) {
            fragment = new EveryDayListFragment();
        } else if (position == 14) {
            fragment = OfferListFragment.newInstance(new int[]{JUDGE_ID});
        } else if (position == 15) {
            fragment = new ChildrenListFragment();
        }
        MainActivity.startFragment(fragment);
     //   fm.beginTransaction().replace(R.id.fragmentContainer, fragment)//.addToBackStack(null)
       //         .commit();

    }


    public void initializeItems() {
        String[] title_list = getActivity().getResources().getStringArray(R.array.catalog_list);
    //    items.add(new CatalogItem(title_list[0], R.drawable.ic_catalog_1_sale, View.INVISIBLE));
        if(!items.isEmpty())
        {
            items.clear();
        }
        items.add(new CatalogItem(title_list[1], R.drawable.ic_catalog_2_ball, View.VISIBLE));
        items.add(new CatalogItem(title_list[2], R.drawable.ic_catalog_3_shirt, View.VISIBLE));
        items.add(new CatalogItem(title_list[3], R.drawable.ic_catalog_4_socks, View.INVISIBLE));
        items.add(new CatalogItem(title_list[4], R.drawable.ic_catalog_5_shields, View.INVISIBLE));
        items.add(new CatalogItem(title_list[5], R.drawable.ic_catalog_6_goalkeeper, View.VISIBLE));
        items.add(new CatalogItem(title_list[6], R.drawable.ic_catalog_7_shoes, View.VISIBLE));
        items.add(new CatalogItem(title_list[7], R.drawable.ic_catalog_8_medicine, View.VISIBLE));
        items.add(new CatalogItem(title_list[8], R.drawable.ic_catalog_9_training, View.VISIBLE));
        items.add(new CatalogItem(title_list[9], R.drawable.ic_catalog_10_thermo, View.INVISIBLE));
        items.add(new CatalogItem(title_list[10], R.drawable.ic_catalog_11_accessories, View.INVISIBLE));
        items.add(new CatalogItem(title_list[11], R.drawable.ic_catalog_12_bags, View.INVISIBLE));
        items.add(new CatalogItem(title_list[12], R.drawable.ic_catalog_13_souvenirs, View.VISIBLE));
        items.add(new CatalogItem(title_list[13], R.drawable.ic_catalog_14_every_day, View.VISIBLE));
        items.add(new CatalogItem(title_list[14], R.drawable.ic_catalog_15_judge, View.INVISIBLE));
        items.add(new CatalogItem(title_list[15], R.drawable.ic_catalog_16_child, View.VISIBLE));
    }

}
