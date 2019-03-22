package ch.supsi.dti.isin.meteoapp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ch.supsi.dti.isin.meteoapp.db.CustomCursorWrapper;
import ch.supsi.dti.isin.meteoapp.db.DatabaseHelper;
import ch.supsi.dti.isin.meteoapp.db.DatabaseSchema;
import ch.supsi.dti.isin.meteoapp.model.apirequest.Location;
import io.nlopez.smartlocation.OnLocationUpdatedListener;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.config.LocationAccuracy;
import io.nlopez.smartlocation.location.config.LocationParams;

import static android.content.ContentValues.TAG;

public class LocationsHolder {

    private static LocationsHolder sLocationsHolder;
    private List<Location> mLocations;
    private SQLiteDatabase mDatabase;

    public static LocationsHolder get(Context context) {
        if (sLocationsHolder == null)
            sLocationsHolder = new LocationsHolder(context);

        return sLocationsHolder;
    }

    private LocationsHolder(Context context) {
        mDatabase = new DatabaseHelper(context).getWritableDatabase();

        mLocations = new ArrayList<>();

        Location myPosition = new Location();
        myPosition.setName("My position");

        mLocations.add(myPosition);

        readData();
    }

    private void readData() {
        String res = "Data:";

        CustomCursorWrapper cursor = queryData(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Location location = cursor.getLocation();

                mLocations.add(location);
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
    }

    private CustomCursorWrapper queryData(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                DatabaseSchema.Table.NAME,
                null, // columns - null selects all columns
                whereClause,
                whereArgs,
                null, // groupBy
                null,  // having
                null  // orderBy
        );
        return new CustomCursorWrapper(cursor);
    }

    public List<Location> getLocations() {
        return mLocations;
    }

    public Location getLocation(UUID id) {
        for (Location location : mLocations) {
            if (location.getId().equals(id))
                return location;
        }

        return null;
    }
}
