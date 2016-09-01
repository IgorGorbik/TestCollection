package listtest;

/**
 *
 * @author Игорь
 */
public interface TestList<E> {

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    int size();

    /**
     * Returns <tt>true</tt> if this list contains no elements.
     *
     * @return <tt>true</tt> if this list contains no elements
     */
    boolean isEmpty();

    /**
     * Returns <tt>true</tt> if this list contains the specified element.
     *
     * @param o element whose presence in this list is to be tested
     * @return <tt>true</tt> if this list contains the specified element
     */
    boolean contains(Object o);

    /**
     * Returns an array containing all of the elements in this list in proper
     * sequence (from first to last element).
     *
     * @return an array containing all of the elements in this list in proper
     * sequence
     */
    Object[] toArray();

    /**
     * Appends the specified element to the end of this list (optional
     * operation).
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt>
     */
    boolean add(E e);

    /**
     * Removes the first occurrence of the specified element from this list, if
     * it is present (optional operation).
     *
     * @param o element to be removed from this list, if present
     * @return <tt>true</tt> if this list contained the specified element
     */
    boolean remove(Object o);

    /**
     * Removes all of the elements from this list (optional operation). The list
     * will be empty after this call returns.
     *
     */
    void clear();

    /**
     * Returns the element at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    E get(int index);

    /**
     * Replaces the element at the specified position in this list with the
     * specified element (optional operation).
     *
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     */
    E set(int index, E element);

    /**
     * Inserts the specified element at the specified position in this list
     * (optional operation).
     *
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     */
    void add(int index, E element);

    /**
     * Removes the element at the specified position in this list (optional
     * operation).
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    E remove(int index);

    /**
     * Returns the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    int indexOf(Object o);

    /**
     * Returns the index of the last occurrence of the specified element in this
     * list, or -1 if this list does not contain the element.
     *
     * @param o element to search for
     * @return the index of the last occurrence of the specified element in this
     */
    int lastIndexOf(Object o);

}
