package com.pongsanit.patorn.getphotos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GetRawData getRawData = new GetRawData("https://www.flickr.com/services/feeds/photos_public.gne?&format=json&nojsoncallback=1");
        FlickrJsonData flickrJsonData = new FlickrJsonData("spongebob", true);
        flickrJsonData.execute();

    }
}
