package com.patornp.rssfeedviewer;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.StringReader;
import java.util.ArrayList;

/**
 * Created by Pongsanit on 6/27/16.
 */
public class ParseRSSItems {
    private String xmlData;
    private ArrayList<RSSItem> eachField;

    public ParseRSSItems(String data) {
        this.xmlData = data;
        eachField = new ArrayList<>();
    }

    public ArrayList<RSSItem> getEachField() {
        return eachField;
    }

    public boolean process() {
        boolean status = true;
        RSSItem currentRecord = null;
        boolean inEntry = false;
        String textValue = "";

        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser xpp = factory.newPullParser();    //setting up xml parsers
            xpp.setInput(new StringReader(this.xmlData));
            int eventType = xpp.getEventType();

            while(eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();
                switch(eventType) {
                    case XmlPullParser.START_TAG:
                        if(tagName.equalsIgnoreCase("entry")) {
                            inEntry = true;
                            currentRecord = new RSSItem();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        textValue = xpp.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry) {
                            if(tagName.equalsIgnoreCase("entry")) {
                                eachField.add(currentRecord);
                                inEntry = false;
                            } else if(tagName.equalsIgnoreCase("name")) {
                                currentRecord.setName(textValue);
                            } else if(tagName.equalsIgnoreCase("artist")) {
                                currentRecord.setCreator(textValue);
                            }
                        }
                        break;
                    default:
                }
                eventType = xpp.next();
            }

        } catch(Exception e) {
            status = false;
            e.printStackTrace();
        }
        return true;
    }
}
