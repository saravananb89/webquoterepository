package com.example.IWQHandyApp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.example.Ford_iWQ.R;

/**
 * Created by ckrish16 on 3/11/14.
 */
public class HomeAction extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home);
		
		String userName = getIntent().getStringExtra("userName");
		
		TextView textview = (TextView)findViewById(R.id.result);
		
		textview.setText("Welcome to WebQuote");
		
		TextView textview1 = (TextView)findViewById(R.id.userName);
		textview1.setText("WELCOME  "+userName.toUpperCase()+" | "+" Last Activity "+" 2014-03-14 01:55:30");
		
		
		Toast toast = Toast.makeText(getApplicationContext(), "Welcome to "+userName, 600000);
		toast.setGravity(Gravity.TOP, 0, 0);
		toast.show();
		
		
	
	}

	public void rfqActionBtn(View view) {
		startActivity(new Intent(HomeAction.this, RFQAction.class));
		// startActivity(new Intent(MyAction.this,LoginAction.class));
	}

	public void advanceSearchActionBtn(View view) {
		startActivity(new Intent(HomeAction.this, AdvanceSearchAction.class));
	}
    public void approvedOrdersSearchActionBtn(View view)
    {
        startActivity(new Intent(HomeAction.this,OrderAction.class));
    }
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			onBackPressed();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

	@Override
	public void onBackPressed() {

	}

	 public void openLoginPage(View view){
	    	
	    	Intent intent = new Intent(HomeAction.this,
	    			LoginAction.class);
	        startActivity(intent);

	    }

}
