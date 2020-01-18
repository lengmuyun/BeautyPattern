package org.geekbang.time.refactor.testability;

public interface WalletRpcService {

    String moveMoney(String id, Long buyerId, Long sellerId, Double amount);

}
