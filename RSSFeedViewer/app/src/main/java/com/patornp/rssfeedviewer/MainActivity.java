package com.patornp.rssfeedviewer;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private String datafromXMLFile;
    private Button topTenApp;
    private Button topSong;
    private ListView listtopFields;
    private TextView currentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        topTenApp = (Button) findViewById(R.id.topTenAppView);
        topSong = (Button) findViewById(R.id.topSong);
        listtopFields = (ListView) findViewById(R.id.listtopFieldsView);
        currentView = (TextView) findViewById(R.id.currentList);

        topTenApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView.setText("TOP Apps");
                DownloadData downloadData = new DownloadData();
                downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topfreeapplications/limit=10/xml");
                ParseRSSItems parseRSSItems = new ParseRSSItems(datafromXMLFile);
                parseRSSItems.process();
                ArrayAdapter<RSSItem> arrayAdapter = new ArrayAdapter<RSSItem>(
                        MainActivity.this, R.layout.list_of_items_view, parseRSSItems.getEachField());
                listtopFields.setAdapter(arrayAdapter);

            }
        });

        topSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentView.setText("TOP Songs");
                DownloadData downloadData = new DownloadData();
                downloadData.execute("http://ax.itunes.apple.com/WebObjects/MZStoreServices.woa/ws/RSS/topsongs/limit=25/xml");
                ParseRSSItems parseRSSItems = new ParseRSSItems(datafromXMLFile);
                parseRSSItems.process();
                ArrayAdapter<RSSItem> arrayAdapter = new ArrayAdapter<RSSItem>(
                        MainActivity.this, R.layout.list_of_items_view, parseRSSItems.getEachField());
                listtopFields.setAdapter(arrayAdapter);

            }
        });

    }

    //Asynchronous processing
    //string - location data, void - no progress bar, string - data returned
    private class DownloadData extends AsyncTask<String, Void, String> {

        @Override                      //Many String args (i.e xml file)
        protected String doInBackground(String... params) {
            datafromXMLFile = downloadXMLFile(params[0]); //processing only first xml file
            if(datafromXMLFile == null){
                Log.d("Download", "Cannot download");
            }
            return datafromXMLFile;
        }

        @Override
        protected void onPostExecute(String Data) {
            super.onPostExecute(Data);
            Log.d("Download", "Data: " + Data);
        }

        private String downloadXMLFile(String urlPath) {
            StringBuilder xmlAdded = new StringBuilder();
            try {
                URL url = new URL(urlPath); //Getting url and opening connection
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                int response = connection.getResponseCode();    //getting response code
//                Log.d("Download", "The response code is " + response); //200 successful
                InputStream inputStream = connection.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

                int charRead;
                char[] inputBuffer = new char[500];
                while(true) {
                    charRead = inputStreamReader.read(inputBuffer); //read chars into array and returns chars read
                    if(charRead <= 0) {
                        break;
                    }
                    xmlAdded.append(String.copyValueOf(inputBuffer, 0, charRead));
                }

                return xmlAdded.toString();

            } catch(IOException e) {
                Log.d("Download", "IO Exception: " + e.getMessage());
            } catch(SecurityException e) {
                Log.d("Download", "Security Exception " + e.getMessage());
            }
            return null;
        }
    }
}
