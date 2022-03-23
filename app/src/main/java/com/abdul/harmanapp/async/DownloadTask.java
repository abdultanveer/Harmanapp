package com.abdul.harmanapp.async;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

/**
 * background thread to download a movie
 */
//params-i/p, progress type, result type}
public class DownloadTask extends AsyncTask<String,Integer,Void> {
    public static String TAG = DownloadTask.class.getSimpleName();
    ProgressBar mProgressBar;//declaration

    public DownloadTask(ProgressBar progressBar) {
        mProgressBar = progressBar; //instantiation
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Void doInBackground(String... strings) { //worker thread doing the job in background
        Log.i(TAG,strings[0]);
        try {
            for(int i=1;i<20;i++){
                Thread.sleep(200);
                publishProgress(i*5);

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        mProgressBar.setProgress(values[0]);

    }

    @Override
    protected void onPostExecute(Void unused) {
        super.onPostExecute(unused);
        mProgressBar.setVisibility(View.INVISIBLE);
    }
}
