package ch.supsi.dti.isin.meteoapp.model.apirequest;

import java.util.List;

public class WeatherComponents {

    private int dt;
    private MainWeatherExtra main;
    private List<Weather> weather;
    private Clouds clouds;
    private Wind wind;
    private String snow;
    private SysExtra sys;
    private String dt_txt;

    public int getDt() {
        return dt;
    }

    public void setDt(int dt) {
        this.dt = dt;
    }

    public MainWeatherExtra getMain() {
        return main;
    }

    public void setMain(MainWeatherExtra main) {
        this.main = main;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getSnow() {
        return snow;
    }

    public void setSnow(String snow) {
        this.snow = snow;
    }

    public SysExtra getSys() {
        return sys;
    }

    public void setSys(SysExtra sys) {
        this.sys = sys;
    }

    public String getDt_txt() {
        return dt_txt;
    }

    public void setDt_txt(String dt_txt) {
        this.dt_txt = dt_txt;
    }

    @Override
    public String toString() {
        return "WeatherComponents{" +
                "dt=" + dt +
                ", main=" + main +
                ", weather=" + weather +
                ", clouds=" + clouds +
                ", wind=" + wind +
                ", snow='" + snow + '\'' +
                ", sys=" + sys +
                ", dt_txt='" + dt_txt + '\'' +
                '}';
    }
}

