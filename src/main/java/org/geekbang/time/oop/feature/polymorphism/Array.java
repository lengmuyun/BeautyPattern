package org.geekbang.time.oop.feature.polymorphism;

public class Array<E> implements Iterator<E> {

    private Object[] data;
    private int size;
    private int currentPos;

    public Array(int size) {
        data = new Object[size];
        this.size = 0;
        this.currentPos = 0;
    }

    public void add(E e) {
        data[size] = e;
        size++;
    }

    @Override
    public boolean hasNext() {
        return currentPos < size;
    }

    @Override
    public E next() {
        E result = (E) data[currentPos];
        currentPos++;
        return result;
    }

    @Override
    public E move() {
        return null;
    }

}
