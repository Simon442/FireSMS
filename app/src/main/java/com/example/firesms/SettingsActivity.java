package com.example.firesms;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class SettingsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private TextView seekBarVolumeNumber;
    private SeekBar seekBarVolumeSlider;
    private CheckBox checkBoxSilentMode;
    private CheckBox checkBoxVibration;
    private CheckBox checkBoxShowAlertDialog;
    private Spinner spinnerAddSound;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);


        List<String> categories = new ArrayList<>();

        Spinner spinnerAddSound = findViewById(R.id.spinnerAddSound);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.select_sound, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAddSound.setAdapter(adapter);
        spinnerAddSound.setOnItemSelectedListener(this);

        seekBarVolumeNumber = (TextView) findViewById(R.id.seekBarVolumeNumber);
        seekBarVolumeSlider = (SeekBar) findViewById(R.id.seekBarVolumeSlider);

        seekBarVolumeSlider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarVolumeNumber.setText("" + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//TODO Testira pozivnik v 5 sekundah
        Button testPagerBtn = findViewById(R.id.testPagerBtn);
        testPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "Test se bo pričel izvajati v 5 sekundah", Toast.LENGTH_SHORT).show();

            }
        });

        //TODO Shrani nastavitve

        Button saveSettingBtn = findViewById(R.id.saveSettingsBtn);
        saveSettingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingsActivity.this, "Uspešno shranjeno. PRIPOROČENO TESTIRANJE", Toast.LENGTH_SHORT).show();

            }
        });
    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


