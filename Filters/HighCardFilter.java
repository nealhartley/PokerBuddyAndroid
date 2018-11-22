package com.nealhartley.pokerbuddy.Filters;

import com.nealhartley.pokerbuddy.Card;

import java.util.ArrayList;

/**
 * Created by Dev on 21/11/2018.
 */

public class HighCardFilter implements AdviceFilterInterface{


    @Override
    public boolean isTrue(ArrayList<Card> cards) {
    //need to test for pairs possibilities and then, if not a pair, check if one card is a high card
        if(cards.get(0).getValue()==cards.get(1).getValue()){
            return false;//were a pair
        }

        if(cards.get(0).getValue() == 1 || cards.get(1).getValue() == 1 ){ return true; }
        else if(cards.get(0).getValue() == 13 || cards.get(1).getValue() == 13){ return true; }
        else if(cards.get(0).getValue() == 12 || cards.get(1).getValue() == 12){ return true; }
        else if(cards.get(0).getValue() == 11 || cards.get(1).getValue() == 11){ return true; }

        return false;
    }

    @Override
    public String getText(ArrayList<Card> cards) {
        return "A high card often wins a lot of hands in poker. The chance that you will pair up somewhere down the line is close" +
                "to 50%. It's always worth seeing the flop with a high card, so long as you dont have to pay more than the blinds." +
                "Combine a high card with other potential and it can devestate your opposition. Be ready to get called: A lucky player\n";
    }

    @Override
    public int getSrength(ArrayList<Card> cards) {
        return 1;
    }
}
