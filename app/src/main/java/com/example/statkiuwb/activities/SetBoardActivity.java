package com.example.statkiuwb.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.statkiuwb.R;
import com.example.statkiuwb.components.board.BoardComponent;
import com.example.statkiuwb.components.ships.DoubleShip;
import com.example.statkiuwb.components.ships.SingularShip;
import com.example.statkiuwb.components.ships.TripleShip;

public class SetBoardActivity extends AppCompatActivity {

    BoardComponent boardComponent;
    SingularShip singularShip;

    DoubleShip verticalDoubleShip;
    DoubleShip horizontalDoubleShip;

    TripleShip verticalTripleShip;
    TripleShip horizontalTripleShip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_board);

        //inits visible components
        initComponents();
    }

    private void initComponents() {
        boardComponent = findViewById(R.id.boardLayoutSetBoardActivity);
        initializeShips();
        //amountOfBars - how many rows will be on the board in one direction v or h
        boardComponent.drawBoard(10);

    }

    private void initializeShips() {
        initializeSingularShip();
        initializeDoubleShips();
        initializeTripleShips();
    }

    private void initializeTripleShips() {
        verticalTripleShip = findViewById(R.id.tripleShipVertical);
        verticalTripleShip.initView(this,3,true,10);

        horizontalTripleShip = findViewById(R.id.tripleShipHorizontal);
        horizontalTripleShip.initView(this,3,false,10);
    }

    private void initializeDoubleShips() {
        verticalDoubleShip = findViewById(R.id.doubleShipVertical);
        verticalDoubleShip.initView(this,2,true,10);

        horizontalDoubleShip = findViewById(R.id.doubleShipHorizontal);
        horizontalDoubleShip.initView(this,2,false,10);
    }

    private void initializeSingularShip() {
        singularShip = findViewById(R.id.singularShip);
        singularShip.initView(this,1,true,10);
    }
}