package ch.supsi.dti.isin.meteoapp.model.apirequest;

import java.util.List;

public class ForecastWeather {

    private int cod;
    private double message;
    private int cnt;
    private List<WeatherComponents> list;
    private Location city;

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public double getMessage() {
        return message;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<WeatherComponents> getList() {
        return list;
    }

    public void setList(List<WeatherComponents> list) {
        this.list = list;
    }

    public Location getLocation() {
        return city;
    }

    public void setLocation(Location city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "ForecastWeather{" +
                "cod=" + cod +
                ", message=" + message +
                ", cnt=" + cnt +
                ", list=" + list +
                ", city=" + city +
                '}';
    }
}

/* ESEMPIO

   {
   "cod": "200",
   "message": 0.0036,
   "cnt": 40,
   "list": [],
   "city": {
      "id": 524901,
      "name": "Moscow",
      "coord": {
         "lat": 55.7522,
         "lon": 37.6156
      },
      "country": "none"
   }
}

 */

