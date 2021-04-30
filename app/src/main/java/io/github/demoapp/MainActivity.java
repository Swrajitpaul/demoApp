package io.github.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {


    public static final String NATIVE = "NATIVE";
    public static final String WEB = "WEB";
    public static final String MODE = "MODE";
    private Button mButton;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)findViewById(R.id.loginButton);

        TabHost tabs = (TabHost) findViewById(R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("native");
        spec.setContent(R.id.tab1);
        spec.setIndicator(NATIVE);
        tabs.addTab(spec);
        spec = tabs.newTabSpec("web");
        spec.setContent(R.id.tab2);
        spec.setIndicator(WEB);
        tabs.addTab(spec);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (tabs.getCurrentTabTag().equals("web")) {
                    intent = new Intent(MainActivity.this, TransitionActivity.class);
                }
                else {
                    intent = new Intent(MainActivity.this, LandingActivity.class);
                }
                startActivity(intent);
            }
        });
    }
}