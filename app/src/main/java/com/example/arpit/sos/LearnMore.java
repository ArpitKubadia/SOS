package com.example.arpit.sos;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.VideoView;

public class LearnMore extends AppCompatActivity {
VideoView videoView;
TextView police,ambulance,fire,women;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_more);
        videoView=findViewById(R.id.cpr);
        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.cpr);
        videoView.setVideoURI(uri);
        videoView.start();
        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView.start();
            }
        });
        police=findViewById(R.id.police_no);
        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",police.getText().toString(),null));
                startActivity(intent);
            }
        });

        ambulance=findViewById(R.id.ambulance_no);
        ambulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",ambulance.getText().toString(),null));
                startActivity(intent);
            }
        });

        women=findViewById(R.id.women_no);
        women.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",women.getText().toString(),null));
                startActivity(intent);
            }
        });

        fire=findViewById(R.id.fire_no);
        fire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_DIAL,Uri.fromParts("tel",fire.getText().toString(),null));
                startActivity(intent);
            }
        });


    }
}
