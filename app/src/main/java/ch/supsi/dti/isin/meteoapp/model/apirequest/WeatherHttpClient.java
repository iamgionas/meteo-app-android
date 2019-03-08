package ch.supsi.dti.isin.meteoapp.model.apirequest;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherHttpClient {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static String APPID = "b038aafc4ea3e367b4fb1fed9126b444";

    private Gson json = new Gson();

    public CurrentWeather getCurrentWeatherDataByLocation(String location) {
        CurrentWeather currentWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "weather?q=" + location + "&units=metric" + "&APPID=" + APPID)).openConnection();
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

    public ForecastWeather getForecastWeatherDataByLocation(String location) {
        ForecastWeather forecastWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "forecast?q=" + location + "&units=metric" + "&APPID=" + APPID)).openConnection();
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

    public CurrentWeather getCurrentWeatherDataById(int id) {
        CurrentWeather currentWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "weather?id=" + id + "&units=metric" + "&APPID=" + APPID)).openConnection();
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

    public ForecastWeather getForecastWeatherDataById(int id) {
        ForecastWeather forecastWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "forecast?id=" + id + "&units=metric" + "&APPID=" + APPID)).openConnection();
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

    public CurrentWeather getCurrentWeatherDataByLatLon(double lat, double lon) {
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

    public ForecastWeather getForecastWeatherDataByLatLon(double lat, double lon) {
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

    public CurrentWeather getCurrentWeatherDataByZIPCode(int zipCode) {
        CurrentWeather currentWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "weather?zip=" + zipCode + "&units=metric" + "&APPID=" + APPID)).openConnection();
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

    public ForecastWeather getForecastWeatherDataByZIPCode(int zipCode) {
        ForecastWeather forecastWeather = null;
        HttpURLConnection con = null ;
        InputStream is = null;

        try {
            con = (HttpURLConnection) ( new URL(BASE_URL + "forecast?zip=" + zipCode + "&units=metric" + "&APPID=" + APPID)).openConnection();
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

