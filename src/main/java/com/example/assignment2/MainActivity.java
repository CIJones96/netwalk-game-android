package com.example.assignment2;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {
    public static MediaPlayer mediaPlayer;
    public static MediaPlayer mediaPlayer1;
    public static MediaPlayer mediaPlayer2;
    public static MediaPlayer mediaPlayer3;
    public CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.chiptune);
        mediaPlayer1 = MediaPlayer.create(MainActivity.this, R.raw.guile);
        mediaPlayer2 = MediaPlayer.create(MainActivity.this, R.raw.omg);
        mediaPlayer3 = MediaPlayer.create(MainActivity.this, R.raw.sad);

        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        checkbox = (CheckBox) findViewById(R.id.checkbox_main);

        checkbox.setOnClickListener(new CheckBox.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkbox.isChecked()) {
                    mediaPlayer.pause();
                    mediaPlayer1.pause();
                    mediaPlayer2.pause();
                    mediaPlayer3.pause();
                } else {
                    mediaPlayer.start();
                    mediaPlayer1.start();
                    mediaPlayer2.start();
                    mediaPlayer3.start();
                }
            }
        });
    }

    public void onResume() {
        super.onResume();
        mediaPlayer.start();
    }

    public void onDestroy() {
        super.onStop();
        MainActivity.this.finish();
        mediaPlayer.release();
        mediaPlayer1.release();
        mediaPlayer2.release();
        mediaPlayer3.release();
    }

    public void showGame(View view) {
        Intent intent = new Intent(this, Game.class);
        startActivity(intent);
    }

    public void showDifficulty(View view) {
        Intent intent = new Intent(this, Difficulty.class);
        startActivity(intent);
    }

    public void showHelp(View view) {
        Intent intent = new Intent(this, Help.class);
        startActivity(intent);
    }
}