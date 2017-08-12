package com.horrornumber1.horrordepartment.CounsilClass;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.horrornumber1.horrordepartment.ApplicationController;
import com.horrornumber1.horrordepartment.R;

import java.util.ArrayList;

public class YoutubeActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener{

    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private boolean fullScreen;
    private ImageView youtubeBtn;
    private YouTubePlayer videoPlayer;
    private ArrayList<String> titles;
    private int radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counsil_youtube);

        Tracker t = ((ApplicationController)getApplication()).getTracker(ApplicationController.TrackerName.APP_TRACKER);
        t.setScreenName("Youtube Activity");
        t.send(new HitBuilders.AppViewBuilder().build());

        youtubeBtn = (ImageView)findViewById(R.id.youtubeBtn);

        Intent intent = new Intent(this.getIntent());
        radio = intent.getIntExtra("position", 1);

        titles = new ArrayList<>();

        titles.add("mkE3w5tQnyQ"); titles.add("9uEyvphCEeA");
        titles.add("QmmgKvFtXfc"); titles.add("fT5sQLRq4wM");
        titles.add("pXoSC6JpE2Q"); titles.add("e-SV0VS5uL4");
        titles.add("SrXPytGTDBA"); titles.add("b2CbD0d7l2A");
        titles.add("ow1DPSMzqmA"); titles.add("EeO8zWO0cHw");
        titles.add("xcGppQgM4gM"); titles.add("bUtGN4_4-7k");
        titles.add("cMSAilkeXNI"); titles.add("XN5aFx0gZNg");

        youtubeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/channel/UCQbKk4fa3B23YDmVXjv-j4w"));
                startActivity(intent);
            }
        });


        getYouTubePlayerProvider().initialize(DeveloperKey.DEVELOPER_KEY,this);
    }
    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider,
                                        YouTubePlayer player, boolean wasRestored) {
        if (!wasRestored) {

            player.cueVideo(titles.get(radio));

            videoPlayer = player;
            videoPlayer.setOnFullscreenListener(new YouTubePlayer.OnFullscreenListener() {
                @Override
                public void onFullscreen(boolean _isFullScreen) {
                    fullScreen = _isFullScreen;
                }
            });

        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider,
                                        YouTubeInitializationResult errorReason) {
        if (errorReason.isUserRecoverableError()) {
            errorReason.getErrorDialog(this, RECOVERY_DIALOG_REQUEST).show();
        } else {
            String errorMessage = String.format(
                    getString(R.string.error_player), errorReason.toString());
            Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        }
    }

    protected YouTubePlayer.Provider getYouTubePlayerProvider() {
        return (YouTubePlayerView) findViewById(R.id.youtube_view);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_DIALOG_REQUEST) {
            // Retry initialization if user performed a recovery action
            getYouTubePlayerProvider().initialize(DeveloperKey.DEVELOPER_KEY, this);
        }
    }
    @Override
    public void onBackPressed(){
        if(fullScreen) {
            videoPlayer.setFullscreen(false);
        }
        else{
            super.onBackPressed();
        }

    }
    @Override
    protected void onStart(){
        super.onStart();
        GoogleAnalytics.getInstance(this).reportActivityStart(this);
    }
    @Override
    protected void onStop(){
        super.onStop();
        GoogleAnalytics.getInstance(this).reportActivityStop(this);
    }

}
