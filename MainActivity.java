package com.nealhartley.pokerbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private PokerGame game;
    private String stage = "DEAL_ONE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new PokerGame();
        sharedPreferences = this.getSharedPreferences("com.nealhartley.pokerbuddy", Context.MODE_PRIVATE);//THINKNEAL

    }

    //the button to select cards
    public void start(View view){
        Intent intent = new Intent(getApplicationContext(),CardPicker.class);
        intent.putParcelableArrayListExtra("deck",game.getDeck());
        startActivityForResult(intent,1);

    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.i("resulting: ", "we should be putting ish down");
        if (requestCode == 1) {
            Log.i("resulting: ", "code was 1");
            if(resultCode == RESULT_OK){
                Log.i("resulting: ", "RESULT_OK");

                Card cardReturned = new Card( data.getIntExtra("SelectedCardNumber",-1), data.getStringExtra("SelectedCardSuit") );
                assignCard(cardReturned);

            }
        }
    }

    //assigns card text to correct place and updates game stage
    private void assignCard(Card card) {

        Log.i("assign card", "entered method");
        Log.i("assign card", card.getValue() + " of " + card.getSuit());


        switch (stage) {
            case "DEAL_ONE":
                TextView cardOne = (TextView) findViewById(R.id.cardOne);
                cardOne.setText(card.getValue() + " of " + card.getSuit());

                TextView title = (TextView) findViewById(R.id.handTitle);
                title.setText("YOUR HAND");

                stage = "DEAL_TWO";
                break;
            case "DEAL_TWO":
                TextView cardTwo = (TextView) findViewById(R.id.cardTwo);
                cardTwo.setText(card.getValue() + " of " + card.getSuit());

                stage = "STAGE_THREE";
                break;

        }



    }

    //TODO: What happens after they select some cards? Game logic...

    // 8 stages:
    //     select starting hand - purely selecting cards
    //          advice
    //     flop                 - select cards for the flop
    //          advice
    //     turn                 - select card for the turn
    //          advice
    //     river                - select last card
    //          advice


}
