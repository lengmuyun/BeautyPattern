package org.geekbang.time.pattern.iterator;

public class ArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;

    /** 不包含标记删除元素 */
    private int actualSize;

    /** 包含标记删除元素 */
    private int totalSize;

    private Object[] elements;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
        this.totalSize = 0;
        this.actualSize = 0;
    }

    public void add(E e) {
        elements[totalSize] = new Element<>(e);
        totalSize++;
        actualSize++;
    }

    public void remove(E e) {
        for (int i=0; i<totalSize; i++) {
            Element<E> currentElement = (Element<E>) elements[i];
            if (currentElement.data.equals(e)) {
                currentElement.delTimestamps = System.currentTimeMillis();
                actualSize--;
            }
        }
    }

    public int getActualSize() {
        return actualSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public E get(int i) {
        checkRange(i);
        Element<E> element = (Element<E>) elements[i];
        return element.data;
    }

    private void checkRange(int i) {
        if (i >= totalSize) {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isExists(int index, long snapshotTimestamp) {
        checkRange(index);
        Element<E> element = (Element<E>) elements[index];
        return element.isExists(snapshotTimestamp);
    }

    public static class Element<E> {

        private E data;
        private long addTimestamps;
        private long delTimestamps;

        public Element(E data) {
            this.data = data;
            this.addTimestamps = System.currentTimeMillis();
            this.delTimestamps = Long.MAX_VALUE;
        }

        public boolean isExists(long snapshotTimestamp) {
            return snapshotTimestamp > addTimestamps && snapshotTimestamp < delTimestamps;
        }

    }

}
