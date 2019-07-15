package com.example.assignment2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Chris on 10/02/2017.
 */

public class Difficulty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficulty);
    }

    public void changeEasy(View view) {
        Toast.makeText(this, "Easy Difficulty Enabled!\nGrid Size: 4x4", Toast.LENGTH_SHORT).show(); // Message showing the difficulty change
        GameView.gridSize = 5; // Grid Size of the Easy Difficulty == 5
    }

    public void changeMedium(View view) {
        Toast.makeText(this, "Medium Difficulty Enabled!\nGrid Size: 7x7", Toast.LENGTH_SHORT).show(); // Message showing the difficulty change
        GameView.gridSize = 7; // Grid Size of the Medium Difficulty == 7
    }

    public void changeHard(View view) {
        Toast.makeText(this, "Medium Difficulty Enabled!\nGrid Size: 9x9", Toast.LENGTH_SHORT).show(); // Message showing the difficulty change
        GameView.gridSize = 9; // Grid Size of the Hard Difficulty == 9
    }

}
