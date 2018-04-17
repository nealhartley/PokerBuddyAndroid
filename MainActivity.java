package com.nealhartley.pokerbuddy;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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


    public void start(View view){
        view.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(getApplicationContext(),CardPicker.class);
        intent.putParcelableArrayListExtra("deck",game.getDeck());
        startActivity(intent);

    }
}
