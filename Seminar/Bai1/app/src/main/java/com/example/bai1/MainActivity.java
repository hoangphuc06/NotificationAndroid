package com.example.bai1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    Button channel1, channel2, channel3;

    private static final String TITLE_PUSH_NOTIFICATION = "Thông báo: tình hình covid";
    private static final String CONTENT_PUSH_NOTIFICATION = "Bộ trưởng Nguyễn Thanh Long nhấn mạnh quan điểm của Việt Nam là làm thế nào để có thể tiếp cận vaccine phòng COVID-19 nhanh nhất và đảm bảo độ bao phủ tiêm chủng vaccine rộng nhất.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        channel1 = findViewById(R.id.channel1);
        channel2 = findViewById(R.id.channel2);
        channel3 = findViewById(R.id.channel3);

        channel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotificationChannel1();
            }
        });

        channel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotificationChannel2();
            }
        });

        channel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendNotificationChannel3();
                //sendCustomNotification();
            }
        });
    }

    private void sendNotificationChannel1() {

        Notification notification = new NotificationCompat.Builder(this, MyNotification.CHANNEL_ID_1)
                .setContentTitle(TITLE_PUSH_NOTIFICATION)
                .setContentText(CONTENT_PUSH_NOTIFICATION)
                .setSmallIcon(R.drawable.ic_baseline_message)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(CONTENT_PUSH_NOTIFICATION))
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);

    }

    private void sendNotificationChannel2() {

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.thongdiep5k);

        Notification notification = new NotificationCompat.Builder(this, MyNotification.CHANNEL_ID_2)
                .setContentTitle("Title 2")
                .setContentText("Content 2")
                .setSmallIcon(R.drawable.ic_baseline_message)
                .setStyle(new NotificationCompat.BigPictureStyle(bitmap).bigLargeIcon(null))
                .setLargeIcon(bitmap)
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);
    }

    private void sendNotificationChannel3() {

        Notification notification = new NotificationCompat.Builder(this, MyNotification.CHANNEL_ID_3)
                .setContentTitle("Title 3")
                .setContentText("Content 3")
                .setSmallIcon(R.drawable.ic_baseline_message)
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);
    }

    private void sendCustomNotification() {

        // collapsed
        RemoteViews notificationLayout = new RemoteViews(getPackageName(),R.layout.layout_custom_notification);
        notificationLayout.setTextViewText(R.id.tv_title_custom,"Title custom");
        notificationLayout.setTextViewText(R.id.tv_message_custom,"Message custom");

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String strDate = sdf.format(new Date());
        notificationLayout.setTextViewText(R.id.tv_time_custom,strDate);

        // expanded
        RemoteViews notificationLayoutExpanded = new RemoteViews(getPackageName(),R.layout.layout_custom_notification_expanded);
        notificationLayoutExpanded.setTextViewText(R.id.tv_title_custom_expanded,"Title custom");
        notificationLayoutExpanded.setTextViewText(R.id.tv_message_custom_expaned,"Message custom");
        notificationLayoutExpanded.setImageViewResource(R.id.img_custom_expanded,R.drawable.thongdiep5k);

        Notification notification = new NotificationCompat.Builder(this, MyNotification.CHANNEL_ID_3)
                .setSmallIcon(R.drawable.ic_baseline_message)
                .setCustomContentView(notificationLayout)
                .setCustomBigContentView(notificationLayoutExpanded)
                .build();

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(getNotificationId(),notification);
    }

    private int getNotificationId() {
        return (int) new Date().getTime();
    }
}