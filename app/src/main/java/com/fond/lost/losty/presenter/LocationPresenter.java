package com.fond.lost.losty.presenter;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;

/**
 * Created by Sahar on 19/04/2018.
 */

public class LocationPresenter
{
    private static LocationPresenter mLocationPresenter;
    private LocationManager mLocationManager;

    public LocationPresenter(Context ctx, LocationListener listener)
    {
        mLocationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED)
        {
            mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, listener);
        }
    }

    public static LocationPresenter getInstance(Context ctx, LocationListener listener)
    {
        if(mLocationPresenter == null)
        {
            mLocationPresenter = new LocationPresenter(ctx ,listener);
        }
        return mLocationPresenter;
    }

    public void onDestroy(LocationListener listener)
    {
        mLocationManager.removeUpdates(listener);
    }
}
