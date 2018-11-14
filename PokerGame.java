package com.nealhartley.pokerbuddy;

import java.util.ArrayList;

/**
 * Created by Dev on 16/04/2018.
 */

public class PokerGame{

    private String gameState = "DEAL_ONE";
    private Dealer dealer;

    //the cards
    //hand
    private Card handOne;
    private Card handTwo;
    //flop
    private Card flopOne;
    private Card flopTwo;
    private Card flopThree;
    private Card turn;
    private Card river;


    public PokerGame(){
        dealer = new Dealer();
    }

    public ArrayList<Card> getDeck(){
        return dealer.getDeck();
    }

    public boolean removeCard(int val, String suit){
        return dealer.removeCard(val, suit);

    }

    //advancing game state methods
    public boolean advanceState(){

        switch (gameState){
            case "DEAL_ONE":
                gameState = "DEAL_TWO";
                break;

            case "DEAL_TWO":
                gameState = "FLOP_ONE";
                break;

            case "FLOP_ONE":
                gameState = "FLOP_TWO";
                break;

            case "FLOP_TWO":
                gameState = "FLOP_THREE";
                break;

            case "FLOP_THREE":
                gameState = "TURN";
                break;

            case "TURN":
                gameState = "RIVER";
                break;

            case "RIVER":
                gameState = "FINISHED";
                break;
       }

        return true;
    }

    public String getState() {
        return gameState;
    }


    //set different card depending on gamestate
    public void setCard(Card card){
        switch (gameState){
            case "DEAL_ONE":
                handOne = card;
                break;

            case "DEAL_TWO":
                handTwo = card;
                break;

            case "FLOP_ONE":
                flopOne = card;
                break;

            case "FLOP_TWO":
                flopTwo = card;
                break;

            case "FLOP_THREE":
                flopThree = card;
                break;

            case "TURN":
                turn = card;
                break;

            case "RIVER":
                river = card;
                break;
        }
    }

    //TODO: Add in the logic for giving advice. Do we want a seperate advice class or should this take palce in game logic?
    //TODO: Game logic works out circumstance then petitions a text holding class for the actual advice string?
    //TODO: Advice text as series of filters added if they are true?
}
