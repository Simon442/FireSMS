package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        pref = this.getSharedPreferences("settings", MODE_PRIVATE);
        editor = pref.edit();

        onFirstStartup();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addPagerBtn = findViewById(R.id.addPagerBtn);
        addPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(AddPagerActivity.class);
            }
        });

        Button settingsBtn = findViewById(R.id.settingBtn);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SettingsActivity.class);
            }
        });

        Switch onoffSwitch = findViewById(R.id.onoffSwitch);
        onoffSwitch.setChecked(pref.getBoolean("onoff", false));
        onoffSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                setPager(isChecked);

        //TODO Dodaj da se na SwtichOn vklopi in SwitchOff izklopi xoxo
            }
        });
    }

    public void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }

    private void setPager(boolean onoff){
        editor.putBoolean("onoff", onoff);
        editor.apply();
    }

    private void onFirstStartup(){
        onFirstStartup(false);
    }

    private void onFirstStartup(boolean forceStartup){
        if(forceStartup || pref.getBoolean("firstStartup", true)){
            editor.putBoolean("firstStartup", false);
            editor.apply();

            openActivity(SplashScreenActivity.class);
        }

    }

}
