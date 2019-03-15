package ch.supsi.dti.isin.meteoapp.activities;

import ch.supsi.dti.isin.meteoapp.model.apirequest.Location;
import ch.supsi.dti.isin.meteoapp.model.apirequest.CurrentWeather;
import ch.supsi.dti.isin.meteoapp.model.apirequest.ForecastWeather;
import ch.supsi.dti.isin.meteoapp.model.apirequest.WeatherHttpClient;

public class Main {

    public static void main(String[] args) {

        System.out.println("Current Weather");

        Location location1 = new Location();
        location1.setName("London");

        // RICERCA PER NOME
        CurrentWeather currentWeather = WeatherHttpClient.getCurrentWeatherDataByLocation2(location1);
        System.out.println(currentWeather.toString());
        System.out.println(currentWeather.getMain().getTemp());

        // RICERCA PER LAT LON
        currentWeather = WeatherHttpClient.getCurrentWeatherDataByLatLon(35, 139);
        System.out.println(currentWeather.toString());
        System.out.println(currentWeather.getMain().getTemp());


        System.out.println("\nForecast Weather");

        Location location2 = new Location();
        location2.setName("London");

        // RICERCA PER NOME
        ForecastWeather forecastWeather = WeatherHttpClient.getForecastWeatherDataByLocation(location2);
        System.out.println(forecastWeather.toString());
        System.out.println(forecastWeather.getList().get(0).getMain().getTemp());

        // RICERCA PER LAT LON
        forecastWeather = WeatherHttpClient.getForecastWeatherDataByLatLon(35, 139);
        System.out.println(forecastWeather.toString());
        System.out.println(forecastWeather.getList().get(0).getMain().getTemp());

    }
}