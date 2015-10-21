package com.ngoprekweb.fit.focusteps;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Utility {
    private static final int DEFAULT_GOAL = 1000;

    public static final int IMAGE_WIDTH=360;
    public static final int IMAGE_HEIGHT=640;

    public static int getGoal(Context context){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPref.getInt(context.getString(R.string.saved_goal_pref), DEFAULT_GOAL);
    }

    public static void saveGoal(Context context, int goal){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(context.getString(R.string.saved_goal_pref), goal);
        editor.commit();
    }

    public static int getInitSteps(Context context){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        return sharedPref.getInt(context.getString(R.string.saved_init_pref), -1);
    }

    public static void saveInitSteps(Context context, int newSteps){
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(context.getString(R.string.saved_init_pref), newSteps);
        editor.commit();
    }

}
