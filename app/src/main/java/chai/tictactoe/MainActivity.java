package chai.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int[][] board = new int[3][3];
    private int whoTurn;
    Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    TextView result;
    boolean gameInProgress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        block1 = (Button) findViewById(R.id.bt_block1);
        block2 = (Button) findViewById(R.id.bt_block2);
        block3 = (Button) findViewById(R.id.bt_block3);
        block4 = (Button) findViewById(R.id.bt_block4);
        block5 = (Button) findViewById(R.id.bt_block5);
        block6 = (Button) findViewById(R.id.bt_block6);
        block7 = (Button) findViewById(R.id.bt_block7);
        block8 = (Button) findViewById(R.id.bt_block8);
        block9 = (Button) findViewById(R.id.bt_block9);
        result = (TextView) findViewById(R.id.tv_show_result);
        restart = (Button) findViewById(R.id.bt_restart_game);

        gameInProgress = false;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = 0;


        block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block1.getText().toString())) {
                        block1.setText((whoTurn == 1)? "X" : "O");
                        board[0][0] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }
        });
        block2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block2.getText().toString())){
                        block2.setText((whoTurn == 1)? "X" : "O");
                        board[0][1] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }
        });
        block3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block3.getText().toString())) {
                        block3.setText((whoTurn == 1)? "X" : "O");
                        board[0][2] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }
        });
        block4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block4.getText().toString())) {
                        block4.setText((whoTurn == 1)? "X" : "O");
                        board[1][0] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }
        });
        block5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block5.getText().toString())) {
                        block5.setText((whoTurn == 1)? "X" : "O");
                        board[1][1] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }
        });
        block6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block6.getText().toString())){
                        block6.setText((whoTurn == 1)? "X" : "O");
                        board[1][2] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }
        });
        block7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block7.getText().toString())){
                        block7.setText((whoTurn == 1)? "X" : "O");
                        board[2][0] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }
        });
        block8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block8.getText().toString())){
                        block8.setText((whoTurn == 1)? "X" : "O");
                        board[2][1] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }
        });
        block9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(gameInProgress){
                    if(TextUtils.isEmpty(block9.getText().toString())){
                        block9.setText((whoTurn == 1)? "X" : "O");
                        board[2][2] = whoTurn;
                        checkEndGame();
                        if(whoTurn == 2) whoTurn = 1; else whoTurn = 2;
                    }
                }

            }

        });



        /**
         * Restarts the game
         */
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!gameInProgress){
                    initGame();
                }else{
                    dispDialog();
                }

            }
        });

    }


    private void checkEndGame() {
        int whoWin = 0;
        int cnt = 0;
        if(checkForWin()) {
            if(whoTurn == 1) result.setText("Player 1 Wins");
            else result.setText("Player 2 Wins");
            gameInProgress = false;
            restart.setText("Start New Game");
        }else {
            for(int i = 0; i < 3; i++)
                for(int j = 0; j < 3; j++)
                    if(board[i][j]>0) cnt++;

            if(cnt == 9){
                whoWin = 3; //draw
                result.setText("It's a Tie");
                gameInProgress = false;
                restart.setText("Start New Game");
            }

        }



    }



    private void initGame(){
        gameInProgress = true;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                board[i][j] = 0;
        block1.setText("");
        block2.setText("");
        block3.setText("");
        block4.setText("");
        block5.setText("");
        block6.setText("");
        block7.setText("");
        block8.setText("");
        block9.setText("");
        restart.setText("Restart Game");
        result.setText("");
        whoTurn = 1;
    }

    public boolean checkForWin() {

        return (checkRowsForWin() || checkColumnsForWin() || checkDiagonalsForWin());

    }





    // Loop through rows and see if any are winners.

    private boolean checkRowsForWin() {

        for (int i = 0; i < 3; i++) {

            if (checkRowCol(board[i][0], board[i][1], board[i][2])) {

                return true;

            }

        }

        return false;

    }





    // Loop through columns and see if any are winners.

    private boolean checkColumnsForWin() {

        for (int i = 0; i < 3; i++) {

            if (checkRowCol(board[0][i], board[1][i], board[2][i])) {

                return true;

            }

        }

        return false;

    }





    // Check the two diagonals to see if either is a win. Return true if either wins.

    private boolean checkDiagonalsForWin() {

        return ((checkRowCol(board[0][0], board[1][1], board[2][2]) == true) || (checkRowCol(board[0][2], board[1][1], board[2][0]) == true));

    }





    // Check to see if all three values are the same (and not empty) indicating a win.

    private boolean checkRowCol(int c1, int c2, int c3) {

        return ((c1 != 0) && (c1 == c2) && (c2 == c3));

    }


    private void dispDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Tic-Tac-Toe");
        alertDialog.setMessage("Do you want to restart the game?");
        alertDialog.setPositiveButton("YES",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        initGame();
                    }
                });

        alertDialog.setNegativeButton("NO",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

        alertDialog.show();
    }
}
