package com.example.IWQHandyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.Ford_iWQ.R;

/**
 * Created by CKRISH16 on 3/14/14.
 */
public class quoteAdvanceSearchActionNext extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quotesearchpage);
    }
    public void quoteSearchFinalbtn(View view)
    {
//        Toast.makeText(rfqAdvanceSearchActionNext.this,"rfqSearchFinalbtn",Toast.LENGTH_SHORT).show();
        startActivity(new Intent(quoteAdvanceSearchActionNext.this,quoteAdvanceSearchActionResult.class));
    }
}
