package com.nealhartley.pokerbuddy;

import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Dev on 16/04/2018.
 */

public class Deck {

    ArrayList<Card> deck;

    public Deck(){

        deck = new ArrayList<>();

        for(int i = 0; i < 4; i++){
            for(int j = 1; j<= 13; j++){
                switch (i){
                    case 0:
                        deck.add(new Card(j,"HEARTS"));
                        break;
                    case 1:
                        deck.add(new Card(j,"CLUBS"));
                        break;
                    case 2:
                        deck.add(new Card(j,"DIAMONDS"));
                        break;
                    case 3:
                        deck.add(new Card(j,"SPADES"));
                        break;
                }
            }
        }
    }

    public boolean drawCard(int value, String suit){

        Card toRemove = new Card(value, suit);

        Log.i("in deck class", "removing: " + value + " of " + suit);



        for (Card c: deck) {

            Log.i("in deck class", "    comparing: " + c.getValue() + " of " + c.getSuit());

            if((c.getSuit().equals(suit)) && (c.getValue() == value)){
                Log.i("in deck class", " found a match!");
                deck.remove(c);

                return true;
            }
        }

       return false;

    }

    public ArrayList<Card> getDeckasArrayList(){
        return deck;
    }


}
