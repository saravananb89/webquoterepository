package com.example.IWQHandyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.example.Ford_iWQ.R;

public class orderSingleItemResult extends Activity {

    // XML node keys
    static final String KEY_orderNumber = "orderNumber";
    static final String KEY_OrderDate = "OrderDate";
    static final String KEY_description = "description";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordersingleitem);

// getting intent data
        Intent in = getIntent();

// Get XML values from previous intent
        String orderNumber = in.getStringExtra(KEY_orderNumber);
        String OrderDate = in.getStringExtra(KEY_OrderDate);
        String description = in.getStringExtra(KEY_description);

// Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.orderNumber);
        TextView lblCat = (TextView) findViewById(R.id.OrderDate);
        TextView lblPub = (TextView) findViewById(R.id.description);

        lblName.setText(orderNumber);
        lblCat.setText(OrderDate);
        lblPub.setText(description);
    }
}
