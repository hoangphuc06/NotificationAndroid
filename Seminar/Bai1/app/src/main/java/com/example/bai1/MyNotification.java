package com.example.bai1;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.media.AudioAttributes;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;

public class MyNotification extends Application {

    public static final String CHANNEL_ID_1 = "CHANNEL_1";
    public static final String CHANNEL_ID_2 = "CHANNEL_2";
    public static final String CHANNEL_ID_3 = "CHANNEL_3";

    @Override
    public void onCreate() {
        super.onCreate();
        createNotificationChannel();
    }

    private void createNotificationChannel()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            Uri sound = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.sound);
            AudioAttributes attributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_NOTIFICATION).build();

            // Config channel 1
            CharSequence name_1 = getString(R.string.channel_name_1);
            String decription_1 = getString(R.string.channel_decription_1);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel_1 = new NotificationChannel(CHANNEL_ID_1,name_1,importance);
            channel_1.setDescription(decription_1);
            channel_1.setSound(sound,attributes);

            // Config channel 2
            CharSequence name_2 = getString(R.string.channel_name_2);
            String decription_2 = getString(R.string.channel_decription_2);
            int importance_2 = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel_2 = new NotificationChannel(CHANNEL_ID_2,name_2,importance_2);
            channel_2.setDescription(decription_2);
            channel_2.setSound(sound,attributes);

            // Config channel 3
            CharSequence name_3 = getString(R.string.channel_name_3);
            String decription_3 = getString(R.string.channel_decription_3);
            int importance_3 = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel_3 = new NotificationChannel(CHANNEL_ID_3,name_3,importance_3);
            channel_3.setDescription(decription_3);
            channel_3.setSound(sound,attributes);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            if (notificationManager != null) {
                notificationManager.createNotificationChannel(channel_1);
                notificationManager.createNotificationChannel(channel_2);
                notificationManager.createNotificationChannel(channel_3);
            }
        }
    }
}
