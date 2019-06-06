package com.example.lab4_new;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

public class VideoActivity extends AppCompatActivity{
    private Button stop;
    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = (VideoView) findViewById(R.id.videoView);

        Uri video = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.luntik);
        videoView.setVideoURI(video);
        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);

        stop = (Button) findViewById(R.id.stopButton);


        videoView.stopPlayback();
        videoView.resume();
        videoView.pause();

    }
    public void stop(View view){
        videoView.stopPlayback();
        videoView.resume();
    }

    public void playButtonListener(View view){
        videoView.start();
    }
    public void pauseButtonListener(View view){
        videoView.pause();
    }
    public void stopButtonListener(View view){
        videoView.stopPlayback();
        videoView.resume();
    }
}
