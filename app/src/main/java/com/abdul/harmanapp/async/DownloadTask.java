package com.abdul.harmanapp.async;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

/**
 * background thread to download a movie
 */
public class DownloadTask extends AsyncTask<String,Integer,Void> {
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar mProgressBar;//declaration

    public DownloadTask(ProgressBar progressBar) {
        mProgressBar = progressBar; //instantiation
    }

    @Override
    protected Void doInBackground(String... strings) {
        Log.i(TAG,strings[0]);
        mProgressBar.setProgress(50);
        return null;
    } //params-i/p, progress type, result type}
}
