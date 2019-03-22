package ch.supsi.dti.isin.meteoapp.activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import ch.supsi.dti.isin.meteoapp.db.DatabaseHelper;
import ch.supsi.dti.isin.meteoapp.fragments.ListFragment;
import ch.supsi.dti.isin.meteoapp.services.NotifyService;


// per richiedere la meteo utilizzare WeatherHttpClient con gli appositi metodi

// per la meteo corrente utilizzare il contenitore CurrentWeather
// per le previsioni meteo future utilizzare il contenitore ForecastWeather

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = getApplicationContext();
        SQLiteDatabase mDatabase = new DatabaseHelper(context).getWritableDatabase();
        NotifyService.setServiceAlarm(this, true);

        mDatabase.close();
    }

    @Override
    protected Fragment createFragment() {
        return new ListFragment();
    }
}
