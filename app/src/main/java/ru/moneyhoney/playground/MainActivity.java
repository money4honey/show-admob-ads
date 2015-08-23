package ru.moneyhoney.playground;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.InterstitialAd;

import ru.moneyhoney.playground.util.LoadAd;
import ru.moneyhoney.playground.util.Rand;

public class MainActivity extends AppCompatActivity {

    AsyncTimer mAsyncTimer;
    InterstitialAd mInterstitialAd;
    Button showAdButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoadAd.updateAd(); // предварительно загружаем объявление в синглетный класс

        showAdButton = (Button)findViewById(R.id.showAd); // получаем объект кнопки
        showAdButton.setOnClickListener(new View.OnClickListener() { // устанавливаем слушателя
            @Override
            public void onClick(View v) {
                mInterstitialAd = LoadAd.getAd(); // получаем объект объявления
                mInterstitialAd.show(); // показываем объявление
            }
        });


        mAsyncTimer = new AsyncTimer(getApplicationContext(), Rand.IntRange(10, 20));
        mAsyncTimer.execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
