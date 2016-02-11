package com.arnold.footballshop;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Arnold on 14.01.2016.
 */
public class Offer {
    private static final String JSON_CATEGORY_ID = "categoryId";
    private static final String JSON_CURRENCY_ID = "currencyId";
    private static final String JSON_PRICE = "price";
    private static final String JSON_IMAGE_URL = "picture";
    private static final String JSON_NAME = "name";
    private static final String JSON_ID = "id";
    private static final String JSON_AVAILABLE = "available";
    private static final String JSON_DESCRIPTION = "description";

    private String mName;
    private String mDescription;
    private String mPictureUrl;
    private int mCategoryId;
    private String mCurrencyId;
    private int mPrice;
    private int mId;
    private boolean mAvailable;
    private Bitmap mPicture;


    public Bitmap getPicture() {
        return mPicture;
    }


    public void setPicture(Bitmap picture) {
        this.mPicture = picture;
    }
    public void setPicture(String pictureUrl) {
        URL url = null;
        try {
            url = new URL(pictureUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.mPicture = bmp;
    }




    public Offer() {
    }

    public boolean isAvailable() {
        return mAvailable;
    }

    public void setAvailable(boolean available) {
        this.mAvailable = available;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }

    public String getPictureUrl() {
        return mPictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.mPictureUrl = pictureUrl;
    //    setPicture(mPictureUrl);
    }

    public int getCategoryId() {
        return mCategoryId;
    }

    public void setCategoryId(int categoryId) {
        this.mCategoryId = categoryId;
    }

    public String getCurrencyId() {
        return mCurrencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.mCurrencyId = currencyId;
    }

    public int getPrice() {
        return mPrice;
    }

    public void setPrice(int price) {
        this.mPrice = price;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        this.mId = id;
    }


    public Offer(JSONObject json) throws JSONException {

        mId = json.getInt(JSON_ID);
        mName = json.getString(JSON_NAME);
        mDescription = json.getString(JSON_DESCRIPTION);
        mPictureUrl = json.getString(JSON_IMAGE_URL);
        mCategoryId = json.getInt(JSON_CATEGORY_ID);
        mCurrencyId = json.getString(JSON_CURRENCY_ID);
        mPrice = json.getInt(JSON_PRICE);
        mAvailable = json.getBoolean(JSON_AVAILABLE);
    }

    public JSONObject toJSON() throws JSONException {
        JSONObject json = new JSONObject();

        json.put(JSON_ID, mId);
        json.put(JSON_NAME, mName);
        json.put(JSON_DESCRIPTION, mDescription);
        json.put(JSON_IMAGE_URL, mPictureUrl);
        json.put(JSON_CATEGORY_ID, mCategoryId);
        json.put(JSON_CURRENCY_ID, mCurrencyId);
        json.put(JSON_PRICE, mPrice);
        json.put(JSON_AVAILABLE, mAvailable);


        return json;
    }
}
