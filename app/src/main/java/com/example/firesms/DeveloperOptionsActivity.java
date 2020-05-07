package com.example.firesms;

        import androidx.appcompat.app.AlertDialog;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.constraintlayout.widget.ConstraintLayout;

        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.provider.Settings;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.widget.Button;
        import android.widget.ImageView;

        import com.tapadoo.alerter.Alerter;

public class DeveloperOptionsActivity extends AppCompatActivity {
    private Button testAlertPagerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);

        //TODO Nardit gumbke https://github.com/Tapadoo/Alerter
        //TODO Implementirat v aplikacijo da se prikaže samo takrat ko je nastavitev vklopljena


        Button testAlerterBtn = (Button) findViewById(R.id.testAlerterBtn);
        testAlerterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerter.create(DeveloperOptionsActivity.this)
                        .setTitle("Ime Pozivnika")
                        .setText("SMS Sporočilo")
                        .setIcon(R.drawable.bellalerter)
                        .setDuration(999999999)
                        .setBackgroundColorRes(R.color.colorPrimary)
                        .enableSwipeToDismiss()
                        .show();
            }
        });

        Button testAlertPagerBtn = (Button) findViewById(R.id.testAlertPagerBtn);
        testAlertPagerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(PagerIntervencijeNetActivity.class);
            }
        });

        Button contactsList = (Button) findViewById(R.id.contactsList);
        contactsList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(SmsActivity.class);
            }
        });

        Button testAlertPagerBtn2 = (Button) findViewById(R.id.testAlertPagerBtn2);
        testAlertPagerBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(PagerAlertActivity.class);
            }
        });

        Button testAlertPagerBtn3 = (Button) findViewById(R.id.testAlertPagerBtn3);
        testAlertPagerBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity(PagerIntervencijeNetFullscreenActivity.class);
            }
        });

    }

    public void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        startActivity(intent);
    }
}