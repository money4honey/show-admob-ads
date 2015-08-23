package ru.moneyhoney.playground.util;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import ru.moneyhoney.playground.R;

/* This is singleton class for loading AdMob ads
*  Note: before call getAd() method call updateAd() */

public class LoadAd {

    private static InterstitialAd sInterstitialAd;
    private static boolean sShowOnLoad;
    private static boolean sIsUpdate;

    private LoadAd(){
        sInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }

    public static InterstitialAd getAd(){
        if (sInterstitialAd != null && sInterstitialAd.isLoaded()){
            return sInterstitialAd;
        } else {
            new LoadAd();
            return sInterstitialAd;
        }
    }

    public static void updateAd(){
        sIsUpdate = true;
        new LoadAd();
    }

    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(MyApplication.getAppContext());
        interstitialAd.setAdUnitId(MyApplication.getAppContext().getString(R.string.interstitial_ad_unit_id)); // AdMob interstitial ad unit id
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (sShowOnLoad) {
                    if (!sIsUpdate){ showInterstitial(); }
                    sIsUpdate = false;
                }
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {}

            @Override
            public void onAdClosed() { updateAd(); }
        });
        return interstitialAd;
    }

    private static void loadInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").build();
        sInterstitialAd.loadAd(adRequest);
    }

    private static void showInterstitial() {
        if (sInterstitialAd != null && sInterstitialAd.isLoaded()) {
            sInterstitialAd.show();
        }
    }

    public static void setShowOnLoad(boolean showOnLoad) {
        LoadAd.sShowOnLoad = showOnLoad;
    }
}
