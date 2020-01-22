package org.geekbang.time.principle.ocp;

public class Notification {

    public void notify(NotificationEmergencyLevel level, String message) {

    }

    public enum NotificationEmergencyLevel {
        SEVERE, URGENCY
    }

}
