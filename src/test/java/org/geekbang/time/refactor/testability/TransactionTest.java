package org.geekbang.time.refactor.testability;

import org.junit.Before;
import org.junit.Test;

import javax.transaction.InvalidTransactionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TransactionTest {

    private TransactionLock mockTransactionLock;
    private WalletRpcService mockWalletRpcServiceOne;
    private WalletRpcService mockWalletRpcServiceTwo;
    private WalletRpcService mockDelayWalletRpcService;

    @Before
    public void initialize() {
        mockTransactionLock = new TransactionLock() {
            @Override
            public boolean lock(String id) {
                return true;
            }

            @Override
            public void unlock(String id) {
            }
        };
        mockWalletRpcServiceOne = (id, buyerId, sellerId, amount) -> "abc123";
        mockWalletRpcServiceTwo = (id, buyerId, sellerId, amount) -> null;
        mockDelayWalletRpcService = (id, buyerId, sellerId, amount) -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ignored) {
            }
            return "abc123";
        };
    }

    /**
     * 1.正常情况下，交易执行成功，回填用于对账（交易与钱包的交易流水）用的 walletTransactionId，交易状态设置为 EXECUTED，函数返回 true。
     * @throws InvalidTransactionException
     */
    @Test
    public void testExecuteNormal() throws InvalidTransactionException {
        Transaction transaction = new Transaction(null, 123L, 234L, 345L, "456");
        transaction.setWalletRpcService(mockWalletRpcServiceOne);
        transaction.setLock(mockTransactionLock);
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

    /**
     * 3. 交易已过期（createTimestamp 超过 14 天），交易状态设置为 EXPIRED，返回 false。
     * @throws InvalidTransactionException
     */
    @Test
    public void testExecuteWithTransactionIsExpired() throws InvalidTransactionException {
        Transaction transaction = new Transaction(null, 123L, 234L, 345L, "456") {

            @Override
            protected boolean isExpired() {
                return true;
            }

        };
        transaction.setLock(new TransactionLock());
        transaction.setWalletRpcService((id, buyerId, sellerId, amount) -> null);
        boolean actualResult = transaction.execute();
        assertFalse(actualResult);
        assertEquals(STATUS.EXPIRED, transaction.getStatus());
    }

    /**
     * 4.交易已经执行了（status==EXECUTED），不再重复执行转钱逻辑，返回 true。
     */
    @Test
    public void testTransactionExecuted() throws InvalidTransactionException {
        Transaction transaction = new Transaction(null, 123L, 234L, 345L, "456");
        transaction.setWalletRpcService(mockWalletRpcServiceOne);
        transaction.setLock(mockTransactionLock);
        boolean executedResult = transaction.execute();
        assertTrue(executedResult);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());

        transaction.setWalletRpcService(null);
        boolean execute = transaction.execute();
        assertTrue(execute);
        assertEquals(STATUS.EXECUTED, transaction.getStatus());
    }

    /**
     * 5.钱包（WalletRpcService）转钱失败，交易状态设置为 FAILED，函数返回 false。
     */
    @Test
    public void testTransactionFailed() throws InvalidTransactionException {
        Transaction transaction = new Transaction(null, 123L, 234L, 345L, "456");
        transaction.setWalletRpcService(mockWalletRpcServiceTwo);
        transaction.setLock(mockTransactionLock);
        boolean executedResult = transaction.execute();
        assertFalse(executedResult);
        assertEquals(STATUS.FAILED, transaction.getStatus());
    }

    /**
     * 6.交易正在执行着，不会被重复执行，函数直接返回 false。
     */
    @Test
    public void testTransactionExecuting() throws InterruptedException {
        Transaction transaction = new Transaction(null, 123L, 234L, 345L, "456");
        transaction.setWalletRpcService(mockDelayWalletRpcService);
        transaction.setLock(new TransactionLock());
        new Thread(() -> {
            try {
                transaction.execute();
            } catch (InvalidTransactionException e) {
            }
        }).start();

        Thread.sleep(50);
        Thread thread2 = new Thread(() -> {
            try {
                boolean execute = transaction.execute();
                assertFalse(execute);
            } catch (InvalidTransactionException e) {
            }
        });
        thread2.start();
        thread2.join();
    }

}