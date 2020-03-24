package com.example.firesms;

import android.Manifest;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class PermissionsActivity extends AppCompatActivity {

    Button permissionsBtn;

    static final int REQUEST_CODE = 123;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        permissionsBtn = findViewById(R.id.permissionsBtn);

        permissionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(PermissionsActivity.this,
                        Manifest.permission.READ_CONTACTS) +
                        ContextCompat.checkSelfPermission(PermissionsActivity.this,
                                Manifest.permission.ACCESS_NOTIFICATION_POLICY) +
                        ContextCompat.checkSelfPermission(PermissionsActivity.this,
                                Manifest.permission.READ_EXTERNAL_STORAGE) +
                        ContextCompat.checkSelfPermission(PermissionsActivity.this,
                                Manifest.permission.READ_PHONE_NUMBERS) +
                        ContextCompat.checkSelfPermission(PermissionsActivity.this,
                                Manifest.permission.CALL_PHONE) +
                        ContextCompat.checkSelfPermission(PermissionsActivity.this,
                                Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS) !=
                        PackageManager.PERMISSION_GRANTED) {

                    //When permission not granted
                    if (ActivityCompat.shouldShowRequestPermissionRationale(PermissionsActivity.this,
                            Manifest.permission.READ_CONTACTS) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(PermissionsActivity.this,
                                    Manifest.permission.ACCESS_NOTIFICATION_POLICY) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(PermissionsActivity.this,
                                    Manifest.permission.READ_EXTERNAL_STORAGE) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(PermissionsActivity.this,
                                    Manifest.permission.READ_PHONE_NUMBERS) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(PermissionsActivity.this,
                                    Manifest.permission.CALL_PHONE) ||
                            ActivityCompat.shouldShowRequestPermissionRationale(PermissionsActivity.this,
                                    Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS)) {

                        //Create AlertDialog
                        AlertDialog.Builder builder = new AlertDialog.Builder(
                                PermissionsActivity.this
                        );
                        builder.setTitle("Odobrite vsa dovoljenja");
                        builder.setMessage("Vsa dovoljenja so potrebna za pravilno delovanje");
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int i) {
                                ActivityCompat.requestPermissions(
                                        PermissionsActivity.this,
                                        new String[]{
                                                Manifest.permission.READ_CONTACTS,
                                                Manifest.permission.ACCESS_NOTIFICATION_POLICY,
                                                Manifest.permission.READ_EXTERNAL_STORAGE,
                                                Manifest.permission.READ_PHONE_NUMBERS,
                                                Manifest.permission.CALL_PHONE,
                                                Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                                        },
                                        REQUEST_CODE
                                );
                            }
                        });
                        builder.setNegativeButton("Prekliči", null);
                        AlertDialog alertDialog = builder.create();
                        alertDialog.show();
                    } else {
                        ActivityCompat.requestPermissions(
                                PermissionsActivity.this,
                                new String[]{
                                        Manifest.permission.READ_CONTACTS,
                                        Manifest.permission.ACCESS_NOTIFICATION_POLICY,
                                        Manifest.permission.READ_EXTERNAL_STORAGE,
                                        Manifest.permission.READ_PHONE_NUMBERS,
                                        Manifest.permission.CALL_PHONE,
                                        Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS
                                },
                                REQUEST_CODE
                        );
                    }
                } else {
                    //When permissions are already granted
                    Toast.makeText(getApplicationContext(),
                            "Dovoljenje je že odobreno",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
