package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ebanx.swipebtn.SwipeButton;

public class PagerAlertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_alert);
    }

    public void Close_normal_dialog(View view) {

        finish();
    }
}

