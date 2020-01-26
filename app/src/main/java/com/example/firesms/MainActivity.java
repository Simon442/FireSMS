package com.example.firesms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button gumbDodajPozivnik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gumbDodajPozivnik = (Button) (R.id.gumbDodajPozivnik);
        gumbDodajPozivnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDodajPozivnike();

            }
        });
    }
    public void openDodajPozivnike(){
        Intent intent = new Intent(this, DodajPozivnike.class);
        startActivity(intent);
    }
}
