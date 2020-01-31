package org.geekbang.time.principle.isp;

import java.util.Map;

public class RedisConfig implements Updater, Viewer {

    /** 配置中心，比如zookeeper */
    private ConfigSource configSource;
    private String address;
    private int timeout;
    private int maxTotal;
    // 省略其他配置: maxWaitMills, maxIdle, minIdle...


    public RedisConfig(ConfigSource configSource) {
        this.configSource = configSource;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public void update() {

    }

    @Override
    public String outputInPlainText() {
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }

}
