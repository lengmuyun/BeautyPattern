package org.geekbang.time.principle.ocp;

public class ApplicationContext {

    private AlertRule alertRule;
    private Notification notification;
    private Alert alert;

    private static ApplicationContext instance = new ApplicationContext();

    private ApplicationContext() {
        initializeBeans();
    }

    public static ApplicationContext getInstance() {
        return instance;
    }

    public void initializeBeans() {
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert();
        alert.addHandler(new TpsAlertHandler(alertRule, notification));
        alert.addHandler(new ErrorAlertHandler(alertRule, notification));
        alert.addHandler(new TimeoutAlertHandler(alertRule, notification));
    }

    public Alert getAlert() {
        return alert;
    }

}
