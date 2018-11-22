package com.nealhartley.pokerbuddy.Filters;

import com.nealhartley.pokerbuddy.Card;

import java.util.ArrayList;

/**
 * Created by Dev on 21/11/2018.
 */

public class LowPairFilter implements AdviceFilterInterface {
    @Override
    public boolean isTrue(ArrayList<Card> cards) {

        if(cards.get(0).getValue() == cards.get(1).getValue()){
            if(cards.get(0).getValue() < 10) {
                return true;
            }
        }


        return false;
    }

    @Override
    public String getText(ArrayList<Card> cards) {
        return "Low pairs are quite commonly the most over valued hand in poker. The odds that someone " +
                "around the table would have been dealt a higher pair than you is quite likely. If no one has then the probability" +
                "of someone pairing up something higher than you on the flop is extraordinarily high." +
                "\n" +
                "\n" +
                "Don't pay more than your blinds for this one. Your only hope from this is to triple up on the flop, and that is not" +
                "very likely. ";
    }

    @Override
    public int getSrength(ArrayList<Card> cards) {
        return 1;
    }
}
