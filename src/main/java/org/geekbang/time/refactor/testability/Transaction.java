package org.geekbang.time.refactor.testability;

import javax.transaction.InvalidTransactionException;

public class Transaction {

    private String id;
    private Long buyerId;
    private Long sellerId;
    private Long productId;
    private String orderId;
    private Long createTimestamp;
    private double amount;
    private STATUS status;
    private String walletTransactionId;

    private WalletRpcService walletRpcService;
    private TransactionLock lock;

    public Transaction(String preAssignedId, Long buyerId, Long sellerId,
                       Long productId, String orderId) {
        fillTransactionId(preAssignedId);
        this.buyerId = buyerId;
        this.sellerId = sellerId;
        this.productId = productId;
        this.orderId = orderId;
        this.status = STATUS.TO_BE_EXECUTD;
        this.createTimestamp = System.currentTimeMillis();
    }

    private void fillTransactionId(String preAssignedId) {
        if (preAssignedId != null && !preAssignedId.isEmpty()) {
            this.id = preAssignedId;
        } else {
            this.id = IdGenerator.generateTransactionId();
        }
        if (!this.id.startsWith("t_")) {
            this.id = "t_" + preAssignedId;
        }
    }

    public void setWalletRpcService(WalletRpcService walletRpcService) {
        this.walletRpcService = walletRpcService;
    }

    public void setLock(TransactionLock lock) {
        this.lock = lock;
    }

    protected boolean isExpired() {
        long executionInvokedTimestamp = System.currentTimeMillis();
        return executionInvokedTimestamp - createTimestamp > 14 * 24 * 3600 * 1000;
    }

    public boolean execute() throws InvalidTransactionException {
        if (buyerId == null || (sellerId == null || amount < 0.0)) {
            throw new InvalidTransactionException("...");
        }
        if (status == STATUS.EXECUTED) return true;

        boolean isLocked = false;
        try {
            isLocked = lock.lock(id);
            if (!isLocked) {
                return false;
            }

            if (status == STATUS.EXECUTED) {
                return true;
            }

            if (isExpired()) {
                this.status = STATUS.EXPIRED;
                return false;
            }
            String walletTransactionId = walletRpcService.moveMoney(id, buyerId, sellerId, amount);
            if (walletTransactionId != null) {
                this.walletTransactionId = walletTransactionId;
                this.status = STATUS.EXECUTED;
                return true;
            } else {
                this.status = STATUS.FAILED;
                return false;
            }
        } finally {
            if (isLocked) {
                lock.unlock(id);
            }
        }
    }

    public STATUS getStatus() {
        return status;
    }
}
