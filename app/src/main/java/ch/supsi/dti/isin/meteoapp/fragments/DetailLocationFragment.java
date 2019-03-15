package ch.supsi.dti.isin.meteoapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.UUID;

import ch.supsi.dti.isin.meteoapp.R;
import ch.supsi.dti.isin.meteoapp.model.LocationsHolder;
import ch.supsi.dti.isin.meteoapp.model.apirequest.Location;
import ch.supsi.dti.isin.meteoapp.model.apirequest.WeatherHttpClient;
import ch.supsi.dti.isin.meteoapp.model.apirequest.CurrentWeather;

public class DetailLocationFragment extends Fragment {
    private static final String ARG_LOCATION_ID = "location_id";

    private Location mLocation;
    private TextView mLocationName;
    private TextView mWeatherType;
    private TextView mTemp;
    private TextView mTempMin;
    private TextView mTempMax;

    public static DetailLocationFragment newInstance(UUID locationId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_LOCATION_ID, locationId);

        DetailLocationFragment fragment = new DetailLocationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UUID locationId = (UUID) getArguments().getSerializable(ARG_LOCATION_ID);
        mLocation = LocationsHolder.get(getActivity()).getLocation(locationId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail_location, container, false);
        mLocationName = v.findViewById(R.id.locationName);
        mWeatherType = v.findViewById(R.id.weatherType);
        mTemp = v.findViewById(R.id.temp);
        mTempMin = v.findViewById(R.id.tempMin);
        mTempMax = v.findViewById(R.id.tempMax);

        WeatherHttpClient.getCurrentWeatherDataByLocation(mLocation, this);

        return v;
    }

    public void update(CurrentWeather cw){
        mLocationName.setText(mLocation.getName());
        mWeatherType.setText(cw.getMain().toString());
        mTemp.setText(cw.getMain().getTemp() + "°C");
        mTempMin.setText(Double.toString(cw.getMain().getTemp_min()) + "°C");
        mTempMax.setText(Double.toString(cw.getMain().getTemp_max()) + "°C");
    }
}

