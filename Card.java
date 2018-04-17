package com.nealhartley.pokerbuddy;

import android.nfc.Tag;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

/**
 * Created by Dev on 16/04/2018.
 */

public class Card implements Parcelable{

    private int value;
    private String suit;

    public Card(int value, String suit){
        value = value;
        suit = suit;
    }

    public int getValue() {
        return value;
    }


    public String getSuit() {
        return suit;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Log.v("tag", "write to parcel " + flags);
        dest.writeInt(value);
        dest.writeString(suit);
    }



    //we need to create the parcelable interface
    public static final Parcelable.Creator<Card> CREATOR
            = new Parcelable.Creator<Card>() {
        //this calls our new constructor defined below
        //it passes along the parcel and then returns the new object
        @Override
        public Card createFromParcel(Parcel source){
            return new Card(source);
        }

        //and for an array
        @Override
        public Card[] newArray(int size){
            return new Card[size];
        }


    };


    /**
     * This will be used only by the MyCreator
     * @param source
     */
    public Card(Parcel source){
            /*
             * Reconstruct from the Parcel
             */
        Log.v("tag", "ParcelData(Parcel source): time to put back parcel data");
        value = source.readInt();
        suit = source.readString();

    }
}
