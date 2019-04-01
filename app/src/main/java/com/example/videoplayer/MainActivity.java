package com.example.videoplayer;

import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

import com.squareup.seismic.ShakeDetector;

public  class MainActivity extends AppCompatActivity implements ShakeDetector.Listener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sm=(SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd=new ShakeDetector(this);

        sd.start(sm);
    }

    @Override
    public void hearShake() {
        MediaController md=new MediaController(this);
        VideoView v =(VideoView)findViewById(R.id.V1);
        v.setVideoPath("android.resource://"+getPackageName() + "/" + R.raw.beautiful1);
        md.setAnchorView(v);
        v.setMediaController(md);
        v.start();

    }

}
