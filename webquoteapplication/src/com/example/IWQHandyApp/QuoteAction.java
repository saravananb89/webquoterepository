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

    public class QuoteAction extends Activity {
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.quotexml);
        }
        public void postQuoteAction(View view)
        {
            Toast.makeText(this, "Quote is Submitted Successfully", Toast.LENGTH_LONG).show();
            startActivity(new Intent(QuoteAction.this,HomeAction.class));
        }
}
