package org.geekbang.time.principle.ocp;

public abstract class Notification {

    protected MsgSender msgSender;

    public Notification(MsgSender msgSender) {
        this.msgSender = msgSender;
    }

    public abstract void notify(String message);

    public enum NotificationEmergencyLevel {
        SEVERE, URGENCY, NORMAL
    }

    public static class SevereNotification extends Notification {

        public SevereNotification(MsgSender msgSender) {
            super(msgSender);
        }

        @Override
        public void notify(String message) {

        }
    }

    public static class UrgencyNotification extends Notification {

        public UrgencyNotification(MsgSender msgSender) {
            super(msgSender);
        }

        @Override
        public void notify(String message) {

        }
    }

    public static class NormalNotification extends Notification {

        public NormalNotification(MsgSender msgSender) {
            super(msgSender);
        }

        @Override
        public void notify(String message) {

        }
    }

}
