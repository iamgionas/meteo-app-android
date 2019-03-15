package ch.supsi.dti.isin.meteoapp.model.apirequest;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import ch.supsi.dti.isin.meteoapp.fragments.DetailLocationFragment;

public class WeatherHttpClient{

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static String APPID = "b038aafc4ea3e367b4fb1fed9126b444";

    private static Gson json = new Gson();

    public static void getCurrentWeatherDataByLocation(Location location, DetailLocationFragment context) {
        CurrentWeather currentWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "weather?q=" + location.getName() + "&units=metric" + "&APPID=" + APPID)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            currentWeather = json.fromJson(br, CurrentWeather.class);
            is.close();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }
        System.out.print(currentWeather.getMain().getTemp());
        context.update(currentWeather);
    }

    public static CurrentWeather getCurrentWeatherDataByLocation2(Location location) {
        CurrentWeather currentWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "weather?q=" + location.getName() + "&units=metric" + "&APPID=" + APPID)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            currentWeather = json.fromJson(br, CurrentWeather.class);
            is.close();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }
        return currentWeather;
    }

    public static ForecastWeather getForecastWeatherDataByLocation(Location location) {
        ForecastWeather forecastWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "forecast?q=" + location.getName() + "&units=metric" + "&APPID=" + APPID)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            forecastWeather = json.fromJson(br, ForecastWeather.class);
            is.close();
            con.disconnect();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }
        return forecastWeather;
    }


    public static CurrentWeather getCurrentWeatherDataByLatLon(double lat, double lon) {
        CurrentWeather currentWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "weather?lat=" + lat + "&lon="+ lon + "&units=metric" + "&APPID=" + APPID)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            currentWeather = json.fromJson(br, CurrentWeather.class);
            is.close();
            con.disconnect();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }
        return currentWeather;
    }

    public static ForecastWeather getForecastWeatherDataByLatLon(double lat, double lon) {
        ForecastWeather forecastWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "forecast?lat=" + lat + "&lon="+ lon + "&units=metric" + "&APPID=" + APPID)).openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            forecastWeather = json.fromJson(br, ForecastWeather.class);
            is.close();
            con.disconnect();
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }
        return forecastWeather;
    }
}

