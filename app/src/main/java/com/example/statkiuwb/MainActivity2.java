package com.example.statkiuwb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Board pixelGrid = new Board(this);
        pixelGrid.setNumColumns(10);
        pixelGrid.setNumRows(10);

        setContentView(pixelGrid);
    }
}

