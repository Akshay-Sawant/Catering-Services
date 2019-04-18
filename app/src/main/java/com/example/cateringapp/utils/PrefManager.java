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

    private static final String USERFULLNAME = "user_full_name";
    private static final String USERNAME = "username";
    private static final String MOBILE_NO = "mobile_no";
    private static final String PASSWORD = "password";
    private static final String FOOD_NAME = "food_name";
    private static final String FOOD_PRICE = "price";
    private static final String MENU_TYPE = "menu_type";
    private static final String HOME_ADDRESS = "home_address";
    private static final String WORK_ADDRESS = "work_address";

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

    public static String getUserFullName(Context ctx) {
        return getSharedPreferences(ctx).getString(USERFULLNAME, "");
    }

    public static void setUserFullName(Context context, String userFullName) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(USERFULLNAME, userFullName);
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

    public static String getMobileNo(Context ctx) {
        return getSharedPreferences(ctx).getString(MOBILE_NO, "");
    }

    public static void setMobileNo(Context context, String mobile_no) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(MOBILE_NO, mobile_no);
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

    public void logoutUser(Context context) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.remove(USERNAME);
        editor.remove(PASSWORD);
        editor.apply();
    }

    public static String getHomeAddress(Context ctx) {
        return getSharedPreferences(ctx).getString(HOME_ADDRESS, "");
    }

    public static void setHomeAddress(Context context, String homeAddress) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(HOME_ADDRESS, homeAddress);
        editor.apply();
    }

    public static String getWorkAddress(Context ctx) {
        return getSharedPreferences(ctx).getString(WORK_ADDRESS, "");
    }

    public static void setWorkAddress(Context context, String workAddress) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(WORK_ADDRESS, workAddress);
        editor.apply();
    }
}
