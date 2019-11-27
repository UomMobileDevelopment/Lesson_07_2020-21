package gr.uom.adroid.lesson_06_2018_19;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeActivity extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    private static final String TAG = "YoutubeActivity";
    
    static final String YOUTUBE_API_KEY = BuildConfig.YoutubeApiKey;

    static final String YOUTUBE_VIDEO = "dLBkApLWQfw";

    static final String YOUTUBE_PLAYLIST = "PL9r2-OXUCAoJTnjUZwFBCibZ6_iel93N4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout layout = (ConstraintLayout) getLayoutInflater().inflate(R.layout.activity_youtube, null);
        setContentView(layout);

//        Button button1 = new Button(this);
//        button1.setLayoutParams(new ConstraintLayout.LayoutParams(350,80));
//        button1.setText("Dynamically added Button");
//        layout.addView(button1);

        YouTubePlayerView player = new YouTubePlayerView(this);
        player.
                setLayoutParams(
                        new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                                                            ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(player);

        player.initialize(YOUTUBE_API_KEY, this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean wasRestored) {
        Log.d(TAG, "onInitializationSuccess: Provider is "+provider.getClass());
        if(!wasRestored){
            youTubePlayer.cueVideo(YOUTUBE_VIDEO);
        }


        youTubePlayer.setPlaybackEventListener(playbackEventListener);
        youTubePlayer.setPlayerStateChangeListener(stateChangeListener);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError()){
            youTubeInitializationResult.getErrorDialog(this, 1).show();
        }
        else{
            String error = "Error happened: "+youTubeInitializationResult;
            Toast.makeText(this, error, Toast.LENGTH_LONG).show();
        }
    }

    private YouTubePlayer.PlaybackEventListener playbackEventListener = new YouTubePlayer.PlaybackEventListener() {
        @Override
        public void onPlaying() {
            Toast.makeText(YoutubeActivity.this, "Video playing", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPaused() {

            Toast.makeText(YoutubeActivity.this, "Video paused", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStopped() {

        }

        @Override
        public void onBuffering(boolean b) {

        }

        @Override
        public void onSeekTo(int i) {

        }
    };

    YouTubePlayer.PlayerStateChangeListener stateChangeListener = new YouTubePlayer.PlayerStateChangeListener() {
        @Override
        public void onLoading() {

        }

        @Override
        public void onLoaded(String s) {

        }

        @Override
        public void onAdStarted() {

        }

        @Override
        public void onVideoStarted() {
            Toast.makeText(YoutubeActivity.this, "Video STARTED", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onVideoEnded() {

            Toast.makeText(YoutubeActivity.this, "Video ENDED", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onError(YouTubePlayer.ErrorReason errorReason) {

        }
    };
}
