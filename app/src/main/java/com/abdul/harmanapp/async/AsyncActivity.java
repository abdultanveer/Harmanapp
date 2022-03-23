package com.abdul.harmanapp.async;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.abdul.harmanapp.R;

public class AsyncActivity extends AppCompatActivity {
ProgressBar mProgressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async);
        mProgressBar = findViewById(R.id.progressBar);
    }

    public void downloadHandler(View view) {
        //create a background thread[asynctask]
        DownloadTask downloadTask = new DownloadTask(mProgressBar);
        downloadTask.execute("http://mymoviedownloadurl.com");
        //pass the download url to it
    }
}