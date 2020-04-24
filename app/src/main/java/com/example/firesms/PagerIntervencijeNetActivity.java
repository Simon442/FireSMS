package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

public class PagerIntervencijeNetActivity extends AppCompatActivity {

    //TODO Vibration on button press
    Button notComingBtn;
    Vibrator vibrator;

    //TODO Volume up key silences/stops vibrating



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_intervencije_net);

}


    public void Not_coming_call(View view) {

        String number = "111111";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;

        }

        startActivity(intent);
        finish();


    }

    public void Coming_call(View view) {
        String number = "222222";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;

        }


        startActivity(intent);
        finish();

    }

    public void Coming_later_call(View view) {
        String number = "333333";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

            return;

        }

        startActivity(intent);
        finish();

    }

    public void Close_dialog(View view) {

        finish();
    }
}



