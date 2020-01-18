package org.geekbang.time.refactor.testability;

public class TransactionLock {

    public boolean lock(String id) {
        return RedisDistributedLock.getSingletonInstance().lockTransction(id);
    }

    public void unlock(String id) {
        RedisDistributedLock.getSingletonInstance().unlockTransction(id);
    }

}
