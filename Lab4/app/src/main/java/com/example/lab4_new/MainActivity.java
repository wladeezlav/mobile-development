package com.example.lab4_new;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button audio, video, internet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        audio = (Button) findViewById(R.id.audioButton);
        video = (Button) findViewById(R.id.videoButton);
        //internet = (Button) findViewById(R.id.internetButton);

    }

    public void videoButtonListener(View view) {
        Intent gotoVideo = new Intent(this, VideoActivity.class);
        startActivity(gotoVideo);
    }

    public void audioButtonListener(View view) {
        Intent gotoAudio = new Intent(this, AudioActivity.class);
        startActivity(gotoAudio);
    }
}
