package com.nealhartley.pokerbuddy.Filters;

import com.nealhartley.pokerbuddy.Card;

import java.util.ArrayList;

/**
 * Created by Dev on 21/11/2018.
 */

public class SuitedPairFilter implements  AdviceFilterInterface{

    @Override
    public boolean isTrue(ArrayList<Card> cards) {
        if(cards.get(0).getSuit().equals(cards.get(1).getSuit())){
            return true;
        }

        return false;
    }

    @Override
    public String getText(ArrayList<Card> cards) {
        return "So you got some suited cards and are drooling over a flush huh? Unfortunately A flush is not very likely to occur" +
                "even when you start of with a pair of suited cards. This combination is great in tandem with the other strength " +
                "of your hand. only play strong if you have other possibilities in your hand.\n";
    }

    @Override
    public int getSrength(ArrayList<Card> cards) {
        return 1;
    }
}
