package com.peyo.overlaytest;

import android.app.Activity;
import android.content.Intent;
import android.provider.Settings;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String TAG = "OverlayTest.Activity";

    @Override
    protected void onResume() {
        super.onResume();
        checkOverlayPermission();
        launchMainService();
        finish();
    }

    private boolean checkOverlayPermission() {
        Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
        startActivity(intent);
        boolean canOverlay = Settings.canDrawOverlays(this);
        Log.i(TAG, "checkOverlayPermission() " + canOverlay);
        return  canOverlay;
    }

    private void launchMainService() {
        Intent svc = new Intent(this, MainService.class);
        stopService(svc);
        startService(svc);
    }
}
