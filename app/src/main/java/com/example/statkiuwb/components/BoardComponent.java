package com.example.statkiuwb.components;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.example.statkiuwb.R;
import com.example.statkiuwb.systemData.DeviceInfo;

import java.util.ArrayList;
import java.util.List;

public class BoardComponent extends ConstraintLayout {

    public static String TAG = "com.example.statkiuwb.components.BoardComponent";
    int boardWidth;
    ConstraintLayout board;
    private View root;
    private Context context;

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

        board.post(() -> setBars());

    }

    private void setBars() {
        List<View> bars = new ArrayList<>();

        for(int j=0; j<10; j++){

            int margin = boardWidth/10;
            //horizontal line
            View hv = new View(context);
            ConstraintLayout.LayoutParams hParams = new ConstraintLayout.LayoutParams(LayoutParams.MATCH_PARENT, 1);
            hParams.setMargins(0, (j+1)*margin,0,0);
            hv.setBackgroundColor(ContextCompat.getColor(getContext(),R.color.blueish));
            hv.setLayoutParams(hParams);
            int [] location = new int[2];
            hv.getLocationOnScreen(location);
            Log.d(TAG, "setBars: "+hv.getLayoutParams().height+" "+hv.getLayoutParams().width+" "+location[0]+ " "+location[1]);
            bars.add(hv);

            //vertival linez
            View vv = new View(context);
            ConstraintLayout.LayoutParams vParams = new ConstraintLayout.LayoutParams(LayoutParams.MATCH_PARENT, 1);
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
}
