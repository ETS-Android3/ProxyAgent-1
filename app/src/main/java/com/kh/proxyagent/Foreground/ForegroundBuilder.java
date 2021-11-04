package com.kh.proxyagent.Foreground;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import com.kh.proxyagent.MainActivity;
import com.kh.proxyagent.R;

import static com.kh.proxyagent.Foreground.NotificationApp.CHANNEL_ID;

public class ForegroundBuilder extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Proxy Agent is On")
                .setContentText("Proxy Agent is currently sending data to you BurpSuite :)")
                .setSmallIcon(R.drawable.foreground_icon)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);

        return START_NOT_STICKY;
    }

    // not useful but required to implement
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
