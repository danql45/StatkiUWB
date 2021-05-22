package com.example.statkiuwb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

public class ShipPlaceBoard extends View {
    private final int boardColor;
    private final int cellFillColor;
//    private final int cellsHighlightColor;

    private final Paint boardColorPaint = new Paint();
    private final Paint cellFillColorPaint = new Paint();
//    private final Paint cellsHighlightColorPaint = new Paint();
    private int cellSize;

    private final Solver solver = new Solver();

    public ShipPlaceBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ShipPlaceBoard,
                0, 0);

        try{
            boardColor = a.getInteger(R.styleable.ShipPlaceBoard_boardColor, 0);
            cellFillColor = a.getInteger(R.styleable.ShipPlaceBoard_cellFillColor, 0);
//            cellsHighlightColor = a.getInteger(R.styleable.ShipPlaceBoard_cellsHighlightColor, 0);
        }finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int height = MeasureSpec.getSize(heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);

        int dimension = Math.min(width, height);

        cellSize = dimension / 10;

        setMeasuredDimension(dimension, dimension);
    }

    @Override
    protected void onDraw(Canvas canvas){
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(16);
        boardColorPaint.setColor(boardColor);
        boardColorPaint.setAntiAlias(true);

        cellFillColorPaint.setStyle(Paint.Style.FILL);
        cellFillColorPaint.setAntiAlias(true);
        cellFillColorPaint.setColor(cellFillColor);

//        cellsHighlightColorPaint.setStyle(Paint.Style.FILL);
//        cellsHighlightColorPaint.setAntiAlias(true);
//        cellsHighlightColorPaint.setColor(cellsHighlightColor);

        colorCell(canvas, solver.getSelected_row(), solver.getSelected_column());
        canvas.drawRect(0,0, getWidth(), getHeight(), boardColorPaint);
        drawBoard(canvas);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event){
        boolean isValid;

        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN){
            solver.setSelected_row((int)Math.ceil(y/cellSize));
            solver.setSelected_column((int)Math.ceil(x/cellSize));
            isValid = true;
        }
        else {
            isValid = false;
        }

        return isValid;
    }

    private void colorCell(Canvas canvas, int r, int c){
        if(solver.getSelected_column() != -1 && solver.getSelected_row() != -1){
//            canvas.drawRect((c-1)*cellSize, 0, c*cellSize, cellSize*10, cellsHighlightColorPaint);
//            canvas.drawRect(0, (r-1)*cellSize, cellSize*10, r*cellSize, cellsHighlightColorPaint);
            canvas.drawRect((c-1)*cellSize, (r-1)*cellSize, c*cellSize, r*cellSize, cellFillColorPaint);
        }
        invalidate();
    }

    private void drawLine(){
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(8);
        boardColorPaint.setColor(boardColor);
    }

    private void drawBoard(Canvas canvas){
        drawLine();
        //draw vertical lines
        for (int c = 0; c < 11; c++){
            canvas.drawLine(cellSize * c, 0, cellSize * c, getWidth(), boardColorPaint);
        }
        //draw horizontal lines
        for (int r = 0; r < 11; r++){
            canvas.drawLine(0, cellSize * r, getWidth(), cellSize * r, boardColorPaint);
        }

    }


}
