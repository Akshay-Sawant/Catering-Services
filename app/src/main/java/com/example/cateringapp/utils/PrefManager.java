package com.example.cateringapp.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private static final String TOTAL_AMOUNT = "total_amount";
    private static final String FOOD_COUNT = "food_count";
    private static final String HOME_ADDRESS = "home_address";
    private static final String WORK_ADDRESS = "work_address";
    private static final String CARD_HOLDER_NAME = "card_holder_name";
    private static final String CARD_NUMBER = "card_number";
    private static final String CARD_EXPIRY_DATE = "card_expiry_date";
    private static final String CARD_CVV_NUMBER = "card_cvv_number";
    private static final String SERVICE_TYPE = "menu_type";
    private static final String TIFFIN_SERVICE_TYPE = "tiffin_service_type";
    private static final String SCHEDULE_SERVICE = "schedule_service";
    private static final String NO_OF_PEOPLE = "no_of_people";
    private static final String NO_OF_GUESTS = "no_of_guests";
    private static final String EVENT_NAME = "event_name";
    private static final String ORDER_DATE = "order_date";
    private static final String ORDER_TIME = "order_time";
    /*private static Gson gson;
    private static String data;
    private static ArrayList<String> foodName;*/

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

    /*public static String[] getFoodName(Context ctx) {
     *//*ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add(getSharedPreferences(ctx).getString(FOOD_NAME, ""));*//*

        Gson gson = new Gson();
        String jsonText = getSharedPreferences(ctx).getString(FOOD_NAME, null);
        String[] text = gson.fromJson(jsonText, String[].class);
        return text;
    }*/

    /*public static void setFoodName(Context context, ArrayList<String> foodName) {
        SharedPreferences.Editor editor = PrefManager.getSharedPreferences(context).edit();
        *//*editor.putString(FOOD_NAME, foodName);
        editor.apply();*//*
//        foodName = foodName;
        gson = new Gson();
        data = gson.toJson(foodName);
        editor.putString(FOOD_NAME, String.valueOf(data));
        editor.apply();
    }*/

    public static ArrayList<String> getFoodName(Context ctx) {

        return new ArrayList<String>(Arrays.asList(TextUtils.split(getSharedPreferences(ctx).getString(FOOD_NAME, ""), "‚‗‚")));

    }

    public static void setFoodName(Context context, ArrayList<String> intList) {

        String[] myIntList = intList.toArray(new String[intList.size()]);

        PrefManager.getSharedPreferences(context).edit().putString(FOOD_NAME, TextUtils.join("‚‗‚", myIntList)).apply();

    }

    public static ArrayList<String> getFoodPrice(Context ctx) {
//        return getSharedPreferences(ctx).getString(FOOD_PRICE, "");

        return new ArrayList<String>(Arrays.asList(TextUtils.split(getSharedPreferences(ctx).getString(FOOD_PRICE, ""), "‚‗‚")));
    }

    public static void setFoodPrice(Context context, ArrayList<String> foodPrice) {

        String[] myFoodPrice = foodPrice.toArray(new String[foodPrice.size()]);

        PrefManager.getSharedPreferences(context).edit().putString(FOOD_PRICE, TextUtils.join("‚‗‚", myFoodPrice)).apply();
        /*editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(FOOD_PRICE, foodPrice);
        editor.apply();*/
    }

    public static ArrayList<String> getFoodCount(Context ctx) {
//        return getSharedPreferences(ctx).getString(FOOD_COUNT, "");
        return new ArrayList<String>(Arrays.asList(TextUtils.split(getSharedPreferences(ctx).getString(FOOD_COUNT, ""), "‚‗‚")));
    }

    public static void setFoodCount(Context context, ArrayList<String> foodCount) {
        String[] myFoodCount = foodCount.toArray(new String[foodCount.size()]);

        PrefManager.getSharedPreferences(context).edit().putString(FOOD_COUNT, TextUtils.join("‚‗‚", myFoodCount)).apply();

        /*editor = PrefManager.getSharedPreferences(context).edit();
        gson = new Gson();
        String json = gson.toJson(foodCount);
        editor.putString(FOOD_COUNT, json);
        editor.apply();*/
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

    public static String getTotalAmount() {
        return TOTAL_AMOUNT;
    }

    public static void setTotalAmount(Context context, String totalAmount) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(TOTAL_AMOUNT, totalAmount);
        editor.apply();
    }

    public static String getCardHolderName(Context ctx) {
        return getSharedPreferences(ctx).getString(CARD_HOLDER_NAME, "");
    }

    public static void setCardHolderName(Context context, String cardHolderName) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(CARD_HOLDER_NAME, cardHolderName);
        editor.apply();
    }

    public static String getCardNumber(Context ctx) {
        return getSharedPreferences(ctx).getString(CARD_NUMBER, "");
    }

    public static void setCardNumber(Context context, String cardNumber) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(CARD_NUMBER, cardNumber);
        editor.apply();
    }

    public static String getCardExpiryDate(Context ctx) {
        return getSharedPreferences(ctx).getString(CARD_EXPIRY_DATE, "");
    }

    public static void setCardExpiryDate(Context context, String cardExpiryDate) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(CARD_EXPIRY_DATE, cardExpiryDate);
        editor.apply();
    }

    public static String getCardCvvNumber(Context ctx) {
        return getSharedPreferences(ctx).getString(CARD_CVV_NUMBER, "");
    }

    public static void setCardCvvNumber(Context context, String cardCvvNumber) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(CARD_CVV_NUMBER, cardCvvNumber);
        editor.apply();
    }

    public static String getServiceType(Context ctx) {
        return getSharedPreferences(ctx).getString(SERVICE_TYPE, "");
    }

    public static void setServiceType(Context context, String serviceType) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(SERVICE_TYPE, serviceType);
        editor.apply();
    }

    public static String getTiffinServiceType(Context ctx) {
        return getSharedPreferences(ctx).getString(TIFFIN_SERVICE_TYPE, "");
    }

    public static void setTiffinServiceType(Context context, String tiffinServiceType) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(TIFFIN_SERVICE_TYPE, tiffinServiceType);
        editor.apply();
    }

    public static String getScheduleService(Context ctx) {
        return getSharedPreferences(ctx).getString(SCHEDULE_SERVICE, "");
    }

    public static void setScheduleService(Context context, String scheduleService) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(SCHEDULE_SERVICE, scheduleService);
        editor.apply();
    }

    public static String getEventName(Context ctx) {
        return getSharedPreferences(ctx).getString(EVENT_NAME, "");
    }

    public static void setEventName(Context context, String eventName) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(EVENT_NAME, eventName);
        editor.apply();
    }

    public static String getNoOfPeople(Context ctx) {
        return getSharedPreferences(ctx).getString(NO_OF_PEOPLE, "");
    }

    public static void setNoOfPeople(Context context, String noOfPeople) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(NO_OF_PEOPLE, noOfPeople);
        editor.apply();
    }

    public static String getNoOfGuests(Context ctx) {
        return getSharedPreferences(ctx).getString(NO_OF_GUESTS, "");
    }

    public static void setNoOfGuests(Context context, String noOfGuests) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(NO_OF_GUESTS, noOfGuests);
        editor.apply();
    }

    public static String getOrderDate(Context ctx) {
        return getSharedPreferences(ctx).getString(ORDER_DATE, "");
    }

    public static void setOrderDate(Context context, String orderDate) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(ORDER_DATE, orderDate);
        editor.apply();
    }

    public static String getOrderTime(Context ctx) {
        return getSharedPreferences(ctx).getString(ORDER_TIME, "");
    }

    public static void setOrderTime(Context context, String orderTime) {
        editor = PrefManager.getSharedPreferences(context).edit();
        editor.putString(ORDER_TIME, orderTime);
        editor.apply();
    }
}
