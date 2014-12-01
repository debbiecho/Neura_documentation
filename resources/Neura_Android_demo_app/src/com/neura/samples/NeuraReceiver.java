
package com.neura.samples;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.widget.Toast;

import com.neura.sdk.config.NeuraConsts;
import com.neura.sdk.util.NeuraAuthUtil;
import com.neura.sdk.util.NeuraUtil;

public class NeuraReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        String eventName = intent.getStringExtra(NeuraConsts.EXTRA_EVENT_NAME);

        if (action.equalsIgnoreCase(NeuraConsts.ACTION_EVENT_REGISTRATION_RESPONSE)) {
            boolean success = intent.getBooleanExtra(NeuraConsts.EXTRA_SUCCESS, false);

            if (success) {
                Toast.makeText(context, "Registered successfully to event " + eventName, Toast.LENGTH_LONG).show();
            } else {
                int errorCode = intent.getIntExtra(NeuraConsts.EXTRA_ERROR_CODE, -1);
                String error = NeuraUtil.errorCodeToString(errorCode);
                String message = "Registration to event " + eventName + " has failed! error = " + error;
                Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            }

        } else {
            handleNeuraEvent(context, intent, eventName);
        }
    }

    private void handleNeuraEvent(Context context, Intent intent, String eventName) {

        /**
         * you can do whatever you want. in this example we only show notification when event occurs..
         */

        /**
         * the intent Bundle will contain key value pairs of additional parameters related to the event, according to the documentation
         */

        String title = "Neura Event";
        String message = "Event Accured: " + eventName + ", ";

        Uri uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification.Builder(context).setSound(uri).setSmallIcon(R.drawable.ic_launcher).setContentTitle(title)
                .setContentText(message).build();
        notificationManager.notify(45, notification);
    }
}
