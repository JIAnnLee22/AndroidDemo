package com.jiannlee22.audiotrackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    private Button mStop;
    private Button mStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        mStart = findViewById(R.id.start);
        mStop = findViewById(R.id.stop);
        mStart.setOnClickListener(v -> AudioRecordManager.getInstance().start());
        mStop.setOnClickListener(v -> AudioRecordManager.getInstance().stop());
    }
}