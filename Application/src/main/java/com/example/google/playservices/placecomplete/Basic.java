package com.example.google.playservices.placecomplete;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

import com.example.android.common.activities.SampleActivityBase;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

import static com.example.android.common.activities.SampleActivityBase.TAG;

public class Basic extends Activity {

    //https://sunny89blog.wordpress.com/category/android-autoplacecomplete/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);

        // Retrieve the PlaceAutocompleteFragment.
        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.autocomplete_fragment);

// Register a listener to receive callbacks when a place has been selected or an error has
// occurred.
        autocompleteFragment.setOnPlaceSelectedListener(new PlaceSelectionListener() {
            @Override
            public void onPlaceSelected(Place place) {
                // TODO: Get info about the selected place.
                Log.i(TAG, "Place: " + place.getName());
                Log.i(TAG, "Place Selected: " + place.getName() + "  " + place.getLatLng());

                double workLatitude = place.getLatLng().latitude;
                double workLongitude = place.getLatLng().longitude;

                //Over we can get the address, rating, price level,etc.

            }

            @Override
            public void onError(Status status) {
                // TODO: Handle the error.
                Log.i(TAG, "An error occurred: " + status);
            }
        });

    }

}
