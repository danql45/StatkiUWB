package com.example.statkiuwb.systemData;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;

public class DeviceInfo {

    public static String TAG = "com.example.statkiuwb.systemData.DeviceInfo";

    public static int getScreenHeight(Context ctx){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity act = (Activity)ctx;
        act.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }
    public static int getScreenWidth(Context ctx){
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity act = (Activity)ctx;
        act.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int convertDpToPixel(float dp, Context context){
        return Math.round(dp * ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }

    public static int convertPixelsToDp(float px, Context context){
        return Math.round(px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
