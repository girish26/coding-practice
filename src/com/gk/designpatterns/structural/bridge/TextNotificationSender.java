package com.gk.designpatterns.structural.bridge;

public class TextNotificationSender implements NotificationSender{

    @Override
    public void sendNotification() {
        System.out.println("Sending text notification");
    }

}
