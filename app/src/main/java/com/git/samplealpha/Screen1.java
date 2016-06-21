package com.git.samplealpha;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Screen1 extends Activity {
    // Splash screen timer
    private static int ACTIVITY_SCREEN1_TIME_OUT = 2000;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(Screen1.this,LoginActivity.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, ACTIVITY_SCREEN1_TIME_OUT);
    }

}