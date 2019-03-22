package ch.supsi.dti.isin.meteoapp.services;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import java.util.List;
import java.util.concurrent.TimeUnit;

import ch.supsi.dti.isin.meteoapp.activities.MainActivity;
import ch.supsi.dti.isin.meteoapp.fragments.Updateable;
import ch.supsi.dti.isin.meteoapp.model.LocationsHolder;
import ch.supsi.dti.isin.meteoapp.model.apirequest.Coordinate;
import ch.supsi.dti.isin.meteoapp.model.apirequest.CurrentWeather;
import ch.supsi.dti.isin.meteoapp.model.apirequest.Location;
import ch.supsi.dti.isin.meteoapp.model.apirequest.WeatherHttpClient;

public class NotifyService extends IntentService implements Updateable {
    private static final String TAG = "TestService";
    private static final int tempMax = 5;

    private static final long POLL_INTERVAL_MS = TimeUnit.MINUTES.toMillis(1); // min. is 1 minute!

    public NotifyService() {
        super(TAG);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, NotifyService.class);
    }

    public static void setServiceAlarm(Context context, boolean isOn) {
        Intent i = NotifyService.newIntent(context);
        PendingIntent pi = PendingIntent.getService(context, 0, i, 0);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (isOn)
            alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), POLL_INTERVAL_MS, pi);
        else {
            alarmManager.cancel(pi);
            pi.cancel();
        }
    }

    private static int sI = 0;

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Received an intent: " + intent);

        WeatherHttpClient w = new WeatherHttpClient(this);

        if(MainActivity.currentLocation.getCoord() != null) {
            w.getCurrentWeatherDataByLatLon(MainActivity.currentLocation.getCoord().getLat(),
                    MainActivity.currentLocation.getCoord().getLon());
        }
    }

    private void sendNotification(int i) {
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("default", "TEST_CHANNEL", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Test Channel Description");
            mNotificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, "default")
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentTitle("Alert Temperatura")
                .setContentText("Temperatura superata: " + i)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        mNotificationManager.notify(0, mBuilder.build());
    }

    @Override
    public void update(CurrentWeather currentWeather) {
        if(currentWeather == null)
            return;
        if(tempMax < (int)currentWeather.getMain().getTemp()){
            sendNotification((int)currentWeather.getMain().getTemp());
        }
    }
}

