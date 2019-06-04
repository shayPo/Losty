package com.fond.lost.losty.view

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.CompoundButton
import android.widget.TextView
import android.widget.Toast
import com.fond.lost.losty.R
import com.fond.lost.losty.presenter.LocationPresenter
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.common.GooglePlayServicesRepairableException
import com.google.android.gms.location.places.ui.PlaceAutocomplete
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_search.*


class SearchByLocationActivity : BaseActivity(), CompoundButton.OnCheckedChangeListener, LocationListener, OnMapReadyCallback, View.OnClickListener, GoogleMap.OnMapLongClickListener {

    private var PLACE_AUTOCOMPLETE_REQUEST_CODE: Int = 1;

    private var mMap: GoogleMap? = null
    private var mMoveMap: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addContentView(R.layout.activity_search)
        init()
    }

    override fun init() {
        super.init()
        locationbutton.setOnCheckedChangeListener(this)
        location_text.setOnClickListener(this)
        var mapFragment: MapFragment = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        mMap = p0
        mMap!!.getUiSettings().setMyLocationButtonEnabled(true)
        mMap!!.getUiSettings().setMapToolbarEnabled(false)
        mMap!!.setOnMapLongClickListener(this)
        val position = LatLng(32.027986, 35.106684)

        //mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(position, 6.5f))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(position, mMap!!.maxZoomLevel - 2))
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PLACE_AUTOCOMPLETE_REQUEST_CODE) {

            if (resultCode == Activity.RESULT_OK) {
                val place = PlaceAutocomplete.getPlace(this, data)

                if (place != null) {
                    location_text.setText(place.address, TextView.BufferType.EDITABLE);
                    moveMap(place.latLng)
                }

            } else if (resultCode == PlaceAutocomplete.RESULT_ERROR) {
                val status = PlaceAutocomplete.getStatus(this, data)
                Toast.makeText(this, "status" + status, Toast.LENGTH_LONG).show()
            } else if (resultCode == Activity.RESULT_CANCELED) {
                // The user canceled the operation.
            }
        }
    }

    override fun onMapLongClick(p0: LatLng?) {
        if (p0 != null) {
            var geocoder = Geocoder(this)
            val list: MutableList<Address>? = geocoder.getFromLocation(p0.latitude, p0.longitude, 1)
            var address = ""

            if (list != null && list.size > 0) {
                address = list[0].getAddressLine(0)
            }
            mMap!!.addMarker(MarkerOptions().position(p0)
                    .title(address));
        }
    }

    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.location_text ->
                try {
                    var intent: Intent =
                            PlaceAutocomplete.IntentBuilder(PlaceAutocomplete.MODE_FULLSCREEN)
                                    .build(this);
                    startActivityForResult(intent, PLACE_AUTOCOMPLETE_REQUEST_CODE);
                } catch (e: GooglePlayServicesRepairableException) {
                    // TODO: Handle the error.
                } catch (e: GooglePlayServicesNotAvailableException) {
                    // TODO: Handle the error.
                }
        }
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        if (p1) {
            //on
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 0)
                } else {
                    mMap?.setMyLocationEnabled(true)
                    LocationPresenter.getInstance(this, this)
                    mMoveMap = true
                }
            } else {
                mMap?.setMyLocationEnabled(true)
                LocationPresenter.getInstance(this, this)
                mMoveMap = true
            }

        }
        //off
        else {
            mMap?.setMyLocationEnabled(false)
            LocationPresenter.getInstance(this, this).onDestroy(this)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            mMap?.setMyLocationEnabled(true)
            LocationPresenter.getInstance(this, this)
        } else {
            locationbutton.isChecked = false
        }
    }

    private fun setAddresses(latitude: Double, longitude: Double) {
        var addresses: List<Address>
        val geocoder = Geocoder(this)
        addresses = geocoder.getFromLocation(latitude, longitude, 1);
        if (addresses != null && addresses.size > 0) {
            var address: Address = addresses.get(0)

            //var street: String = address.getAddressLine(0)
            var street: String = address.getThoroughfare()
            location_text.text = street
        }
    }

    override fun onStatusChanged(p0: String?, p1: Int, p2: Bundle?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderDisabled(p0: String?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLocationChanged(p0: Location?) {
        if(mMoveMap)
        {
            mMoveMap = false
            setAddresses(p0?.latitude!!, p0?.longitude!!)
            moveMap(LatLng(p0?.latitude!!, p0?.longitude!!))
        }
    }

    private fun moveMap(latLong: LatLng) {
        mMap!!.moveCamera(CameraUpdateFactory.zoomTo(16.0F))
        mMap!!.moveCamera(CameraUpdateFactory.newLatLng(latLong))
    }


    override fun back(): Boolean {
        return true
    }

    override fun onDestroy() {
        LocationPresenter.getInstance(this, this).onDestroy(this)
        super.onDestroy()
    }
}