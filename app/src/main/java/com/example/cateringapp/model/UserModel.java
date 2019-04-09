package com.example.cateringapp.model;

public class UserModel {
/*
    public static final String TABLE_NAME = "customer_login";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_MOBILE = "mobile";
*/

    private int id;
    private String name, password, mobile;

/*
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " ("
            + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT, "
            + COLUMN_PASSWORD + " TEXT, "
            + COLUMN_MOBILE + " TEXT"
            + ")";
*/

    public UserModel() {
    }

    public UserModel(int id, String name, String password, String mobile) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
