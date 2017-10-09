package com.example.abed.downloadingwebcontent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DownLoadAsync result = new DownLoadAsync();
       result.execute("http://www.dailymotion.com/jo");
    }
}
