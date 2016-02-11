package com.arnold.footballshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by Arnold on 02.02.2016.
 */
public class OfferItemViewHolder implements LoaderManager.LoaderCallbacks<Bitmap> {
    private static final String TAG = "OfferItemViewHolder";
    private final Bundle bundle = new Bundle();
    private static int nextLoaderId = 0;
    private int mId= -999;
    private final Context context;
    public final ImageView imageView;
    public final TextView text;
    public final TextView text2;
    public final ProgressBar progressBar;
    private final int loaderId;

    public OfferItemViewHolder(Context context, ImageView imageView, TextView text, TextView text2, ProgressBar progressBar) {
       this.context = context;
        this.imageView = imageView;
  this.text = text;
        this.text2 = text2;
        this.progressBar = progressBar;
        this.loaderId = nextLoaderId++;
    }
    @Override
    public Loader<Bitmap> onCreateLoader(int id, Bundle args)
    {
        return new OfferAdapterImageLoader(context, args.getInt("offerId"));
    }

    @Override
    public void onLoadFinished(Loader<Bitmap> loader, Bitmap bitmap)
    {
        if(bitmap != null)
        {
            imageView.setImageBitmap(bitmap);
        }
        imageView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onLoaderReset(Loader<Bitmap> loader)
    {
        loader.abandon();
    }

    public void setOffer(OfferItem item)
    {
        text.setText(item.getName());
        text2.setText(item.getPrice());
        imageView.setVisibility(View.GONE);
        progressBar.setVisibility(View.VISIBLE);
       int  id = item.getId();
        if(!(id == mId) )
        {
            bundle.putInt("offerId",id);
            ((FragmentActivity)context).getSupportLoaderManager().restartLoader(loaderId, bundle, this);
            Log.d(TAG, "Restarting loader: " + loaderId + " : " + id);
        }
    }
}


