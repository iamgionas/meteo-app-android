package ch.supsi.dti.isin.meteoapp.fragments;

import ch.supsi.dti.isin.meteoapp.model.apirequest.CurrentWeather;

public interface Updateable {
    void update(CurrentWeather currentWeather);
}
