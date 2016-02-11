package com.arnold.footballshop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Arnold on 17.01.2016.
 */
public class CatalogItemAdapter extends ArrayAdapter<CatalogItem>
{
    private List<CatalogItem> mItems;
    private boolean mHasItemIcon;
    public CatalogItemAdapter(Context context, List<CatalogItem> items, boolean hasItemIcon)
    {

        super(context, R.layout.list_item_catalog, items);
        mItems = items;
        mHasItemIcon = hasItemIcon;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        CatalogItemViewHolder holder = null;
        if(view == null)
        {
            view = LayoutInflater.from(getContext()).inflate(R.layout.list_item_catalog, parent, false);
            ImageView imageView = (ImageView)view.findViewById(R.id.catalog_icon);
            if(!mHasItemIcon)
            {
                imageView.setVisibility(View.GONE);
            }

            TextView title = (TextView)view.findViewById(R.id.catalog_title);
            ImageView imageView2 = (ImageView)view.findViewById(R.id.catalog_right_imageview);
            view.setTag(new CatalogItemViewHolder(imageView,title,imageView2));

        }
        if(holder == null && view != null)
        {
            Object tag = view.getTag();
            if(tag instanceof CatalogItemViewHolder)
            {
                holder = (CatalogItemViewHolder)tag;
            }
        }
        CatalogItem item = getItem(position);
        if(item != null && holder != null)
        {


            holder.text.setText(item.getTitle());
            holder.imageView2.setVisibility(item.getNextVisibility());
            if(mHasItemIcon)
            {
                holder.imageView.setImageResource(item.getIconId());
            }
            else
            {
                holder.imageView.setVisibility(View.GONE);
            }
        }
        return view;
    }
}