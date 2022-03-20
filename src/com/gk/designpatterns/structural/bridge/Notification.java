package com.gk.designpatterns.structural.bridge;

public abstract class Notification {
    NotificationSender notificationSender;
    public Notification(NotificationSender notificationSender) {
        this.notificationSender = notificationSender;
    }

    abstract public void send();
}
