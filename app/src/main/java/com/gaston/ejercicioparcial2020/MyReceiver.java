package com.gaston.ejercicioparcial2020;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyReceiver extends BroadcastReceiver {
    public static final String EVENTO_01="evento";
    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(context.getApplicationContext() , NOTIFICATION_CHANNEL_ID)
                        .setContentTitle("Informacion ingresada")
                        .setContentText(intent.getExtras().getString("data1")+ "--"+ intent.getExtras().getString("data2")+ "--"+
                                intent.getExtras().getString("data3")+ "--"+ intent.getExtras().getString("data4"))
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context.getApplicationContext());
        notificationManager.notify(99, mBuilder.build());
    }
}