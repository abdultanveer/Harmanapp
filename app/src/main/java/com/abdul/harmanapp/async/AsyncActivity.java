package com.abdul.harmanapp.async;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.RemoteInput;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.abdul.harmanapp.MainActivity;
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
        String replyLabel = "reply back";
                //getResources().getString(R.string.reply_label);
        RemoteInput remoteInput = new RemoteInput.Builder("KEY_TEXT_REPLY")
                .setLabel(replyLabel)
                .build();
        PendingIntent replyPendingIntent =
                PendingIntent.getBroadcast(getApplicationContext(),
                        123,new Intent(),
                        //getMessageReplyIntent(conversation.getConversationId()),
                        PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Action action =
                new NotificationCompat.Action.Builder(R.drawable.ic_launcher_foreground,
                       "label title",
                       // getString(R.string.label),
                        replyPendingIntent)
                        .addRemoteInput(remoteInput)
                        .build();

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        //in a hotel -- flight midnight--book a cab -- create an intent -- reception[operating system] - fire intent on my behalf
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        createNotificationChannel();
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "harman_imp_ID")
                .setSmallIcon(R.drawable.ic_launcher_background)
                .setContentTitle("harman title")
                .setContentText("android app dev")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .addAction(action)
                .setContentIntent(pendingIntent);


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
            channel.setShowBadge(true);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
             notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}