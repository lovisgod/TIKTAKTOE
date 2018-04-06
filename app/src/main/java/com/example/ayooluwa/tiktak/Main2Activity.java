package com.example.ayooluwa.tiktak;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);
//set on click lisitener for the buttons
        Button singleplayer = (Button) findViewById(R.id.singleplayer);
        //set a clickListener to the view
        singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent si = new Intent(Main2Activity.this, singleplayerActivity.class);
                startActivity(si);
            }
        });

        Button multiplayer = (Button) findViewById(R.id.multiplayer);
        //set onclick listener to the view
        multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pi = new Intent(Main2Activity.this, multiPlayerActivity.class);
                startActivity(pi);
            }
        });


    }
}

