package com.example.statkiuwb.components.ships;

import android.content.Context;

public interface IShip {

    void setShip(int amountOfSquares, boolean orientation, int amountOfSquaresOnBoard);

    void initView(Context context, int amountOfSquares, boolean orientation, int amountOfSquaresOnBoard);
}
