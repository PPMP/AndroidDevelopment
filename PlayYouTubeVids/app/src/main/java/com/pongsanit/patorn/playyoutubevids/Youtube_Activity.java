package com.pongsanit.patorn.playyoutubevids;

import android.os.Bundle;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class Youtube_Activity extends YouTubeBaseActivity
    implements YouTubePlayer.OnInitializedListener
{

    private String GOOGLE_API_KEY = "AIzaSyA7MUFjIq9ZeoEIzm_ELVesRT_RjWn9ttw";
    private String YOUTUBE_VIDEO_ID = "kOkQ4T5WO9E";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube);
        YouTubePlayerView youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player_view);
        youTubePlayerView.initialize(GOOGLE_API_KEY, this); //initialize a YouTubePlayer, which can be used to play videos and control video playback.
    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if(!b) {
            youTubePlayer.cueVideo(YOUTUBE_VIDEO_ID);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

    }
}
