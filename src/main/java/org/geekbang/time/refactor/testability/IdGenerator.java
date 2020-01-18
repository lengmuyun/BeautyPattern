package org.geekbang.time.refactor.testability;

import java.util.UUID;

public class IdGenerator {

    public static String generateTransactionId() {
        return UUID.randomUUID().toString().replace('-', ' ');
    }

}
