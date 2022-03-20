package com.gk.designpatterns.structural.bridge;

public class NotificationSenderImplementation {
    public static void main(String[] args) {
        NotificationSender notificationSender = new TextNotificationSender();
        Notification textNotification = new TextNotification(notificationSender);
        textNotification.send();
    }
}
