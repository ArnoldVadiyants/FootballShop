package com.arnold.footballshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arnold on 17.01.2016.
 */
public class OfferItemAdapter extends ArrayAdapter<OfferItem>
{
    private List<OfferItem> mItems;
    public OfferItemAdapter(Context context, List<OfferItem> items)
    {

        super(context, R.layout.list_item_offer, items);
        mItems = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        OfferItemViewHolder holder = null;
        if(view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_offer, parent, false);
            ImageView imageView = (ImageView)view.findViewById(R.id.offer_item_picture);
            TextView name = (TextView)view.findViewById(R.id.offer_item_name);
            TextView price = (TextView)view.findViewById(R.id.offer_item_price);
            ProgressBar progress = (ProgressBar) view.findViewById(R.id.offer_item_progress);
            view.setTag(new OfferItemViewHolder(getContext(), imageView,name,price,progress));

        }
        if(holder == null && view != null)
        {
            Object tag = view.getTag();
            if(tag instanceof OfferItemViewHolder)
            {
                holder = (OfferItemViewHolder)tag;
            }
        }
        OfferItem item = getItem(position);
        if(item != null && holder != null)
        {

          //  holder.imageView.setImageBitmap(item.getPicture());
            holder.setOffer(item);
        }
        return view;
    }
}