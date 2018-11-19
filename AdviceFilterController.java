package com.nealhartley.pokerbuddy;

import com.nealhartley.pokerbuddy.Filters.AdviceFilterInterface;

import java.util.ArrayList;

/**
 * Created by Dev on 15/11/2018.
 */

public class AdviceFilterController {

    private String advice = "";

    private ArrayList<AdviceFilterInterface> handFilters;
    private ArrayList<AdviceFilterInterface> flopFilters;
    private ArrayList<AdviceFilterInterface> turnFilters;
    private ArrayList<AdviceFilterInterface> riverFilters;

    public AdviceFilterController(){

    }

    public String filter(Card handOne, Card handTwo){
        return advice;
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
