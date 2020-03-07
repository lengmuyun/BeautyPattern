package org.geekbang.time.principle.ocp;

public class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getTps() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            notification.notify("...");
        }
    }

}
