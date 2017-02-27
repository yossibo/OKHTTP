package com.example.okhttp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by jbt on 27/02/2017.
 */

public class MyDownloader extends AsyncTask<String , Void, String> {
    TextView textView;

    public MyDownloader(TextView textView) {
        this.textView = textView;
    }

    @Override
    protected String doInBackground(String... params) {

        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(params[0]).build();

       String result="";

        try {
           Response response = client.newCall(request).execute();
            result= response.body().string();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    protected void onPostExecute(String restult) {

        textView.setText(restult);
    }
}
