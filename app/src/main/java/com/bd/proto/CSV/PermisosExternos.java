package com.bd.proto.CSV;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

public class PermisosExternos {


    public int API_VERSION = Build.VERSION.SDK_INT;
    private static final int REQUEST_EXTERNAL_STORAGE = 1;
    private static String[] PERMISSIONS_STORAGE = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    public PermisosExternos() {}
    // Note call this method
    public static void verifyStoragePermissions(Activity activity) {
        int permission = ActivityCompat.checkSelfPermission(
                activity,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);

        if(permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    activity,
                    PERMISSIONS_STORAGE,
                    REQUEST_EXTERNAL_STORAGE
            );
        }
    }
}