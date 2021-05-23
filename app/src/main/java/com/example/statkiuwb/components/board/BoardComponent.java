package com.example.statkiuwb.components.board;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.statkiuwb.R;
import com.example.statkiuwb.systemData.DeviceInfo;

import java.util.ArrayList;
import java.util.List;

public class BoardComponent extends ConstraintLayout implements View.OnTouchListener {

    public static String TAG = "com.example.statkiuwb.components.board.BoardComponent";
    int boardWidth;
    FrameLayout board;
    private View root;
    private Context context;
    int amountOfSquaresInRow = 10;

    public BoardComponent(@NonNull Context context) {
        super(context);
        initView(context);
    }

    private void initView(Context context) {
        this.context = context;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.board_component,this);
        board = findViewById(R.id.boardLayout);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(DeviceInfo.getScreenWidth(context),
                DeviceInfo.getScreenWidth(context));
        boardWidth = DeviceInfo.getScreenWidth(context);
        board.setLayoutParams(params);
        board.setOnTouchListener(this);

        board.post(() -> setBars());

    }

    private void setBars() {
        List<View> bars = new ArrayList<>();

        for(int j=0; j<amountOfSquaresInRow; j++){

            int margin = boardWidth/amountOfSquaresInRow;
            //horizontal line
            View hv = new View(context);
            ConstraintLayout.LayoutParams hParams = new ConstraintLayout.LayoutParams(LayoutParams.MATCH_PARENT, DeviceInfo.convertDpToPixel(3,context));
            hParams.setMargins(0, (j+1)*margin,0,0);
            hv.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.blueish));
            hv.setLayoutParams(hParams);
            int [] location = new int[2];
            hv.getLocationOnScreen(location);
            Log.d(TAG, "setBars: "+hv.getLayoutParams().height+" "+hv.getLayoutParams().width+" "+location[0]+ " "+location[1]);
            bars.add(hv);

            //vertival linez
            View vv = new View(context);
            ConstraintLayout.LayoutParams vParams = new ConstraintLayout.LayoutParams(DeviceInfo.convertDpToPixel(3,context), LayoutParams.MATCH_PARENT);
            vParams.setMargins((j+1)*margin, 0,0,0);
            vv.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.blueish));
            vv.setLayoutParams(vParams);
            int [] location2 = new int[2];
            vv.getLocationOnScreen(location);
            Log.d(TAG, "setBars: "+vv.getLayoutParams().height+" "+hv.getLayoutParams().width+" "+location2[0]+ " "+location2[1]);
            bars.add(vv);

        }
        for(int i=0; i<bars.size(); i++){
            board.addView(bars.get(i));
        }
    }

    public BoardComponent(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public BoardComponent(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public BoardComponent(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        //czy jest to event puszczonego palca czyli ktos cos wcisnal
        if(event.getAction() == MotionEvent.ACTION_DOWN){

            switch(v.getId()){

                case R.id.boardLayout:
                    performCLickOnGrid(event);
                    break;
            }
        }

        //zwraca flage p/f czy ten event zostal wykonany - czyli jak false to poleci ten event dalej wglab drzewa layoutu
        return false;
    }

    private void performCLickOnGrid(MotionEvent event) {

        int x,y;
        x= (int)event.getX();
        y= (int)event.getY();

        //x i y to koordynaty kliku w obrebie planszy czyli niewazne gdzie plansa bedzie na ekranie to lewy gorny rog
        //planszy zwroci 0,0, a prawy dolny boardWidth,boardWidth
        //no czyli jak wiemy ile jest whardatow w pionie i poziomie to moge wyliczyc ktory zostal klikniety


        for(int i=0; i<amountOfSquaresInRow; i++){
            for(int j=0; j<amountOfSquaresInRow; j++){

                if(isBetween(x,j) && isBetween(y,i)){
                    Toast.makeText(context, "coords:"+i+","+j, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    private boolean isBetween(int x, int j) {
        int squareSize = boardWidth/amountOfSquaresInRow;
        if(x>j*squareSize && x<(j+1)*squareSize){
            return true;
        }else{
            return false;
        }
    }
}
