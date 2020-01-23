package org.geekbang.time.principle.lsp;

public class NoAuthorizationRuntimeException extends RuntimeException {

    public NoAuthorizationRuntimeException(String message) {
        super(message);
    }

}
