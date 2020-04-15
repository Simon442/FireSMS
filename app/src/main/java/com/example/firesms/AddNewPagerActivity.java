package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;


public class AddNewPagerActivity extends AppCompatActivity {
    Context context = getApplicationContext();
    SQLiteHelper dbHelper = new SQLiteHelper(context);
    EditText name,Telephone,keyword;
    name = (EditText)findviewById(R.id.textPagerName);

}
