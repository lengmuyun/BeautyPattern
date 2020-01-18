package org.geekbang.time.oop.feature.polymorphism;

public class DynamicArray {

    private static final int DEFAULT_CAPACITY = 10;
    protected int size = 0;
    protected int capacity = DEFAULT_CAPACITY;
    protected Integer[] elements = new Integer[DEFAULT_CAPACITY];

    public int size() {
        return size;
    }

    public Integer get(int index) {
        return elements[index];
    }

    public void add(Integer e) {
        ensureCapactiy();
        elements[size++] = e;
    }

    protected void ensureCapactiy() {
        // 如果数组满了就扩容
    }

}
