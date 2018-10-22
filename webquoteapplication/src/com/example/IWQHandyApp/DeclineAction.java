package com.example.IWQHandyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.Ford_iWQ.R;

/**
 * Created by ckrish16 on 3/12/14.
 */
public class DeclineAction extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.declinexml);
    }
    public void postDeclineAction(View view)
    {
        Toast.makeText(this,"RFQ is Declined Successfully",Toast.LENGTH_LONG).show();
        startActivity(new Intent(DeclineAction.this,HomeAction.class));
    }
}
