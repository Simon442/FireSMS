package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.TedPermission;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    ListView emergencyList;
    private static final int PERMISSIONS_REQUEST_READ_CONTACTS = 100;
    ArrayList<String> smsList;
    private static final String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = this.getSharedPreferences("settings", MODE_PRIVATE);
        editor = pref.edit();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addPagerBtn = findViewById(R.id.addPagerBtn);
        addPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(AddPagerActivity.class);
            }
        });

        Button settingsBtn = findViewById(R.id.settingsBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SettingsActivity.class);
            }
        });


        Button devOptionsBtn = findViewById(R.id.devOptionsBtn);
        devOptionsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(DeveloperOptionsActivity.class);
            }
        });


        Switch onoffSwitch = findViewById(R.id.onoffSwitch);
        onoffSwitch.setChecked(pref.getBoolean("onoff", false));
        onoffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPager(isChecked);
                setService(isChecked);
            }
        });

        setService(pref.getBoolean("onoff", false));


    }

    public void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void setPager(boolean onoff){
        editor.putBoolean("onoff", onoff);
        editor.apply();
    }

    private void setService(boolean onoff){
        Intent smsService = new Intent(this, ForegroundService.class);
        if(onoff){
            ContextCompat.startForegroundService(this, smsService);
        }
        else{
            stopService(smsService);
        }
    }

    private void onFirstStartup(){
        onFirstStartup(true);
    }

    private void onFirstStartup(boolean forceStartup){
        if(forceStartup || pref.getBoolean("firstStartup", true)){
            editor.putBoolean("firstStartup", false);
            editor.apply();

            openActivity(SplashScreenActivity.class);
        }

    }

    public void checkPermissions(View view) {

        PermissionListener permissionListener = new PermissionListener() {
            @Override
            public void onPermissionGranted() {
                //TODO Only open Setting until its not accepted
                Toast.makeText(MainActivity.this, "Pritisni na FireSMS in dovoli Dostop do Načina ne Moti", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_NOTIFICATION_POLICY_ACCESS_SETTINGS);

                startActivity(intent);

            }

            @Override
            public void onPermissionDenied(List<String> deniedPermissions) {

            }
        };

        TedPermission.with(this)
                .setPermissionListener(permissionListener)
                .setDeniedMessage("FireSMS morda ne bo deloval pravilno\n\nPritisni še enkrat na Vklopi ali pojdi v nastavitve")
                .setPermissions(Manifest.permission.READ_CONTACTS,
                        Manifest.permission.ACCESS_NOTIFICATION_POLICY,
                        Manifest.permission.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS,
                        Manifest.permission.READ_SMS,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_NUMBERS,
                        Manifest.permission.CALL_PHONE)
                .check();

    }
}
