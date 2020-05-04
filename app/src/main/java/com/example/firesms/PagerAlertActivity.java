package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.ebanx.swipebtn.SwipeButton;

public class PagerAlertActivity extends AppCompatActivity {

    //TODO Swipe silences, then converts into button and on press it closes

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_alert);
    }

    public void Close_dialog_normal(View view) {

        finish();
    }
}

