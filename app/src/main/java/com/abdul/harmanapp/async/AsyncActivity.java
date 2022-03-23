package com.abdul.harmanapp.async;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

        switch (view.getId()){
            case R.id.btnDownload:
                downloadMovie();
                break;
            case R.id.btnStart:
                Intent serviceIntent = new Intent(this,MusicService.class);
                serviceIntent.putExtra("musicfilename","latest.mp3");
                startService(serviceIntent);
                break;
            case R.id.btnStop:
                Intent servIntent = new Intent(this,MusicService.class);
                stopService(servIntent);
                break;
        }
    }

    private void downloadMovie() {
        //create a background thread[asynctask]
        DownloadTask downloadTask = new DownloadTask(mProgressBar);
        downloadTask.execute("http://mymoviedownloadurl.com");
        //pass the download url to it
    }
}