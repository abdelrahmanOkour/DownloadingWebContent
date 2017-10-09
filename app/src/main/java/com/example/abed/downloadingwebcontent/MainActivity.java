package com.example.abed.downloadingwebcontent;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView imageView;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.imageView);
        btn= (Button) findViewById(R.id.button);
        btn.setOnClickListener(this);
    }
    public void downloadImage(){
        ImageDownloader imageDownloader=new ImageDownloader();
        try {
            Bitmap bitmap=imageDownloader.execute("https://instagram.com/p/BZ_pr6jHRw_/").get();
            imageView.setImageBitmap(bitmap);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        downloadImage();
    }
}
