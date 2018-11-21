package com.nealhartley.pokerbuddy.Filters;

import com.nealhartley.pokerbuddy.Card;

import java.util.ArrayList;

/**
 * Created by Dev on 15/11/2018.
 */

public interface  AdviceFilterInterface {

public boolean isTrue(ArrayList<Card> cards);

    //gets the text that tells you how you should play the hand at this point
public String getText(ArrayList<Card> cards);

    // a number signifying the strength of the hand
        // strength can be 1 - 10
        // 1  = weak
        // 2 = medium - Can play depending on how your opponents
        // 3 = strong - should definitely play this
public int getSrength(ArrayList<Card> cards);

    //TODO: now i need to think of all the concrete implimentations for these filters
    // for hand
    //high pair - 3, low pair - 1, suited - 1, straight potential - 1, high card - 1

    //for flop
    //triples - 3, straight potential - 1, flush potential - 1, high pair - 2,
    // low pair - 1, two pair - 2, four of a kind - 3, full house - 3, the nut - 3
    // flush - 3, straight - 3

    //for turn
    //triples - 2 or 3, straight potential - 1, flush potential - 1, high pair - 1,
    // low pair - 0, two pair - 1, four of a kind - 3, full house - 3, the nut - 3
    // flush - 3, straight - 3

    //for river
    //triples - 2, straight potential - 0, flush potential - 0, high pair - 1, low pair - 0,
    // two pair - 1, four of a kind - 3, full house - 2, the nut - 3, flush - 2 or 3, straight - 2 or 3

    //warning filters
    // flush potential, straight potential, higher pair, triple or full house potential,
    // (IDEA)likelihood of better hand on the table....?

}
