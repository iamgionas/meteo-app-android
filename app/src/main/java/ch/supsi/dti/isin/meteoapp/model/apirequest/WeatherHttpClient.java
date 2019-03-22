package ch.supsi.dti.isin.meteoapp.model.apirequest;

import android.os.AsyncTask;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import ch.supsi.dti.isin.meteoapp.fragments.DetailLocationFragment;
import ch.supsi.dti.isin.meteoapp.fragments.Updateable;

public class WeatherHttpClient extends AsyncTask<URL, Integer, CurrentWeather> {

    private static String BASE_URL = "http://api.openweathermap.org/data/2.5/";
    private static String APPID = "b038aafc4ea3e367b4fb1fed9126b444";

    private static Gson json = new Gson();
    private Updateable context;

    public WeatherHttpClient(Updateable context){
        this.context = context;
    }

    public void getCurrentWeatherDataByLocation(Location location) {
        URL u = null;
        try {
            u = new URL(BASE_URL + "weather?q=" + location.getName() + "&units=metric" + "&APPID=" + APPID);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        this.execute(u);
    }

    @Override
    protected void onPostExecute(CurrentWeather currentWeather) {
        super.onPostExecute(currentWeather);
        context.update(currentWeather);
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

    @Override
    protected CurrentWeather doInBackground(URL... urls) {
        HttpURLConnection con = null;
        InputStream is = null;
        CurrentWeather currentWeather = null;
        try {
            con = (HttpURLConnection) urls[0].openConnection();
            con.setRequestMethod("GET");
            con.setDoInput(true);
            con.setDoOutput(true);
            con.connect();

            // Let's read the response
            is = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            currentWeather = json.fromJson(br, CurrentWeather.class);
            is.close();
        } catch(Throwable t) {
            t.printStackTrace();
        }
        finally {
            try { is.close(); } catch(Throwable t) {}
            try { con.disconnect(); } catch(Throwable t) {}
        }
        return currentWeather;
    }
}

