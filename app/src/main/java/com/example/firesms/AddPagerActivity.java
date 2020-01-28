package com.example.firesms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AddPagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pager);

        ImageButton addPagerBtn = findViewById(R.id.addPagerBtn);
        addPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddPagerActivity.this);
                final View mView = getLayoutInflater().inflate(R.layout.activity_add_new_pager_dialog,null);

                Button mAddPager = mView.findViewById(R.id.addNewPagerBtn);

                mAddPager.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // TODO: Tole da bo delal
                        // TODO: Poglej ce je boljsi nacin kot isEmpty() ker sem na hitro probal pa ni delal
                        EditText mPagerName = mView.findViewById(R.id.textPagerName);
                        EditText mPhoneNumber = mView.findViewById(R.id.textPhoneNumber);
                        EditText mKeyword = mView.findViewById(R.id.textKeyword);
                        if (!mPagerName.getText().toString().isEmpty() & mKeyword.getText().toString().isEmpty() & mPhoneNumber.getText().toString().isEmpty()){
                            Toast.makeText(getBaseContext(), R.string.success_added_pager_msg, Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(getBaseContext(), R.string.failed_add_pager_msg, Toast.LENGTH_SHORT).show();
                        }

                        // TODO: Pager manager u svoj java file in nardis nov class z metodami za shranjevanje pa to
                        // TODO: potem pa lahko mas neskoncno pagerjev ce jih sharins v svojo datoteko kot xml
                        // TODO: To lahko tud jaz nardim ce hoces
                    }
                });

                // TODO: Cancel on click mislm da se da z finish() samo nisem ziher;

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();


            }
        });


    }
}
