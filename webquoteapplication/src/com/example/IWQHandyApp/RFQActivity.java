package com.example.IWQHandyApp;

/**
 * Created by ckrish16 on 3/12/14.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Ford_iWQ.R;

public class RFQActivity extends Activity {
    static final String KEY_RFQNumber= "DueDate";
//    static final String KEY_CATEGORY = "SupplierCode";
//    static final String KEY_RFQDescription = "description";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        TextView textview = new TextView(this);
//        textview.setText("This is Android tab");
        setContentView(R.layout.rfqtabactivity);
        Intent in = getIntent();

// Get XML values from previous intent
        String RFQNumber = in.getStringExtra(KEY_RFQNumber);
//        String CATEGORY = in.getStringExtra(KEY_CATEGORY);
//        String RFQDescription = in.getStringExtra(KEY_RFQDescription);

// Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.rfqIdTabView);
//        TextView lblCat = (TextView) findViewById(R.id.category_label);
//        TextView lblPub = (TextView) findViewById(R.id.published_label);
//        Toast.makeText(RFQActivity.this,"I at RFQ Activity"+RFQNumber,Toast.LENGTH_LONG).show();
        lblName.setText(RFQNumber);
//        lblCat.setText(CATEGORY);
//        lblPub.setText(RFQDescription);




            }
}

