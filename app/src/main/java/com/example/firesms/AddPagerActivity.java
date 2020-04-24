package com.example.firesms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AddPagerActivity extends AppCompatActivity {

    private EditText name,phone,keyword;
    private Button savebtn,Clearbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pager);

        // Our Database handler
        final SQLiteHelper dbhelper = new SQLiteHelper(getApplicationContext());

        ImageButton addPagerBtn = findViewById(R.id.addPagerBtn);
        final View mView = getLayoutInflater().inflate(R.layout.activity_add_new_pager_dialog, null);

        ArrayList<HashMap<String, String>> DB = dbhelper.getUsers();
        //ListViews
        ListView lv;
        lv = (ListView)mView.findViewById(R.id.pagerList);
        ListAdapter adapter = new SimpleAdapter
                (this, DB, R.layout.activity_add_pager,new String[]{"name","telephone","keyword"}, new int[]{R.id.textPagerName, R.id.textPhoneNumber, R.id.keywordText});
        if( !adapter.isEmpty() ){

        } else{
            lv.setAdapter(adapter);
        }

        addPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddPagerActivity.this);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();


                // The vars that will be used
                name = (EditText)mView.findViewById(R.id.textPagerName);
                phone = (EditText)mView.findViewById(R.id.textPhoneNumber);
                keyword = (EditText)mView.findViewById(R.id.keywordText);
                // Buttons
                savebtn = (Button)mView.findViewById(R.id.addNewPagerBtn);
                Clearbtn = (Button)mView.findViewById(R.id.cancelAddPager);

                // when clicked will save to database
                savebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Make sure that the text fields are not empty!
                        if ( !name.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() && !keyword.getText().toString().isEmpty()) {
                           // add to database
                            long val = dbhelper.Insert(
                                    name.getText().toString(), phone.getText().toString(),keyword.getText().toString()
                            );
                            // In case it fails show msg to user
                            if (val == -1){
                                Toast.makeText(getBaseContext(), "FAILED TO ADD TO DATABASE!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getBaseContext(), R.string.success_added_pager_msg, Toast.LENGTH_SHORT).show();
                            }

                            // TODO: Make it hide after entering
                            //dialog.hide();
                        } else {
                            Toast.makeText(getBaseContext(), R.string.failed_add_pager_msg, Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                // Clear the text areas when clicked
                Clearbtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        name.setText("");
                        phone.setText("");
                        keyword.setText("");
                    }
                });

                dialog.show();
            }
        });
    }
}
