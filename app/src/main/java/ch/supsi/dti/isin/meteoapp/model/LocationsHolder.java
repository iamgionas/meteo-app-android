package ch.supsi.dti.isin.meteoapp.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ch.supsi.dti.isin.meteoapp.db.CustomCursorWrapper;
import ch.supsi.dti.isin.meteoapp.db.DatabaseHelper;
import ch.supsi.dti.isin.meteoapp.db.DatabaseSchema;
import ch.supsi.dti.isin.meteoapp.model.apirequest.Location;

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
