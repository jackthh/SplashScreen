package com.example.splashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class SplashActivity extends Activity {
    private static int splashTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        // Declaration of Thread
        Thread splashThread = new Thread() {
            @Override
            public void run() {

                try {
                    int waited = 0;
                    while (waited < splashTime) {
                        sleep(100);
                        waited += 200;
                    }

                } catch (InterruptedException i) {
                    Log.d("Error while counting", i.toString());
                } finally {
                    finish();
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                }
            }
        };

        // Start Thread
        splashThread.start();
    }
}
