package com.gaston.ejercicioparcial2020;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.core.app.NotificationCompat;

public class MyReceiver extends BroadcastReceiver {
    public static final String EVENTO_01="evento";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        throw new UnsupportedOperationException("Not yet implemented");

        /*NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this , EVENTO_01)
                        .setContentTitle("Informacion ingresada")
                        .setContentText(intent.getExtras().getString("data1")+ "--"+ intent.getExtras().getString("data2")+ "--"+ intent.getExtras().getString("data3")+ "--"+ intent.getExtras().getString("data4"));
                        //.setPriority(NotificationCompat.PRIORITY_DEFAULT);*/

    }
}