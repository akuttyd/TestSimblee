package com.example.android.bluetoothlegatt;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {

    private static final int PERMISSION_ACCESS_COARSE_LOCATION_CODE = 1;
    private static final int PERMISSION_READ_EXTERNAL_STORAGE_CODE = 2;
    private static final int PERMISSION_READ_PHONE_STATE_CODE = 3;
    private static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 4;
    private boolean isPermissionsGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {

            // Using handler with postDelayed called runnable run method

            @Override
            public void run() {

                if (checkAndRequestPermissions()) {
                    Intent i = new Intent(SplashActivity.this, DeviceScanActivity.class);
                    startActivity(i);
                    // close this activity

                    finish();
                }
            }

        }, 100); // wait for 5 seconds

    }


    private boolean checkAndRequestPermissions() {
        int permissionReadPhoneState = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_PHONE_STATE);
        int locationPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION);
        int readExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        List<String> listPermissionsNeeded = new ArrayList<>();
        listPermissionsNeeded.add(Manifest.permission.ACCESS_FINE_LOCATION);

        listPermissionsNeeded.add(Manifest.permission.READ_PHONE_STATE);

        listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSION_ACCESS_COARSE_LOCATION_CODE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //do anything
                } else {
                    Toast.makeText(this, "Permission not granted!",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                break;
            }

            case PERMISSION_READ_EXTERNAL_STORAGE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(this, "Permission not granted!",
                            Toast.LENGTH_LONG).show();
                }
            }
            break;
            case PERMISSION_READ_PHONE_STATE_CODE: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {


                } else {
                    Toast.makeText(this, "Permission not granted for read phone state!",
                            Toast.LENGTH_LONG).show();
                }
            }
            break;
            case REQUEST_ID_MULTIPLE_PERMISSIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Intent i = new Intent(SplashActivity.this, DeviceScanActivity.class);
                    startActivity(i);

                    // close this activity
                    finish();
                } else {
                    Toast.makeText(this, "Permission not granted!",
                            Toast.LENGTH_LONG).show();
                }
            }
            break;
        }
    }


}
