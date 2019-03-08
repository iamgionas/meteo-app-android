package ch.supsi.dti.isin.meteoapp.activities;

import ch.supsi.dti.isin.meteoapp.model.apirequest.CurrentWeather;
import ch.supsi.dti.isin.meteoapp.model.apirequest.ForecastWeather;
import ch.supsi.dti.isin.meteoapp.model.apirequest.WeatherHttpClient;

public class Main {

    public static void main(String[] args) {

        WeatherHttpClient weatherHttpClient = new WeatherHttpClient();

        System.out.println("Current Weather");

        // RICERCA PER NOME
        CurrentWeather currentWeather = weatherHttpClient.getCurrentWeatherDataByLocation("London");
        System.out.println(currentWeather.toString());
        System.out.println(currentWeather.getMain().getTemp());

        // RICERCA PER ID
        currentWeather = weatherHttpClient.getCurrentWeatherDataById(2172797);
        System.out.println(currentWeather.toString());
        System.out.println(currentWeather.getMain().getTemp());

        // RICERCA PER LAT LON
        currentWeather = weatherHttpClient.getCurrentWeatherDataByLatLon(35,139);
        System.out.println(currentWeather.toString());
        System.out.println(currentWeather.getMain().getTemp());

        // RICERCA PER ZIP CODE
        currentWeather = weatherHttpClient.getCurrentWeatherDataByZIPCode(94040);
        System.out.println(currentWeather.toString());
        System.out.println(currentWeather.getMain().getTemp());




        System.out.println("\nForecast Weather");

        // RICERCA PER NOME
        ForecastWeather forecastWeather = weatherHttpClient.getForecastWeatherDataByLocation("London");
        System.out.println(forecastWeather.toString());
        System.out.println(forecastWeather.getList().get(0).getMain().getTemp());

        // RICERCA PER ID
        forecastWeather = weatherHttpClient.getForecastWeatherDataById(2172797);
        System.out.println(forecastWeather.toString());
        System.out.println(forecastWeather.getList().get(0).getMain().getTemp());

        // RICERCA PER LAT LON
        forecastWeather = weatherHttpClient.getForecastWeatherDataByLatLon(35,139);
        System.out.println(forecastWeather.toString());
        System.out.println(forecastWeather.getList().get(0).getMain().getTemp());

        // RICERCA PER ZIP CODE
        forecastWeather = weatherHttpClient.getForecastWeatherDataByZIPCode(94040);
        System.out.println(forecastWeather.toString());
        System.out.println(forecastWeather.getList().get(0).getMain().getTemp());
    }
}
