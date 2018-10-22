package com.example.IWQHandyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.Ford_iWQ.R;

/**
 * Created by ckrish16 on 3/12/14.
 */
public class AdvanceSearchActionNext extends Activity{
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ordersearchpage);
    }
    public void orderAdvanceFinalSearchBtnClick(View view)
    {
        startActivity(new Intent(AdvanceSearchActionNext.this,AdvanceSearchActionResult.class));
    }
}
