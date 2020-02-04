package com.example.firesms;

        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;

        import com.tapadoo.alerter.Alerter;

public class DeveloperOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer_options);

        Button testAlerterBtn = (Button) findViewById(R.id.testAlerterBtn);
        testAlerterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Alerter.create(DeveloperOptionsActivity.this)
                        .setTitle("FireSMS")
                        .setText("//SMS Sporočilo")
                        .setIcon(R.drawable.bellalerter)
                        .setDuration(10000)
                        .enableSwipeToDismiss()
                        .show();
            }
        });


    }

}
