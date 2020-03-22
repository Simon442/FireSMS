package com.example.firesms;

import android.Manifest;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PermissionsActivity extends AppCompatActivity {

    private Object PermissionListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkPermissions (View view) {
        //Ask for permissions

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {

            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {
                Toast.makeText(PermissionsActivity.this, "FireSMS morda ne bo deloval pravilno", Toast.LENGTH_SHORT).show();
            }
        };
//TODO na switch ko ga vklopiš da bi se permissioni pokazali
        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setPermissions(Manifest.permission.READ_CONTACTS,
                        Manifest.permission.ACCESS_NOTIFICATION_POLICY,
                        Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
                        Manifest.permission.FOREGROUND_SERVICE,
                        Manifest.permission.MODIFY_AUDIO_SETTINGS,
                        Manifest.permission.READ_SMS)
                .check();
    }
}
