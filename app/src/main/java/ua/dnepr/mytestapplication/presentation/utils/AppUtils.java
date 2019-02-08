package ua.dnepr.mytestapplication.presentation.utils;

import android.content.Context;
import android.util.DisplayMetrics;


public class AppUtils {
    public static int convertDPtoPixels(Context context, float dps) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dps * scale + 0.5f);
    }
    public static float convertPixelsToDp(float px, Context context){
        return px / ((float) context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
