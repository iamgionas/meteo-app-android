package ch.supsi.dti.isin.meteoapp.fragments;

import ch.supsi.dti.isin.meteoapp.model.apirequest.CurrentWeather;

// Interfaccia che contiene il metodo callback
public interface Updateable {
    void update(CurrentWeather currentWeather);
}
