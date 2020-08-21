package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button start,reset,stop;
    private Canvas canvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start=(Button)findViewById(R.id.start);
        reset=(Button)findViewById(R.id.stop);
        stop=(Button)findViewById(R.id.stopp);

        canvas=(Canvas)findViewById(R.id.canvas);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                canvas.start();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                canvas.reset();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                canvas.stop();
            }
        });

    }
}