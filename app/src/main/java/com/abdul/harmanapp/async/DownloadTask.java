package com.abdul.harmanapp.async;

import android.os.AsyncTask;
import android.widget.ProgressBar;

/**
 * background thread to download a movie
 */
public class DownloadTask extends AsyncTask<String,Integer,Void> {
    public DownloadTask(ProgressBar progressBar) {
    }

    @Override
    protected Void doInBackground(String... strings) {
        return null;
    } //params-i/p, progress type, result type}
}
