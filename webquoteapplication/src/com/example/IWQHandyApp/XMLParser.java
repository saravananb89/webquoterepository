package com.example.IWQHandyApp;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import android.util.Log;

public class XMLParser {

    public String getXmlFromUrl(String url) {
        String xml = null;

//		
//		try {             
//			// defaultHttpClient             
////			DefaultHttpClient httpClient = new DefaultHttpClient();             
////			HttpPost httpPost = new HttpPost(url);               
////			HttpResponse httpResponse = httpClient.execute(httpPost);             
////			HttpEntity httpEntity = httpResponse.getEntity();             
////			xml = EntityUtils.toString(httpEntity);           
//		} catch (UnsupportedEncodingException e) {             
//			//e.printStackTrace();         } 
//		catch (ClientProtocolException e) {             
//			//e.printStackTrace();         } 
//		catch (IOException e) {            
//			//e.printStackTrace();         
//		}   

        return xml;
    }


    public Document getDomElement(String xml){
        Document doc = null;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);
        } catch (ParserConfigurationException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (SAXException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        } catch (IOException e) {
            Log.e("Error: ", e.getMessage());
            return null;
        }
        return doc;
    }


    public String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return this.getElementValue(n.item(0));
    }

    public final String getElementValue( Node elem ) {
        Node child;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( child = elem.getFirstChild();
                     child != null;
                     child = child.getNextSibling() ){
                    if( child.getNodeType() == Node.TEXT_NODE  ){
                        return child.getNodeValue();
                    }
                }
            }
        }
        return "";
    }

    public String getKeyValue(String key, String id, Document doc) {
        String value="";
        NodeList nl = doc.getElementsByTagName("item");   // looping through all item nodes <item>

        for (int i = 0; i < nl.getLength(); i++) {
            Node nNode = nl.item(i);
            Element e = (Element) nNode;
            String name = getValue(e, "name"); // name child value
            String cost = getValue(e, "cost"); // cost child value
            //String description = getValue(e, "description"); // description child value }

            if( name.equals(key)){
                value = cost;
            }

        }
        return value;
    }
}
