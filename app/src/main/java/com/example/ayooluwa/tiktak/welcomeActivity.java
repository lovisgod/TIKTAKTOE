package com.example.ayooluwa.tiktak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class welcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);
//set on click lisitener for the buttons
        Button singleplayer = findViewById(R.id.singleplayer);
        //set a clickListener to the view
       singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(welcomeActivity.this, singleplayerActivity.class);
                startActivity(si);
            }
        });

        Button multiplayer = findViewById(R.id.multiplayer);
        //set onclick listener to the view
        multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pi = new Intent(welcomeActivity.this, multiPlayerActivity.class);
                startActivity(pi);
            }
        });


    }
}

