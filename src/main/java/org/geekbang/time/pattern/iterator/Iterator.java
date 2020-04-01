package org.geekbang.time.pattern.iterator;

public interface Iterator<E> {

    boolean hasNext();
    void next();
    E currentItem();

}
