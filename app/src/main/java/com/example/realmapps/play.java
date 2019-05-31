package com.example.realmapps;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class play extends AppCompatActivity {
    MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id= item.getItemId();
        if (id==R.id.logout){
            Toast.makeText(getApplicationContext(),"logout selected",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(play.this,MainActivity.class);
            startActivity(intent);
        }
        else if (id==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    public void play (View v){
        if (player == null){
            player = MediaPlayer.create(this,R.raw.song);
 player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
     @Override
     public void onCompletion(MediaPlayer mp) {

         stopPlayer();
     }
 });
        }
        player.start();
    }
    public void stop (View v){
        stopPlayer();

        }
        private void stopPlayer(){
        if (player != null){
            player.release();
            player=null;
            Toast.makeText(getApplicationContext(),"stop selected",Toast.LENGTH_LONG).show();
        }
        }

    @Override
    protected void onStop() {
        super.onStop();
        stopPlayer();
    }
}

