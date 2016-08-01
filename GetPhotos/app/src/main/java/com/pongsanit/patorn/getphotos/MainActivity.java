package com.pongsanit.patorn.getphotos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = "MAINACTIVITY";
    private List<Photo> mPhotosList = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GetRawData getRawData = new GetRawData("https://www.flickr.com/services/feeds/photos_public.gne?&format=json&nojsoncallback=1");
        FlickrJsonData flickrJsonData = new FlickrJsonData("spongebob", true);
        flickrJsonData.execute();

    }

    public class ProcessPhotos extends FlickrJsonData {
        public ProcessPhotos(String searchCriteria, boolean matchAll){
            super(searchCriteria,matchAll);
        }

        public void execute(){
            super.execute();
            ProcessData processData = new ProcessData();
            processData.execute();
        }

        public class ProcessData extends DownloadJsonData{
            protected void onPostExecute(String webData){
                super.onPostExecute(webData);
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, getMPhotos());
                mRecyclerView.setAdapter(recyclerViewAdapter);

            }
        }
    }
}
