package com.example.lab4_new;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class AudioActivity extends AppCompatActivity{

    Button play, pause, stop;
    MediaPlayer player;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_audio);

            play = (Button) findViewById(R.id.playMusicButton);
            pause = (Button) findViewById(R.id.pauseMusicButton);
            stop = (Button) findViewById(R.id.stopMusicButton);

            player = MediaPlayer.create(this, R.raw.army);
            player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    stopPlay();
                }
            });

//just some change
        }

        public void playMusicButtonListener(View view){
            player.start();
        }
        public void pauseMusicButtonListener(View view){
            player.pause();
        }
        public void stopMusicButtonListener(View view){
            stopPlay();
           // player.stop();
        }

        private void stopPlay(){
            player.stop();
            try {
                player.prepare();
                player.seekTo(0);
            }
            catch (Throwable t) {
                Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        }
}
