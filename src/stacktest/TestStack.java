package stacktest;


/**
 *
 * @author Игорь
 */
public class TestStack<E> {

    private Node last = null;
    private int count = 0;

    public TestStack() {
    }

    private class Node {

        private Node priv = null;
        private E content = null;

        Node(Node priv, E content) {
            this.priv = priv;
            this.content = content;
        }

        public Node getPriv() {
            return priv;
        }

        public void setPriv(Node next) {
            this.priv = next;
        }

        public E getContent() {
            return content;
        }

        public void setContent(E content) {
            this.content = content;
        }

    }

    /**
     * Pushes an item onto the top of this stack. This has exactly
     *
     * @param item the item to be pushed onto this stack.
     */
    public void push(E item) {
        Node t = null;
        if (last == null) {
            t = new Node(null, item);
            last = t;
            count++;
        } else {
            t = new Node(last, item);
            last = t;
            count++;
        }
    }

    /**
     * Removes the object at the top of this stack and returns that object as
     * the value of this function.
     *
     * @return The object at the top of this stack.
     */
    public E pop() {
        Node t = null;
        if (last != null) {
            Node t1 = last.getPriv();
            t = last;
            last = t1;
            count--;
        } else {
            throw new StackEmptyException("Stack is empty");
        }
        return t.getContent();
    }

    /**
     * Looks at the object at the top of this stack without removing it from the
     * stack.
     *
     * @return the object at the top of this stack.
     */
    public E peek() {
        Node t = null;
        if (last != null) {
            t = last;
        } else {
            throw new StackEmptyException("Stack is empty");
        }
        return t.getContent();
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
