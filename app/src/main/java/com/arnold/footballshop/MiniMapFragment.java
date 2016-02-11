package com.arnold.footballshop;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Arnold on 21.01.2016.
 */
public class MiniMapFragment extends SupportMapFragment implements OnBackPressedListener {
    static final LatLng SHOP_LOC = new LatLng(49.9787615, 36.2718146);

    @Override
    public void onResume() {
        super.onResume();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    @Override
    public void onPause() {
        super.onPause();
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
    }

    @Override
    public View onCreateView(LayoutInflater arg0, ViewGroup arg1, Bundle arg2) {
        View v = super.onCreateView(arg0, arg1, arg2);
        initMap();
        return v;
    }

    private void initMap() {
        try {


            GoogleMap map = getMap();
            UiSettings settings = map.getUiSettings();
            settings.setAllGesturesEnabled(true);
            settings.setMyLocationButtonEnabled(false);
            settings.setZoomControlsEnabled(true);
            settings.setZoomGesturesEnabled(true);
            settings.setCompassEnabled(true);


            map.addMarker(new MarkerOptions()
                    .position(SHOP_LOC)
                    .title(getResources().getString(R.string.app_name))
                    .snippet("Полевая 44"));
            // .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
            //   map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
            //  map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
            // map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            //  map.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
            map.animateCamera(CameraUpdateFactory.newLatLngZoom(SHOP_LOC, 16), 2000, null);
        } catch (NullPointerException e)
        {
            Toast.makeText(getContext(), "Не удается получить данные Google Map", Toast.LENGTH_SHORT);
        }

        // Zoom in, animating the camera.
 //   map.animateCamera(CameraUpdateFactory.zoomTo(16), 2000, null);
         }

    @Override
    public void onBackPressed() {
        MainActivity.startFragment(new InfoAdressFragment());
    }
}