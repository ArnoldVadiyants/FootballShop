package com.arnold.footballshop;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;

public class OfferLab {

	
	private static final String TAG = "OfferLab";
	private static final String OfferS_FILENAME = "offers.json";
	private ArrayList<Offer> mOffers;
	private OfferIntentJSONSerializer mSerializer;
	private static OfferLab sOfferLab;
	private Context mAppContext;
	public static boolean offersLoading = false;
	//public static boean newConstructor = true;

	private OfferLab(Context appContext) {
		mAppContext = appContext;
		mSerializer = new OfferIntentJSONSerializer(mAppContext, OfferS_FILENAME);
		try {
			mOffers = mSerializer.loadOffers();
			Log.d(TAG, "loading Offers: ");
			} catch (Exception e) {
			mOffers = new ArrayList<Offer>();
			//Log.e(TAG, "Error loading Offers: ", e);
			}

	}

	public static OfferLab get(Context c) {
		if (sOfferLab == null) {
			sOfferLab = new OfferLab(c.getApplicationContext());
		}
	//	else newConstructor = false;
		return sOfferLab;
	}

	public void addOffer(Offer r) {
		mOffers.add(r);
	}
	public void removeAllOffers()
	{
		mOffers.clear();
	}



	public ArrayList<Offer> getOffers() {
		return mOffers;
	}

	public Offer getOffer(int id) {
		for (Offer r : mOffers) {
			Log.d(TAG, "UUID **" + r.getId() + "**" + id + "**");
			if (r.getId() == id)
			{
				return r;
			}


		}
		return null;
	}
	public ArrayList<Offer>  getOffersFomCategoryId(int [] arrayId) {
		ArrayList<Offer> offers = new ArrayList<Offer>();
		for (Offer o : mOffers) {

			int catId = o.getCategoryId();
			for (int id : arrayId) {
				if (catId == id) {
					offers.add(o);
					break;
				}
			}
		}
		return offers;
	}
	public boolean saveOffers() {
		try {

		mSerializer.saveOffers(mOffers);
		Log.d(TAG, "Offers saved to file");
		return true;
		} catch (Exception e) {
		Log.e(TAG, "Error saving Offers: ", e);
		return false;
		}
		}
	public boolean saveOffers(ArrayList<Offer> offers) {
		mOffers = offers;
		try {

			mSerializer.saveOffers(mOffers);
			Log.d(TAG, "Offers saved to file");
			return true;
		} catch (Exception e) {
			Log.e(TAG, "Error saving Offers: ", e);
			return false;
		}
	}




//	*/
}
