package com.arnold.footballshop;

/**
 * Created by Arnold on 16.01.2016.
 */
public class OfferItem {
    private int  mId;
    private String mName;
    private String mPrice;

    OfferItem() {
       mId = 0;
        mName = "Name";
        mPrice = "Price";
    }

    public OfferItem(int id, String name, String price) {
        this.mId = id;
        this.mName = name;
        this.mPrice = price;
    }

    public String getName() {
        return mName;
    }
  //  public void setName(String name) {
  //      mName = name;
 //   }


 //   public void setId(int id) {
  //      mId = id;
 //  }
    public int getId() {
        return mId;
    }

  //  public void setPrice(String price) { mPrice = price;}
    public String getPrice() {
        return mPrice;
    }


}

