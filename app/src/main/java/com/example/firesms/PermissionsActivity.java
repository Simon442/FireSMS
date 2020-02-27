package com.example.firesms;

import android.Manifest;
import android.os.Bundle;

import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PermissionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkPermission() {

        Dexter.withActivity(this)
                .withPermission(
                        Manifest.permission.READ_CONTACTS,
                        Manifest.permission.ACCESS_NOTIFICATION_POLICY,
                        Manifest.permission.READ_SMS,
                        Manifest.permission.WAKE_LOCK,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.MODIFY_AUDIO_SETTINGS,
                        Manifest.permission.FOREGROUND_SERVICE,
                        Manifest.permission.READ_PHONE_NUMBERS,
                        Manifest.permission.CALL_PHONE,
                        Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
                ).withListener(new MultiplePermissionsListener() {
                                   @Override
                                   public void onPermissionsChecked(MultiplePermissionsReport report) {/* ... */}

            @Override
            public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {/* ... */} {

}

        });
                               }
    }
