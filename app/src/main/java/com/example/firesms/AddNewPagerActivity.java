package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class AddNewPagerActivity extends AppCompatActivity {
    Context context = getApplicationContext();
    SQLiteHelper dbHelper = new SQLiteHelper(context);
    EditText name,phone,keyword;
    Button savebtn;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_pager_dialog);
        name = (EditText)findViewById(R.id.textPagerName);
        phone = (EditText)findViewById(R.id.textPhoneNumber);
        keyword = (EditText)findViewById(R.id.keywordText);
        savebtn = (Button)findViewById(R.id.addNewPagerBtn);

        savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteHelper helper = new SQLiteHelper(getApplicationContext());
                long val = helper.Insert(
                        name.getText().toString(), phone.getText().toString(),keyword.getText().toString()
                );
                // In case it fails show msg to user
                if (val == -1){
                    Toast.makeText(getBaseContext(), "FAILED TO ADD!", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getBaseContext(), R.string.success_added_pager_msg, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
