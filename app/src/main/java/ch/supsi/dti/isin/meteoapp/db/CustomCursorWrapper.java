package ch.supsi.dti.isin.meteoapp.db;


import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

import ch.supsi.dti.isin.meteoapp.model.apirequest.Location;

public class CustomCursorWrapper extends CursorWrapper {

    public CustomCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    public Location getLocation() {
        String name = getString(getColumnIndex(DatabaseSchema.Table.Cols.LOCATION));

        return new Location(name);
    }
}