package com.communisolve.runningtrackerapp.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.lifecycle.LifecycleService
import com.communisolve.runningtrackerapp.Common.Common
import com.communisolve.runningtrackerapp.Common.Common.ACTION_PAUSE_SERVICE
import com.communisolve.runningtrackerapp.Common.Common.ACTION_START_OR_RESUME_SERVICE
import com.communisolve.runningtrackerapp.Common.Common.ACTION_STOP_SERVICE
import com.communisolve.runningtrackerapp.R
import com.communisolve.runningtrackerapp.ui.MainActivity
import timber.log.Timber

class TrackingService : LifecycleService() {

    var isFirstRun: Boolean = true
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when (it.action) {

                ACTION_START_OR_RESUME_SERVICE -> {
                    if (isFirstRun) {
                        startForeground()
                        isFirstRun = false
                    }else{
                        Timber.d("resuming service")
                    }
                }
                ACTION_PAUSE_SERVICE -> {
                    Timber.d("pause service")
                }
                ACTION_STOP_SERVICE -> {
                    Timber.d("Stopped service")
                }
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    private fun startForeground() {
        val notificationManager =
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel(notificationManager)
        }

        val notificationBuilder = NotificationCompat.Builder(this, Common.NOTIFICATION_CHANNEL_ID)
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
            .setContentTitle("Running App")
            .setContentText("00:00:00")
            .setContentIntent(getMainActivityPendingIntent())

        startForeground(Common.NOTIFICATION_ID, notificationBuilder.build())

    }

    private fun getMainActivityPendingIntent() = PendingIntent.getActivity(
        this,
        0,
        Intent(this, MainActivity::class.java).also {
            it.action = Common.ACTION_SHOW_TRACKING_FRAGMENT
        },
        FLAG_UPDATE_CURRENT
    )

    @RequiresApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel(notificationManager: NotificationManager) {
        val channel = NotificationChannel(
            Common.NOTIFICATION_CHANNEL_ID,
            Common.NOTIFICATION_CHANNEL_Name,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)
    }
}


