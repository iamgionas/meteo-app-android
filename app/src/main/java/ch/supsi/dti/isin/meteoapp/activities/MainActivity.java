package ch.supsi.dti.isin.meteoapp.activities;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;

import ch.supsi.dti.isin.meteoapp.db.DatabaseHelper;
import ch.supsi.dti.isin.meteoapp.fragments.ListFragment;
import ch.supsi.dti.isin.meteoapp.model.apirequest.Coordinate;
import ch.supsi.dti.isin.meteoapp.model.apirequest.Location;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

import static android.content.ContentValues.TAG;
import ch.supsi.dti.isin.meteoapp.services.NotifyService;


// per richiedere la meteo utilizzare WeatherHttpClient con gli appositi metodi

// per la meteo corrente utilizzare il contenitore CurrentWeather
// per le previsioni meteo future utilizzare il contenitore ForecastWeather

public class MainActivity extends SingleFragmentActivity {

    public static final Location currentLocation = new Location();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Context context = getApplicationContext();
        SQLiteDatabase mDatabase = new DatabaseHelper(context).getWritableDatabase();

        mDatabase.close();

        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.i(TAG, "Permission not granted");
            requestPermissions();
        } else {
            Log.i(TAG, "Permission granted");
            startLocationListener();
        }

        NotifyService.setServiceAlarm(this, true);
    }

    private void startLocationListener() {
        long mLocTrackingInterval = 1000 * 5; // 5 sec
        float trackingDistance = 0;
        LocationAccuracy trackingAccuracy = LocationAccuracy.HIGH;

        LocationParams.Builder builder = new LocationParams.Builder()
                .setAccuracy(trackingAccuracy)
                .setDistance(trackingDistance)
                .setInterval(mLocTrackingInterval);

        SmartLocation.with(this)
                .location()

                .continuous()
                .config(builder.build())
                .start(new OnLocationUpdatedListener() {
                    @Override
                    public void onLocationUpdated(android.location.Location location) {

                        Log.i(TAG, "Location2" + location);
                        Coordinate coordinate = new Coordinate();
                        coordinate.setLat(location.getLatitude());
                        coordinate.setLon(location.getLongitude());

                        currentLocation.setCoord(coordinate);
//                        mAdapter.mLocations.get(0).setName("Lat=" + location.getLatitude() + " / Long=" + location.getLongitude());
                    }
                });
    }

    private void requestPermissions() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        } else {
            startLocationListener();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 0: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    startLocationListener();
                return;
            }
        }
    }

    @Override
    protected Fragment createFragment() {
        return new ListFragment();
    }
}
