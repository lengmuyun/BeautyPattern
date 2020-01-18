package org.geekbang.time.refactor.testability;

import java.util.HashSet;
import java.util.Set;

public class RedisDistributedLock {

    private static RedisDistributedLock instance = new RedisDistributedLock();

    private static Set<String> set = new HashSet<>();

    public static RedisDistributedLock getSingletonInstance() {
        return instance;
    }

    public boolean lockTransction(String id) {
        boolean contains = set.contains(id);
        if (contains) {
            return false;
        }
        set.add(id);
        return true;
    }

    public void unlockTransction(String id) {
        set.remove(id);
    }

}
