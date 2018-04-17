package com.nealhartley.pokerbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CardPicker extends AppCompatActivity {

    private ArrayList<Card> deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_picker);

        deck = getIntent().getParcelableArrayListExtra("deck");
    }


    public void selectSuit(View view){
        Button tv = (Button) view;
        String suit = tv.getText().toString();

        switch (suit){
            case "HEARTS":
                break;
            case "DIAMONDS":
                break;
            case "SPADES":
                break;
            case "CLUBS":
                break;

        }

        //TODO: Implement sorting of card of selected suit and displaying thme in the listview
        //also minimize the buttons until they selct a card.
        //also need to implement some sort of staging intent extra that controls how many cards they pick at each step


    }

}
