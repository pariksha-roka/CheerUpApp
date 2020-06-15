package com.example.cheerupapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.cheerupapp.R;
import com.example.cheerupapp.entities.DanceSong;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class AddSongForDanceScrollingActivity extends AppCompatActivity {

    private EditText songNameEditText;
    private EditText addFavoriteVerseEditText;
    private SeekBar ratingSeekBar;
    private Button cancelSongButton;
    private Button addDanceSongButton;

    private DanceSong danceSong;
    private Long ratingValue = 0L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dance_song_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        songNameEditText = findViewById(R.id.danceSongIdEditText);
        addFavoriteVerseEditText = findViewById(R.id.addFavoriteVerseEditText);
        ratingSeekBar = findViewById(R.id.ratingSeekBar);
        cancelSongButton = findViewById(R.id.cancelSongButton);
        addDanceSongButton = findViewById(R.id.addDanceSongButton);

        addDanceSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDanceSong(v);
            }
        });

        cancelSongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel(v);
            }
        });

        ratingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ratingValue = Long.valueOf(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void addDanceSong(View v) {
        String songName = songNameEditText.getText().toString();
        //this trim method is to get rid of every empty spaces
        if (songName.trim().isEmpty()){
            Snackbar.make(v, "Song name is required", Snackbar.LENGTH_SHORT).show();
            songNameEditText.getText().clear();
            songNameEditText.requestFocus();
            return;
        }
        String favoriteVerse = addFavoriteVerseEditText.getText().toString().trim();
        danceSong = new DanceSong();
        danceSong.setName(songName);
        danceSong.setFavoriteVerse(favoriteVerse);
        danceSong.setRating(ratingValue);

        //after we click add, we need to close this activity and go back to Dance page fifth activity
        // for that we need to create intent
        Intent goingBackIntent = new Intent();
        goingBackIntent.putExtra(DanceSong.DANCE_SONG_KEY, danceSong);
        setResult(RESULT_OK, goingBackIntent);
        finish();
    }

    private void cancel(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }
}
