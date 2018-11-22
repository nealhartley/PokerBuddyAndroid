package com.nealhartley.pokerbuddy.Filters;

import com.nealhartley.pokerbuddy.Card;

import java.util.ArrayList;

/**
 * Created by Dev on 21/11/2018.
 */

public class StraightPotenFilter implements AdviceFilterInterface{

    private int spread;

    @Override
    public boolean isTrue(ArrayList<Card> cards) {
        spread = Math.abs(cards.get(0).getValue() - cards.get(1).getValue());

        if(spread < 5 && spread > 0){
            return true;
        }
        // ace king case
        else if(cards.get(0).getValue() == 1 && cards.get(1).getValue() == 13){
            spread = 1;
            return true;
        }
        //king ace case
        else if(cards.get(0).getValue() == 13 && cards.get(1).getValue() == 1){
            spread = 1;
            return true;
        }


        return false;
    }

    @Override
    public String getText(ArrayList<Card> cards) {

        return "Straight potential can come in handy. Just realise that forming the straight from the potential is very unlikely." +
                "It becomes more likely the closer your cards are together. This is called: The Spread. \n" +
                "\n" +
                "Straights much like flushes are great to have in your back pocket. Its strength should be balanced out with" +
                "other potential in your hand.\n";
    }

    @Override
    public int getSrength(ArrayList<Card> cards) {
        return 1;
    }
}
