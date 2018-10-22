package com.example.IWQHandyApp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.Ford_iWQ.R;

/**
 * Created by ckrish16 on 3/11/14.
 */
public class LoginAction extends Activity {
    private EditText userID;
    private EditText pwdID;
    static final String KEY_userminidetails = "userminidetails";
    static final String KEY_userName = "userName";
    static final String KEY_password= "password";
    boolean br=false;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
    }



    public void loginClickBtn(View view) {

        userID = (EditText) findViewById(R.id.userID);
        pwdID = (EditText) findViewById(R.id.passwordID);
        String currentUser=userID.getText().toString();

        if (userID.getText().toString().equalsIgnoreCase("") || pwdID.getText().toString().equalsIgnoreCase("")) {
            Toast toast = Toast.makeText(LoginAction.this,"All Fields Required",Toast.LENGTH_LONG);
            //toast.getView().setBackgroundColor(Color.RED);
            toast.setGravity(Gravity.TOP, 0, 0);
			toast.show();
		} else {
			Toast toast = Toast.makeText(getApplicationContext(),
					"Validating...", Toast.LENGTH_SHORT);
			// toast.getView().setBackgroundColor(Color.GRAY);
			toast.setGravity(Gravity.TOP, 0, 0);
			toast.show();

			br = credentailsValidation(userID.getText().toString(), pwdID
					.getText().toString());
			if (br == true) {
				Intent intent = new Intent(LoginAction.this, HomeAction.class);
				intent.putExtra("userName", currentUser);
				startActivity(intent);
			} else{
				Toast toast1 =Toast.makeText(LoginAction.this, "Invalid Credentails",
						Toast.LENGTH_LONG);
			    toast1.setGravity(Gravity.TOP, 0, 0);
			   toast1.show();
			}
		}



    }
    public boolean credentailsValidation(String userID,String pwdID)
    {
        XMLParser parser = new XMLParser();
//        getApplicationContext().getAssets().open("loginvalues");
        String xml=null;
        StringBuilder sb= null;
        String dbUserName=null;
        String dbPassword=null;
        try{
            AssetManager assetManager = getAssets();
            InputStream instream = assetManager.open("loginvalues.xml");



            BufferedReader br = null;
            sb = new StringBuilder();

            String line;
            try {

                br = new BufferedReader(new InputStreamReader(instream));
                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }




        }catch(Exception e){
            e.printStackTrace();
        }
        xml=sb.toString();
//        Toast.makeText(LoginAction.this,"All Fields Required"+xml,Toast.LENGTH_LONG).show();
        Document doc = parser.getDomElement(xml); // getting DOM element

        NodeList nl = doc.getElementsByTagName(KEY_userminidetails);
        for (int i = 0; i < nl.getLength(); i++) {

            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value
           dbUserName=parser.getValue(e, KEY_userName);
            dbPassword=parser.getValue(e, KEY_password);

            // adding HashList to ArrayList
           }
        if ((userID.equals(dbUserName)) && (pwdID.equals(dbPassword)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

   
}
