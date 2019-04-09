package com.example.cateringapp.model;

public class Reports {

    // Contacts table name
    public static final String TABLE_REPORTS = "contacts";

    // Contacts Table Columns names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_PH_NO = "phone_number";
    public static final String KEY_DATE = "date";

    String CREATE_REPORTS_TABLE = "CREATE TABLE " + TABLE_REPORTS
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + KEY_NAME + " TEXT,"
            + KEY_PH_NO + " TEXT,"
            + KEY_DATE + " TEXT" + ")";

    //private variables
    private int _id;
    private String _name;
    private String _phone_number;
    private String _date;

    public Reports() {
    }

    public Reports(int _id, String _name, String _phone_number, String _date) {
        this._id = _id;
        this._name = _name;
        this._phone_number = _phone_number;
        this._date = _date;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public String get_phone_number() {
        return _phone_number;
    }

    public void set_phone_number(String _phone_number) {
        this._phone_number = _phone_number;
    }

    public String get_date() {
        return _date;
    }

    public void set_date(String _date) {
        this._date = _date;
    }
}
