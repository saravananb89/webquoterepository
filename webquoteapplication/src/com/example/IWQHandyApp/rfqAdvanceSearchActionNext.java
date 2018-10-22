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
public class rfqAdvanceSearchActionNext extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rfqsearchpage);
    }
    public void rfqSearchFinalbtn(View view)
    {
//        Toast.makeText(rfqAdvanceSearchActionNext.this,"rfqSearchFinalbtn",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(rfqAdvanceSearchActionNext.this,SingleMenuItemActivity.class));
    }
}
