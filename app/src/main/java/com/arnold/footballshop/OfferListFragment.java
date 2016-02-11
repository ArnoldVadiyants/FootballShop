package com.arnold.footballshop;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class OfferListFragment extends ListFragment {
    public static final String EXTRA_OFFER_ID =
            "offerlistfragment.offer_id";
    private static List<OfferItem> items = new ArrayList<OfferItem>();
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

      /*  HandleXML handleXML= new HandleXML(getActivity());
        handleXML.fetchXML();
        while (handleXML.parsingComplete);*/

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                OfferLab offerLab  = OfferLab.get(getActivity());
                Offer o = new Offer();
                //   Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.no_image_available);


                o.setPicture("https://shop.football.kharkov.ua/files/products/winner_match_sala_1.200x200.jpg?c588a02aef37459e4dc9ed119307cb54");
                o.setCurrencyId("UAH");
                o.setName("Name впукпукукр ке керкер кнркенр кенр енркнрукнунер укеп кер укер4ер кер укенр унеоуно #");
                o.setPrice(345);
                offerLab.addOffer(o);


                o = new Offer();

                o.setPicture("https://shop.football.kharkov.ua/files/products/379_large.200x200.jpg?1dcb2d6a1919b625dce5793907a6fd29");
                o.setCurrencyId("UAH");
                o.setName("Name #");
                o.setPrice(345);
                offerLab.addOffer(o);

                for(int i =0; i<=10; i++)
        {
          o = new Offer();
        //   Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.no_image_available);


            o.setPicture("https://shop.football.kharkov.ua/files/products/b100064.150.200x200.jpg?17fd0d517bd4da3008e8451a53513768");
            o.setCurrencyId("UAH");
            o.setName("Щитки Uhlsport Shockshield Lite - поставляются в специальном чулке, который надевается под гетры. #" +i );
            o.setPrice(i);
            offerLab.addOffer(o);
        }
            }
        }).start();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
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

}
