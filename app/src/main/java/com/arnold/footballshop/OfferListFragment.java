package com.arnold.footballshop;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OfferListFragment extends ListFragment implements OnBackPressedListener {
    public static final String EXTRA_OFFER_ID =
            "offerlistfragment.offer_id";

    private static List<OfferItem> items = new ArrayList<OfferItem>();
    private String fragmentTag = "";
   public OfferListFragment()
    {}
    public static  OfferListFragment newInstance(int[] arrayID) {
        Bundle args = new Bundle();
        args.putIntArray(EXTRA_OFFER_ID, arrayID);
        OfferListFragment fragment = new OfferListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int [] arrayId = getArguments().getIntArray(EXTRA_OFFER_ID);
        initializeItems(arrayId);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.offers_listview, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ListAdapter adapter = new OfferItemAdapter(getActivity(), items);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // TODO Auto-generated method stub

    }


    public void initializeItems(int[] arrayId)
    {

        items.clear();
        ArrayList<Offer>offers;
        if(arrayId == null)
        {
           offers = OfferLab.get(getActivity()).getOffers();
        }
       else
        {
            offers = OfferLab.get(getActivity()).getOffersFomCategoryId(arrayId);
        }

       for (Offer o : offers)
       {

         /* Bitmap b = o.getPicture();

           if(b == null)
           {
               b = BitmapFactory.decodeResource(getResources(), R.drawable.no_image_available);
           }
*/

int id = o.getId();
           String s = o.getName();
           String s1 = ""+o.getPrice();
           String s2 = o.getCurrencyId();
           if (s2.equals("UAH"))
           {
               s1 = s1 + " грн";
           }
           else
           {
               s+=" " + o.getCurrencyId();
           }

          items.add(new OfferItem(id, s,s1));
       }
    }

    @Override
    public void onBackPressed() {
        Log.d("TAG",String.valueOf(fragmentTag == null));
if(fragmentTag != null)
{
    Log.d("TAG", "onBackPressed " + fragmentTag);
    MainActivity.startFragment(fragmentTag);
}
    }
}
