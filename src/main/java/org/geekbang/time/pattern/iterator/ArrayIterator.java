package org.geekbang.time.pattern.iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayIterator<E> implements Iterator<E> {

    protected int cursor;
    protected ArrayList<E> arrayList;

    protected ArrayIterator() {
    }

    public ArrayIterator(ArrayList<E> list) {
        this.cursor = 0;
        this.arrayList = list;
    }

    @Override
    public boolean hasNext() {
        return cursor != arrayList.size();
    }

    @Override
    public E next() {
        if (cursor >= arrayList.size()) {
            throw new NoSuchElementException();
        }
        E e = arrayList.get(cursor);
        cursor++;
        return e;
    }

}
