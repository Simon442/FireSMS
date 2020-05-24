package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;

public class PagerIntervencijeNetFullscreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager_intervencije_net_fullscreen);

    }


    public void Not_coming_call(View view) {

        String number = "111111";
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        Vibrator v = (Vibrator) getApplicationContext().getSystemService(getApplicationContext().VIBRATOR_SERVICE);
        v.vibrate(100);
        ((new Handler())).postDelayed(new Runnable(){
            public void run(){

                Log.i("I","TEST I AM IN RUN");
            }
        }, 100);
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
        Vibrator v = (Vibrator) getApplicationContext().getSystemService(getApplicationContext().VIBRATOR_SERVICE);
        v.vibrate(100);
        ((new Handler())).postDelayed(new Runnable(){
            public void run(){

                Log.i("I","TEST I AM IN RUN");
            }
        }, 100);
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
        Vibrator v = (Vibrator) getApplicationContext().getSystemService(getApplicationContext().VIBRATOR_SERVICE);
        v.vibrate(100);
        ((new Handler())).postDelayed(new Runnable(){
            public void run(){

                Log.i("I","TEST I AM IN RUN");
            }
        }, 100);
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
