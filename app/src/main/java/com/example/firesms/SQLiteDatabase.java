package com.example.firesms;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteDatabase extends SQLiteOpenHelper {
        // If you change the database stuff, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "FIRESMS.db";


        SQLiteDatabase(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onDowngrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    public void onCreate(android.database.sqlite.SQLiteDatabase db) {
        db.execSQL( "CREATE TABLE " + DATABASE_NAME + "(" +
                "NAME VARCHAR(25) PRIMARY KEY," +
                "PHONE_NUMBER VARCHAR(25) NOT NULL," +
                "KEYWORD VARCHAR(15) NOT NULL);");
    }

    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(db);
    }
}
