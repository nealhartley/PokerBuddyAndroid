package com.nealhartley.pokerbuddy;

import java.util.ArrayList;

/**
 * Created by Dev on 16/04/2018.
 */

public class PokerGame{

    private Dealer dealer;
    public PokerGame(){
        dealer = new Dealer();
    }

    public ArrayList<Card> getDeck(){
        return dealer.getDeck();
    }

}
