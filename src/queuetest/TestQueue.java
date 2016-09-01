package queuetest;


import java.util.NoSuchElementException;

/**
 *
 * @author Игорь
 */
public class TestQueue<E> {

    private Node first = null;
    private Node last = null;
    private int count = 0;

    public TestQueue() {
    }

    private class Node {

        private Node next = null;
        private E content = null;

        Node(Node next, E content) {
            this.next = next;
            this.content = content;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public E getContent() {
            return content;
        }

        public void setContent(E content) {
            this.content = content;
        }

    }

    /**
     * Inserts the specified element into this queue if it is possible to do so
     * immediately without violating capacity restrictions.
     *
     * @param e the element to add
     * @return {@code true} if the element was added to this queue, else
     * {@code false}
     */
    public boolean offer(E e) {
        Node t = null;
        if (first == null) {
            t = new Node(null, e);
            first = t;
            last = t;
            count++;
        } else {
            t = new Node(null, e);
            last.setNext(t);
            last = t;
            count++;
        }
        return true;
    }

    /**
     * Retrieves and removes the head of this queue, or returns {@code null} if
     * this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public E poll() {
        Node t = null;
        E e = null;
        if (first == null) {
            return e;
        } else {
            e = first.getContent();
            t = first.getNext();
            first = t;
            count--;
        }
        return e;
    }

    /**
     * Retrieves and removes the head of this queue. This method differs from
     * {@link #poll poll} only in that it throws an exception if this queue is
     * empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public E remove() {
        Node t = null;
        E e = null;
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            e = first.getContent();
            t = first.getNext();
            first = t;
            count--;
        }
        return e;
    }

    /**
     * Retrieves, but does not remove, the head of this queue, or returns
     * {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    public E peek() {
        Node t = null;
        E e = null;
        if (first == null) {
            return e;
        } else {
            e = first.getContent();
        }
        return e;
    }

    /**
     * Retrieves, but does not remove, the head of this queue. This method
     * differs from {@link #peek peek} only in that it throws an exception if
     * this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    public E element() {
        Node t = null;
        E e = null;
        if (first == null) {
            throw new NoSuchElementException();
        } else {
            e = first.getContent();
        }
        return e;
    }

    /**
     * Tests if this stack is empty.
     *
     * @return  <code>true</code> if and only if this stack contains no items;
     * <code>false</code> otherwise.
     */
    public boolean isEmpty() {
        return count == 0;
    }

}
