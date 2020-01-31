package org.geekbang.time.principle.isp;

import java.util.Map;

public class MysqlConfig implements Viewer {

    private ConfigSource configSource;

    public MysqlConfig(ConfigSource configSource) {
        this.configSource = configSource;
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
