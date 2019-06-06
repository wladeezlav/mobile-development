package com.example.lab4_new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class VideoFromInternetActivity extends AppCompatActivity {
    VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_from_internet);

        videoView = (VideoView) findViewById(R.id.videoViewInternet);
        videoView.setVideoPath("http://video.ch9.ms/ch9/507d/71f4ef0f-3b81-4d2c-956f-c56c81f9507d/AndroidEmulatorWithMacEmulator.mp4");
        videoView.stopPlayback();
        videoView.resume();
        videoView.pause();
    }

    public void playInternetButtonListener(View view) {
        videoView.start();
    }
    public void pauseInternetButtonListener(View view) {
        videoView.pause();
    }
    public void stopInternetButtonListener(View view) {
        videoView.stopPlayback();
        videoView.resume();
    }
}
