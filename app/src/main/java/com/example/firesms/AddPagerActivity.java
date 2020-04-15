package com.example.firesms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddPagerActivity extends AppCompatActivity {

    EditText name,phone,keyword;
    Button savebtn,Clearbtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pager);
        ImageButton addPagerBtn = findViewById(R.id.addPagerBtn);


        addPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddPagerActivity.this);
                final View mView = getLayoutInflater().inflate(R.layout.activity_add_new_pager_dialog, null);
                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();

                        // TODO: Tole da bo delal
                        // TODO: Poglej ce je boljsi nacin kot isEmpty() ker sem na hitro probal pa ni delal

                        // TODO: Pager manager u svoj java file in nardis nov class z metodami za shranjevanje pa to
                        // TODO: potem pa lahko mas neskoncno pagerjev ce jih sharins v svojo datoteko kot xml
                        // TODO: To lahko tud jaz nardim ce hoces

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
                        // Our Database handler
                        SQLiteHelper helper = new SQLiteHelper(getApplicationContext());
                        // Make sure that the text fields are not empty!
                        if ( !name.getText().toString().isEmpty() && !phone.getText().toString().isEmpty() && !keyword.getText().toString().isEmpty()) {
                           // add to database
                            long val = helper.Insert(
                                    name.getText().toString(), phone.getText().toString(),keyword.getText().toString()
                            );
                            // In case it fails show msg to user
                            if (val == -1){
                                Toast.makeText(getBaseContext(), "FAILED TO ADD TO DATABASE!", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(getBaseContext(), R.string.success_added_pager_msg, Toast.LENGTH_SHORT).show();
                            }
                            dialog.hide();
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
                // TODO: Cancel on click mislm da se da z finish() samo nisem ziher;


                dialog.show();
            }
        });
    }
}
