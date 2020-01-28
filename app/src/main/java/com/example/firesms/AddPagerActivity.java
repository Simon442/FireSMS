package com.example.firesms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPagerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pager);

        Button addPagerBtn = findViewById(R.id.addPagerBtn);
        addPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder mBuilder = new AlertDialog.Builder(AddPagerActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.activity_add_new_pager_dialog,null);
                final EditText mPagerName = mView.findViewById(R.id.textPagerName);
                final EditText mPhoneNumber = mView.findViewById(R.id.textPhoneNumber);
                final EditText mKeyword = mView.findViewById(R.id.textKeyword);
                EditText mTitle = mView.findViewById(R.id.textFireSMS);
                EditText mInfo = mView.findViewById(R.id.textIntervencijeText);
                Button mAddPager = mView.findViewById(R.id.addPagerBtn);
                Button mCancelAddPager = mView.findViewById(R.id.cancelAddPager);

                mAddPager.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!mPagerName.getText().toString().isEmpty() & mKeyword.getText().toString().isEmpty() & mPhoneNumber.getText().toString().isEmpty()){
                            Toast.makeText(AddPagerActivity.this, R.string.success_added_pager_msg, Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(AddPagerActivity.this, R.string.failed_add_pager_msg, Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                mBuilder.setView(mView);
                AlertDialog dialog = mBuilder.create();
                dialog.show();


            }
        });


    }
}
