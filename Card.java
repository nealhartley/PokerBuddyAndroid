package com.nealhartley.pokerbuddy;

/**
 * Created by Dev on 16/04/2018.
 */

public class Card {

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



}
