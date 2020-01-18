package org.geekbang.time.oop.feature.polymorphism;

public interface Iterator<E> {

    boolean hasNext();
    E next();
    E move();

}
