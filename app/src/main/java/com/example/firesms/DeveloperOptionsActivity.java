package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tapadoo.alerter.Alerter;

public class DeveloperOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);

        Button testAlerterBtn = findViewById(R.id.testAlerterBtn);
        testAlerterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    //TODO Bodi srček smrček pa poglej zakaj se alerter ne prikaže ko kliknem na gumbek "https://github.com/Tapadoo/Alerter



    public void testAlerterBtn(View view) {

        Alerter.create(this)
                .setTitle("FireSMS")
                .setText("//SMS Sproočilo//")
                .setIcon(R.drawable.ic_launcher_foreground)
                .setDuration(10000)
                .enableSwipeToDismiss()
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(DeveloperOptionsActivity.this, "", Toast.LENGTH_SHORT).show();
                    }
                })
                .show();

    }
}
