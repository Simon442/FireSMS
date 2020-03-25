package com.example.firesms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

public class PermissionsActivity extends AppCompatActivity {

    private static final String TAG = "PermissionsActivity";

    private static final int REQUEST_CODE = 1;

    private static String[] CALL_PERMISSIONS = {
            Manifest.permission.READ_CONTACTS,
            Manifest.permission.ACCESS_NOTIFICATION_POLICY,
            Manifest.permission.READ_SMS,
            Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
            Manifest.permission.READ_PHONE_NUMBERS,
            Manifest.permission.CALL_PHONE};

    private static String[] STORAGE_PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        verifyPermissions();


    }

    private void verifyPermissions() {
        Log.d(TAG, "verifyPermissions: Checking Permissions");

        int permissionReadContacts = ActivityCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.READ_CONTACTS);
        int permissionAccessNotificationPolicy = ActivityCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.ACCESS_NOTIFICATION_POLICY);
        int permissionReadSms = ActivityCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.READ_SMS);
        int permissionReadExternalStorage = ActivityCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE);
        int permissionRequestIgnoreBatteryOptimizations = ActivityCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS);
        int permissionReadPhoneNumbers = ActivityCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.READ_PHONE_NUMBERS);
        int permissionCallPhone = ActivityCompat.checkSelfPermission(PermissionsActivity.this, Manifest.permission.CALL_PHONE);

        if (permissionReadContacts != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PermissionsActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
        }
        if (permissionAccessNotificationPolicy != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PermissionsActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
        }
        if (permissionReadContacts != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PermissionsActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
        }
        if (permissionReadSms != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PermissionsActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
        }
        if (permissionRequestIgnoreBatteryOptimizations != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PermissionsActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
        }
        if (permissionReadPhoneNumbers != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PermissionsActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
        }
        if (permissionCallPhone != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PermissionsActivity.this,
                    CALL_PERMISSIONS,
                    1
            );
        }
        if (permissionReadExternalStorage != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    PermissionsActivity.this,
                    STORAGE_PERMISSIONS,
                    1
            );
        }
    }
}