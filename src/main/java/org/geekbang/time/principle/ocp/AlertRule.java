package org.geekbang.time.principle.ocp;

import java.util.HashMap;
import java.util.Map;

public class AlertRule {

    private Map<String, ApiRule> apiRuleMap = new HashMap<>();

    ApiRule getMatchedRule(String api) {
        return apiRuleMap.get(api);
    }

    public class ApiRule {

        private long maxTps;
        private long maxErrorCount;
        private long maxTimeoutTps;

        public ApiRule(long maxTps, long maxErrorCount, long maxTimeoutTps) {
            this.maxTps = maxTps;
            this.maxErrorCount = maxErrorCount;
            this.maxTimeoutTps = maxTimeoutTps;
        }

        long getMaxTps() {
            return maxTps;
        }

        long getMaxErrorCount() {
            return maxErrorCount;
        }

        public long getMaxTimeoutTps() {
            return maxTimeoutTps;
        }
    }
}
