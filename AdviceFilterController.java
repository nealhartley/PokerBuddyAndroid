package com.nealhartley.pokerbuddy;

import android.util.Log;

import com.nealhartley.pokerbuddy.Filters.AdviceFilterInterface;
import com.nealhartley.pokerbuddy.Filters.HighCardFilter;
import com.nealhartley.pokerbuddy.Filters.HighPairFilter;
import com.nealhartley.pokerbuddy.Filters.LowPairFilter;
import com.nealhartley.pokerbuddy.Filters.StraightPotenFilter;
import com.nealhartley.pokerbuddy.Filters.SuitedPairFilter;

import java.util.ArrayList;

/**
 * Created by Dev on 15/11/2018.
 */

public class AdviceFilterController {

    private String advice = "";
    private int strength = 0;

    private ArrayList<AdviceFilterInterface> handFilters;
    private ArrayList<AdviceFilterInterface> flopFilters;
    private ArrayList<AdviceFilterInterface> turnFilters;
    private ArrayList<AdviceFilterInterface> riverFilters;

    public AdviceFilterController(){

        //lets set up all the filters for hand.
        handFilters = new ArrayList<AdviceFilterInterface>();
        handFilters.add(new HighCardFilter());
        handFilters.add(new HighPairFilter());
        handFilters.add(new LowPairFilter());
        handFilters.add(new StraightPotenFilter());
        handFilters.add(new SuitedPairFilter());

    }

    public AdvicePacket filter(Card handOne, Card handTwo){

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(handOne);
        cards.add(handTwo);

        for (AdviceFilterInterface filter: handFilters ) {
            Log.i("filtering","filtering");
            if(filter.isTrue(cards)){
                advice = advice + filter.getText(cards);
                strength = strength + filter.getSrength(cards);
                Log.i("filtering","found filter that applies. advice: " + advice + ", strength: " + strength);
            }

        }


        return new AdvicePacket(advice, strength);
    }


    public String filter(Card handOne, Card handTwo, Card flopOne, Card flopTwo, Card flopThree){
        return advice;
    }


    public String filter(Card handOne, Card handTwo, Card flopOne, Card flopTwo, Card flopThree, Card turn){
        return advice;
    }


    public String filter(Card handOne, Card handTwo, Card flopOne, Card flopTwo, Card flopThree, Card turn, Card river){
        return advice;
    }


}
