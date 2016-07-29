package com.pongsanit.patorn.playyoutubevids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button youtubePlayer;
    private Button standalonePlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        youtubePlayer = (Button) findViewById(R.id.youtube_player);
        standalonePlayer = (Button) findViewById(R.id.standalone);
        youtubePlayer.setOnClickListener(this); //this represents onClick() method
        standalonePlayer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()){
            case R.id.youtube_player:
                intent = new Intent(MainActivity.this, Youtube_Activity.class);
                break;
            case R.id.standalone:
                intent = new Intent(MainActivity.this, Standalone_Activity.class);
                break;
        }

        if(intent != null) {
            startActivity(intent);  //starts activity depending on intent
        }

    }
}
