package ch.supsi.dti.isin.meteoapp.activities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import ch.supsi.dti.isin.meteoapp.db.DatabaseHelper;
import ch.supsi.dti.isin.meteoapp.db.DatabaseSchema;
import ch.supsi.dti.isin.meteoapp.fragments.ListFragment;


// per richiedere la meteo utilizzare WeatherHttpClient con gli appositi metodi

// per la meteo corrente utilizzare il contenitore CurrentWeather
// per le previsioni meteo future utilizzare il contenitore ForecastWeather

public class MainActivity extends SingleFragmentActivity {
    private SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = getApplicationContext();
        mDatabase = new DatabaseHelper(context).getWritableDatabase();
        mDatabase.close();
    }

    @Override
    protected Fragment createFragment() {
        return new ListFragment();
    }
}
