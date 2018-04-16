package com.nealhartley.pokerbuddy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    private PokerGame game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        game = new PokerGame();

    }


    public void start(View view){
        view.setVisibility(View.INVISIBLE);
    }
}
