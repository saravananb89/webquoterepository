package com.example.IWQHandyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.example.Ford_iWQ.R;

/**
 * Created by CKRISH16 on 3/12/14.
 */
public class AdvanceSearchAction extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searchpage);
    }
    public void orderAdvanceSearchBtnClick(View view)
    {
        startActivity(new Intent(AdvanceSearchAction.this,AdvanceSearchActionNext.class));
    }
    public void rfqAdvanceSearchBtnClick(View view)
    {
        startActivity(new Intent(AdvanceSearchAction.this,rfqAdvanceSearchActionNext.class));
    }
    public void quoteAdvanceSearchBtnClick(View view)
    {
        startActivity(new Intent(AdvanceSearchAction.this,quoteAdvanceSearchActionNext.class));
    }

}
