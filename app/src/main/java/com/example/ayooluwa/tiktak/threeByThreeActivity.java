package com.example.ayooluwa.tiktak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class threeByThreeActivity extends AppCompatActivity implements View.OnClickListener {
    public Button[][] buttons = new Button[3][3];
    public boolean player1turn = true;
    //    public boolean player2turn = false;
//this helps to monitor the moves of players and check if its up to 9 to reset the board automatically
    public int movescount;
    //this help to monitor the points of each player
    public int player1point;
    public int player2point;
    public TextView player1TextView;
    public TextView player2TextView;
    public String playername;
    public String player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the textview for the player names and score
        player1TextView = findViewById(R.id.text_view_p1);
        player1TextView.setText(getIntent().getExtras().getString("EdiTtEXTvALUE"));
        playername = player1TextView.getText().toString();
        player2TextView = findViewById(R.id.text_view_p2);
        player2TextView.setText(getIntent().getExtras().getString("EdiTtEXTvALUE2"));
        player2 = player2TextView.getText().toString();
// use this to declare and loop through the button array
        for (int k = 0; k < 3; k++) {
            for (int p = 0; p < 3; p++) {
                // use this to get the button id and form an array
                String buttonID = "button_" + k + p;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                //we pass the res id created into the buttons object instatiated in the begginning pf the main activity class
                buttons[k][p] = findViewById(resID);
                buttons[k][p].setOnClickListener(this);
                // here we pass a resource id into our button reset to make the reset button in our xml layout work.
                // set an on click lisetener to the button and cast the method reset game into it to reset all the games parameters
                Button buttonReset = findViewById(R.id.button_reset);
                buttonReset.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                         resetGame();
                    }
                });

            }
        }
        Button mainMenu = findViewById(R.id.backToMenu);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ni = new Intent(threeByThreeActivity.this, welcomeActivity.class);
                startActivity(ni);
            }
        });
    }


    @Override
    public void onClick(View view) {
// this checked if the box that was clicked contains an empty string
        if (!((Button) view).getText().toString().equals("")) {
            return;
        }
        if (player1turn) {
            ((Button) view).setText("O");

        } else {
            ((Button) view).setText("X");

        }
        movescount++;

        if(checkForWin()) {
            if (player1turn){
            player1Wins();
            resetBoard();
            } else {
                player2Wins();
                resetBoard();
            }
        }
        if (movescount == 9) {
            draw();
            resetBoard();
        }
        player1turn = !player1turn;
    }

    private boolean checkForWin() {
        String[][] field = new String[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }
// create a for loop to check through your boxes if the strings in them are identical to check fot a winner
        for (int i = 0; i < 3; i++) {
            if (field[i][0].equals(field[i][1])
                    && field[i][0].equals(field[i][2])
                    && !field[i][0].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (field[0][i].equals(field[1][i])
                    && field[0][i].equals(field[2][i])
                    && !field[0][i].equals("")) {
                return true;
            }
        }

        if (field[0][0].equals(field[1][1])
                && field[0][0].equals(field[2][2])
                && !field[0][0].equals("")) {
            return true;
        }

        return field[0][2].equals(field[1][1])
                && field[0][2].equals(field[2][0])
                && !field[0][2].equals("");

    }


    private void draw() {
        Toast.makeText(this, "Draw!", Toast.LENGTH_SHORT).show();

    }
    private void player1Wins() {
        player1point++;
        Toast.makeText(this, playername + "wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        player2point++;
        Toast.makeText(this, player2 + "wins", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }
    private void updatePointsText() {
        player1TextView.setText(playername + player1point);
        player2TextView.setText(player2 + player2point);
    }
    private void resetBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j].setText("");
            }
        }

        movescount = 0;
        player1turn = true;
    }
    private void resetGame() {
        player1point = 0;
        player2point = 0;
        updatePointsText();
        resetBoard();
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", movescount);
        outState.putInt("player1Points", player1point);
        outState.putInt("player2Points", player2point);
        outState.putBoolean("player1Turn", player1turn);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        movescount = savedInstanceState.getInt("roundCount");
        player1point = savedInstanceState.getInt("player1Points");
        player2point = savedInstanceState.getInt("player2Points");
        player1turn = savedInstanceState.getBoolean("player1Turn");
    }
}





