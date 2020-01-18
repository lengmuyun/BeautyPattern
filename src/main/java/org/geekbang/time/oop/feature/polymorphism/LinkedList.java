package org.geekbang.time.oop.feature.polymorphism;

public class LinkedList<E> implements Iterator<E> {

    /** 头节点，哨兵节点 */
    private LinkedListNode<E> head = new LinkedListNode<>(null);
    private LinkedListNode<E> current = head;

    public void add(E e) {
        LinkedListNode<E> tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = new LinkedListNode<>(e);
    }

    @Override
    public boolean hasNext() {
        return current.next != null;
    }

    @Override
    public E next() {
        E result = current.next.data;
        current = current.next;
        return result;
    }

    @Override
    public E move() {
        return null;
    }

    private class LinkedListNode<E> {

        public E data;
        public LinkedListNode<E> next;

        public LinkedListNode(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }
    }

}
