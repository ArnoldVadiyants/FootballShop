package com.arnold.footballshop;

import android.content.Context;
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * Created by Arnold on 31.01.2016.
 */
public class HandleXML {
    private static final  String TAG = "HandleXML";
    private static final  String XML_URL = "https://shop.football.kharkov.ua/yandex.php";
    private static final  String OFFER = "offer";
    private static final  String OFFER_CATEGORY_ID = "categoryId";
    private static final  String OFFER_CURRENCY_ID = "currencyId";
    private static final  String OFFER_PRICE = "price";
    private static final  String OFFER_IMAGE_URL = "picture";
    private static final  String OFFER_NAME = "name";
    private static final  String OFFER_ID = "id";
    private static final  String OFFER_AVAILABLE = "available";
    private static final  String OFFER_DESCRIPTION = "description";
    private XmlPullParserFactory xmlFactoryObject;
    public volatile boolean parsingComplete = true;
    private String mName;
    private String mDescription;
    private String mPicture;
    private int mCategoryId;
    private String mCurrencyId;
    private int mPrice;
    private int mOfferId;
    private boolean mOfferAvailable;
    private OfferLab offerLab;
    private Context mContext;

    public HandleXML(Context mContext) {
        this.mContext = mContext;
        offerLab = OfferLab.get(mContext);
    }

    public void parseOffers(XmlPullParser myParser) {

        int event;
        String text=null;
        boolean hasAttr= false, hasPrice= false, hasCurrencyID= false, hasCategoryID= false, hasPicture= false, hasName= false, hasDescription = false;
        if (!offerLab.getOffers().isEmpty())
        {
            offerLab.removeAllOffers();
        }
        OfferLab.offersLoading = true;
        try {

            event = myParser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                String name=myParser.getName();

                switch (event){
                    case XmlPullParser.START_TAG:
                        if(name.equals(OFFER)){
                            try
                            {
                                mOfferId = Integer.parseInt(myParser.getAttributeValue(null, OFFER_ID));
                            }
                            catch (NumberFormatException e) {
                                mOfferId = new Random().nextInt();
                            }
                            mOfferAvailable = Boolean.parseBoolean(myParser.getAttributeValue(null,OFFER_AVAILABLE));
                            Log.d(TAG, mOfferId + " " + mOfferAvailable);
                        }
                        hasAttr = true;
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                         if(name.equals(OFFER_PRICE)){
                            try
                            {
                                mPrice = Integer.parseInt(text);
                                Log.d(TAG, ""+ mPrice);
                            }
                            catch (NumberFormatException e) {
                                mPrice = 0;
                            }
                             hasPrice = true;
                        }

                        else if(name.equals(OFFER_CURRENCY_ID)){
                            mCurrencyId = text;
                            Log.d(TAG, ""+ mCurrencyId);
                             hasCurrencyID = true;
                        }

                        else if(name.equals(OFFER_CATEGORY_ID)){
                            try
                            {
                                mCategoryId = Integer.parseInt(text);
                            }
                            catch (NumberFormatException e) {
                                mCategoryId = 0;
                            }
                            Log.d(TAG, ""+ mCategoryId);
                             hasCategoryID = true;
                        }
                        else if(name.equals(OFFER_IMAGE_URL)){
                                mPicture = text;
                            Log.d(TAG, ""+ mPicture);
                             hasPicture = true;
                        }
                        else if(name.equals(OFFER_NAME)){
                            mName = text;
                            Log.d(TAG, ""+ mName);
                             hasName = true;
                        }
                        else if(name.equals(OFFER_DESCRIPTION)){
                            mDescription = text;
                            Log.d(TAG, ""+ mDescription);
                             hasDescription = true;
                        }
                        else{
                        }

                        break;
                }
                if(hasAttr && hasPrice && hasCurrencyID && hasCategoryID && hasPicture && hasName && hasDescription)
                {
                    Offer o = new Offer();
                    o.setCategoryId(mCategoryId);
                    o.setCurrencyId(mCurrencyId);
                    o.setDescription(mDescription);
                    o.setAvailable(mOfferAvailable);
                    o.setId(mOfferId);
                    o.setName(mName);
                    o.setPictureUrl(mPicture);
                    o.setPrice(mPrice);
                    offerLab.addOffer(o);
                    hasAttr= false;  hasPrice= false; hasCurrencyID= false; hasCategoryID= false; hasPicture= false; hasName= false; hasDescription = false;

                }
                event = myParser.next();
            }
            OfferLab.get(mContext).saveOffers();
            OfferLab.offersLoading = false;
            parsingComplete = false;
        }

        catch (Exception e) {
            e.printStackTrace();
        }

}

    public void fetchXML(){

        Thread thread = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    URL url = new URL(XML_URL);
                    HttpURLConnection conn = (HttpURLConnection)url.openConnection();

                    conn.setReadTimeout(10000 /* milliseconds */);
                    conn.setConnectTimeout(15000 /* milliseconds */);
                    conn.setRequestMethod("GET");
                    conn.setDoInput(true);
                    conn.connect();

                    InputStream stream = conn.getInputStream();
                    xmlFactoryObject = XmlPullParserFactory.newInstance();
                    XmlPullParser myparser = xmlFactoryObject.newPullParser();

                    myparser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
                    myparser.setInput(stream, null);


                    parseOffers(myparser);
                    stream.close();
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}

