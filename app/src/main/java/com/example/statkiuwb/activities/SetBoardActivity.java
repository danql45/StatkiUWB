package com.example.statkiuwb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.statkiuwb.R;
import com.example.statkiuwb.components.board.BoardComponent;

public class SetBoardActivity extends AppCompatActivity {

    BoardComponent boardComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_board);

        //inits visible components
        initComponents();
    }

    private void initComponents() {
        boardComponent = findViewById(R.id.boardLayoutSetBoardActivity);
        //amountOfBars - how many rows will be on the board in one direction v or h
        boardComponent.drawBoard(10);
    }
}