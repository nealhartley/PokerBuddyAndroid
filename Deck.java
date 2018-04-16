package com.nealhartley.pokerbuddy;

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
                    case 1: i = 0;
                        deck.add(new Card(j,"HEARTS"));
                        break;
                    case 2: i = 1;
                        deck.add(new Card(j,"CLUBS"));
                        break;
                    case 3: i = 2;
                        deck.add(new Card(j,"DIAMONDS"));
                        break;
                    case 4: i = 3;
                        deck.add(new Card(j,"SPADES"));
                        break;
                }
            }
        }
    }

    public boolean drawCard(int value, String suit){

        Card toRemove = new Card(value, suit);
        return deck.remove(toRemove);

    }


}
