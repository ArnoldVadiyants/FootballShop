package com.arnold.footballshop;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Arnold on 17.01.2016.
 */
public class CatalogItemViewHolder {
    public final ImageView imageView;
    public final TextView text;
    public final ImageView imageView2;

    public CatalogItemViewHolder(ImageView imageView, TextView text, ImageView imageView2) {
        this.imageView = imageView;
        this.text = text;
        this.imageView2 = imageView2;
    }
}
