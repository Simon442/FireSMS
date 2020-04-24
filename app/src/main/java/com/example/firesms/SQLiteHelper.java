package com.example.firesms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
        // If you change the database stuff, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "FIRESMS.db";

        public SQLiteHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onDowngrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

        public void onCreate(android.database.sqlite.SQLiteDatabase db) {
            db.execSQL(
                    "CREATE TABLE " + dbSchema.TABLE_NAME + "(" +
                    dbSchema.COLUMN1_TITLE +" VARCHAR(25) NOT NULL," +
                    dbSchema.COLUMN2_TITLE +" VARCHAR(25) PRIMARY KEY," +
                    dbSchema.COLUMN3_TITLE +" VARCHAR(15) NOT NULL" +
                    ");"
            );
        }

        public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
            onCreate(db);
        }

        // Insert into the database
        public long Insert(String NAME,String PHONE, String KEYWORD){
            // Open the database for writing
            SQLiteDatabase db = this.getWritableDatabase();
            // Prep to write!
            ContentValues values = new ContentValues();
            values.put(dbSchema.COLUMN1_TITLE,NAME);
            values.put(dbSchema.COLUMN2_TITLE,PHONE);
            values.put(dbSchema.COLUMN3_TITLE,KEYWORD);
            // Insert, NOTE THIS WILL RETURN -1 if failed, you can replace null with something you want it to do
            long RETURN =  db.insert(dbSchema.TABLE_NAME, null, values);
            // we must close the connection first
            db.close();
            return RETURN;
        }

        public ArrayList<HashMap<String,String>> getUsers(){
            SQLiteDatabase db = this.getReadableDatabase();
            ArrayList<HashMap<String, String>> DB = new ArrayList<>();
            String Select = "SELECT " + dbSchema.COLUMN1_TITLE + ", " + dbSchema.COLUMN2_TITLE + ", " + dbSchema.COLUMN3_TITLE + " FROM " + dbSchema.TABLE_NAME;
            Cursor cursor = db.rawQuery(Select, null);
            try {
                while( cursor.moveToNext()) {
                    HashMap<String,String> hash = new HashMap<>();
                    hash.put("Name:", cursor.getString(cursor.getColumnIndex(dbSchema.COLUMN1_TITLE)));
                    hash.put("Telephone:", cursor.getString(cursor.getColumnIndex(dbSchema.COLUMN2_TITLE)));
                    hash.put("Keyword:" ,cursor.getString(cursor.getColumnIndex(dbSchema.COLUMN3_TITLE)));
                    DB.add(hash);
                }
            } finally {
                db.close();
            }


            return DB;
        }

         // Delete User Details
         public void DeletePager(String phone){
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(dbSchema.TABLE_NAME,  dbSchema.COLUMN2_TITLE+" = ?",new String[]{phone});
            db.close();
        }

        public static class dbSchema implements BaseColumns {
            // This is Done so its easy to change anything in the database
            public static final String TABLE_NAME = "SMS";
            public static final String COLUMN1_TITLE = "NAME";
            public static final String COLUMN2_TITLE = "PHONE_NUMBER";
            public static final String COLUMN3_TITLE = "KEYWORD";
        }
}
