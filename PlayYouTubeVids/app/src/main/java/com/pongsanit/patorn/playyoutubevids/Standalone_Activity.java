package com.pongsanit.patorn.playyoutubevids;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

public class Standalone_Activity extends AppCompatActivity
        implements View.OnClickListener
{

    private String GOOGLE_API_KEY = "AIzaSyA7MUFjIq9ZeoEIzm_ELVesRT_RjWn9ttw";
    private String YOUTUBE_VIDEO_ID = "kOkQ4T5WO9E";
    private String PlAYLIST = "PLvFYFNbi-IBEzlv32QUnKOdmokcDrP3Oq";
    private Button playVideo;
    private Button playPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);
        playVideo = (Button) findViewById(R.id.btnPlay);
        playPlaylist = (Button) findViewById(R.id.btnPlayPlaylist);
        playVideo.setOnClickListener(this);
        playPlaylist.setOnClickListener(this);  //this points to the onClick function
    }

    @Override
    public void onClick(View view) {
        Intent intent = null;
        switch(view.getId()) {
            case R.id.btnPlay:
                intent = YouTubeStandalonePlayer.createVideoIntent(this, GOOGLE_API_KEY, YOUTUBE_VIDEO_ID);
                break;
            case R.id.btnPlayPlaylist:
                intent = YouTubeStandalonePlayer.createPlaylistIntent(this, GOOGLE_API_KEY, PlAYLIST);
                break;
            default:
        }
        if(intent != null) {
            startActivity(intent);      //starts activity based on intent
        }
    }
}
