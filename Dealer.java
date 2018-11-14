package com.nealhartley.pokerbuddy;

import java.util.ArrayList;

/**
 * Created by Dev on 16/04/2018.
 */

public class Dealer {

    private Deck deck;

    public Dealer(){
        deck = new Deck();
    }


    public ArrayList<Card> getDeck() {
        return deck.getDeckasArrayList();

    }

    public boolean removeCard(int val, String suit) {

        return deck.drawCard(val, suit);
    }
}
