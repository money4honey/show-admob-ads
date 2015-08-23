package ru.moneyhoney.playground;

import android.content.Context;
import android.os.AsyncTask;
import android.os.SystemClock;

import com.google.android.gms.ads.InterstitialAd;

import ru.moneyhoney.playground.util.LoadAd;

/* This is Asynchronous Timer class for call periodic action */

public class AsyncTimer extends AsyncTask<Void, Integer, Void> {
    private static int mCounter = 0;
    private static int mPeriod;
    private Context mContext;

    InterstitialAd mInterstitialAd;

    public AsyncTimer(Context context, int period) {
        super();
        mContext = context;
        mPeriod = period;
    }

    @Override
    protected Void doInBackground(Void... params) {
        while (mCounter < mPeriod){
            mCounter++;
            publishProgress(mCounter);

            SystemClock.sleep(1000);
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

        if (mCounter == mPeriod){
            mCounter = 0;

            // periodic action below

            mInterstitialAd = LoadAd.getAd();
            mInterstitialAd.show();
        }
    }

    public static void resetTimer(){
        mCounter = 0;
    }

}
