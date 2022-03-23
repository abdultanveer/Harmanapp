package com.abdul.harmanapp.async;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.abdul.harmanapp.R;

public class AsyncActivity extends AppCompatActivity {
ProgressBar mProgressBar;
    NotificationManager notificationManager;
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
            case R.id.btnNotify:
                showNotification();
                break;
        }
    }

    private void showNotification() {
        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "harman_imp_ID")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("harman title")
                .setContentText("android app dev")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        notificationManager.notify(12, builder.build()); //id 12 -- is notfication id to update or cancel a notification

    }

    private void downloadMovie() {
        //create a background thread[asynctask]
        DownloadTask downloadTask = new DownloadTask(mProgressBar);
        downloadTask.execute("http://mymoviedownloadurl.com");
        //pass the download url to it
    }

    /**
     * channel was introduced to prevent spamming notice board
     * you can disable a channel from settings
     */
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "ride updates";
                    //getString(R.string.channel_name);
            String description = "this channel sends the important updates about the ride";
                    //getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel("harman_imp_ID", name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
             notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}