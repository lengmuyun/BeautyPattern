package org.geekbang.time.principle.ocp;

public class ApiStatInfo {

    private String api;
    private long requestCount;
    private long errorCount;
    private long timeoutCount;
    private long durationOfSeconds;

    public long getTps() {
        return requestCount / durationOfSeconds;
    }

    public String getApi() {
        return api;
    }

    public long getErrorCount() {
        return errorCount;
    }


    public long getTimeoutTps() {
        return timeoutCount / durationOfSeconds;
    }
}
