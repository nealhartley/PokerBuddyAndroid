package com.nealhartley.pokerbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private PokerGame game;




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

                //add selected card to game data
                Card cardReturned = new Card( data.getIntExtra("SelectedCardNumber",-1), data.getStringExtra("SelectedCardSuit") );
                assignCard(cardReturned);

                //update the deck
                if(game.removeCard(cardReturned.getValue(),cardReturned.getSuit())){

                }
                else{
                    Toast toast = Toast.makeText(getApplicationContext(),"error removing card from game deck",Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        }
    }

    //assigns card text to correct place and updates game stage
    private void assignCard(Card card) {

        Log.i("assign card", "entered method");
        Log.i("assign card", card.getValue() + " of " + card.getSuit());


        switch (game.getState()) {
            case "DEAL_ONE":
                setCardText(R.id.cardOne, card);
                TextView title = (TextView) findViewById(R.id.handTitle);
                title.setText("YOUR HAND");
                game.setCard(card);
                game.advanceState();
                break;

            case "DEAL_TWO":
                setCardText(R.id.cardTwo, card);
                game.setCard(card);
                game.advanceState();
                break;

            case "FLOP_ONE":
                setCardText(R.id.flopOne, card);

                TextView table = (TextView) findViewById(R.id.table);
                table.setText("The table");
                game.setCard(card);
                game.advanceState();
                break;

            case "FLOP_TWO":
                setCardText(R.id.flopTwo, card);
                game.setCard(card);
                game.advanceState();
                break;

            case "FLOP_THREE":
                setCardText(R.id.flopThree, card);
                game.setCard(card);
                game.advanceState();
                break;

            case "TURN":
                setCardText(R.id.turn, card);
                game.setCard(card);
                game.advanceState();
                break;

            case "RIVER":
                setCardText(R.id.river, card);
                game.setCard(card);
                game.advanceState();
                break;


        }
    }

    public boolean setCardText(int viewId,  Card card){
        TextView cardView = (TextView) findViewById(viewId);
        cardView.setText(card.getValue() + " of " + card.getSuit());


        return true;
    }



    //TODO: need to move lots of this game logic from MainActivity to poker game class. Main activity becoming big ball of mud


}
