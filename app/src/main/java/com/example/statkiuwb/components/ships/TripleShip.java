package com.example.statkiuwb.components.ships;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.statkiuwb.R;
import com.example.statkiuwb.systemData.DeviceInfo;

public class TripleShip extends LinearLayout implements IShip {

    Context context;
    LinearLayout ship;

    public TripleShip(Context context) {
        super(context);
        this.context = context;
    }

    public TripleShip(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public TripleShip(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public TripleShip(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.context = context;
    }

    @Override
    public void setShip(int amountOfSquares, boolean orientation, int amountOfSquaresOnBoard) {
        initView(context,amountOfSquares,orientation, amountOfSquaresOnBoard);
    }

    private LayoutParams createLayoutParams(int amountOfSquares, boolean orientation, int amoutOfSquaresOnBoard) {
        LinearLayout.LayoutParams params;
        int squareSize = DeviceInfo.getScreenWidth(context)/amoutOfSquaresOnBoard;
        if(orientation){
            params = new LinearLayout.LayoutParams(squareSize, amountOfSquares*squareSize);
        }else{
            params = new LinearLayout.LayoutParams(amountOfSquares*squareSize, squareSize);
        }

        return params;

    }
    @Override
    public void initView(Context context, int amountOfSquares, boolean orientation, int amountOfSquaresOnBoard) {

        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.ship,this);
        ship = findViewById(R.id.ship);
        LinearLayout.LayoutParams params = createLayoutParams(amountOfSquares,orientation, amountOfSquaresOnBoard);
//        boardWidth = DeviceInfo.getScreenWidth(context);
        ship.setLayoutParams(params);

    }
}
