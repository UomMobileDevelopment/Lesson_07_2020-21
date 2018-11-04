package gr.uom.adroid.lesson_06_2018_19;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnPlayVideo = findViewById(R.id.btnPlayVideo);
        Button btnStartStandalone = findViewById(R.id.btnStandaloneActivity);

        btnPlayVideo.setOnClickListener(this);
        btnStartStandalone.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = null;

        if(v.getId() == R.id.btnPlayVideo){
            intent = new Intent(this, YoutubeActivity.class);
        }
        else if (v.getId() == R.id.btnStandaloneActivity) {
            intent = new Intent(this, StandaloneActivity.class);
        }

        if(intent != null){
            startActivity(intent);
        }
    }
}
