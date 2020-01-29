package com.example.firesms;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class ReadSMSActivity extends AppCompatActivity {

    private static ArrayAdapter<String> adapter;
    ListView ViewSmsList;
    private static final int PERMISSION_REQUEST_READ_CONTACTS = 100;
    ArrayList<String> ViewSmsList;

    public static void setAdapter(ArrayAdapter<String> adapter) {
        ReadSMSActivity.adapter = adapter;
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewSmsList = (ListView) findViewById(R.id.smsList);

        int permissionCheck = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_SMS);

        if (permissionCheck = PackageManager.PERMISSION_GRANTED) {
            showContacts();

        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_SMS},
                    PERMISSION_REQUEST_READ_CONTACTS);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode = PERMISSION_REQUEST_READ_CONTACTS) {
            showContacts();
        } else {
            Toast.makeText(this, Toast.LENGTH_SHORT).show();
        }
    }


    private void showContacts() {
        Uri inboxUri = Uri.parse("content:://sms/inbox");
        ViewSmsList = new ArrayList<>();
        ContentResolver contentResolver =  getContentResolver();

        //TODO tukaj se zatakne
        Cursor cursor = contentResolver.query(inboxUri, null, null, null, null);
        while (cursor.moveToNext()) {
            String number = cursor.getString(cursor.getColumnIndexOrThrow("address")).toString();
            String body = cursor.getString(cursor.getColumnIndexOrThrow("body")).toString();
            ViewSmsList ("Number "+number "\n" + "Body +"+body);
        }
        cursor.close();
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,
                ViewSmsList);

        ReadSMSActivity.setAdapter(adapter);

    }
}
