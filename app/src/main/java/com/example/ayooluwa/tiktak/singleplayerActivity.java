package com.example.ayooluwa.tiktak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class singleplayerActivity extends AppCompatActivity {
    EditText playerName;
    Button SendPlayerName;
    Intent pintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.singleplayer);
        playerName = findViewById(R.id.three_board);
        SendPlayerName = findViewById(R.id.proceed1);
        SendPlayerName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pintent = new Intent(getApplicationContext(), chooseBoardActivity.class);
                pintent.putExtra("EdiTtEXTvALUE", playerName.getText().toString());
                pintent.putExtra("not correct", false);
                startActivity(pintent);
            }
        });
    }
}
