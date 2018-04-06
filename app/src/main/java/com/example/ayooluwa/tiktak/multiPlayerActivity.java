package com.example.ayooluwa.tiktak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class multiPlayerActivity extends AppCompatActivity {
EditText playername1;
EditText playername2;
Button proceed;
Intent mintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multiplayer);
        playername1 = (EditText)findViewById(R.id.player1);
        playername2 = (EditText)findViewById(R.id.player2);
        proceed = (Button)findViewById(R.id.next);
        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mintent = new Intent(getApplicationContext(), chooseBoardActivity.class);
                mintent.putExtra("EdiTtEXTvALUE", playername1.getText().toString());
                mintent.putExtra("EdiTtEXTvALUE2", playername2.getText().toString());
                startActivity(mintent);
            }
        });

    }
}
