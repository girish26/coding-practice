package com.gk.designpatterns.structural.bridge;

public class TextNotification extends Notification{

    public TextNotification(NotificationSender notificationSender) {
        super(notificationSender);
    }

    @Override
    public void send() {
        notificationSender.sendNotification();
    }
}
