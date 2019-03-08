package ch.supsi.dti.isin.meteoapp.activities;

import android.support.v4.app.Fragment;

import ch.supsi.dti.isin.meteoapp.fragments.ListFragment;


// per richiedere la meteo utilizzare WeatherHttpClient con gli appositi metodi

// per la meteo corrente utilizzare il contenitore CurrentWeather
// per le previsioni meteo future utilizzare il contenitore ForecastWeather

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new ListFragment();
    }
}
