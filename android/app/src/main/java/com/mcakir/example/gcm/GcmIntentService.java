package com.mcakir.example.gcm;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.text.TextUtils;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.mcakir.example.R;
import com.mcakir.example.log.Logger;
import com.mcakir.example.ui.PushNotificationActivity;

public class GcmIntentService extends IntentService {

    private final static Logger logger = Logger.getLogger(GcmIntentService.class.getName());

    public GcmIntentService() {
        super(GcmIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Bundle bundle = intent.getExtras();

        if(bundle != null){

            GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);
            String messageType = gcm.getMessageType(intent);

            String message = bundle.getString("title");

            if (GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE.equals(messageType)
                    && !TextUtils.isEmpty(message)) {

                sendNotification(message);

            }

            // handle other message types

            GcmBroadcastReceiver.completeWakefulIntent(intent);
        }
    }

    private void sendNotification(String msg) {

        Intent displayIntent  = new Intent(this, PushNotificationActivity.class);
        displayIntent.putExtra(PushNotificationActivity.EXTRA_PUSH_MESSAGE_KEY, msg);

        PendingIntent contentIntent = TaskStackBuilder.create(this)
                .addNextIntentWithParentStack(displayIntent)
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this)
                        .setContentTitle(getResources().getString(R.string.app_name))
                        .setStyle(new NotificationCompat.BigTextStyle().bigText(msg))
                        .setContentText(msg)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                        .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});

        builder.setAutoCancel(true);
        builder.setContentIntent(contentIntent);

        NotificationManager notificationManager = (NotificationManager) this.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, builder.build());
    }
}
