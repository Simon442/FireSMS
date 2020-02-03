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
    }

    public void testAlerterBtn(View view) {

        Alerter.create(this)
                .setTitle("//Ime Pozivnika//")
                .setText("//SMS Sporočilo")
                .setIcon(R.mipmap.ic_launcher_foreground)
                .setDuration(10000)
                .show();
    }

}
