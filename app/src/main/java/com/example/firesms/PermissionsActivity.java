package com.example.firesms;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE != PackageManager.PERMISSION_GRANTED)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 10);


                if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_CONTACTS != PackageManager.PERMISSION_GRANTED)) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS}, 10);

                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS != PackageManager.PERMISSION_GRANTED)) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS}, 10);

                        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE != PackageManager.PERMISSION_GRANTED)) {
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 10);
                        }
                    }
                }