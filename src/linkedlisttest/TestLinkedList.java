package linkedlisttest;

import java.util.Arrays;
import listtest.TestList;

/**
 *
 * @author Игорь
 */
public class TestLinkedList implements TestList {

    private int count = 0;

    private Node first = null;
    private Node last = null;

    TestLinkedList() {
    }

    class Node {

        private Node priv = null;
        private Node next = null;
        private int num;
        private Object content = null;

        Node(Node priv, Node next, int num, Object content) {
            this.priv = priv;
            this.next = next;
            this.num = num;
            this.content = content;
        }

        public Node getPriv() {
            return priv;
        }

        public void setPriv(Node priv) {
            this.priv = priv;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public Object getContent() {
            return content;
        }

        public void setContent(Object content) {
            this.content = content;
        }

    }

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * @param o element to be appended to this list
     * @return <tt>true</tt>
     */
    @Override
    public boolean add(Object o) {
        Node t = null;
        if (count == 0) {
            t = new Node(null, null, count++, o);
            first = t;
            last = t;
        } else {
            t = new Node(last, null, count++, o);
            last.setNext(t);
            last = t;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TestLinkedList{" + Arrays.toString(toArray()) + '}';
    }

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    @Override
    public Object[] toArray() {
        Node t1 = first;
        Object[] arr = new Object[count];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = t1.getContent();
            t1 = t1.getNext();
        }
        return arr;
    }

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present (optional operation).
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        Node t1 = first;
        for (int i = 0; i < count; i++) {
            if (o == t1.getContent()) {
                if (i == 0) {
                    first = t1.getNext();
                    t1.getNext().setPriv(null);
                    count--;
                    return true;
                } else {
                    Node tn = t1.getNext();
                    Node tp = t1.getPriv();
                    tn.setPriv(tp);
                    tp.setNext(tn);
                    count--;
                    return true;
                }
            }
            t1 = t1.getNext();
        }
        return false;
    }

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    @Override
    public Object set(int index, Object element) {
        if (index < 0 || index > (count - 1)) {
            throw new IllegalArgumentException();
        }
        Object r = null;
        Node t1 = first;
        for (int i = 0; i < count; i++) {
            if (index == t1.getNum()) {
                r = t1.getContent();
                t1.setContent(element);
            }
            t1 = t1.getNext();
        }
        return r;
    }

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    @Override
    public void add(int index, Object element) {
        if (index < 0 || index > (count - 1)) {
            throw new IllegalArgumentException();
        }
        Node t = null;
        Node t1 = first;
        for (int i = 0; i < count; i++) {
            if (index == t1.getNum()) {
                if (index == 0) {
                    t = new Node(null, t1, index, element);
                    t1.setPriv(t);
                    first = t;
                    count++;
                    updateNum();
                    return;
                } else {
                    Node tp = t1.getPriv();
                    t = new Node(tp, t1, index, element);
                    tp.setNext(t);
                    t1.setPriv(t);
                    count++;
                    updateNum();
                    return;
                }
            }
            t1 = t1.getNext();
        }
    }

    private void updateNum() {
        Node t2 = first;
        for (int i = 0; i < count; i++) {
            t2.setNum(i);
            t2 = t2.getNext();
        }
    }

    /**
     * Removes the element at the specified position in this list (optional
     * operation).
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    @Override
    public Object remove(int index) {
        Node t1 = first;
        for (int i = 0; i < count; i++) {
            if (index == t1.getNum()) {
                if (i == 0) {
                    first = t1.getNext();
                    t1.getNext().setPriv(null);
                    count--;
                    return true;
                } else {
                    Node tn = t1.getNext();
                    Node tp = t1.getPriv();
                    tn.setPriv(tp);
                    tp.setNext(tn);
                    count--;
                    return true;
                }
            }
            t1 = t1.getNext();
        }
        return false;
    }

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    @Override
    public boolean contains(Object o) {
        Node t1 = first;
        for (int i = 0; i < count; i++) {
            if (o == t1.getContent()) {
                return true;
            }
            t1 = t1.getNext();
        }
        return false;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public Object get(int index) {
        if (index < 0 || index > count - 1) {
            throw new IndexOutOfBoundsException();
        }
        Node t1 = first;
        Object a = null;
        for (int i = 0; i < count; i++) {
            if (t1.getNum() == index) {
                a = t1.getContent();
            }
            t1 = t1.getNext();
        }
        return a;
    }

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        Node t1 = first;
        Object a = null;
        for (int i = 0; i < count; i++) {
            if (t1.getContent() == o) {
                return t1.getNum();
            }
            t1 = t1.getNext();
        }
        return -1;
    }

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this
     */
    @Override
    public int lastIndexOf(Object o) {
        Node t1 = last;
        Object a = null;
        for (int i = 0; i < count; i++) {
            if (t1.getContent() == o) {
                return t1.getNum();
            }
            t1 = t1.getPriv();
        }
        return -1;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return count;
    }

    /**
     * Removes all of the elements from this list (optional operation). The list
     * will be empty after this call returns.
     *
     */
    @Override
    public void clear() {
        first = null;
        last = null;
        count = 0;
    }

}
