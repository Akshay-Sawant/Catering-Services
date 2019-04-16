package com.example.cateringapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Lincoln on 05/05/16.
 */
public class PrefManager {
    private SharedPreferences pref;
    private static SharedPreferences.Editor editor;
    private Context _context;

    // shared pref mode
    private int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "Catering-Services";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private static final boolean LOGGED_IN = false;
    private static final String FOOD_NAME = "food_name";
    private static final String FOOD_PRICE = "price";
    private static final String MENU_TYPE = "menu_type";
    private static final String LOG_IN = "login";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static String getFoodName(Context ctx) {
        return getSharedPreferences(ctx).getString(FOOD_NAME, "");
    }

    public static void setFoodName(Context context, String foodName) {
        SharedPreferences.Editor editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(FOOD_NAME, foodName);
        editor.apply();
    }

    public static String getFoodPrice(Context ctx) {
        return getSharedPreferences(ctx).getString(FOOD_PRICE, "");
    }

    public static void setFoodPrice(Context context, String foodPrice) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(FOOD_PRICE, foodPrice);
        editor.apply();
    }

    public static String getUsername(Context ctx) {
        return getSharedPreferences(ctx).getString(USERNAME, "");
    }

    public static void setUsername(Context context, String username) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(USERNAME, username);
        editor.apply();
    }

    public static String getPassword(Context ctx) {
        return getSharedPreferences(ctx).getString(PASSWORD, "");
    }

    public static void setPassword(Context context, String password) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(PASSWORD, password);
        editor.apply();
    }

    public static boolean isLoggedIn(Context ctx) {
        return getSharedPreferences(ctx).getBoolean(LOG_IN, LOGGED_IN);
    }

    public static void setLoggedIn() {

    }
}
