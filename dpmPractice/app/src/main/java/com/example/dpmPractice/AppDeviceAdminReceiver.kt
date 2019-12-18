package com.example.dpmPractice

import android.app.admin.DeviceAdminReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AppDeviceAdminReceiver : DeviceAdminReceiver() {
    override fun onEnabled(context: Context, intent: Intent) {
        super.onEnabled(context, intent)
        Log.d(TAG, "Admin onEnabled")
    }

    override fun onDisabled(context: Context, intent: Intent){
        super.onDisabled(context, intent)
        Log.d(TAG, "Admin Disabled")
    }
    companion object {
        private val TAG = AppDeviceAdminReceiver::class.java.simpleName
    }
}