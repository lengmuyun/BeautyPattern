package org.geekbang.time.pattern.singleton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private FileWriter writer;
    private static final Logger instance = new Logger();

    private Logger() {
        try {
            File file = new File("/Users/wangzheng/log.txt");
            writer = new FileWriter(file, true);
        } catch (IOException e) {
            throw new RuntimeException("create logger failed!");
        }
    }

    public static Logger getInstance() {
        return instance;
    }

    public void log(String message) throws IOException {
        synchronized (Logger.class) {
            writer.write(message);
        }
    }

}
