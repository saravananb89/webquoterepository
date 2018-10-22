package com.example.IWQHandyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.Ford_iWQ.R;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Handler;

public class MyAction extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static int SPLASH_TIME_OUT = 1500;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

//        Timer timer = new Timer();
//
//        timer.schedule(new TimerTask() {
//            public void run() {
//                startActivity(new Intent(MyAction.this, LoginAction.class));
//            }
//        }, 0, 3000);


//        startActivity(new Intent(MyAction.this, LoginAction.class)
//
//            );

            new Handler().postDelayed(new Runnable() {


            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity
                Intent i = new Intent(MyAction.this, LoginAction.class);
                startActivity(i);

                // close this activity
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}
//    public void launchAppBtn(View view)
//    {
//        startActivity(new Intent(MyAction.this,LoginAction.class));
//    }

