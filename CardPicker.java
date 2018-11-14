package com.nealhartley.pokerbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


//TODO: Need to control the selection of cards at each step. i.e select 2 cards for your
// first turn, 3 at the flop, 1 then 1.
//TODO: send back the updated deck and selected cards at each step.

public class CardPicker extends AppCompatActivity {

    private ArrayList<Card> deck;
    private ArrayAdapter arrayAdapter;

    private String currentSuit;

    private Card selectedCard;

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_picker);


        //set up our deck of cards
        listView = (ListView) findViewById(R.id.cards);
        deck = getIntent().getParcelableArrayListExtra("deck");
        Log.i("deck size", "" + deck.size());
    }

    public void testButton(View view){
        Log.i("lets test","tested");
    }

    public void selectSuit(View view) {
        Log.i("test method enter", "entered");
        Button tv = (Button) view;
        String suit = tv.getText().toString();

        switch (suit) {
            case "HEARTS":
                Log.i("case", "HEARTS");
                displayCards("HEARTS");
                break;
            case "DIAMONDS":
                Log.i("case", "DIAMONDS");
                displayCards("DIAMONDS");
                break;
            case "SPADES":
                Log.i("case", "SPADES");
                displayCards("SPADES");
                break;
            case "CLUBS":
                Log.i("case", "CLUBS");
                displayCards("CLUBS");
                break;

        }
    }


    public void displayCards(String suit){

        currentSuit = suit;

        Log.i("yep", "displaying cards");

        if(deck.size()==0 || deck == null){
            Log.i("yep", "rip deck sucks");
            return;
        }

        final ArrayList<String> allOfSuitString = new ArrayList<String>();
        final ArrayList<Card> allOfSuitCards = new ArrayList<Card>();

        //add all cards of chosen suit to a sub array
        for(Card c : deck){

            if(c.getSuit().equals(suit)){
                allOfSuitString.add(c.getValue() + " of " + c.getSuit());
                allOfSuitCards.add(c);
            }

        }

        //now we have a sub array with all cards of a given suit
        //we need to add this item as a list to our listview
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, allOfSuitString);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast toast = Toast.makeText(getApplicationContext(),allOfSuitString.get(position),Toast.LENGTH_SHORT);
                toast.show();

                selectedCard = allOfSuitCards.get(position);
                //code for removing the card from the deck
                deck.remove(allOfSuitCards.get(position));
                displayCards(currentSuit);


                Log.i("returning", "returning");

                Intent intent = new Intent();
                intent.putExtra("SelectedCardSuit", selectedCard.getSuit());
                intent.putExtra("SelectedCardNumber", selectedCard.getValue());
                intent.putParcelableArrayListExtra("deck",deck);
                setResult(RESULT_OK,intent);
                finish();


            }
        });

    }
/*
    @Override
    public void onBackPressed(){
        Intent intent = new Intent();
        intent.putExtra("SelectedCardSuit", selectedCard.getSuit());
        intent.putExtra("SelectedCardNumber", selectedCard.getValue());
        intent.putParcelableArrayListExtra("deck",deck);
        setResult(RESULT_OK,intent);
        finish();
    }
*/

}


