package com.nealhartley.pokerbuddy.Filters;

import com.nealhartley.pokerbuddy.Card;

import java.util.ArrayList;

/**
 * Created by Dev on 19/11/2018.
 */

public class HighPairFilter implements AdviceFilterInterface{

    private int value = 3;

    @Override
    public boolean isTrue(ArrayList<Card> cards) {
        if(cards.get(0).getValue() == cards.get(1).getValue()){
            if(cards.get(0).getValue() > 9){
                return true;
            }
        }

        return false;
    }

    @Override
    public String getText(ArrayList<Card> cards) {
        if(cards.get(0).getValue() == 1 || cards.get(0).getValue() == 13 ){
            return "This is one of the best possible starting hands. Look to push people out early in order to decrease the" +
                    "chances of someone pulling a better hand than you. raise and re-raise.\n";
        }
        else {
            return "Not a bad starting hand. Puts you in stead to see a triple on the flop. But as it is there is a chance someone" +
                    "got dealt a better hand than you, and even if they didnt anyone who has a single card better than you has a close " +
                    "to 50% chance of pairing up.  This hand is worth getting to the flop if you don't have to pay much to get there." +
                    "Call small raises or try to make it through on blinds.\n";
        }
    }

    @Override
    public int getSrength(ArrayList<Card> cards) {
        if(cards.get(0).getValue() == 1 || cards.get(0).getValue() == 13 ){
            return 3;
        }
        else {
            return 2;
        }
    }
}
