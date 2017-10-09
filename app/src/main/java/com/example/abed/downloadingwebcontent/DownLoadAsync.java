package com.example.abed.downloadingwebcontent;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;


public class DownLoadAsync extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... params) {

        URL url=null;
        String result="";
        HttpURLConnection httpsURLConnection=null;
        try {
            url=new URL(params[0]);
            httpsURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream=(httpsURLConnection.getInputStream());
            InputStreamReader reader=new InputStreamReader(inputStream);
            int data=reader.read();
            while (data!=-1){
                char curr=(char)data;
                result+=curr;
                data=reader.read();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        Log.i("Result",s);
    }
}
