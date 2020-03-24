package org.geekbang.time.pattern.responsibility.link;

public abstract class Handler {

    protected Handler successor;

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    public void handle() {
        boolean handled = doHandle();
        if (!handled && successor != null) {
            successor.handle();
        }
    }

    protected abstract boolean doHandle();

}
