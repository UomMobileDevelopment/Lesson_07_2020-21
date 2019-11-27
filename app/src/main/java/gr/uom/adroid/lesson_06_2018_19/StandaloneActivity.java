package gr.uom.adroid.lesson_06_2018_19;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeStandalonePlayer;

/**
 * Created by teohaik on 5/11/2018.
 */

public class StandaloneActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standalone);

        Button btnPlayVideo = findViewById(R.id.btnPlayVideo);
        Button btnPlayPlaylist = findViewById(R.id.btnPlaylist);

        btnPlayPlaylist.setOnClickListener(this);
        btnPlayVideo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        if(v.getId() == R.id.btnPlayVideo){
                intent = YouTubeStandalonePlayer.createVideoIntent(this, BuildConfig.YoutubeApiKey, YoutubeActivity.YOUTUBE_VIDEO);
        }
        else if(v.getId() == R.id.btnPlaylist){

            intent = YouTubeStandalonePlayer.createPlaylistIntent(this, BuildConfig.YoutubeApiKey, YoutubeActivity.YOUTUBE_PLAYLIST);
        }

        if(intent != null){
            startActivity(intent);
        }

    }

}
