package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class SettingsActivity extends AppCompatActivity implements AddPagerSoundFragment.SingleChoiceListener {

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private TextView textViewPagerSound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        CheckBox checkBoxSound = findViewById(R.id.checkBoxSound);
        checkBoxSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment singleChoiceDialog = new AddPagerSoundFragment();
                singleChoiceDialog.setCancelable((false));
                singleChoiceDialog.show(getSupportFragmentManager(),"Single Choice Dialog");
            }
        });
    }

    @Override
    public void onPositiveButtonClicked(String[] list, int position) {

        textViewPagerSound.setText("Selected item ="+list[position] );

    }

    @Override
    public void onNegativeButtonClicked() {

        textViewPagerSound.setText("Dialog cancel");

    }
}
