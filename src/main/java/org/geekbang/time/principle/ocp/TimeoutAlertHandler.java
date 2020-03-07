package org.geekbang.time.principle.ocp;

public class TimeoutAlertHandler extends AlertHandler {

    public TimeoutAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getTimeoutTps() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTimeoutTps()) {
            notification.notify("...");
        }
    }

}
