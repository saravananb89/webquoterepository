package com.example.IWQHandyApp;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

import android.content.res.AssetManager;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.example.Ford_iWQ.R;


public class RFQAction extends ListActivity {

    // All static variables 
   //static final String URL =new File("rfqxmldata.xml").getAbsolutePath();
    // XML node keys
    static final String KEY_RFQ = "RFQ"; // parent node
    static final String KEY_RFQNumber = "RFQNumber";
    static final String KEY_DueDate= "DueDate";
    static final String KEY_SupplierCode = "SupplierCode";
    static final String KEY_description = "description";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rfqmain);

        ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

        XMLParser parser = new XMLParser();
     //   String xml = parser.getXmlFromUrl(URL); // getting XML
        String xml="";
        StringBuilder sb=null;
        try{
            AssetManager assetManager = getAssets();
            InputStream instream = assetManager.open("rfqxmldata.xml");



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

        Document doc = parser.getDomElement(xml); // getting DOM element

        NodeList nl = doc.getElementsByTagName(KEY_RFQ);
        // looping through all item nodes <item> 
        for (int i = 0; i < nl.getLength(); i++) {
            // creating new HashMap 
            HashMap<String, String> map = new HashMap<String, String>();
            Element e = (Element) nl.item(i);
            // adding each child node to HashMap key => value 
            map.put(KEY_RFQNumber , parser.getValue(e, KEY_RFQNumber));
            map.put(KEY_DueDate, parser.getValue(e, KEY_DueDate));
            map.put(KEY_SupplierCode , parser.getValue(e, KEY_SupplierCode ));
            map.put(KEY_description , parser.getValue(e, KEY_description ));

            // adding HashList to ArrayList 
            menuItems.add(map);
        }

        // Adding menuItems to ListView 
        ListAdapter adapter = new SimpleAdapter(this, menuItems,
                R.layout.list_item,
                new String[] { KEY_DueDate, KEY_description, KEY_SupplierCode }, new int[] {
                R.id.DueDate, R.id.description, R.id.SupplierCode });

        setListAdapter(adapter);

        // selecting single ListView item 
        ListView lv = getListView();
        // listening to single listitem click
        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // getting values from selected ListItem 
                String name = ((TextView) view.findViewById(R.id.DueDate)).getText().toString();
                String cost = ((TextView) view.findViewById(R.id.SupplierCode)).getText().toString();
                String description = ((TextView) view.findViewById(R.id.description)).getText().toString();

                // Starting new intent
                Intent in = new Intent(getApplicationContext(), SingleMenuItemActivity.class);
                in.putExtra(KEY_DueDate , name);
                in.putExtra(KEY_SupplierCode, cost);
                in.putExtra(KEY_description, description);


                startActivity(in);

            }
        });
    }
}
