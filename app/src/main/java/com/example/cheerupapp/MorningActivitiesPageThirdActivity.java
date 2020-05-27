package com.example.cheerupapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MorningActivitiesPageThirdActivity extends AppCompatActivity {

    TextView userNameTextView;
    Button goBackToWelcomePageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_morning_activities_page_third);
/*        final User user;

        Intent userCallerIntent = new Intent();
        user = (User) userCallerIntent.getSerializableExtra(User.USER_KEY);

        userNameTextView = findViewById(R.id.userNameTextView);
        userNameTextView.setText(user.getName());*/

        goBackToWelcomePageButton = findViewById(R.id.goBackToWelcomePageButton);

        goBackToWelcomePageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goingBackToWelcomePageIntent = new Intent();
                //goingBackToWelcomePageIntent.putExtra(User.USER_KEY, user);
                setResult(RESULT_OK, goingBackToWelcomePageIntent);
                finish();
            }
        });
    }
}
