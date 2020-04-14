package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState !=null){
            seconds=savedInstanceState.getInt( "seconds");
            running=savedInstanceState.getBoolean("running");
        }
        runtimer();
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("seconds", seconds);
        savedInstanceState.putBoolean("running", running);



    }
    public void onclickStart(View view){
        running=true;
    }
    public void onclickStop(View view){
        running=false;
    }
    public void onclickReset(View view){
        running=false;
        seconds = 0;
    }

    private void runtimer(){
        final TextView mytime=(TextView) findViewById(R.id.timeView);
        final Handler hand=new Handler();
        hand.post(new Runnable() {
            @Override
            public void run() {

                int hours=seconds/3600;
                int minuts=(seconds%3600)/60;
                int secs=seconds%60;
                String time=String.format("%d:%2d:%2d",hours,minuts,secs);
                mytime.setText(time);

                if(running){

                    seconds++;
                }
             hand.postDelayed(this,1000);
            }
        });


    }
}
