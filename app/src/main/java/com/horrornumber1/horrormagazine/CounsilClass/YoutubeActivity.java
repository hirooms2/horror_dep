package com.horrornumber1.horrormagazine.CounsilClass;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.horrornumber1.horrormagazine.R;

import java.util.ArrayList;

public class YoutubeActivity extends YouTubeBaseActivity implements
        YouTubePlayer.OnInitializedListener{

    private static final int RECOVERY_DIALOG_REQUEST = 1;
    private boolean fullScreen;
    private YouTubePlayer videoPlayer;
    private ArrayList<String> titles;
    private int radio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.counsil_youtube);

        Intent intent = new Intent(this.getIntent());
        radio = intent.getIntExtra("position", 1);

        titles = new ArrayList<>();

        titles.add("k5PWb4dRv84"); titles.add("k5PWb4dRv84");
        titles.add("k5PWb4dRv84"); titles.add("k5PWb4dRv84");
        titles.add("k5PWb4dRv84"); titles.add("k5PWb4dRv84");
        titles.add("k5PWb4dRv84"); titles.add("k5PWb4dRv84");
        titles.add("k5PWb4dRv84"); titles.add("k5PWb4dRv84");
        titles.add("drLQN_SKN6g"); titles.add("drLQN_SKN6g");
        titles.add("drLQN_SKN6g"); titles.add("drLQN_SKN6g");


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

}
