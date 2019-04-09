package com.example.cateringapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

import com.example.cateringapp.model.Reports;
import com.example.cateringapp.model.User;

import java.util.ArrayList;
import java.util.List;

import static com.example.cateringapp.model.Reports.KEY_DATE;
import static com.example.cateringapp.model.Reports.KEY_ID;
import static com.example.cateringapp.model.Reports.KEY_NAME;
import static com.example.cateringapp.model.Reports.KEY_PH_NO;
import static com.example.cateringapp.model.Reports.TABLE_REPORTS;

public class DatabaseHelper extends SQLiteOpenHelper {

    /*
     * Database Details
     *
     * @DATABASE VERSION
     * @DATABASE NAME
     * @DATABASE TABLE NAME
     * */
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Users.db";
    private static final String TABLE_OF_USERS = "users";

    /*
     * Table column details
     *
     * @TABLE COLUMN NAMES
     * */
    private static final String USER_ID = "user_id";
    private static final String USER_NAME = "user_name";
    private static final String USER_EMAIL = "user_email";
    private static final String USER_PASSWORD = "user_password";

    //Query for creating table
    private String CREATE_TABLE = "CREATE TABLE " + TABLE_OF_USERS + "(" + USER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + USER_NAME + " TEXT," + USER_EMAIL + " TEXT," + USER_PASSWORD + " TEXT" + ")";

    //Query for deleting a table
    private String DELETE_TABLE = "DROP TABLE IF EXISTS ";

    //Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    //Default method of SQLiteOpenHelper to create a database
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.close();
        db.execSQL(Reports.TABLE_REPORTS);
        db.close();
    }

    //Default method of SQLiteOpenHelper to update a database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Delete the table if exists
        db.execSQL(DELETE_TABLE + TABLE_OF_USERS);
        db.execSQL(DELETE_TABLE + Reports.TABLE_REPORTS);

        //Create table
        onCreate(db);
    }

    //Create users record
    public void addUsers(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getName());
        values.put(USER_EMAIL, user.getEmail());
        values.put(USER_PASSWORD, user.getPassword());

        // Inserting Row
        db.insert(TABLE_OF_USERS, null, values);
        db.close();
    }

    public List<User> getAllUsers() {
// array of columns to fetch
        String[] columns = {
                USER_ID,
                USER_EMAIL,
                USER_NAME,
                USER_PASSWORD
        };
        // sorting orders
        String sortOrder =
                USER_NAME + " ASC";
        List<User> userList = new ArrayList<User>();

        SQLiteDatabase db = this.getReadableDatabase();

        // query the user table
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id,user_name,user_email,user_password FROM user ORDER BY user_name;
         */
        Cursor cursor = db.query(TABLE_OF_USERS, //Table to query
                columns,    //columns to return
                null,        //columns for the WHERE clause
                null,        //The values for the WHERE clause
                null,       //group the rows
                null,       //filter by row groups
                sortOrder); //The sort order


        // Traversing through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                User user = new User();
                user.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(USER_ID))));
                user.setName(cursor.getString(cursor.getColumnIndex(USER_NAME)));
                user.setEmail(cursor.getString(cursor.getColumnIndex(USER_EMAIL)));
                user.setPassword(cursor.getString(cursor.getColumnIndex(USER_PASSWORD)));
                // Adding user record to list
                userList.add(user);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        // return user list
        return userList;
    }

    public void updateUsers(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(USER_NAME, user.getName());
        values.put(USER_EMAIL, user.getEmail());
        values.put(USER_PASSWORD, user.getPassword());

        // updating row
        db.update(TABLE_OF_USERS, values, USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public void deleteUsers(User user) {
        SQLiteDatabase db = this.getWritableDatabase();
        // delete user record by id
        db.delete(TABLE_OF_USERS, USER_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    public boolean checkForUsers(String email) {
// array of columns to fetch
        String[] columns = {
                USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();

        // selection criteria
        String selection = USER_EMAIL + " = ?";

        // selection argument
        String[] selectionArgs = {email};

        // query user table with condition
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com';
         */
        Cursor cursor = db.query(TABLE_OF_USERS, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                      //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        if (cursorCount > 0) {
            return true;
        }
        return false;
    }

    public boolean checkForUsers(String email, String password) {
        // array of columns to fetch
        String[] columns = {
                USER_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = USER_EMAIL + " = ?" + " AND " + USER_PASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {email, password};
        // query user table with conditions

        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_OF_USERS, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order

        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();

        return cursorCount > 0;
    }

    /**
     * Reports functions
     * All CRUD(Create, Read, Update, Delete) Operations
     */

    // Adding new contact
    public void addReport(Reports reports) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Reports.KEY_NAME, reports.get_name()); // Contact Name
        values.put(Reports.KEY_PH_NO, reports.get_phone_number()); // Contact Phone
        values.put(Reports.KEY_DATE, reports.get_date()); // Date

        // Inserting Row
        db.insert(Reports.TABLE_REPORTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact

    // TODO:Not being used

    public Reports getReport(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Reports.TABLE_REPORTS, new String[]{Reports.KEY_ID,
                        Reports.KEY_NAME, Reports.KEY_PH_NO, KEY_DATE}, Reports.KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        // return contact
        Reports reports = new Reports(
                Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3)
        );
        cursor.close();

        return reports;
    }

    // Get Contacts list by date

    public List<Reports> getReportByDate(String mDate) {
        List<Reports> contactList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_REPORTS + " WHERE " + KEY_DATE + " BETWEEN ? AND ?" + "'%" + mDate + "'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Reports contact = new Reports();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_name(cursor.getString(1));
                contact.set_phone_number(cursor.getString(2));
                contact.set_date(cursor.getString(3));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        cursor.close();

        // return contact list
        return contactList;
    }

    // Getting All Contacts
    // TODO:Not being used
    public List<Reports> getAllReports() {
        List<Reports> contactList = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_REPORTS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Reports contact = new Reports();
                contact.set_id(Integer.parseInt(cursor.getString(0)));
                contact.set_name(cursor.getString(1));
                contact.set_phone_number(cursor.getString(2));
                contact.set_date(cursor.getString(3));

                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        cursor.close();

        // return contact list
        return contactList;
    }

    // Updating single contact
    // TODO:Not being used
    public int updateReport(Reports reports) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, reports.get_name());
        values.put(KEY_PH_NO, reports.get_phone_number());
        values.put(KEY_DATE, reports.get_date());

        // updating row
        return db.update(TABLE_REPORTS, values, KEY_ID + " = ?",
                new String[]{String.valueOf(reports.get_id())});
    }

    // Deleting single contact
    public void deleteReport(Reports reports) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_REPORTS, KEY_ID + " = ?",
                new String[]{String.valueOf(reports.get_id())});
        db.close();
    }
}
