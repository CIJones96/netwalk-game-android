package com.example.assignment2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chris on 02/02/2017.
 */

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new GameView(getApplicationContext())); // GameView content
    }
}