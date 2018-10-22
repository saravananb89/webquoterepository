package com.example.IWQHandyApp;


import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import com.example.Ford_iWQ.R;

public class SingleMenuItemActivity extends TabActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);

        Resources ressources = getResources();
        TabHost tabHost = getTabHost();

        // Android tab
        Intent intentAndroid = new Intent().setClass(this, RFQActivity.class);
       // intentAndroid= getIntent();
        TabSpec tabSpecAndroid = tabHost
                .newTabSpec("Android")
                .setIndicator("", ressources.getDrawable(R.drawable.icon_android_config))
                .setContent(intentAndroid);

        // Apple tab
        Intent intentApple = new Intent().setClass(this, LineItemActivity.class);
        TabSpec tabSpecApple = tabHost
                .newTabSpec("Apple")
                .setIndicator("", ressources.getDrawable(R.drawable.icon_apple_config))
                .setContent(intentApple);

        // Windows tab
        Intent intentWindows = new Intent().setClass(this, ClausesActivity.class);
        TabSpec tabSpecWindows = tabHost
                .newTabSpec("Windows")
                .setIndicator("", ressources.getDrawable(R.drawable.icon_windows_config))
                .setContent(intentWindows);

        // Blackberry tab
//        Intent intentBerry = new Intent().setClass(this, BlackBerryActivity.class);
//        TabSpec tabSpecBerry = tabHost
//                .newTabSpec("Berry")
//                .setIndicator("", ressources.getDrawable(R.drawable.icon_blackberry_config))
//                .setContent(intentBerry);

        // add all tabs
        tabHost.addTab(tabSpecAndroid);
        tabHost.addTab(tabSpecApple);
        tabHost.addTab(tabSpecWindows);
//        tabHost.addTab(tabSpecBerry);

        //set Windows tab as default (zero based)


        tabHost.getTabWidget().getChildAt(1).getLayoutParams().height = 100;
        tabHost.setCurrentTab(0);
    }
    public void declinebtnclk(View view)
    {
        startActivity(new Intent(SingleMenuItemActivity.this, DeclineAction.class));
    }
    public void quotebtnclk(View view)
    {
        startActivity(new Intent(SingleMenuItemActivity.this, QuoteAction.class));
    }


}

//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.widget.TextView;
//
//public class SingleMenuItemActivity  extends Activity {
//
//	// XML node keys
//	static final String KEY_DueDate = "DueDate";
//	static final String KEY_SupplierCode = "SupplierCode";
//	static final String KEY_description = "description";
//	@Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.single_list_item);
//
//        // getting intent data
//        Intent in = getIntent();
//
//        // Get XML values from previous intent
//        String name = in.getStringExtra(KEY_DueDate);
//        String cost = in.getStringExtra(KEY_SupplierCode);
//        String description = in.getStringExtra(KEY_description);
//
//        // Displaying all values on the screen
//        TextView lblName = (TextView) findViewById(R.id.DueDate_label);
//        TextView lblCost = (TextView) findViewById(R.id.SupplierCode_label);
//        TextView lblDesc = (TextView) findViewById(R.id.description_label);
//
//        lblName.setText(name);
//        lblCost.setText(cost);
//        lblDesc.setText(description);
//    }
//}
