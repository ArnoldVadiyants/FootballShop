package com.arnold.footballshop;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.content.AsyncTaskLoader;
import android.util.DisplayMetrics;
import android.util.Log;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Please note: This code is designed to demonstrate some
 * basic concepts for loading images for display within
 * ListViews. It is not production standard because
 * it does not handle lack of connectivity, and
 * should support image caching to further 
 * improve performance.
 * Please refer to the accompanying article for
 * more information:
 * http://blog.stylingandroid.com/archives/1737
 */

public class OfferAdapterImageLoader extends AsyncTaskLoader<Bitmap>
{
	private static final String TAG = "OfferAdapterImageLoader";

	private static String density = null;
	private int mId;
	private boolean cancelled = false;

	public OfferAdapterImageLoader(Context context, int id)
	{
		super(context);
		mId = id;
		if (density == null)
		{
			DisplayMetrics dm = context.getResources().getDisplayMetrics();
			switch (dm.densityDpi)
			{
			case DisplayMetrics.DENSITY_LOW:
				density = "ldpi";
				break;
			case DisplayMetrics.DENSITY_MEDIUM:
				density = "mdpi";
				break;
			case DisplayMetrics.DENSITY_HIGH:
				density = "hdpi";
				break;
			case DisplayMetrics.DENSITY_XHIGH:
				density = "xhdpi";
				break;
			default:
				density = "mdpi";
				break;
			}
		}
	}

	@Override
	public Bitmap loadInBackground()
	{
		URL url = null;
		Bitmap bitmap = null;
		HttpURLConnection http = null;
		try
		{
			url = new URL(OfferLab.get(getContext()).getOffer(mId).getPictureUrl());
			URLConnection conn = url.openConnection();
			if(conn instanceof HttpURLConnection)
			{
				http = (HttpURLConnection)conn;
				if(http.getResponseCode() == HttpURLConnection.HTTP_OK /*&& http.getContentType().startsWith("image")*/)
				{
					bitmap = BitmapFactory.decodeStream(http.getInputStream());
				}
			}
		}
		catch (Exception e)
		{
			Log.e(TAG, "Error loading image", e);
		}
		finally
		{
			if(http != null)
			{
				http.disconnect();
			}
		}
		return cancelled ? null : bitmap;
	}
	
	@Override
	protected void onStartLoading()
	{
		super.onStartLoading();
		forceLoad();
	}
	
	@Override
	protected void onAbandon()
	{
		super.onAbandon();
		cancelled = true;
	}

}
